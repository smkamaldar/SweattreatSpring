package com.shop.sweattreat.model;



import javax.persistence.*;
import java.text.ParseException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


// we told Lombok to generate these for all the fields of the class.

@Entity
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    //    Use LocalTime.format(DateTimeFormatter) method to format a local time to the desired string representation

    @Column(name="name")
    private String name;
    @Column(name="start_time")
    private LocalTime startTime;
    @Column(name="end_time")
    private LocalTime endTime;
    @Column(name="max_mileage")
    private int maxMileage;
    @Column(name="has_refrigerated_box")
    private boolean hasRefrigeratedBox;
    @Column(name="charge_per_mile")
    private double chargePerMile;
    @Column(name="is_available")
    private boolean isAvailable;

    public Courier(){}
    public Courier(String name, String startTime, String endTime, int maxMileage, boolean hasRefrigeratedBox, double chargePerMile) throws ParseException {
        this.name = name;
        setStartTime(startTime);
        setEndTime(endTime);
        this.maxMileage = maxMileage;
        this.hasRefrigeratedBox = hasRefrigeratedBox;
        this.chargePerMile = chargePerMile;
        this.isAvailable = true;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.startTime = LocalTime.parse(startTime,formatter);
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.endTime =  LocalTime.parse(endTime,formatter);
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean state) {
        isAvailable = state;
    }

    public boolean getHasRefrigeratedBox() {
        return hasRefrigeratedBox;
    }
    public void setHasRefrigeratedBox(boolean status) {
        this.hasRefrigeratedBox = status;
    }
    public double getChargePerMile() {
        return chargePerMile;
    }


    public int getMaxMileage() {
        return maxMileage;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
