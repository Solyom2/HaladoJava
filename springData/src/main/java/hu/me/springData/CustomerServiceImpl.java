package hu.me.springData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    CrudRepository crudRepository;

    @PostConstruct
    void init() {
         crudRepository.save(new Customer("Ramszesz", "Fárajó"));
    }

    @Autowired
    public void setCrudRepository(CrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }


    @Override
    public Iterable<Customer> findAll() {
        return crudRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        crudRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Optional<Customer> customer = crudRepository.findById(id);

        if(customer.isPresent()) {
            crudRepository.delete(customer);
        }
    }

}
