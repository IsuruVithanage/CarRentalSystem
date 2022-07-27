package lk.carrental.spring.repo;

import lk.carrental.spring.entity.Admin;
import lk.carrental.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin,String> {
    Admin findTopByOrderByAdminIDDesc();
}
