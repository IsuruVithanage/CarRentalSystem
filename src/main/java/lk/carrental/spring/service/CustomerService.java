package lk.carrental.spring.service;

import lk.carrental.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    List<CustomerDTO> getAllCustomers();
    void deleteCustomer(String id);
    void updateCustomer(CustomerDTO dto);
    String generateCustID();

}
