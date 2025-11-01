package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Menu extends JFrame implements ActionListener{
     JLabel l1;
     JButton deposit,withdraw,balance,change,exit,pdf,statement,p;
     String pinnumber;
    
    Menu(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,830);
        add(image);
        
        l1 = new JLabel("WELCOME TO MAIN MENU");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,650,40);
        image.add(l1);
        
        
            
        deposit =new JButton("DEPOSIT"); 
        deposit.setFont(new Font("Raleway",Font.BOLD,20));
        deposit.setBackground(Color.BLACK);
        deposit.setForeground(Color.WHITE);
        deposit.setBounds(400,200,300,60);       
        image.add(deposit);
        
        
        withdraw =new JButton("WITHDRAWL"); 
        withdraw.setFont(new Font("Raleway",Font.BOLD,20));
        withdraw.setBackground(Color.BLACK);
        withdraw.setForeground(Color.WHITE);
        withdraw.setBounds(720,200,300,60);       
        image.add(withdraw);
        
        balance =new JButton("BALANCE ENQUIRY"); 
        balance.setFont(new Font("Raleway",Font.BOLD,20));
        balance.setBackground(Color.BLACK);
        balance.setForeground(Color.WHITE);
        balance.setBounds(400,280,300,60);       
        image.add(balance);
        
        change =new JButton("CHANGE PIN"); 
        change.setFont(new Font("Raleway",Font.BOLD,20));
        change.setBackground(Color.BLACK);
        change.setForeground(Color.WHITE);
        change.setBounds(720,280,300,60);       
        image.add(change);
        
        statement =new JButton("TRANSACTION RECORD"); 
        statement.setFont(new Font("Raleway",Font.BOLD,20));
        statement.setBackground(Color.BLACK);
        statement.setForeground(Color.WHITE);
        statement.setBounds(400,360,300,60);       
        image.add(statement);
                       
        pdf =new JButton("VIRTUAL CARD"); 
        pdf.setFont(new Font("Raleway",Font.BOLD,20));
        pdf.setBackground(Color.BLACK);
        pdf.setForeground(Color.WHITE);
        pdf.setBounds(720,360,300,60);       
        image.add(pdf);
        
        p =new JButton("DOWNLOAD CARD");
        p.setFont(new Font("Raleway",Font.BOLD,20));
        p.setBackground(Color.BLACK);
        p.setForeground(Color.WHITE);
        p.setBounds(400,440,300,60);       
        image.add(p);
                        
        exit =new JButton("EXIT"); 
        exit.setFont(new Font("Raleway",Font.BOLD,20));
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setBounds(720,440,300,60);       
        image.add(exit);
        
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        balance.addActionListener(this);
        change.addActionListener(this);
        exit.addActionListener(this);
        pdf.addActionListener(this);
        statement.addActionListener(this);
        p.addActionListener(this);
        
        
        
        
        setSize(1550,850);
        setLocation(0,0);
        setVisible(true);
            
    }
    
    @Override
        public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        
        }else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
            
        }else if(ae.getSource()==change){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
            
        }else if(ae.getSource()==exit){
                System.exit(0);
            } else if(ae.getSource()==pdf){
                
            new PDFGenerator(pinnumber).setVisible(true);
            }else if(ae.getSource()==statement){
                
            new MiniStatement(pinnumber).setVisible(true);
            }
        else if(ae.getSource()==p){                
            new Pdf(pinnumber).setVisible(true);
            }
        
         
        }
    
    public static void main(String[] args){
    
    new Menu("").setVisible(true);
    }
}
