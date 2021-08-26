/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;
import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author phili
 */
public class Admin extends Customer 
{
    static JFrame errorMessage;
    
    
    public Admin(String username, String password, String name, String email, String phoneNo, String address, String userType)
    {
        super(username,password, name, email, phoneNo,  address, userType);
    }
    
    public static void addUser(String username, String password, String name, String email, String phoneNo, String address, String userType)
    {
        try
        {
            //compare username with all the username in the text file
            //insert reading component to get previous customerID
            //add UID
            BufferedReader br = new BufferedReader(new FileReader("src\\oodj_assignment\\textFile\\Users.txt"));
            ArrayList <Integer> userIDList = new ArrayList<Integer>();
            ArrayList <String> usernameList = new ArrayList<String>();
            String line;
            Boolean flag = false; //boolean variable to determine whether inputted username exist in the textfile
            
            while ((line = br.readLine()) != null)
            {
                
                String [] user = line.split(","); //splits user detail by commas
                usernameList.add(user[1]);

                if (user[0].contains(userType))
                {
                    int userID = Integer.parseInt(user[0].substring(3));    //removes the prefix of the User ID (ADM, CUS)
                    userIDList.add(userID);                                 //adds the number portion 
                }
            }
            br.close();
            
            for (int i = 0; i < usernameList.size(); i++)
            {
                if (username.equals(usernameList.get(i)))
                {
                    JOptionPane.showMessageDialog(errorMessage, "Username has been taken! Please try again.","Error",JOptionPane.WARNING_MESSAGE);
                    flag = true;
                }
            }
                
            if (flag == false)
            {
                String newUID = userType + String.valueOf(userIDList.size() + 1);
            
                PrintWriter pw = new PrintWriter(new FileWriter(new File("src\\oodj_assignment\\textFile\\Users.txt"),true));

                pw.println(String.format("%s,%s,%s,%s,%s,%s,%s",newUID,username,password,name,email,phoneNo,address));
                pw.close();
                JOptionPane.showMessageDialog(errorMessage, " Customer data added","Entry Successful!",JOptionPane.INFORMATION_MESSAGE);
            }

        }
        catch(IOException Ex)
        {
            JOptionPane.showMessageDialog(errorMessage, " An Error Occured. Please try again. Possible error:[Invalid tampering of file]","Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    //method to show list of customers to pnlViewCustomer
    public static ArrayList viewCustomer() throws IOException
    {
        ArrayList<Customer> cusList = new ArrayList<Customer>();
        try
        {
            //ArrayList to store Customer objects
            Scanner scanner = new Scanner (new File("src\\oodj_assignment\\textFile\\Users.txt"));
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                String [] user = line.split(",");

                Customer cus = new Customer (user[0],user[1],user[2],user[3],user[4],user[5],user[6]);
                cusList.add(cus); //adding each customer object into an arrayList
            }
            scanner.close();
        }
        catch(IOException Ex)
        {
            JOptionPane.showMessageDialog(errorMessage, "File is corrupted or manually tampered. Kindly revert the changes.","Error",JOptionPane.WARNING_MESSAGE);
        }
        return cusList;
    }
    public static void editCustomer(ArrayList<Customer> cust)
    {
        try
        {
            PrintWriter pw = new PrintWriter(new FileWriter(new File("src\\oodj_assignment\\textFile\\Users.txt"),false));

            for (int i = 0; i < cust.size(); i++)
            {
                pw.println(cust.get(i).toString());
            }

            pw.close();
            JOptionPane.showMessageDialog(errorMessage, " Customer data updated.","Update Successful!",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(IOException Ex)
        {
            
        }
    }
    public void deleteCustomer()
    {
    
    }
    
    //param1 - origin           (beans)     || brand(equipment)
    //param2 - altitude         (beans)
    //param3 - tasting notes    (beans)
    //mode   -  beans || equipments
    public static void addProduct(String productName, int productQuan,double productPrice, double weight, String param1, double param2, String param3, String mode)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("src\\oodj_assignment\\textFile\\Products.txt"));
            ArrayList <Integer> prodIDList = new ArrayList<Integer>();
            ArrayList <String> prodNameList = new ArrayList<String>();
            String line;
            Boolean flag = false; //boolean variable to determine whether inputted username exist in the textfile      
            while ((line = br.readLine()) != null)
            {
                
                String [] prod = line.split(","); //splits product detail by commas
                prodNameList.add(prod[1]);
                int prodID = Integer.parseInt(prod[0].substring(4));    //removes the prefix of the Product ID (Prod)
                prodIDList.add(prodID);                                 //adds the number portion of the Product Id
            }
            br.close();  
            
            for (int i = 0; i < prodNameList.size(); i++)
            {
                if (productName.equals(prodNameList.get(i)))
                {
                    JOptionPane.showMessageDialog(errorMessage, "Duplicated product name inputted. Please retry.","Error",JOptionPane.WARNING_MESSAGE);
                    flag = true;
                }
            }
            if (flag == false)
            {
                PrintWriter pw = new PrintWriter(new FileWriter(new File("src\\oodj_assignment\\textFile\\Products.txt"),true));
                
                String newProdID = "Prod" + String.valueOf(prodIDList.size() + 1); //generating a new product ID
                if(mode.equals("beans"))
                {
                    Product nonFragile = new nonFragile(newProdID,productName,productQuan,productPrice,weight,param1,param2,param3);
                    JOptionPane.showMessageDialog(errorMessage, "New product added successfully.","New product entry.",JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(nonFragile.toString());
                    pw.println(nonFragile.toString());
                }
                else if (mode.equals("equipment"))
                {
                    Product fragile = new Fragile(newProdID,productName,productQuan,productPrice,weight,param1);
                    JOptionPane.showMessageDialog(errorMessage, "New product added successfully.","New product entry.",JOptionPane.INFORMATION_MESSAGE);
                    pw.println(fragile.toString());
                }
                pw.close();
            }
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(errorMessage, "An expected error has occured. Please retry.","Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
