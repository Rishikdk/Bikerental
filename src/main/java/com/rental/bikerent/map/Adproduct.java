package com.rental.bikerent.map;

import com.rental.bikerent.model.Category;
import com.rental.bikerent.model.Product;
import com.rental.bikerent.repository.AcategoryRepository;
import com.rental.bikerent.repository.ArproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

@Controller
public class Adproduct {
    @Autowired
    private ArproductRepository arproductRepository;

    @Autowired
    private  AcategoryRepository acategoryRepository;



//    @RequestMapping(value="/add_Rentingp", method= RequestMethod.POST)
//
//    public String arproduct(@RequestBody AdRproductDto adRproductDto) throws Exception {
//        Product product= new Product();
//        Category category = acategoryRepository.findById(1)
//                .orElseThrow(() -> new Exception("Category not found"));
//        product.setCategory(category);
//        product.setpName(adRproductDto.getpName());
//        product.setpPic(adRproductDto.getpPic());
//        product.setPbooked(adRproductDto.getPbooked());
//        product.setpDiscount(adRproductDto.getpDiscount());
//        product.setpQuantity(adRproductDto.getpQuantity());
//        product.setpPrice(adRproductDto.getpPrice());
//        product.setpRepair(adRproductDto.getpRepair());
//
//
////        arproductRepository.save((Product)product);
//        Product product1= arproductRepository.save((Product)product);
//System.out.println(product1.getpName());
////        System.out.println(product.getpName());
//        return "Admin/home";
//    }


    @RequestMapping(value="/add_Renting", method= RequestMethod.POST)
//    @PostMapping("/add_Renting")
    public String processRenting(@ModelAttribute AdRproductDto adRproductDto, @RequestParam("profile") MultipartFile file, Principal principal){
    try {

        String name = principal.getName();
        Category category= this.acategoryRepository.getCategoryByCategoryTitle(adRproductDto.getCategoryTitle());
        Product product = new Product();

        product.setCategory(category);
        product.setpDiscount(adRproductDto.getpDiscount());
        product.setpName(adRproductDto.getpName());
        product.setpPrice(adRproductDto.getpPrice());
        product.setpQuantity(adRproductDto.getpQuantity());
        product.setpRepair(adRproductDto.getpRepair());


        this.acategoryRepository.save(category);
        product.setPbooked(0);
    //uplode file image
            if(file.isEmpty()){
                System.out.println("No image found");
            }
            else{
                product.setpPic(file.getOriginalFilename());
                Path targetLocation = Paths.get("src/main/resources/static/pic").resolve(Objects.requireNonNull(file.getOriginalFilename()));
                Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("uploded");
                Product product1 = this.arproductRepository.save(product);
                return "redirect:/admin/add_Rproduct";

            }
    }catch (Exception e){
        System.out.println("ERROR"+ e.getMessage());
        return "redirect:/admin/add_Rproduct";
    }
        return "redirect:/admin/add_Rproduct";
    }
}
