
package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class PDFGenerator extends JFrame  {
    public static  String pinnumber;
    String name1,email1,card,phone;
    
    JLabel l1;
    PDFGenerator(String pinnumber){
        PDFGenerator.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel label = new JLabel(i6);
        label.setBounds(0, 0, 600, 400);
        add(label);
        
        l1 = new JLabel("Unity Bank");
        l1.setFont(new Font("Osward", Font.BOLD, 28));
        l1.setBounds(220,15,180,32);
        label.add(l1);
        
        
          try	{ 
                    Conn c=new Conn();
		     
                     ResultSet r = c.s.executeQuery("select * from signup32 inner join signup on signup32.formno= signup.formno  where pinnumber = '"+pinnumber+"' ");
                    
                     
                     while(r.next()){
                         
                        
                        name1=r.getString("name");
                                                                       
                        if(r.getString("email")!=null){
                        email1=r.getString("email"); 
                        }
                        card=r.getString("cardnumber");
                        
                        phone=r.getString("phone");
                        
                     }
                     
                     
     }  catch (SQLException ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        l1 = new JLabel("Name : "+name1);
        l1.setFont(new Font("Osward", Font.BOLD, 20));
        l1.setBounds(30,80,400,32);
        label.add(l1);
        
        l1 = new JLabel("Card Number : "+card);
        l1.setFont(new Font("Osward", Font.BOLD, 20));
        l1.setBounds(30,122,400,32);
        label.add(l1);
        
        l1 = new JLabel("E-mail : "+email1);
        l1.setFont(new Font("Osward", Font.BOLD, 20));
        l1.setBounds(30,164,400,32);
        label.add(l1);
        
        l1 = new JLabel("Phone Number : "+phone);
        l1.setFont(new Font("Osward", Font.BOLD, 20));
        l1.setBounds(30,206,400,32);
        label.add(l1);
                                        
        setSize(600,400);
        setLocation(400,30);
        setVisible(true);
    
    }   
   
    
    public static void main(String[] args) {
        new PDFGenerator("").setVisible(true);                                          
    }
}


        
   
    
    

