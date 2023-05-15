package com.huycode.customer;

import com.huycode.customer.Customer;
import com.huycode.customer.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository<Customer,Integer>{
}
