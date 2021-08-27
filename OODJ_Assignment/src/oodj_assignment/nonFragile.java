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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public String getTasteNotes() {
        return tasteNotes;
    }

    public void setTasteNotes(String tasteNotes) {
        this.tasteNotes = tasteNotes;
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

