package lk.carrental.spring.repo;

import lk.carrental.spring.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, String> {
}
