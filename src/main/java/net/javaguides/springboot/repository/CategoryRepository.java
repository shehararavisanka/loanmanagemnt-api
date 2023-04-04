package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Brands;
import net.javaguides.springboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
