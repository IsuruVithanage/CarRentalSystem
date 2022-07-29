package lk.carrental.spring.service.impl;

import lk.carrental.spring.dto.AdminDTO;
import lk.carrental.spring.dto.CustomerDTO;
import lk.carrental.spring.entity.Admin;
import lk.carrental.spring.entity.Customer;
import lk.carrental.spring.entity.RentReq;
import lk.carrental.spring.repo.AdminRepo;
import lk.carrental.spring.repo.CustomerRepo;
import lk.carrental.spring.repo.RentReqRepo;
import lk.carrental.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo repo;

    @Autowired
    private RentReqRepo reqRepo;

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

    @Override
    public String generateAdminID() {
        Admin top = repo.findTopByOrderByAdminIDDesc();
        if(top!=null){
            Integer index = Integer.parseInt(top.getAdminID().split("-")[1]);
            ++index;
            return index<10 ? "A-00"+index : index<100 ? "A-0"+index :"A-"+index;
        }
        return "A-001";
    }

}
