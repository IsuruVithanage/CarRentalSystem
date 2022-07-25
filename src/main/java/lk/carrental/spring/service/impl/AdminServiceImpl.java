package lk.carrental.spring.service.impl;

import lk.carrental.spring.dto.AdminDTO;
import lk.carrental.spring.dto.CustomerDTO;
import lk.carrental.spring.entity.Admin;
import lk.carrental.spring.entity.Customer;
import lk.carrental.spring.repo.AdminRepo;
import lk.carrental.spring.repo.CustomerRepo;
import lk.carrental.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if (!repo.existsById(dto.getAdminID())) {
            repo.save(mapper.map(dto, Admin.class));
        } else {
            throw new RuntimeException("Admin Already Exist..!");
        }

    }
}
