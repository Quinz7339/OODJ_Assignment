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

/**
 *
 * @author phili
 */
public class Customer 
{
    protected String UID;
    protected String username;
    protected String password;
    protected String name;
    protected String emailAddress;
    protected String phoneNumber;
    protected String address;
    
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
    
    public  void addUser()
    {
        
    }
    public void login()
    {
        
    }
    public void browseProd()
    {
        
    }
    public void viewProd()
    static JFrame errorMessage;
    public static String login(String usr, String pwd)
    {
        try
        {
            //compare username with all the username in the text file
            BufferedReader br = new BufferedReader(new FileReader("src\\oodj_assignment\\textFile\\Users.txt"));
            String line;
            Boolean flagUsrname = false;
            Boolean flagPwd = false;
            String userType = "";
            
            while ((line = br.readLine()) != null)
            {
                String [] user = line.split(",",7); //splits user detail by commas
                
                if (usr.equals(user[1]))
                {
                    flagUsrname = true;
                    
                    if (pwd.equals(user[2]))
                    {
                        flagPwd = true;

                    }
                    userType = user[0].substring(0,3);
                }
                
            }
            br.close();

            if (flagUsrname == true && flagPwd == true)
            {
                System.out.println(userType);
                if (userType.equals("ADM"))
                {
                    return "adm";
                }
                else if (userType.equals("CUS"))
                {
                    return "cus";
                }
                        
            }
            else
                {
                    JOptionPane.showMessageDialog(errorMessage, "Incorrect Username or Password! Please try again.","Error",JOptionPane.WARNING_MESSAGE);
                }
            

        }
        catch(IOException Ex)
        {
            JOptionPane.showMessageDialog(errorMessage, " An Error Occured. Please try again","Error",JOptionPane.WARNING_MESSAGE);
        }
        return "null";
    }
    public static void addUser()
    {
        
    }
}
