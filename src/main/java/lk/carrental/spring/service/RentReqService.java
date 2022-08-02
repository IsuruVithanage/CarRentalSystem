package lk.carrental.spring.service;

import lk.carrental.spring.dto.CustomerDTO;
import lk.carrental.spring.dto.RentReqDTO;
import lk.carrental.spring.dto.VehicleDTO;
import lk.carrental.spring.entity.Driver;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RentReqService {
    void saveRentReq(RentReqDTO dto);

    List<RentReqDTO> getAllRentReq();

    void deleteRentReq(String id);
    void updateRentReq(RentReqDTO dto);
    String generateRentReqID();
    void confirmReq(String id);
    void payedReq(String id);
    void deniedmReq(String id);
    void assignDriver(String id);
    boolean ifDriverNeed(String id);
    List<RentReqDTO> getReq(String status);
    List<RentReqDTO> getpayReq();
    RentReqDTO searchReq(String id);

}
