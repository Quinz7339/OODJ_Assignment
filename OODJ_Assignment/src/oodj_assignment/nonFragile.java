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
    
    public nonFragile(String productID,String productName, double productPrice, double weight, String param1, double param2, String param3)
    {
        super(productID,productName, productPrice,weight);
        this.origin = param1;
        this.altitude = param2;
        this.tasteNotes = param3;
    }
}

