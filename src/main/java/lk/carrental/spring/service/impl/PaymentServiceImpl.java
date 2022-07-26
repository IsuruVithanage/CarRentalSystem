package lk.carrental.spring.service.impl;

import lk.carrental.spring.dto.DriverDTO;
import lk.carrental.spring.dto.PaymentDTO;
import lk.carrental.spring.entity.Driver;
import lk.carrental.spring.entity.Payment;
import lk.carrental.spring.repo.DriverRepo;
import lk.carrental.spring.repo.PaymentRepo;
import lk.carrental.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void savePayment(PaymentDTO dto) {
        if (!repo.existsById(dto.getPaymentID())) {
            repo.save(mapper.map(dto, Payment.class));
        } else {
            throw new RuntimeException("Driver Already Exist..!");
        }

    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return mapper.map(repo.findAll(), new TypeToken<List<PaymentDTO>>() {
        }.getType());
    }
}
