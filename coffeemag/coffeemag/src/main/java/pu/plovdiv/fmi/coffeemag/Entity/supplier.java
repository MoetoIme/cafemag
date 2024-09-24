package pu.plovdiv.fmi.coffeemag.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<coffee> coffees;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoffees(List<coffee> coffees) {
        this.coffees = coffees;
    }

    public String getName() {
        return name;
    }

    public List<coffee> getCoffees() {
        return coffees;
    }

    public Long getId() {
        return id;
    }
}