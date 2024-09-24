package pu.plovdiv.fmi.coffeemag.Entity;

import jakarta.persistence.*;
import pu.plovdiv.fmi.coffeemag.Entity.coffee;

import java.util.List;
@Entity
public class customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name="coffee")
    private coffee Coffee;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoffee(coffee coffee) {
        Coffee = coffee;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public coffee getCoffee() {
        return Coffee;
    }
}
