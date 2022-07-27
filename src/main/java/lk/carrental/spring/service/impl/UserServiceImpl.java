package lk.carrental.spring.service.impl;

import lk.carrental.spring.dto.DriverDTO;
import lk.carrental.spring.dto.UserDTO;
import lk.carrental.spring.entity.Driver;
import lk.carrental.spring.entity.User;
import lk.carrental.spring.repo.DriverRepo;
import lk.carrental.spring.repo.UserRepo;
import lk.carrental.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveUser(UserDTO dto) {
        if (!repo.existsById(dto.getUserID())) {
            repo.save(mapper.map(dto, User.class));
        } else {
            throw new RuntimeException("Driver Already Exist..!");
        }

    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapper.map(repo.findAll(), new TypeToken<List<UserDTO>>() {
        }.getType());
    }

    @Override
    public void deleteUser(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }

    }

    @Override
    public void updateUser(UserDTO dto) {
        if (repo.existsById(dto.getUserID())) {
            repo.save(mapper.map(dto, User.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }

    }

    @Override
    public String generateUserID() {
        User top = repo.findTopByOrderByUserIDDesc();
        if(top!=null){
            Integer index = Integer.parseInt(top.getUserID().split("-")[1]);
            ++index;
            return index<10 ? "U-00"+index : index<100 ? "U-0"+index :"U-"+index;
        }
        return "U-001";
    }

}
