package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Brands;
import net.javaguides.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsRepository extends JpaRepository<Brands, Long> {
}
