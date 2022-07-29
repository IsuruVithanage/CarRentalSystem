package lk.carrental.spring.repo;

import lk.carrental.spring.entity.RentReq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.Mapping;

public interface RentReqRepo extends JpaRepository<RentReq, String> {
    RentReq findTopByOrderByRentIDDesc();

    @Modifying
    @Query(value = "UPDATE RentReq SET reqConfirm=:status WHERE rentID=:id")
    void confirmReq(@Param("status")String status,@Param("id")String id);
}
