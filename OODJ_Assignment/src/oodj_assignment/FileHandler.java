/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;
import java.io.*;

/**
 *
 * @author phili
 */
public class FileHandler 
{
    public void AddUser()
    {
        File FAddUser = new File("Users.txt");
        try
        {
            FileWriter fw = new FileWriter(FAddUser,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter (bw);
            
        }
        catch(IOException Ex)
        {
            
        }
    }
    
}
