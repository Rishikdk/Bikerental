package com.rental.bikerent.repository;

import com.rental.bikerent.model.Category;
import com.rental.bikerent.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArproductRepository extends JpaRepository<Product, Long> {
}
