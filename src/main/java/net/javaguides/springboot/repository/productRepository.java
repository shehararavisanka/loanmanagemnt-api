package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<Product, Long> {
}
