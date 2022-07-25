package lk.carrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data // apply getters and setters
@ToString
public class DriverDTO {
    private String driverID;
    private String name;
    private String address;
    private String nic;
    private String licenseNo;
    private String contact;
    private String availability;
    private UserDTO user;
}
