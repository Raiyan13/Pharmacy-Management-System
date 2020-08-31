package PharmacyManagementSystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author S.m.Tahmin Kabir Raiyan
 * ID: 181-115-006
 * Department: CSE
 * Metropolitan University.
 */
public class FirstFrame extends JFrame{
    
    JLabel welcome,imageLabel;
    Container c;
    Font f,f1;
    ImageIcon img;
    JButton newUser,login;
    Cursor cursor;
    
    
    FirstFrame()
    {
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        
            
        f = new Font("Arial", Font.BOLD, 30);
        
        welcome = new JLabel();
        welcome.setText("Pharmacy Management System");
        welcome.setBounds(45, 50, 450, 50);
        welcome.setFont(f);
        welcome.setForeground(Color.WHITE);
        c.add(welcome);
        
        
         f1 = new Font("Arial",Font.CENTER_BASELINE, 17);
         
         
        login = new JButton("Login");
        login.setFont(f1);
        login.setBounds(160,140,220,45);
        c.add(login);
        
        newUser = new JButton("Sign In");
        newUser.setFont(f1);
        newUser.setBounds(160,210,220,47);
        c.add(newUser);
        
        cursor = new Cursor(Cursor.HAND_CURSOR);
        login.setCursor(cursor);
        newUser.setCursor(cursor);
        
        img = new ImageIcon(getClass().getResource("image.jpg"));
        imageLabel = new JLabel(img);
        imageLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imageLabel);
        
        //Add Icon
        img = new ImageIcon(getClass().getResource("image.jpg"));
        this.setIconImage(img.getImage());
        
        //Action Listener
        Handler handler1 = new Handler();
        login.addActionListener(handler1);
        newUser.addActionListener(handler1);
        
        
    }
    
    
    class Handler implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent event) 
        {
            FileReadForLogin file = new FileReadForLogin();
            
            String u = file.getUserNameReader();
            String p = file.getPasswordReader();
            
            //JOptionPane.showMessageDialog(null,u);
            //JOptionPane.showMessageDialog(null,p);
             if( event.getSource() == login )
              {
                
                if( !u.isEmpty() && !p.isEmpty())
                {
                   LoginFrame log = new LoginFrame();
                   log.setTitle("Login");
                   log.setVisible(true);
                   log.setBounds(450, 200, 550, 350);
                   dispose();
                }
                else
                {
                  JOptionPane.showMessageDialog(null, "Please Sign In First\n", "Info", 2);
                }
              }
              
              else if( event.getSource() == newUser)
              {
                if( !u.isEmpty() && !p.isEmpty())
                {
                   JOptionPane.showMessageDialog(null, "You Are Not A New User.Please Login!\n", "Info", 2);
                }
                else
                {
                  
                  NewUser nw = new NewUser();
                  nw.setVisible(true);
                  nw.setBounds(450, 200, 500, 350);
                  dispose();
                }
              }
        }
        
    }
    
    
    /*public static void main(String[] args) {
        
        FirstFrame frame = new FirstFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Welcome Pharmacy Management System");
        frame.setBounds(450, 200, 550, 350); //dis from left,dis from top,weidth,height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
      */
    
}
