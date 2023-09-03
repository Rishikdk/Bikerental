package com.rental.bikerent.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto inc of id
    private Long categoryId;
    private  String categoryTitle;
    @Column(length = 50000)
    private String categoryDec;
@OneToMany(mappedBy = "category")
    private List<Product> product= new ArrayList<>();

@OneToMany(mappedBy = "categorys" )
    private List<Sellingp> sellingp = new ArrayList<>();

    public Category() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryDec() {
        return categoryDec;
    }

    public void setCategoryDec(String categoryDec) {
        this.categoryDec = categoryDec;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public List<Sellingp> getSellingp() {
        return sellingp;
    }

    public void setSellingp(List<Sellingp> sellingp) {
        this.sellingp = sellingp;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryTitle='" + categoryTitle + '\'' +
                ", categoryDec='" + categoryDec + '\'' +
                ", product=" + product +
                ", sellingp=" + sellingp +
                '}';
    }
}
