package com.rental.bikerent.map;

import com.rental.bikerent.model.Category;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.util.Date;

public class AdRproductDto {
    private Long pId;
    private String pName;
    private int pPrice;

    private String pPic;
    private Date pRepair;
    private int pDiscount;

    private int pQuantity;
private long categoryId;
    private int pbooked;

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

    @Override
    public String toString() {
        return "AdRproductDto{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                ", pPic='" + pPic + '\'' +
                ", pRepair=" + pRepair +
                ", pDiscount=" + pDiscount +
                ", pQuantity=" + pQuantity +
                ", pbooked=" + pbooked +
                '}';
    }
}
