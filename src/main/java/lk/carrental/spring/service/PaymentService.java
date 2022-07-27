package lk.carrental.spring.service;

import lk.carrental.spring.dto.DriverDTO;
import lk.carrental.spring.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    void savePayment(PaymentDTO dto);

    List<PaymentDTO> getAllPayments();
    String generatePaymentID();
}
