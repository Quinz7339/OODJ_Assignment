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
            Boolean flag = false;
            
            while ((line = br.readLine()) != null)
            {
                
                String [] user = line.split(",",7); //splits user detail by commas
                usernameList.add(user[1]);

                if (user[0].contains(userType))
                {
                    int userID = Integer.parseInt(user[0].substring(3));
                    userIDList.add(userID);
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
            JOptionPane.showMessageDialog(errorMessage, " An Error Occured. Please try again","Error",JOptionPane.WARNING_MESSAGE);
        }
    }
    public String toString()
    {
         return  String.format("%s,%s,%s,%s,%s,%s,%s\n",UID,username,password,name, emailAddress,phoneNumber,address);
    }
}
