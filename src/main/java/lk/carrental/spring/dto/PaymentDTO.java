package lk.carrental.spring.dto;

import lk.carrental.spring.entity.RentReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Data // apply getters and setters
@ToString
public class PaymentDTO {
    private String paymentID;
    private double milage;
    private double price;
    private double damagecost;
    private double fullamount;
    private RentReq rentReq;
}
