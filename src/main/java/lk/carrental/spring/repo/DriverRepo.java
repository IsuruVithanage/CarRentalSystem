package lk.carrental.spring.repo;

import lk.carrental.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DriverRepo extends JpaRepository<Driver, String> {
    Driver findTopByOrderByDriverIDDesc();

    @Query(value = "")
    void confirmReq(@Param("status")String status, @Param("id")String id);
}
