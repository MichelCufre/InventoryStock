package com.stock.stock.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.stock.Classes.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    boolean existsByName(String name);
}
