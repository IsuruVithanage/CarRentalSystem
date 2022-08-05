package lk.carrental.spring.repo;

import lk.carrental.spring.entity.RequestDeniedDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RequestDeniedDetailsRepo extends JpaRepository<RequestDeniedDetails, String> {

    @Query(value = "FROM RequestDeniedDetails WHERE cID=:id")
    String getreqDetail(@Param("id")String id);
}
