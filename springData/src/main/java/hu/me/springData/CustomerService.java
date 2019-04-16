package hu.me.springData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    Iterable<Customer> findAll();
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);

}
