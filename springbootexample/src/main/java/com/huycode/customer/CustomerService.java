package com.huycode.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("api/v1/customers")

public class CustomerService {

    private  CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    public List<Customer> getCustomers(){
        return customerDAO.findAll();
    }
    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ){
    }
    record UpdateCustomerRequest(
            String name,
            String email,
            Integer age
    ){
    }
    public void addCustomer(@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setAge(request.age);
        customer.setEmail(request.email);
        customerDAO.save(customer);
    }


    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerDAO.deleteById(id);


    }
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody UpdateCustomerRequest request){
        Customer existingCustomer = customerDAO.findById(id).get();
        existingCustomer.setName(request.name);
        existingCustomer.setAge(request.age);
        existingCustomer.setEmail(request.email);
        customerDAO.save(existingCustomer);
    }

}
