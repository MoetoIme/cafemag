package pu.plovdiv.fmi.coffeemag.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class workers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<customer> customers;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<customer> getCustomers() {
        return customers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomers(List<customer> customers) {
        this.customers = customers;
    }
}

