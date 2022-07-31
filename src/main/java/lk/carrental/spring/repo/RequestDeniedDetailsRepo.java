package lk.carrental.spring.repo;

import lk.carrental.spring.entity.RequestDeniedDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDeniedDetailsRepo extends JpaRepository<RequestDeniedDetails, String> {
}
