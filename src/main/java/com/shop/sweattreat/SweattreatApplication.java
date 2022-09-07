package com.shop.sweattreat;

//import com.shop.sweattreat.controller.CouriersController;
import com.shop.sweattreat.model.Courier;
import com.shop.sweattreat.repository.CourierRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class SweattreatApplication {

//	private static final Logger log = LoggerFactory.getLogger(SweattreatApplication.class);
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SweattreatApplication.class, args);
	}
	}

//			CouriersController couriers = new CouriersController();
//			couriers.addCourier(new Courier("bobby", "09:00", "13:00", 5, true, 1.75));
//			couriers.addCourier(new Courier("Martin", "09:00", "17:00", 3, false, 1.50));
//			couriers.addCourier(new Courier("Geoff", "10:00", "16:00", 4, true, 2));
//
//			while (true) {
//				System.out.println("Sweat Treats Store");
//				String isUser = getUserInput("Are you a user or admin?");
//				if (isUser.equals("admin")) {
//					String newCourier = getUserInput("Do you want to add a new courier? (Y/N)");
//					while (newCourier.equals("Y")) {
//						System.out.println("Please provide us the new courier's details.");
//						String name = getUserInput("name: ");
//						String startTime = getDateFromUser("Start time (hh:mm): ");
//						String endTime = getDateFromUser("End time (hh:mm): ");
//						int maxMileage = Integer.parseInt(getUserInput("maximum mileage : "));
//						double chargePerMile = Double.parseDouble(getUserInput("charge per mile : "));
//						String hasRef = getUserInput("does it have refrigerator hasRefrigeratedBox? (Y/N)");
////
//						Courier courier = new Courier(name, startTime, endTime, maxMileage, hasRef.equals("Y"), chargePerMile);
//						couriers.addCourier(courier);
//						newCourier = getUserInput("Do you want to add a new courier? (Y/N)");
//					}
//
//				} else {
//					String time = getDateFromUser("what time do you expect you order? (HH:MM)");
//					int mileage = Integer.parseInt(getUserInput("How far is your delivery point?"));
//					String hasRef = getUserInput("Does your item need a refrigerator hasRefrigeratedBox or not?(Y/N)");
//					couriers.book(time, mileage, hasRef.equals("Y"));
//				}
//
//
///		}





// first it fetch courierrepository from spring courier context.
//	@Bean
//	public CommandLineRunner demo(CourierRepository repository) {
//		return (args) -> {
////				saving new courier to database
//			repository.save(new Courier("bobby", "09:00", "13:00", 5, true, 1.75));
//			repository.save(new Courier("Martin", "09:00", "17:00", 3, false, 1.50));
//			repository.save(new Courier("Geoff", "10:00", "16:00", 4, true, 2));
//
////fetching all the courier objects and printing it out
//			for (Courier courier : repository.findAll()) {
//				log.info("new courier is : " + courier.getName()+courier.getEndTime());
//			}
//		};
//	}
//}



//		public static String getDateFromUser(String message) {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
//			boolean check = true;
//			LocalTime requestedTime = null;
//
//			while (check) {
//				String time = getUserInput(message);
//				try {
//					requestedTime = LocalTime.parse(time, formatter);
//					check = false;
//					return requestedTime.toString();
//				} catch (Exception e) {
//					System.out.println("invalid format !!!");
//				}
//			}
//			return requestedTime.toString();
//		}
//
//		public static String getUserInput(String message) {
//			System.out.println();
//			System.out.print(message);
//			Scanner input = new Scanner(System.in);
//			return input.nextLine();
//		}
//	}

