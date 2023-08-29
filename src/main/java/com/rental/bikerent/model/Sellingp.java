package com.rental.bikerent.model;

import javax.persistence.*;

@Entity
@Table(name="sell")
public class Sellingp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String sname;
    private int sprice;
    private String sdis;
    private int squantity;

    private String sbrand;
    private String sdec;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSprice() {
        return sprice;
    }

    public void setSprice(int sprice) {
        this.sprice = sprice;
    }

    public String getSdis() {
        return sdis;
    }

    public void setSdis(String sdis) {
        this.sdis = sdis;
    }

    public int getSquantity() {
        return squantity;
    }

    public void setSquantity(int squantity) {
        this.squantity = squantity;
    }

    public String getSbrand() {
        return sbrand;
    }

    public void setSbrand(String sbrand) {
        this.sbrand = sbrand;
    }

    public String getSdec() {
        return sdec;
    }

    public void setSdec(String sdec) {
        this.sdec = sdec;
    }

    @Override
    public String toString() {
        return "Sellingp{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", sprice=" + sprice +
                ", sdis='" + sdis + '\'' +
                ", squantity=" + squantity +
                ", sbrand='" + sbrand + '\'' +
                ", sdec='" + sdec + '\'' +
                '}';
    }
}
