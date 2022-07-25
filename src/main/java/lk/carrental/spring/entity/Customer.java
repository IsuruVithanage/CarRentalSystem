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
public class Customer {
    @Id
    private String custID;
    private String name;
    private String address;
    private String email;
    private String licenseNo;
    private String nic;
    private String contact;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
