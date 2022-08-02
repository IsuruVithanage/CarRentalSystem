package lk.carrental.spring.repo;

import lk.carrental.spring.entity.Driver;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver, String> {
    Driver findTopByOrderByDriverIDDesc();

    @Query(value = "FROM Driver WHERE availability=:status")
    List<Driver> selectDriver(@Param("status")String status, Pageable p);

    @Modifying
    @Query(value = "UPDATE Driver SET availability=:status WHERE driverID=:id")
    void driverUnavailable(@Param("status")String status,@Param("id")String id);

}
