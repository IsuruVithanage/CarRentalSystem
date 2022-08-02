package lk.carrental.spring.service;

import lk.carrental.spring.dto.DriverDTO;
import lk.carrental.spring.dto.UserDTO;
import lk.carrental.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO dto);

    List<UserDTO> getAllUsers();

    void deleteUser(String id);
    void updateUser(UserDTO dto);
    String generateUserID();

    Long userCount();

}
