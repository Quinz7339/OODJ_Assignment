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
public class Fragile extends Product
{
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProdQuantity() {
        return prodQuantity;
    }

    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(double productWeight) {
        this.productWeight = productWeight;
    }
    
    
    public Fragile(String prodID,String prodName,int prodQuan, double prodPrice, double prodWeight, String param1)
    {
        super(prodID,prodName,prodQuan, prodPrice,prodWeight);
        this.brand = param1;
    }
    public String toString()
    {
        return String.format("%s,%s,%s,%s,%s,%s",productID,productName,prodQuantity,productPrice,productWeight,brand);
    }
}
