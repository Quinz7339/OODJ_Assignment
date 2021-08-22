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
public class FileHandler 
{
    JFrame errorMessage;
    
    public void addCustomer(String username, String password, String name, String email, String phoneNo, String address)
    {
        File FAddUser = new File("src\\oodj_assignment\\textFile\\Users.txt");
        try
        {
            FileWriter fw = new FileWriter(FAddUser,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            
            User addUsr = new User(username,password,name,email,phoneNo,address);
            
            pw.println(addUsr.toString());
            pw.close();
            JOptionPane.showMessageDialog(errorMessage, " Customer data added","Entry Successful!",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(IOException Ex)
        {
            errorMessage = new JFrame();
            JOptionPane.showMessageDialog(errorMessage, " An Error Occured. Please try again","Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    public void addProduct()
    {
        
    }
    
    public void editCustomer()
    {

        try 
        {
            File FEditUser = new File("src\\oodj_assignment\\textFile\\Users.txt");
            Scanner scanInfo = new Scanner(FEditUser);
            
            
        }
        catch(IOException Ex)
        {
            
        }
        
        
    }
    
    
}
