package pu.plovdiv.fmi.coffeemag.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pu.plovdiv.fmi.coffeemag.Entity.customer;
import pu.plovdiv.fmi.coffeemag.Repository.customerR;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing customer-related operations.
 */
@Service
public class customerService {

    private final customerR customerRepository;
    private pu.plovdiv.fmi.coffeemag.Entity.customer customer;


    @Autowired
    public customerService(customerR customerRepository) {
        this.customerRepository = customerRepository;

    }

    /**
     * Retrieve a list of all customers.
     *
     * @return List of CustomerEntity objects.
     */
    public List<customer> getAllCustomers() {

        List<pu.plovdiv.fmi.coffeemag.Entity.customer> all = List.of(customer);
        return all;
    }

    /**
     * Retrieve a customer by their unique identifier.
     *
     * @param id The unique identifier of the customer.
     * @return CustomerEntity object or null if not found.
     */
    public customer getCustomerById(Long id) {
        Optional<customer> customer = customerRepository.findById(id);
        return customer.orElse(null);
    }

    /**
     * Create a new customer.
     *
     * @param customerEntity The customer entity to be created.
     * @return Created CustomerEntity object.
     */
    public customer createCustomer(customer customerEntity) {
        return customerRepository.save(customerEntity);
    }

    /**
     * Update an existing customer by their unique identifier.
     *
     * @param id             The unique identifier of the customer to be updated.
     * @param customerEntity The updated customer entity.
     * @return Updated CustomerEntity object or null if not found.
     */
    public customer updateCustomer(Long id, customer customerEntity) {
        if (customerRepository.existsById(id)) {
            customerEntity.setId(id);
            return customerRepository.save(customerEntity);
        } else {
            return null; // Handle not found error
        }
    }

    /**
     * Delete a customer by their unique identifier.
     *
     * @param id The unique identifier of the customer to be deleted.
     */
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    /**
     * Add a book to a customer's collection.
     *
     * @param customerId The unique identifier of the customer.
     * @param bookId     The unique identifier of the book to be added.
     * @return Updated CustomerEntity object or null if not found.
     */
    public customer addBookToCustomer(Long customerId, Long bookId) {
        customer Customer = customerRepository.findById(customerId).orElse(null);
        

       

            return customer;
            
    }
}