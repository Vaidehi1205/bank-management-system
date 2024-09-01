package bank.managment.system;

import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
    
    try{
        c=DriverManager.getConnection("jdbc:mysql:///BankManagment","root","Vaidehi@12");
        s=c.createStatement();
        
    }
    catch(SQLException e){   
        System.out.println(e);
    }
    
    }
    
}
