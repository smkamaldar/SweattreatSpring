package com.shop.sweattreat.model;



import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    @Length(min=3)
    @NotBlank
    @Column(name="name")
    private String name;

//    @DateTimeFormat
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name="start_time")
    private LocalTime startTime;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name="end_time")
    private LocalTime endTime;
    @NotNull
    @Min(2)
    @Column(name="max_mileage")
    private int maxMileage;
    @NotNull
    @Column(name="has_refrigerated_box")
    private boolean hasRefrigeratedBox;
    @NotNull
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
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.startTime = LocalTime.parse(startTime);
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) throws ParseException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.endTime =  LocalTime.parse(endTime);
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
