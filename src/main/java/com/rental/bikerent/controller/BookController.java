package com.rental.bikerent.controller;

import com.rental.bikerent.model.Book;
import com.rental.bikerent.model.Product;
import com.rental.bikerent.model.User;
import com.rental.bikerent.repository.ArproductRepository;
import com.rental.bikerent.repository.BookRepository;
import com.rental.bikerent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ArproductRepository arproductRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/do_booking",method = RequestMethod.POST)
    public String booking(@ModelAttribute("Book") Book book, @RequestParam("pid")Integer pid, Principal principal){

        Product product = arproductRepository.getReferenceById(Long.valueOf(pid));
        User user = userRepository.getUserByUserName(principal.getName());
        book.setUser(user);
        book.setProduct(product);
        Book book1 = bookRepository.save(book);
        System.out.println(book1);
        return "redirect:/user/home";
    }
}
