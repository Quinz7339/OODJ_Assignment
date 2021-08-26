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
    public Fragile(String productID,String productName,int productQuan, double productPrice, double weight, String param1)
    {
        super(productID,productName,productQuan, productPrice,weight);
    }
}
