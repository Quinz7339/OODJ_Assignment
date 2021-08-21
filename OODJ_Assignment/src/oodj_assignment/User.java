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
public class User 
{
    private String username;
    private String password;
    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    
    public void User (String usr, String pw, String Name, String Email, String phoneNo, String Address)
    {
        this.username=usr;
        this.password=pw;
        this.name=Name;
        this.emailAddress=Email;
        this.phoneNumber=phoneNo;
        this.address=Address;
        
    }
    public void Login()
    {
        FileHandler fh = new FileHandler();
    }
}
