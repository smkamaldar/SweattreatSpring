package com.shop.sweattreat.web;

import com.shop.sweattreat.execption.CourierNotFoundException;
import com.shop.sweattreat.model.Courier;
import com.shop.sweattreat.repository.CourierRepository;
import com.shop.sweattreat.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sweat")
public class CourierController {
    private CourierService courierService;
    private final CourierRepository courierRepository;

    @Autowired
    public CourierController(CourierRepository courierRepository) {

        this.courierRepository = courierRepository;
    }

    @Autowired
    public void setCourierService(CourierService courierService) {
        this.courierService = courierService;
    }

    @GetMapping("allCouriers")
    public ResponseEntity<List<Courier>> getAllCouriers() {
        List<Courier> list = courierService.listCourier();
        return new ResponseEntity<List<Courier>>(list, HttpStatus.OK);
    }


    @GetMapping("courier/{id}")
    public ResponseEntity<Courier> getCourier(@PathVariable("id") long id){
        try {
            return new ResponseEntity<Courier>(courierService.findCourier(id), HttpStatus.OK);
        } catch (CourierNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id Not Found");
        }
    }

    @GetMapping("availableCouriers")
    public ResponseEntity<List<Courier>> getAvailableCourier() {
        List<Courier> list = courierService.availableCouriers();
        return new ResponseEntity<List<Courier>>(list, HttpStatus.OK);
    }


    @PostMapping("addCourier")
    public  ResponseEntity<Courier> addCourier(@Valid @RequestBody Courier newCourier)  {
        ArrayList<String> names = courierRepository.getCourierName();
        for (String name : names) {
            if (newCourier.getName().equals(name)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "user exists.");
            }
        }
        newCourier.setIsAvailable(true);
        Courier courier = courierService.addCourier(newCourier);
        return new ResponseEntity<Courier>(courier, HttpStatus.CREATED);
    }


    @GetMapping("cheapest")
    public ResponseEntity<Courier> getCheapestCourier(@RequestParam("time") String time,@RequestParam("mileage") @NotNull() int mileage , boolean needRefrigerator){
        Courier cheapest = courierService.book(time,mileage, needRefrigerator);
        return new ResponseEntity<Courier>(cheapest,HttpStatus.OK);
    }

    @DeleteMapping("couriers/{id}")
    public ResponseEntity<?> deleteCourier(@PathVariable Long id) {
        try{
             courierService.delete(id);
            return new ResponseEntity<>("selected courier is deleted",HttpStatus.OK);

        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id Not Found",e);
        }

    }
}
