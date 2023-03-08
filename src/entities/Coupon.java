/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author BouheniMed
 */
public class Coupon {
    private int id_coupon;
    private Float reduction;
    private String coupon;
 

public Coupon() {
 this.id_coupon = id_coupon;
        this.reduction = reduction;
        this.coupon = coupon;     
}

    public Coupon(int id_coupon, Float reduction, String coupon) {
        this.id_coupon = id_coupon;
        this.reduction = reduction;
        this.coupon = coupon;
    }

    public int getId_coupon() {
        return id_coupon;
    }

    public void setId_coupon(int id_coupon) {
        this.id_coupon = id_coupon;
    }

    public Float getReduction() {
        return reduction;
    }

    public void setReduction(Float reduction) {
        this.reduction = reduction;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        return "Coupon{" + "id_coupon=" + id_coupon + ", reduction=" + reduction + ", coupon=" + coupon + '}';
    }
 
}