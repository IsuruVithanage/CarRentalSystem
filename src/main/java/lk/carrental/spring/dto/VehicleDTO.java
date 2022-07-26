package lk.carrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data // apply getters and setters
@ToString
public class VehicleDTO {
    private String vehicleID;
    private String brand;
    private String type;
    private String passengerNo;
    private String transmisson;
    private String fuelType;
    private String color;
    private String regNumber;
    private double extraMilage;
    private double dailyRent;
    private double monthlyRent;
    private double extraMilagePrice;
    private String availability;

}
