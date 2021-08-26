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
    
    public Product(String prodID,String prodName,int prodQuan, double prodPrice, double prodWeight)
    {
        this.productID = prodID;
        this.productName = prodName;
        this.prodQuantity = prodQuan;
        this.productPrice = prodPrice;
        this.productWeight = prodWeight;
    }
}


