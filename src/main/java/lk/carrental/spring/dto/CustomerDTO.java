package lk.carrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data // apply getters and setters
@ToString
public class CustomerDTO {
    private String custID;
    private String name;
    private String address;
    private String email;
    private String licenseNo;
    private String nic;
    private String contact;
    private UserDTO user;
}
