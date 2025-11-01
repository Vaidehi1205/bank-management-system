package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JLabel l1,card_no,pin;
    JTextField cardTextField;
    JPasswordField pinPasswordField;
    JButton signin,clear,signup;
  
    Login(){                     
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        l1 = new JLabel("WELCOME TO BANKING SYSTEM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        l1.setBounds(200,40,650,40);
        add(l1);
        
        card_no = new JLabel("Card No:");
        card_no.setFont(new Font("Raleway", Font.BOLD, 28));
        card_no.setBounds(125,150,375,30);
        add(card_no);
        
        cardTextField = new JTextField(15);
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(125,220,375,30);
        add(pin);
        
        pinPasswordField = new JPasswordField(15);
        pinPasswordField.setFont(new Font("Arial", Font.BOLD, 14));
        pinPasswordField.setBounds(300,220,230,30);
        add(pinPasswordField);
                
        signin = new JButton("SIGN IN");
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        
        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        
        setLayout(null);
        
        signin.setFont(new Font("Arial", Font.BOLD, 14));
        signin.setBounds(300,300,100,30);
        add(signin);
        
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(430,300,100,30);
        add(clear);
        
        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.setBounds(300,350,230,30);
        add(signup);
        
        signin.addActionListener(this);
        clear.addActionListener(this);
        signup.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(1550,850);
        setLocation(0,0);
        setVisible(true);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==signin){
            String cardnumber = cardTextField.getText();
            String pinnumber =pinPasswordField.getText();
            String query="select *from signup32 where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"' ";
            try{
                 Conn c = new Conn();
                ResultSet rs= c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Menu(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch(Exception e){}
        
        }else if(ae.getSource()==clear){
            cardTextField.setText("");
            pinPasswordField.setText("");
        
        }else if(ae.getSource()==signup){
             setVisible(false);
                new SignupOne().setVisible(true);
            
        }                              
    }

    
    public static void main(String[] args)
    {
       new Login().setVisible(true);
    }

}
