package lk.carrental.spring.repo;

import lk.carrental.spring.entity.RentReq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentReqRepo extends JpaRepository<RentReq, String> {
    RentReq findTopByOrderByRentIDDesc();
}
