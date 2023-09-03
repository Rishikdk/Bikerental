package com.rental.bikerent.repository;

import com.rental.bikerent.model.Category;
import com.rental.bikerent.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArproductRepository extends JpaRepository<Product, Long> {


//    List<Product> findByProductType(String productType);

    //position based param
//    @Query("from Product p where p.productType= ?1")
//    List<Product> findByProduct(String productType);

    //named parameters
    //@Query("from product p where p.productType= :productType")
    //List<Product> findByProduct2(@Param("productType") String productType);
}
