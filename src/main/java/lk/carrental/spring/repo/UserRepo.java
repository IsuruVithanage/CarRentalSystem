package lk.carrental.spring.repo;

import lk.carrental.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
    User findTopByOrderByUserIDDesc();
}
