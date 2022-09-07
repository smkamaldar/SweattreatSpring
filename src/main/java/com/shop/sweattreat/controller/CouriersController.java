//package com.shop.sweattreat.controller;
//
//
//import com.shop.sweattreat.model.Courier;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.logging.FileHandler;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.logging.SimpleFormatter;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping(path="api/v1/couriers")
//public class CouriersController {
//    private static final Logger LOGGER = Logger.getLogger(CouriersController.class.getName());
//
//    static {
//        FileHandler fileHandler = null;
//        try {
//            fileHandler = new FileHandler(CouriersController.class.getSimpleName() + ".log");
//            fileHandler.setFormatter(new SimpleFormatter());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        LOGGER.addHandler(fileHandler);
//    }
//
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//    private Courier courier;
//    private final List<Courier> couriers = new ArrayList<Courier>();
//
//    public void addCourier(Courier courier) {
//        couriers.add(courier);
//    }
//
//    public int countOfCouriers() {
//        return couriers.size();
//    }
//
//    public List<Courier> availableCouriers() {
//
//        return couriers.stream().filter(courier -> courier.getAvailable()).collect(Collectors.toList());
//
//    }
//    @GetMapping
//    public Courier book(String time, int mileage, boolean needRefrigrator) throws Exception {
//        Courier cheapest = null;
//        LocalTime requestedTime = LocalTime.parse(time, formatter);
//
//        var filter = availableCouriers().stream()
//                .filter(courier -> courier.getEndTime().isAfter(requestedTime)
//                        && courier.getStartTime().isBefore(requestedTime)
//                        && courier.getMaxMileage() >= mileage
//                        && courier.hasRefrigeratedBox() == needRefrigrator)
//                .collect(Collectors.toList());
//
//        if (!filter.isEmpty()) {
////            given the courier and compare their chargepermile
////            static function
////            comparator contains  a list of objects
//            Comparator<Courier> comparator = Comparator.comparing(Courier::getChargePerMile);
//            cheapest = filter.stream().min(comparator).get();
//            cheapest.setAvailable(false);
//            LOGGER.log(Level.INFO, "the cheapest courier "
//                    + cheapest.getName() + " with amount of "
//                    + cheapest.getChargePerMile() + " has been selected.\n" +"your total amount is :"+ cheapest.getChargePerMile()*mileage);
//            System.out.println(cheapest.getName() + " has been booked for you!");
//        } else {
//            LOGGER.log(Level.WARNING, "\n\t no one available for you at " + time);
//            System.out.println("no one is available at the moment");
//        }
//        return cheapest;
//    }
//}
