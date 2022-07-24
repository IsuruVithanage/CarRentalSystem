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
public class RentReq {
    @Id
    private String rentID;
    private String custID;
    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String returnTime;
    private String vehicleID;
    private String driverNeed;
    private String userID;
}
