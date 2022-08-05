package lk.carrental.spring.repo;

import lk.carrental.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    Customer findTopByOrderByCustIDDesc();

    @Query(value = "FROM Customer WHERE user.userID=:id")
    List<Customer> findCustByUser(@Param("id")String id);
}
