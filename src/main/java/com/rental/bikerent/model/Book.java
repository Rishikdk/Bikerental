package com.rental.bikerent.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bid;
    private java.sql.Date fdate;
    private java.sql.Date ldate;

    private Integer bquantity;



    @ManyToOne
    private User user;

    @ManyToOne
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getBquantity() {
        return bquantity;
    }

    public void setBquantity(Integer bquantity) {
        this.bquantity = bquantity;
    }

    public long getBid() {
        return bid;
    }

    public void setBid(long bid) {
        this.bid = bid;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public Date getLdate() {
        return ldate;
    }

    public void setLdate(Date ldate) {
        this.ldate = ldate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", fdate=" + fdate +
                ", ldate=" + ldate +
                ", bquantity=" + bquantity +
                ", user=" + user +
                ", product=" + product +
                '}';
    }
}
