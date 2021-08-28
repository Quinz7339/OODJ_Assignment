/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

/**
 *
 * @author phili
 */
public class OrderItem 
{
    private final String productID;
    private final String productName;
    private final int buyQuan;
    private final double productPrice;
    private final double shippingFee;

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getBuyQuan() {
        return buyQuan;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public double calcSubtotal()
    {
        return buyQuan * productPrice + shippingFee;
    }
    public OrderItem(String ID, String prodName, int buyQuan, double prodPrice, double prodShippingFee)
    {
        this.productID = ID;
        this.productName = prodName;
        this.buyQuan = buyQuan;
        this.productPrice = prodPrice;
        this.shippingFee = prodShippingFee;
    }
}
