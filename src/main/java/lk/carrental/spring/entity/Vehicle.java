package lk.carrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Vehicle {
    @Id
    private String vehicleID;
    private String brand;
    private String type;
    private String passengerNo;
    private String transmisson;
    private String fuelType;
    private String color;
    private String regNumber;
    private double dailyMilage;
    private double monthlyMilage;
    private double dailyRent;
    private double monthlyRent;
    private double extraMilagePrice;
    private String availability;
    private String imgOne;
    private String imgTwo;
    private String imgThree;
    private String imgFour;
    private String imgFive;
}
