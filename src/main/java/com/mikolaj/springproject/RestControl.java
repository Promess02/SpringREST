package com.mikolaj.springproject;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
public class RestControl {
    CustomerRepository customerRepository;
    public RestControl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;   }
    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("{customerId}")
    public Optional<Customer> getSingleCustomer(@PathVariable("customerId") Integer id){
        return customerRepository.findById(id);
    }
    record NewCustomerRequest(String name,
                              String email,
                              Integer age) { }
    @PostMapping
    public void addCustomer(@RequestBody RestControl.NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setEmail(request.email);
        customer.setAge(request.age);
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }
    @PutMapping("{customerId}")
    public void updateCustomer(@RequestBody RestControl.NewCustomerRequest request, @PathVariable("customerId") Integer id){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(request.name);
        customer.setAge(request.age);
        customer.setEmail(request.email);
        customerRepository.save(customer);
    }
}
