package lk.carrental.spring.service.impl;

import lk.carrental.spring.dto.RequestDeniedDetailsDTO;
import lk.carrental.spring.entity.RequestDeniedDetails;
import lk.carrental.spring.repo.RequestDeniedDetailsRepo;
import lk.carrental.spring.service.RequestDeniedDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RequestDeniedDetailsServiceImpl implements RequestDeniedDetailsService {
    @Autowired
    private RequestDeniedDetailsRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDeniedReq(RequestDeniedDetailsDTO dto) {
        if (!repo.existsById(dto.getDenyReqID())) {
            repo.save(mapper.map(dto, RequestDeniedDetails.class));
        } else {
            throw new RuntimeException("Customer Already Exist..!");
        }

    }
}
