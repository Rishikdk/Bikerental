//package com.rental.bikerent.model;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Category {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto inc of id
//    private int categoryId;
//    private  String categoryTitle;
//    private String categoryDec;
//@OneToMany(mappedBy = "category")
//    private List<Product> product= new ArrayList<>();
//
//    public Category() {
//    }
//
//    public Category(int categoryId, String categoryTitle, String categoryDec) {
//        this.categoryId = categoryId;
//        this.categoryTitle = categoryTitle;
//        this.categoryDec = categoryDec;
//    }
//
//    public Category(List<Product> product) {
//        this.product = product;
//    }
//
//    public Category(String categoryTitle, String categoryDec) {
//        this.categoryTitle = categoryTitle;
//        this.categoryDec = categoryDec;
//
//    }
//
//
//
//    public int getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(int categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public String getCategoryTitle() {
//        return categoryTitle;
//    }
//
//    public void setCategoryTitle(String categoryTitle) {
//        this.categoryTitle = categoryTitle;
//    }
//
//    public String getCategoryDec() {
//        return categoryDec;
//    }
//
//    public void setCategoryDec(String categoryDec) {
//        this.categoryDec = categoryDec;
//    }
//
//    public List<Product> getProduct() {
//        return product;
//    }
//
//    public void setProduct(List<Product> product) {
//        this.product = product;
//    }
//
//    @Override
//    public String toString() {
//        return "Category{" +
//                "categoryId=" + categoryId +
//                ", categoryTitle='" + categoryTitle + '\'' +
//                ", categoryDec='" + categoryDec + '\'' +
//                '}';
//    }
//}
