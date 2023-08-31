package com.rental.bikerent.map;

import com.rental.bikerent.model.Category;
import com.rental.bikerent.model.Sellingp;
import com.rental.bikerent.repository.ASellingProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdSellingProduct {
    @Autowired
    private ASellingProductRepository aSellingProductRepository;

    @RequestMapping(value="/add_Sproduct", method= RequestMethod.POST)
    public String asproduct( @ModelAttribute("sell") Sellingp sellingp){
        Sellingp to = aSellingProductRepository.save(sellingp);
        System.out.println(to.getSname());
//        System.out.println(product.getpName());
        return "Admin/home";
    }
}
