package com.haonanzhang415.bankApp.service;

import com.haonanzhang415.bankApp.entity.Customer;
import com.haonanzhang415.bankApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Long saveCustomer(Customer customer) {
        return customerRepository.save(customer).getId();
    }


}
