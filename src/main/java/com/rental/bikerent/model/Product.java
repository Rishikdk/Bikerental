package com.rental.bikerent.model;

import javax.persistence.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;
    private String pName;
    private int pPrice;

    private String pPic;

    private java.sql.Date pRepair;
    private int pDiscount;

    private String pbrand;

    private int pQuantity;

    private int pbooked;
    @ManyToOne
   private Category category;

    public String getPbrand() {
        return pbrand;
    }

    public void setPbrand(String pbrand) {
        this.pbrand = pbrand;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public Date getpRepair() {
        return pRepair;
    }

    public void setpRepair(Date pRepair) {
        this.pRepair = pRepair;
    }

    public int getpDiscount() {
        return pDiscount;
    }

    public void setpDiscount(int pDiscount) {
        this.pDiscount = pDiscount;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
    }

    public int getPbooked() {
        return pbooked;
    }

    public void setPbooked(int pbooked) {
        this.pbooked = pbooked;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                ", pPic='" + pPic + '\'' +
                ", pRepair=" + pRepair +
                ", pDiscount=" + pDiscount +
                ", pbrand='" + pbrand + '\'' +
                ", pQuantity=" + pQuantity +
                ", pbooked=" + pbooked +
                ", category=" + category +
                '}';
    }
}


//    public void setpRepair(String pRepair) throws ParseException {
////        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-mm-dd");
//
//        SimpleDateFormat receivedDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        java.util.Date date = receivedDateFormat.parse(pRepair);
//        this.pRepair = java.sql.Date.valueOf(LocalDate.now());
//    }