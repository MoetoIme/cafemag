package pu.plovdiv.fmi.coffeemag.contollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pu.plovdiv.fmi.coffeemag.Entity.coffee;
import pu.plovdiv.fmi.coffeemag.Entity.customer;
import pu.plovdiv.fmi.coffeemag.Service.coffeeService;

import java.util.List;

/**
 * Controller for managing customer-related operations.
 */
@RestController
@RequestMapping("/customers")
public class coffeeContoller {

    private final coffeeService CoffeeService;

    @Autowired
    public coffeeContoller(coffeeService coffeeService) {
        CoffeeService = coffeeService;
    }
    @GetMapping
    public List<coffee> getAllCoffees() {
        return CoffeeService.getAllCoffees();
    }
    @GetMapping("/{id}")
    public coffee getcoffeeById(@PathVariable Long id) {
        return CoffeeService.getCoffeeById(id);
    }
    @PostMapping
    public coffee createCoffee(@RequestBody coffee coffeeEntity) {
        return CoffeeService.createCoffee(coffeeEntity);
    }
    @PutMapping("/{id}")
    public coffee updateCoffee(@PathVariable Long id, @RequestBody coffee coffeeEntity) {
        return CoffeeService.updateCoffee(id, coffeeEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteCoffee(@PathVariable Long id) {
        CoffeeService.deleteCoffee(id);
    }
}

