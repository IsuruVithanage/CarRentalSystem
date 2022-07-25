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
public class Driver {
    @Id
    private String driverID;
    private String name;
    private String address;
    private String nic;
    private String licenseNo;
    private String contact;
    private String availability;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
