package com.rental.bikerent.map;

import com.rental.bikerent.Dto.AdSproductDto;
import com.rental.bikerent.model.Category;
import com.rental.bikerent.model.Sellingp;
import com.rental.bikerent.repository.ASellingProductRepository;
import com.rental.bikerent.repository.AcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Objects;

@Controller
public class AdSellingProduct {
    @Autowired
    private ASellingProductRepository aSellingProductRepository;

    @Autowired
    private AcategoryRepository acategoryRepository;

    @RequestMapping(value="/deleteSelling", method= RequestMethod.POST)
    public String deleteSelling(@RequestParam("id") Integer id){

        aSellingProductRepository.deleteById(Long.valueOf(id));
        return "redirect:/admin/add_Sproduct";
    }

    @RequestMapping(value="/add_Sproduct", method= RequestMethod.POST)
    public String asproduct(@ModelAttribute AdSproductDto adSproductDto , @RequestParam("profileS")MultipartFile file, Principal principal){
        try {
//            Sellingp to = aSellingProductRepository.save(sellingp);
//            System.out.println(to.getSname());
//        System.out.println(product.getpName());

//            String name = principal.getName();
            Category category= this.acategoryRepository.getCategoryByCategoryTitle(adSproductDto.getCategoryTitle());
            Sellingp sellingp = new Sellingp();
          sellingp.setCategorys(category);
          sellingp.setSdec(adSproductDto.getSdec());
          sellingp.setSbrand(adSproductDto.getSbrand());
          sellingp.setSname(adSproductDto.getSname());
          sellingp.setSprice(adSproductDto.getSprice());
          sellingp.setSquantity(adSproductDto.getSquantity());
          sellingp.setSdis(adSproductDto.getSdis());

          this.acategoryRepository.save(category);


            if (file.isEmpty()) {
                System.out.println("No image found");
            } else {
                sellingp.setsPic(file.getOriginalFilename());
                Path targetLocation = Paths.get("src/main/resources/static/spic").resolve(Objects.requireNonNull(file.getOriginalFilename()));
                Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("uplode");
                Sellingp sellingp1=this.aSellingProductRepository.save(sellingp);
                return "redirect:/admin/add_Sproduct";


            }
        }catch (Exception e){
            System.out.println("ERROR" + e.getMessage());
            return "redirect:/admin/home";
        }
        return "redirect:/admin/home";
    }
}
