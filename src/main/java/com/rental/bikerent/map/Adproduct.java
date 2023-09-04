package com.rental.bikerent.map;

import com.rental.bikerent.Dto.AdRproductDto;
import com.rental.bikerent.model.Category;
import com.rental.bikerent.model.Product;
import com.rental.bikerent.repository.AcategoryRepository;
import com.rental.bikerent.repository.ArproductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Objects;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class Adproduct {
    @Autowired
    private ArproductRepository arproductRepository;

    @Autowired
    private  AcategoryRepository acategoryRepository;

//for delete
    @RequestMapping(value="/deleteProduct", method= RequestMethod.POST)
    public String deleteRenting(@RequestParam("id") Integer id){

        arproductRepository.deleteById(Long.valueOf(id));
        return "redirect:/admin/product";
    }
//update work
    @RequestMapping(value="/updateRproduct", method= RequestMethod.POST)
        public String updateRproduct(@ModelAttribute AdRproductDto adRproductDto, @RequestParam("profile")MultipartFile file, Model model, HttpSession session,Principal principal)
    {
        try {
           Product oldproduct =this.arproductRepository.findById(adRproductDto.getpId()).get();
                //old data
//            Product oldproduct= this.arproductRepository.findAllById(productrequest.getpId());
//            String name= principal.getName();
            Product product= new Product();
            Category category= this.acategoryRepository.getCategoryByCategoryTitle(adRproductDto.getCategoryTitle());
            product.setCategory(category);
            product.setPbooked(adRproductDto.getPbooked());
        product.setpId(adRproductDto.getpId());
        product.setpDiscount(adRproductDto.getpDiscount());
        product.setpPrice(adRproductDto.getpPrice());
        product.setpName(adRproductDto.getpName());
        product.setpRepair(adRproductDto.getpRepair());
        product.setpQuantity(adRproductDto.getpQuantity());
//
            //image..
            if(!file.isEmpty()){



//                update new photo
                Path targetLocation = Paths.get("src/main/resources/static/pic").resolve(Objects.requireNonNull(file.getOriginalFilename()));
                Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);
                product.setpPic(file.getOriginalFilename());
                product.setpPic(file.getOriginalFilename());


            }else
            {
               product.setpPic(oldproduct.getpPic());


            }
            this.arproductRepository.save(product);


        }catch (Exception e){
            e.printStackTrace();

        }

//        System.out.println("Product name:" + product.getpName());
        return "redirect:/admin/product";
        }






    @RequestMapping(value="/add_Renting", method= RequestMethod.POST)
    public String processRenting(@ModelAttribute AdRproductDto adRproductDto, @RequestParam("profile") MultipartFile file, Principal principal, Model model){
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
              //  System.out.println("uploded");
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
