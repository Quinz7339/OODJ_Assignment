/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;

import java.util.ArrayList;

/**
 *
 * @author phili
 */
public class Order 
{
    private final String orderID;
    private final ArrayList<OrderItem> orderItem;
    private final double grandTotal;
    private final String payStatus = "Unpaid";  

    public String getOrderID() {
        return orderID;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public ArrayList<OrderItem> getOrderItem() {
        return orderItem;
    }

    public double getGrandTotal() {
        return grandTotal;
    }
    
    public Order(String orderID, ArrayList<OrderItem> orderItem) 
    {
        this.orderID = orderID;
        this.orderItem = orderItem;
        double tempGrandTotal = 0;
        for (OrderItem orderItems: orderItem)
        {
            tempGrandTotal = orderItems.calcSubtotal() + tempGrandTotal;
        }
        this.grandTotal = tempGrandTotal;
    }
}
