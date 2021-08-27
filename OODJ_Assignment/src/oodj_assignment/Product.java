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
public class Product 
{
    protected String productID;
    protected String productName;
    protected int prodQuantity;
    protected double productPrice;
    protected double productWeight;
    
    public Product(){}
    
    public Product(String prodID,String prodName,int prodQuan, double prodPrice, double prodWeight)
    {
        this.productID = prodID;
        this.productName = prodName;
        this.prodQuantity = prodQuan;
        this.productPrice = prodPrice;
        this.productWeight = prodWeight;
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
    
}


