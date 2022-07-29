package lk.carrental.spring.service;

import lk.carrental.spring.dto.RentReqDTO;
import lk.carrental.spring.dto.VehicleDTO;

import java.util.List;

public interface RentReqService {
    void saveRentReq(RentReqDTO dto);

    List<RentReqDTO> getAllRentReq();

    void deleteRentReq(String id);
    void updateRentReq(RentReqDTO dto);
    String generateRentReqID();
    void confirmReq(String id);
}
