package lk.carrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class RentReq {
    @Id
    private String rentID;
    private String pickedDate;
    private String pickedTime;
    private String returnDate;
    private String returnTime;
    private String driverNeed;

    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;

    private Driver driver;
}
