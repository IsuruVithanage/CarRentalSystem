package lk.carrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data // apply getters and setters
@ToString
public class AdminDTO {
    private String adminID;
    private String name;
    private String email;
    private String contact;
    private UserDTO userDTO;
}
