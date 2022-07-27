package lk.carrental.spring.service.impl;

import lk.carrental.spring.dto.RentReqDTO;
import lk.carrental.spring.dto.VehicleDTO;
import lk.carrental.spring.entity.Driver;
import lk.carrental.spring.entity.RentReq;
import lk.carrental.spring.entity.Vehicle;
import lk.carrental.spring.repo.RentReqRepo;
import lk.carrental.spring.repo.VehicleRepo;
import lk.carrental.spring.service.RentReqService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentReqServiceImpl implements RentReqService {
    @Autowired
    private RentReqRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveRentReq(RentReqDTO dto) {
        if (!repo.existsById(dto.getRentID())) {
            repo.save(mapper.map(dto, RentReq.class));
        } else {
            throw new RuntimeException("Driver Already Exist..!");
        }

    }

    @Override
    public List<RentReqDTO> getAllRentReq() {
        return mapper.map(repo.findAll(), new TypeToken<List<RentReqDTO>>() {
        }.getType());
    }

    @Override
    public void deleteRentReq(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }

    }

    @Override
    public void updateRentReq(RentReqDTO dto) {
        if (repo.existsById(dto.getRentID())) {
            repo.save(mapper.map(dto, RentReq.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }

    }

    @Override
    public String generateRentReqID() {
        RentReq top = repo.findTopByOrderByRentIDDesc();
        if(top!=null){
            Integer index = Integer.parseInt(top.getRentID().split("-")[1]);
            ++index;
            return index<10 ? "R-00"+index : index<100 ? "R-0"+index :"R-"+index;
        }
        return "R-001";
    }

}
