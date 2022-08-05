package lk.carrental.spring.service;

import lk.carrental.spring.dto.RequestDeniedDetailsDTO;
import lk.carrental.spring.dto.VehicleDTO;

import java.util.List;

public interface RequestDeniedDetailsService {
    void saveDeniedReq(RequestDeniedDetailsDTO dto);
    List<RequestDeniedDetailsDTO> getDetails(String custID);
}
