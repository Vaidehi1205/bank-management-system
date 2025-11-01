
package bank.managment.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;
    
    
    BalanceEnquiry(String pinnumber){
	this.pinnumber = pinnumber;
        
	setLayout(null);

	ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/img.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,830);
        add(image);

	back = new JButton("Back");
	back.setBounds(355, 520, 150, 30);
	back.addActionListener(this);
	image.add(back);

        int balance = 0;
        try	{ 
                    Conn c=new Conn();
		     ResultSet rs = c.s.executeQuery("select * from Transactions where pinnumber = '"+pinnumber+"' ");
		     
		     while(rs.next()) {
			if (rs.getString("type").equals("Deposit"))   {
				balance += Integer.parseInt(rs.getString("num"));
 			}	else	{
				balance -= Integer.parseInt(rs.getString("num"));
			}
		    }
 	} catch (Exception e)  {
		System.out.println(e);
	}
       
        
        JLabel text = new JLabel("Your Current Account balance is RS " +balance);
	text.setForeground(Color.BLACK);
        text.setFont(new Font("System", Font.BOLD, 25));
	text.setBounds(170, 300,600, 40);
	image.add(text);

        
        setSize(900, 850);
        setLocation(300, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Menu(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}
 
    

