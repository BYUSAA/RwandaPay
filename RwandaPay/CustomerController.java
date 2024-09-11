package com.rwandapay.controller;

import com.rwandapay.model.Customer;
import com.rwandapay.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Register new customer
    @PostMapping("/register")
    public String registerCustomer(@RequestBody Customer customer) {
        if (customerRepository.findByPhoneNumber(customer.getPhoneNumber()).isPresent()) {
            return "Customer already registered!";
        }
        customerRepository.save(customer);
        return "Registration successful!";
    }

    // Login customer
    @PostMapping("/login")
    public String loginCustomer(@RequestParam String phoneNumber, @RequestParam String pin) {
        Optional<Customer> customerOpt = customerRepository.findByPhoneNumber(phoneNumber);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            if (customer.getPin().equals(pin)) {
                return "Login successful!";
            } else {
                return "Incorrect PIN!";
            }
        }
        return "Customer not found!";
    }
}
