/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment;
import javax.swing.*;
/**
 *
 * 
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here 
        loginMenu login = new loginMenu();
        login.setVisible(true);
        
        Admin_Menu admMenu = new Admin_Menu();
        admMenu.setVisible(false);
        
        Cus_Menu cusMenu = new Cus_Menu();
        cusMenu.setVisible(false);
        
    }
    
}
