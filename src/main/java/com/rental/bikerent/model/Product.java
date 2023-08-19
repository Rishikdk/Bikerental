package com.rental.bikerent.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    private String pName;
    @Column(length = 3000)
    private String pDec;
    private String pPhoto;

    private int pPrice;
    private int pDis;
    private int pQuantity;
    @ManyToOne
    private Category category;

    public Product() {

    }

    public Product(String pName, String pDec, String pPhoto, int pPrice, int pDis, int pQuantity, Category category) {
        this.pName = pName;
        this.pDec = pDec;
        this.pPhoto = pPhoto;
        this.pPrice = pPrice;
        this.pDis = pDis;
        this.pQuantity = pQuantity;
        this.category=category;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDec() {
        return pDec;
    }

    public void setpDec(String pDec) {
        this.pDec = pDec;
    }

    public String getpPhoto() {
        return pPhoto;
    }

    public void setpPhoto(String pPhoto) {
        this.pPhoto = pPhoto;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public int getpDis() {
        return pDis;
    }

    public void setpDis(int pDis) {
        this.pDis = pDis;
    }

    public int getpQuantity() {
        return pQuantity;
    }

    public void setpQuantity(int pQuantity) {
        this.pQuantity = pQuantity;
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
                ", pDec='" + pDec + '\'' +
                ", pPhoto='" + pPhoto + '\'' +
                ", pPrice=" + pPrice +
                ", pDis=" + pDis +
                ", pQuantity=" + pQuantity +
                '}';
    }
}
