package com.haonanzhang415.bankApp.service;

import com.haonanzhang415.bankApp.customer.CustomerAgeException;
import com.haonanzhang415.bankApp.customer.CustomerSalaryException;
import com.haonanzhang415.bankApp.entity.Customer;
import com.haonanzhang415.bankApp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Long saveCustomer(Customer customer) throws CustomerAgeException, CustomerSalaryException {

        if (customer.getAnnualIncome() < 30000.00) {
            throw new CustomerSalaryException();
        }

        if (customer.getAge() < 18) {
            throw new CustomerAgeException();
        }

        return customerRepository.save(customer).getId();
    }

    public void printAllCustomers() throws FileNotFoundException {

        List<Customer> customerList = customerRepository.findAll();

        File customerInfos = new File("customers.txt");
        PrintWriter pw = new PrintWriter(customerInfos);
        for (Customer c : customerList) {
            pw.println("  ");
            String[] infos = c.getCustomerInfo();
            for (String info : infos) {
                pw.println(info);
            }
        }
        pw.flush();
        pw.close();
    }

}
