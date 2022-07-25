package lk.carrental.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "driverID",referencedColumnName = "driverID",nullable = false)
    private Driver driver;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "customerID",referencedColumnName = "custID",nullable = false)
    private Customer customer;
}