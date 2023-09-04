package com.rental.bikerent.repository;

import com.rental.bikerent.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
