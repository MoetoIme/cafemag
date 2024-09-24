package pu.plovdiv.fmi.coffeemag.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pu.plovdiv.fmi.coffeemag.Entity.supplier;

@Repository
public interface suppliersR extends JpaRepository<supplier, Long> { }

