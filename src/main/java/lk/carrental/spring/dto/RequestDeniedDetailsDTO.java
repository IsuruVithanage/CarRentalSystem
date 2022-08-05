package lk.carrental.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data // apply getters and setters
@ToString
public class RequestDeniedDetailsDTO {
    private String denyReqID;
    private String message;
    private String cID;
}
