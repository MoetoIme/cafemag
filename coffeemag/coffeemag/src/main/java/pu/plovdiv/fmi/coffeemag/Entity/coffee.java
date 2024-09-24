package pu.plovdiv.fmi.coffeemag.Entity;

import jakarta.persistence.*;

@Entity
public class coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;

    @ManyToOne
    private supplier Supplier;

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setSupplier(supplier supplier) {
        Supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public supplier getSupplier() {
        return Supplier;
    }
}
