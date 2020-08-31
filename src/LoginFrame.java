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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @author S.m.Tahmin Kabir Raiyan
 * ID: 181-115-006
 * Department: CSE
 * Metropolitan University.
 */
public class LoginFrame extends JFrame {

    JLabel label,label1,imageLabel;
    Container c;
    Font f,f1;
    JTextField tf1;
    JPasswordField pass;
    JButton login,clear,forgot;
    ImageIcon img;
    Cursor cursor;
    
    
    LoginFrame() {
        
        
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.LIGHT_GRAY);
        
            
        f = new Font("Arial", Font.BOLD, 17);
        f1 = new Font("Arial", Font.BOLD, 13);
        //First JLabel........
        label = new JLabel();
        label.setText(" Enter Username: ");
        label.setBounds(70, 50, 200, 50);
        label.setFont(f);
        label.setForeground(Color.WHITE);
        c.add(label);

        //Second JLabel........
        label1 = new JLabel();
        label1.setText(" Enter Password: ");
        label1.setBounds(72, 120, 200, 50);
        label1.setFont(f);
        label1.setForeground(Color.WHITE);
        c.add(label1);
       
        
        
        //First text field
        tf1 = new JTextField();
        tf1.setBounds(220, 56, 220, 37);  //dis from left,dis from top,weidth,height
        tf1.setFont(f);//set Font
        tf1.setBackground(Color.white);  //setting the background color
        tf1.setForeground(Color.black); //setting font color
        c.add(tf1);
        
        //password Field
        pass = new JPasswordField();
        pass.setEchoChar('*'); //default * and can be changed with this 
        pass.setBounds(220, 126, 220, 37);
        c.add(pass);
        
        //JButton for login
        login = new JButton("Login");
        login.setFont(f);
        login.setBounds(220,190,220,40);
        c.add(login);
        
        
        //JButton for clear
        clear = new JButton("Clear All");
        clear.setFont(f1);
        clear.setBounds(350,240,90,25);
        c.add(clear);
        
        
        //JButton For Forgot Password
        forgot = new JButton("Forgot Password");
        forgot.setFont(f1);
        forgot.setBounds(220,240,140,25);
        c.add(forgot);
        
        
        //Add mouse cursor on JButton
        cursor = new Cursor(Cursor.HAND_CURSOR);
        login.setCursor(cursor);
        clear.setCursor(cursor);
        forgot.setCursor(cursor);
        
        
        //Action Listener
        Handler handler = new Handler();
        login.addActionListener(handler);
        clear.addActionListener(handler);
        forgot.addActionListener(handler);
        
        
         //adding image
        img = new ImageIcon(getClass().getResource("image.jpg"));
        imageLabel = new JLabel(img);
        imageLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        c.add(imageLabel);
        
        //Add Icon
        img = new ImageIcon(getClass().getResource("image.jpg"));
        this.setIconImage(img.getImage());
    }

    
    //for action listener
    class Handler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) 
        {
            if (event.getSource() == login) 
            {
                 String u="",p="";
                if (tf1.getText().isEmpty() && pass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Username and Password\n", "Info", 2);
                } else if (tf1.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Username\n", "Info", 2);
                } else if (pass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Password\n", "Info", 2);
                }
                else{
            try{
              File file = new File("Username and Password\\UserName.txt");
              Scanner scan = new Scanner(file);
              u = scan.next();
              //JOptionPane.showMessageDialog(null,u);
              scan.close();
            }catch(Exception e){
             System.out.println("File Not Found");
            }
              
            try{
              File file1 = new File("Username and Password\\Password.txt");
              Scanner scan = new Scanner(file1);
              p = scan.next();
              
              scan.close();
            }catch(Exception e){
             System.out.println("File Not Found");
            }
               
               if(u.equals(tf1.getText()) && p.equals(pass.getText()) )
                {
                    ManagementSystem ms = new ManagementSystem();
                    ms.setVisible(true);
                    //ms.setBounds(5, 5, 1400, 750);
                    ms.setTitle("Pharmacy Management System");
                    dispose();
                   //JOptionPane.showMessageDialog(null, "Login Successful!!\n", "Info", 1);
                   /*JFramePractice_JTextField practice = new JFramePractice_JTextField();
                   practice.setVisible(true);
                   practice.setBounds(50, 20, 1200, 700);*/
                }
                  
                else
                  JOptionPane.showMessageDialog(null, "Invalid Username or Password\n", "Info", 1); 
                
            } 
            }
            
            else if(event.getSource() == clear) 
            {
                tf1.setText("");
                pass.setText("");
            }
            
            else if(event.getSource() == forgot)
            {    
                pass.setText("");
                FileReadForLogin file = new FileReadForLogin();
                String u = file.getPasswordReader();
                String s,s1 = "*";
                char[] ch = u.toCharArray();
                int len = u.length();
                
                for(int i=0;i<len-2;i++)
                   ch[i]='*';
          
                JOptionPane.showMessageDialog(null, "Last Two Characters Are "+String.valueOf(ch), "Info", 1); 
            }
        }

    }
   
   
   
   
   //main class
    /*public static void main(String[] args) {

       
        LoginFrame frame = new LoginFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Login");
        frame.setBounds(450, 200, 550, 350); //dis from left,dis from top,weidth,height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
*/
}
