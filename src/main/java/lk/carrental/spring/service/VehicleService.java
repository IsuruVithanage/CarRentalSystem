package lk.carrental.spring.service;

import lk.carrental.spring.dto.CustomerDTO;
import lk.carrental.spring.dto.UserDTO;
import lk.carrental.spring.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    void saveVehicle(VehicleDTO dto);

    List<VehicleDTO> getAllVehicle();

    void deleteVehicle(String id);
    void updateVehicle(VehicleDTO dto);
    String generateVehicleID();

    VehicleDTO searchVehicle(String id);

    List<VehicleDTO> getSelectedVehicles(String status);
}
