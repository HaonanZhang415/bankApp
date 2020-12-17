package com.haonanzhang415.bankApp.customer;

import com.haonanzhang415.bankApp.entity.Customer;
import com.haonanzhang415.bankApp.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(convertCustomerDTOToCustomerEntity(customerDTO));
        return customerDTO;
    }

    private Customer convertCustomerDTOToCustomerEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }

}
