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
public class nonFragile extends Product
{
    private String origin;
    private double altitude;
    private String tasteNotes;
    
    public nonFragile(String prodID,String prodName,int prodQuan, double prodPrice, double prodWeight, String param1, double param2, String param3)
    {
        super(prodID,prodName,prodQuan, prodPrice,prodWeight);
        this.origin = param1;
        this.altitude = param2;
        this.tasteNotes = param3;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",productID,productName,prodQuantity,productPrice,productWeight,origin,altitude,tasteNotes);
    }
}

