package pu.plovdiv.fmi.coffeemag.contollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pu.plovdiv.fmi.coffeemag.Entity.supplier;
import pu.plovdiv.fmi.coffeemag.Service.supplierService;

import java.util.List;

/**
 * Controller for managing customer-related operations.
 */
@RestController
@RequestMapping("/customers")
public class supplierContoller {

    private final supplierService SupplierService;

    @Autowired
    public supplierContoller(supplierService supplierService) {
        SupplierService = supplierService;
    }

    @GetMapping
    public List<supplier> getAllSuppliers() {
        return SupplierService.getAllSuppliers();
    }

    @GetMapping("/{id}")
    public supplier getSupplierById(@PathVariable Long id) {
        return SupplierService.getSupplierById(id);
    }
    @PostMapping
    public supplier createsupplier(@RequestBody supplier supplierEntity) {
        return SupplierService.createSupplier(supplierEntity);
    }
    @PutMapping("/{id}")
    public supplier updateSupplier(@PathVariable Long id, @RequestBody supplier supplierEntity) {
        return SupplierService.updateSupplier(id, supplierEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        SupplierService.deleteSupplier(id);
    }
}
