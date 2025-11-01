package bank.managment.system;

import javax.swing.*;
import java .awt.*;
import java.awt.event.*;
import java.util.*;



public class Deposit extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton deposit, back;
    String pinnumber;
  
    
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,830);
        add(image);
        
        
        JLabel text =new JLabel("Enter the amount you want to deposit");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD, 30));
        text.setBounds(150,150,800,40);
        image.add(text);
        
        amount= new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD ,22));
        amount.setBounds(200,250,320,30);
        image.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(355,350,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        
        back = new JButton("Back");
        back.setBounds(510,350,150,30);
        back.addActionListener(this);
        image.add(back);
        
    setSize(900,850);
    setLocation(300,0);
    setVisible(true);
}
    
    @Override
    public void actionPerformed(ActionEvent ae){
        try{        
            String num = amount.getText();
            Date date = new Date();
            if(ae.getSource()==deposit){
                if(amount.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }else{
                    Conn c = new Conn();
                    c.s.executeUpdate("insert into Transactions values('"+pinnumber+"', '"+date+"', 'Deposit', '"+num+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+num+" Deposited Successfully");
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }else if(ae.getSource()==back){
                setVisible(false);
                new Menu(pinnumber).setVisible(true);
            }
        }catch(Exception e){
        }
    }
            
    
    public static void main(String[] args){
        new Deposit("").setVisible(true);
    }
    
}