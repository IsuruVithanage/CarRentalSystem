package lk.carrental.spring.dto;

import lk.carrental.spring.entity.Customer;
import lk.carrental.spring.entity.Driver;
import lk.carrental.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data // apply getters and setters
@ToString
public class RentReqDTO {
    private String rentID;
    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String returnTime;
    private String driverNeed;
    private Vehicle vehicle;
    private Driver driver;
    private Customer customer;
}
