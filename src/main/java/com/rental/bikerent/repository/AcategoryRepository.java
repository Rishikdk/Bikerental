package com.rental.bikerent.repository;

import com.rental.bikerent.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcategoryRepository extends JpaRepository<Category, Integer> {

//   public Category getCategoryByCategoryName(String name);
}
