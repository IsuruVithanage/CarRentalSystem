package lk.carrental.spring.service;

import lk.carrental.spring.dto.CustomerDTO;
import lk.carrental.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO dto);

    List<DriverDTO> getAllDrivers();

    void deleteDriver(String id);
    void updateDriver(DriverDTO dto);
    String generateDriverID();
}
