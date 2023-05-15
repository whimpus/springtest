
package com.huycode.customer;

import com.huycode.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    @PostMapping
    public void addCustomer(@RequestBody CustomerService.NewCustomerRequest request){
        customerService.addCustomer(request);
    }
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerService.deleteCustomer(id);

    }
    /*@PutMapping("{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer id, @RequestBody CustomerService.UpdateCustomerRequest request){
        customerService.updateCustomer(request);
    }*/




}

