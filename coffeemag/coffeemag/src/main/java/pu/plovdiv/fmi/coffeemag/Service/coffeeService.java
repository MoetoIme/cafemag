package pu.plovdiv.fmi.coffeemag.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pu.plovdiv.fmi.coffeemag.Entity.coffee;
import pu.plovdiv.fmi.coffeemag.Repository.coffeeR;

import java.util.List;
import java.util.Optional;

@Service
public class coffeeService {

    @Autowired
    private coffeeR coffeeRepository;

    /**
     * Retrieve a list of all coffees.
     *
     * @return List of coffee objects.
     */
    public List<coffee> getAllCoffees() {
        return coffeeRepository.findAll();
    }

    /**
     * Retrieve a coffee by its unique identifier.
     *
     * @param id The unique identifier of the coffee.
     * @return coffee object.
     */
    public coffee getCoffeeById(Long id) {
        Optional<coffee> optionalCoffee = coffeeRepository.findById(id);
        if (optionalCoffee.isPresent()) {
            return optionalCoffee.get();
        } else {
            throw new RuntimeException("Coffee not found with id: " + id);
        }
    }

    /**
     * Create a new coffee.
     *
     * @param coffeeEntity The coffee entity to be created.
     * @return Created coffee object.
     */
    public coffee createCoffee(coffee coffeeEntity) {
        return coffeeRepository.save(coffeeEntity);
    }

    /**
     * Update an existing coffee by its unique identifier.
     *
     * @param id            The unique identifier of the coffee to be updated.
     * @param coffeeDetails The updated coffee entity.
     * @return Updated coffee object.
     */
    public coffee updateCoffee(Long id, coffee coffeeDetails) {
        coffee existingCoffee = getCoffeeById(id);
        existingCoffee.setPrice(coffeeDetails.getPrice());
        existingCoffee.setSupplier(coffeeDetails.getSupplier());
        // Update any other fields as necessary
        return coffeeRepository.save(existingCoffee);
    }

    /**
     * Delete a coffee by its unique identifier.
     *
     * @param id The unique identifier of the coffee to be deleted.
     */
    public void deleteCoffee(Long id) {
        coffee existingCoffee = getCoffeeById(id);
        coffeeRepository.delete(existingCoffee);
    }
}
