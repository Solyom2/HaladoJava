package hu.me.springData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Customer> findAllCustomer() {
        return customerService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/" /*consumes = "application/json"*/)
    public void save(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/")
    @ResponseBody
    public String delete(Long id) {
        customerService.deleteCustomer(id);
        return "ok";
    }

}
