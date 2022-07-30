package lk.carrental.spring.repo;

import lk.carrental.spring.entity.Driver;
import lk.carrental.spring.entity.RentReq;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

public interface RentReqRepo extends JpaRepository<RentReq, String> {
    RentReq findTopByOrderByRentIDDesc();

    @Modifying
    @Query(value = "UPDATE RentReq SET reqConfirm=:status WHERE rentID=:id")
    void confirmReq(@Param("status")String status,@Param("id")String id);

    @Modifying
    @Query(value = "UPDATE RentReq SET driver=:driver WHERE rentID=:id")
    void assignDriver(@Param("driver")Driver driver,@Param("id")String id);

    @Query(value = "SELECT driverNeed FROM RentReq WHERE rentID=:id")
    String ifDriverNeed(@Param("id")String id);

    @Query(value = "FROM RentReq WHERE reqConfirm=:status")
    List<RentReq> getReq(@Param("status")String status);
}
