package com.shop.sweattreat.model;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.ParseException;
import java.time.LocalTime;



@Entity
public class Courier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @NotNull(message= "must not be ignored")
    @Length(min=3, message="not allowed less than 3")
    @Column(name="name")
    private String name;

//    @DateTimeFormat
    @NotNull(message="A valid time must be provided")
    @Column(name="start_time")
    private LocalTime startTime;
    @NotNull(message="A valid time must be provided")
    @Column(name="end_time")
    private LocalTime endTime;
    @NotNull(message = "you need to provide your max mileage")
    @Min(2)
    @Column(name="max_mileage")
    private int maxMileage;
    @NotNull(message = "you need to provide true or false value")
    @Column(name="has_refrigerated_box")
    private boolean hasRefrigeratedBox;
    @Positive(message = "your rate must be a positive value")
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
