package lk.carrental.spring.repo;

import lk.carrental.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {
    Vehicle findTopByOrderByVehicleIDDesc();
}
