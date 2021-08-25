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
    {
        
    }
}
