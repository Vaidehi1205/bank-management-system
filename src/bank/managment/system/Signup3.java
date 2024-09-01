
package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    
    
    Signup3(String formno){
        this.formno=formno;
        setLayout(null);
    
        JLabel l1=new JLabel("PAGE 3: ACCOUNT DETAILS");
        l1.setFont(new Font("Raleway",Font.BOLD,28));
        l1.setBounds(280,40,450,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);                      
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,180,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(300,180,200,20);
        add(r2);
        
        r3=new JRadioButton("Recurring Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,210,180,20);
        add(r3);
        
        r4=new JRadioButton("Current Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(300,210,180,20);
        add(r4);
        
        ButtonGroup typegroup=new ButtonGroup();
        typegroup.add(r1);
        typegroup.add(r2);
        typegroup.add(r3);
        typegroup.add(r4);
        
        JLabel card=new JLabel("Card No:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,250,200,30);                      
        add(card);
        
        JLabel number=new JLabel("xxxx-xxxx-xxxx-1234");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(300,250,300,30);                      
        add(number);
        
        JLabel info1=new JLabel("Your 16 Digit Card No.");
        info1.setFont(new Font("Raleway",Font.BOLD,12));
        info1.setBounds(300,280,330,20);                      
        add(info1);
        
        JLabel pin=new JLabel("Pin No:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,310,200,30);                      
        add(pin);
        
        JLabel pino=new JLabel("xxxx");
        pino.setFont(new Font("Raleway",Font.BOLD,22));
        pino.setBounds(300,310,300,30);                      
        add(pino);
        
        JLabel info2=new JLabel("Your 4 Digit Pin No.");
        info2.setFont(new Font("Raleway",Font.BOLD,12));
        info2.setBounds(300,340,330,20);                      
        add(info2);
        
        JLabel service=new JLabel("Services Required");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100,380,330,30);                      
        add(service);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBackground(Color.white);
        c1.setBounds(100,410,200,20);
        add(c1);
        
        c2 = new JCheckBox("INTERNATE BANKING");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBackground(Color.white);
        c2.setBounds(300,410,200,20);
        add(c2);
        
        c3 = new JCheckBox("MOBILE BANKING");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBackground(Color.white);
        c3.setBounds(100,440,200,20);
        add(c3);
        
        c4 = new JCheckBox("EMAIL AND SMS ALERT");
         c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBackground(Color.white);
        c4.setBounds(300,440,250,20);
        add(c4);
        
        c5 = new JCheckBox("CHEQUE BOOK");
         c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBackground(Color.white);
        c5.setBounds(100,470,200,20);
        add(c5);
        
        c6 = new JCheckBox("E-STATEMENT");
         c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBackground(Color.white);
        c6.setBounds(300,470,200,20);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct.");
         c7.setFont(new Font("Raleway",Font.BOLD,14));
        c7.setBackground(Color.white);
        c7.setBounds(100,530,500,20);
        add(c7);
        
        submit =new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(500,600,100,30);       
        add(submit);
        
        cancel =new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(630,600,100,30);        
        add(cancel);
        
        submit.addActionListener(this);
        cancel.addActionListener(this);
        
         getContentPane().setBackground(Color.WHITE);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        String accountType = null;
        if(r1.isSelected()){ 
            accountType = "Saving Account";
        }
        else if(r2.isSelected()){ 
            accountType = "Fixed Deposit Account";
        }
        else if(r3.isSelected()){ 
            accountType = "Current Account";
        }else if(r4.isSelected()){ 
            accountType = "Recurring Deposit Account";
        }
        
        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardnumber = "" + Math.abs(first7);
        
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pinnumber = "" + Math.abs(first3);
        
        String facility = "";
        if(c1.isSelected()){ 
            facility = facility + " ATM Card";
        }
        if(c2.isSelected()){ 
            facility = facility + " Internet Banking";
        }
        if(c3.isSelected()){ 
            facility = facility + " Mobile Banking";
        }
        if(c4.isSelected()){ 
            facility = facility + " EMAIL Alerts";
        }
        if(c5.isSelected()){ 
            facility = facility + " Cheque Book";
        }
        if(c6.isSelected()){ 
            facility = facility + " E-Statement";
        }
        
        try{
            if(ae.getSource()==submit){
                
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                }else{
                    Conn c = new Conn();
                    String q1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";                 
                    c.s.executeUpdate(q1);
                    String q2 = "insert into signup32 values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";                  
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin:"+ pinnumber);
                    
                    
                }
            
            }else if(ae.getSource()==cancel){
                System.exit(0);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }        
    }
    
    public static void main(String[] args){
        new Signup3("").setVisible(true);
    }    

    private Object setContentPane() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
