package com.inventory.repositories;

import com.inventory.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<Product, Long> {
    Product findByProductID(@Param("productID") Long id);
}
