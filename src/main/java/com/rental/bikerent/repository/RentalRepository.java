package com.rental.bikerent.repository;

import com.rental.bikerent.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Product, Long> {


}
