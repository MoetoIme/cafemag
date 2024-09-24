package pu.plovdiv.fmi.coffeemag.contollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pu.plovdiv.fmi.coffeemag.Entity.customer;
import pu.plovdiv.fmi.coffeemag.Service.customerService;

import java.util.List;

/**
 * Controller for managing customer-related operations.
 */
@RestController
@RequestMapping("/customers")
public class customerContoller {

    private final customerService customerService;

    @Autowired
    public customerContoller(pu.plovdiv.fmi.coffeemag.Service.customerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping
    public List<customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
    @PostMapping
    public customer createCustomer(@RequestBody customer customerEntity) {
        return customerService.createCustomer(customerEntity);
    }
    @PutMapping("/{id}")
    public customer updateCustomer(@PathVariable Long id, @RequestBody customer customerEntity) {
        return customerService.updateCustomer(id, customerEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
