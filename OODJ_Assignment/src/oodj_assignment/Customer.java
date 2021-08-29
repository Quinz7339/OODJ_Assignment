/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;
import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.JFrame;
import static oodj_assignment.Admin.errorMessage;

/**
 *
 * @author phili
 */
public class Customer 
{
    static JFrame errorMessage;
    protected String UID;
    protected String username;
    protected String password;
    protected String name;
    protected String emailAddress;
    protected String phoneNumber;
    protected String address;
    
    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Customer (){}
    public Customer (Customer cus)
    {
        this.UID = cus.getUID();
        this.username=cus.getUsername();
        this.password=cus.getPassword();
        this.name=cus.getName();
        this.emailAddress=cus.getEmailAddress();
        this.phoneNumber=cus.getPhoneNumber();
        this.address=cus.getAddress();
    } 
    
    public Customer (String uid, String usr, String pw, String Name, String Email, String phoneNo, String Address)
    {
        this.UID=uid;
        this.username=usr;
        this.password=pw;
        this.name=Name;
        this.emailAddress=Email;
        this.phoneNumber=phoneNo;
        this.address=Address;
    }
    
    public Customer login(String usr, String pwd)
    {
        try
        {
            //compare username with all the username in the text file
            BufferedReader br = new BufferedReader(new FileReader("src\\oodj_assignment\\textFile\\Users.txt"));
            String line;
            Boolean flagUsrname = false;
            Boolean flagPwd = false;
            
            while ((line = br.readLine()) != null)
            {
                String [] user = line.split(","); //splits user detail by commas
                Customer User = new Customer(user[0],user[1],user[2],user[3],user[4],user[5],user[6]);
                
                if (usr.equals(user[1]))
                {
                    flagUsrname = true;
                    
                    if (pwd.equals(user[2]))
                    {
                        flagPwd = true;
                        if (flagUsrname == true && flagPwd == true)
                        {
                            return User;
                        }
                        else
                        {
                            return null;
                        }
                    }
                }
                
            }
            br.close();
        }
        catch(IOException Ex)
        {
            JOptionPane.showMessageDialog(errorMessage, " An Error Occured. Please try again","Error",JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }

    // TO view/browse product to be added into order items
    public ArrayList browseProd()
    {
        ArrayList<Object> prodList = new ArrayList();
        // ArrayList<Product> nonFragProdList = new ArrayList<nonFragile>();
        try
        {
            //ArrayList to store Customer objects
            Scanner scanner = new Scanner (new File("src\\oodj_assignment\\textFile\\Products.txt"));
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String [] prod = line.split(",");
                
                if (prod.length == 6)
                {
                    Product fragProd = new Fragile (prod[0],prod[1],Integer.parseInt(prod[2]),Double.parseDouble(prod[3]),Double.parseDouble(prod[4]),prod[5]);
                    prodList.add(fragProd);
                }
                else if (prod.length == 8)
                {
                    Product nonFragProd = new nonFragile (prod[0],prod[1],Integer.parseInt(prod[2]),Double.parseDouble(prod[3]),Double.parseDouble(prod[4]),prod[5], Double.parseDouble(prod[6]), prod[7]);
                    prodList.add(nonFragProd);
                }
            }
            scanner.close();
        }
        catch(IOException Ex)
        {
            JOptionPane.showMessageDialog(errorMessage, "File is corrupted or manually tampered. Kindly revert the changes.","Error",JOptionPane.WARNING_MESSAGE);
        }
        return prodList;
    }
    
    public void addOrder(Order order)
    {
        try
        {
            PrintWriter pw = new PrintWriter(new FileWriter(new File("src\\oodj_assignment\\textFile\\Orders.txt"),true));
            for (OrderItem orderItem: order.getOrderItem())
            {
                pw.println(String.format("%s,%s,%s,%s,%s,%s", order.getOrderID(),this.UID, orderItem.getProductID(), orderItem.getBuyQuan(), orderItem.calcSubtotal(),order.getPayStatus()));
            }
            pw.close();
        }
        catch (IOException Ex)
        {
            JOptionPane.showMessageDialog(errorMessage, "File not found!","Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public String genOrderID()
    {
        try
        {
            ArrayList <Integer> orderIDList = new ArrayList<Integer>();

            Scanner scanner = new Scanner (new File("src\\oodj_assignment\\textFile\\Orders.txt"));
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String [] order = line.split(",");
                int orderID = Integer.parseInt(order[0].substring(3));    //removes the prefix of the User ID (ADM, CUS)
                orderIDList.add(orderID);
                    
            }
            
            if (orderIDList.size() == 0)
            {
                orderIDList.add(0);
            }
                        
            String newOrderID = "ODR" + String.valueOf(Collections.max(orderIDList,null) + 1);
            return newOrderID;
        }
        catch(IOException Ex)
        {
            JOptionPane.showMessageDialog(errorMessage, "File is corrupted or manually tampered. Kindly revert the changes.","Error",JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    
    public ArrayList viewOrder(String UID) throws IOException
    {
        ArrayList<Order> orderList = new ArrayList<Order>();
        ArrayList<OrderItem> orderItems = new ArrayList();
        ArrayList<Object> prodList = new ArrayList();
        Admin adm = new Admin();
        prodList = adm.viewProduct();
        ArrayList<String> tempOrderIDDup = new ArrayList();
        ArrayList<String> tempOrderIDNoDup = new ArrayList();
        
        //retrieve order and get its order item's details with the product list
        try
        {
            //ArrayList to retrieve  objects
            Scanner scannerOrder = new Scanner (new File("src\\oodj_assignment\\textFile\\Orders.txt"));
            while (scannerOrder.hasNextLine())
            {
                String line = scannerOrder.nextLine();
                String [] odrVar = line.split(",");
                
                if (odrVar[1].equals(this.UID))
                {
                    tempOrderIDDup.add(odrVar[0]);
                    for (Object prod: prodList)
                    {
                        if (prod instanceof Fragile)
                        {
                            Fragile fragProd = (Fragile) prod;
                            if (odrVar[2].equals(fragProd.getProductID()))
                            {
                                OrderItem orderItem = new OrderItem(odrVar[2], fragProd.getProductName(), Integer.parseInt(odrVar[3]), fragProd.getProductPrice(), fragProd.calcShipping());
                                orderItems.add(orderItem);
                            }

                        }
                        else
                        {
                            nonFragile nonFragProd = (nonFragile) prod;
                            if (odrVar[2].equals(nonFragProd.getProductID()))
                            {
                                OrderItem orderItem = new OrderItem(odrVar[2], nonFragProd.getProductName(), Integer.parseInt(odrVar[3]), nonFragProd.getProductPrice(), nonFragProd.calcShipping());
                                orderItems.add(orderItem);
                            }
                        }
                    }
                }
            }
            for (String OrderID : tempOrderIDDup) 
            {
                // If this element is not present in tempOrderIDNoDup
                // then add it
                if (!tempOrderIDNoDup.contains(OrderID)) 
                {
                    tempOrderIDNoDup.add(OrderID);
                }
            }
            
            for (String OrderID: tempOrderIDNoDup)
            {
                Order orders = new Order(OrderID,orderItems);
                orderList.add(orders);
            }
            scannerOrder.close();
        }
        catch(IOException Ex)
        {
            JOptionPane.showMessageDialog(errorMessage, "File is corrupted or manually tampered. Kindly revert the changes.","Error",JOptionPane.WARNING_MESSAGE);
        }
        return orderList;
    }
    public String toString()
    {
         return  String.format("%s,%s,%s,%s,%s,%s,%s",UID,username,password,name, emailAddress,phoneNumber,address);
    }
}
