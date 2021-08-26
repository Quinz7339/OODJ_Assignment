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
