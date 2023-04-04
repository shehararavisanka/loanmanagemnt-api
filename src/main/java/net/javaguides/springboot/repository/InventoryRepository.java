package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Brands;
import net.javaguides.springboot.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
