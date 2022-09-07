package com.shop.sweattreat.service;

import com.shop.sweattreat.execption.CourierNotFoundException;
import com.shop.sweattreat.model.Courier;
import com.shop.sweattreat.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourierServiceImpl implements CourierService{

    @Autowired
    private CourierRepository courierRepository;

    @Override
    public List<Courier> listCourier() {
        return (List<Courier>) courierRepository.findAll();
    }

    @Override
    public Courier findCourier(long id)  {
        Optional<Courier> result = courierRepository.findById(id);
        if(result.isPresent())
         return result.get();
        else
            throw new CourierNotFoundException("id not found");
    }

    @Override
    public List<Courier> availableCouriers() {
        return listCourier().stream().filter(courier -> courier.getIsAvailable()).collect(Collectors.toList());
    }


    public Courier addCourier(Courier courier) {

      return  courierRepository.save(courier);
//       listCourier().add(courier);
//       return courier;

    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    public Courier book(String time, int mileage, boolean needRefrigrator) {
        Courier cheapest = null;
        LocalTime requestedTime = LocalTime.parse(time, formatter);

        var filter = availableCouriers().stream()
                .filter(courier -> courier.getEndTime().isAfter(requestedTime)
                        && courier.getStartTime().isBefore(requestedTime)
                        && courier.getMaxMileage() >= mileage
                        && courier.getHasRefrigeratedBox() == needRefrigrator)
                .collect(Collectors.toList());

        if (!filter.isEmpty()) {
//            given the courier and compare their chargepermile
//            static function
//            comparator contains  a list of objects
            Comparator<Courier> comparator = Comparator.comparing(Courier::getChargePerMile);
            cheapest = filter.stream().min(comparator).get();
            cheapest.setIsAvailable(false);
//            find the id
            courierRepository.save(cheapest);
            System.out.println(cheapest.getName() + " has been booked for you!");
        } else {
            System.out.println("no one is available at the moment");
        }
        return cheapest;
    }
    public void delete(Long id){
        courierRepository.deleteById(id);
    }

}
