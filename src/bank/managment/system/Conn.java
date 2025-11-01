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

    void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
