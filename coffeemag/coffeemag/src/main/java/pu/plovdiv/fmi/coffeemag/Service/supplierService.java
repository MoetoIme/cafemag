package pu.plovdiv.fmi.coffeemag.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pu.plovdiv.fmi.coffeemag.Entity.supplier;
import pu.plovdiv.fmi.coffeemag.Repository.suppliersR;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing supplier-related operations.
 */
@Service
public class supplierService {

    private final suppliersR suppliersR;
    private suppliersR supplierRepository;

    @Autowired
    public supplierService(suppliersR supplierRepository) {
        this.suppliersR = supplierRepository;
    }

    /**
     * Retrieve a list of all suppliers.
     *
     * @return List of SupplierEntity objects.
     */
    public List<supplier> getAllSuppliers() {
        return suppliersR.findAll();
    }

    /**
     * Retrieve a supplier by their unique identifier.
     *
     * @param id The unique identifier of the supplier.
     * @return SupplierEntity object or null if not found.
     */
    public supplier getSupplierById(Long id) {
        Optional<supplier> supplier = suppliersR.findById(id);
        return supplier.orElse(null);
    }

    /**
     * Create a new supplier.
     *
     * @param supplierEntity The supplier entity to be created.
     * @return Created SupplierEntity object.
     */
    public supplier createSupplier(supplier supplierEntity) {
        return suppliersR.save(supplierEntity);
    }

    /**
     * Update an existing supplier by their unique identifier.
     *
     * @param id             The unique identifier of the supplier to be updated.
     * @param supplierEntity The updated supplier entity.
     * @return Updated SupplierEntity object or null if not found.
     */
    public supplier updateSupplier(Long id, supplier supplierEntity) {
        if (suppliersR.existsById(id)) {
            supplierEntity.setId(id);
            return suppliersR.save(supplierEntity);
        } else {
            return null; // Handle not found error
        }
    }

    /**
     * Delete a supplier by their unique identifier.
     *
     * @param id The unique identifier of the supplier to be deleted.
     */
    public void deleteSupplier(Long id) {
        suppliersR.deleteById(id);
    }

    /**
     * Associate a supplier with a product.
     *
     * @param supplierId The unique identifier of the supplier.
     * @param productId  The unique identifier of the product.
     * @return Updated SupplierEntity object or null if not found.
     */
    public supplier associateSupplierWithProduct(Long supplierId, Long productId) {
        supplier Supplier = suppliersR.findById(supplierId).orElse(null);
        if (Supplier != null) {
            // Assuming you have a method in supplier entity to add a product
            // Supplier.addProduct(productId);
            suppliersR.save(Supplier);
        }
        return Supplier;
    }
}
