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
    protected double weight;
    
    public Product(String productID,String productName,int productQuan, double productPrice, double weight)
    {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.weight = weight;
    }
}


