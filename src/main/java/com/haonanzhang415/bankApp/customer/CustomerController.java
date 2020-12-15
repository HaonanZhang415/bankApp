package com.haonanzhang415.bankApp.customer;

import com.haonanzhang415.bankApp.entity.Customer;
import com.haonanzhang415.bankApp.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        Long id = customerService.saveCustomer(convertCustomerDTOToCustomerEntity(customerDTO));
        customerDTO.setId(id);
        return customerDTO;
    }

    private Customer convertCustomerDTOToCustomerEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }

}
