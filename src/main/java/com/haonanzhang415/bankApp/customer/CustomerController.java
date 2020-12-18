package com.haonanzhang415.bankApp.customer;

import com.haonanzhang415.bankApp.entity.Customer;
import com.haonanzhang415.bankApp.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        try {
            customerService.saveCustomer(convertCustomerDTOToCustomerEntity(customerDTO));
        } catch (CustomerSalaryException ex) {
            return ex.getMessage();
        } catch (CustomerAgeException ex) {
            return ex.getMessage();
        }
        return "customer created";
    }

    private Customer convertCustomerDTOToCustomerEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }

    @GetMapping("/printCustomers")
    public String printCustomers() {
        try {
            customerService.printAllCustomers();
            return "all customer info printed";
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "an error occurred";
        }
    }

}
