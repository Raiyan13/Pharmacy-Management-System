/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PharmacyManagementSystem;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author S.m.Tahmin Kabir Raiyan
 * ID: 181-115-006
 * Department: CSE
 * Metropolitan University.
 */
public class FileReadForLogin {
    
    String reader1="",reader2="";
  

    public String getUserNameReader() {
        
            try{
              File file = new File("Username and Password\\UserName.txt");
              Scanner scan = new Scanner(file);
              reader1 = scan.next();
              //JOptionPane.showMessageDialog(null,u);
              scan.close();
            }catch(Exception e){
             System.out.println();
            }
              
        return reader1;
    }
    
    public String getPasswordReader() {
        
              
            try{
              File file1 = new File("Username and Password\\Password.txt");
              Scanner scan = new Scanner(file1);
              reader2 = scan.next();
              scan.close();
            }catch(Exception e){
             System.out.println();
            }
            //JOptionPane.showMessageDialog(null,reader2);
        return reader2;
    }
    
    
}
