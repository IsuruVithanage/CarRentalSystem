package lk.carrental.spring.service.impl;

import lk.carrental.spring.dto.CustomerDTO;
import lk.carrental.spring.entity.Customer;
import lk.carrental.spring.repo.CustomerRepo;
import lk.carrental.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        if (!repo.existsById(dto.getCustID())) {
            repo.save(mapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("Customer Already Exist..!");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapper.map(repo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public List<CustomerDTO> getCustByUser(String id) {
        return mapper.map(repo.findCustByUser(id), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public void deleteCustomer(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Customer ID.. No Such Customer..!");
        }

    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (repo.existsById(dto.getCustID())) {
            repo.save(mapper.map(dto, Customer.class));
        } else {
            throw new RuntimeException("No Such Customer To Update..! Please Check the ID..!");
        }

    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), CustomerDTO.class);
        } else {
            throw new RuntimeException("No Customer For " + id + " ..!");
        }
    }

    @Override
    public String generateCustID() {
        Customer top = repo.findTopByOrderByCustIDDesc();
        if(top!=null){
            Integer index = Integer.parseInt(top.getCustID().split("-")[1]);
            ++index;
            return index<10 ? "C-00"+index : index<100 ? "C-0"+index :"C-"+index;
        }
        return "C-001";
    }
}
