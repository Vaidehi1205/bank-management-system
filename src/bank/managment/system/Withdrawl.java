package bank.managment.system;

import javax.swing.*;
import java .awt.*;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
import java.util.*;
import java.sql.ResultSet;


public class Withdrawl extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdraw, back;
    String pinnumber;
  
    
    Withdrawl(String pinnumber){
        this.pinnumber=pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,830);
        add(image);
        
        JLabel text =new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.BLACK);
        text.setFont(new Font("System",Font.BOLD, 30));
        text.setBounds(200,150,800,40);
        image.add(text);
        
        amount= new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD ,22));
        amount.setBounds(200,250,320,30);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,350,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        
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
        if(ae.getSource()==withdraw){
           String num= amount.getText();            
           Date date=new Date();
           int a=parseInt(num);
            
        try{
                    int balance = 0;
                   Conn c= new Conn();
                   ResultSet rs = c.s.executeQuery("select * from Transactions where pinnumber = '"+pinnumber+"' ");
		     
		     while(rs.next()) {
			if (rs.getString("type").equals("Deposit"))   {
				balance += Integer.parseInt(rs.getString("num"));
 			}	else	{
				balance -= Integer.parseInt(rs.getString("num"));
			}
                     }
                   
                if(balance<=1000 || balance<=a){
                       JOptionPane.showMessageDialog(null, "Insufficient balance");
                       setVisible(false);
                       new Withdrawl(pinnumber).setVisible(true);
                   }
            else {
            
                Conn conn= new Conn();
                String query= "insert into Transactions values('"+pinnumber+"','"+date+"','Withdrawl','"+num+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs"+num+" Withdraw Successfuly");
                setVisible(false);
                new Menu(pinnumber).setVisible(true);
                   }
                
             } catch(Exception e){
                System.out.println(e);

                }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Menu(pinnumber).setVisible(true);
            
        }
    }
    
        
    
    public static void main(String args[]){
        new Withdrawl("").setVisible(true);
    }
}
    

