package lk.carrental.spring.repo;

import lk.carrental.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver, String> {
    Driver findTopByOrderByDriverIDDesc();
}
