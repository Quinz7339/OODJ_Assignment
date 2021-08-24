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
    public static void addUser(String username, String password, String name, String email, String phoneNo, String address)
    {
        File FAddUser = new File("src\\oodj_assignment\\textFile\\Users.txt");
        try
        {
            //insert reading component to get previous customerID
            //add UID
            File getPrevUID = new File("src\\oodj_assignment\\textFile\\Products.txt");
            Scanner scanInfo = new Scanner(getPrevUID);
            while(scanInfo.hasNextLine())
            {
                
            }
            
            FileWriter fw = new FileWriter(FAddUser,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(username + "," +password + "," + name + "," + email + "," + phoneNo + "," + address);
            pw.close();
            JOptionPane.showMessageDialog(errorMessage, " Customer data added","Entry Successful!",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(IOException Ex)
        {
            JOptionPane.showMessageDialog(errorMessage, " An Error Occured. Please try again","Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    public String toString()
    {
         return  UID + ","+username + "," + password + "," + name + "," + emailAddress + "," + phoneNumber + "," + address + "\n";
    }
}
