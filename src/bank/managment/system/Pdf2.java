/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.managment.system;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Pdf2 {
    String pinnumber;
    int balance = 0;

    Pdf2(String pinnumber){
           	 
        try{
            
        Document document = new Document();
        FileOutputStream outputStream = new FileOutputStream("statment.pdf");
        PdfWriter.getInstance(document, outputStream);
        document.open();
        
        Paragraph paragraph1 = new Paragraph("UNITY BANK");
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        document.add(paragraph1);
            
           
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM Transactions where pinnumber = '"+pinnumber+"'");
            while(rs.next()){
                
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("num"));
                }else{
                    balance -= Integer.parseInt(rs.getString("num"));
                }
                
                if(rs.getString("type").equals("Deposit")){
                    Paragraph paragraph2 = new Paragraph("<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("num") + "<br><br><html>");
                    paragraph2.setAlignment(Element.ALIGN_LEFT);
                    document.add(paragraph2);                                
                }else{                               
                    Paragraph paragraph3 = new Paragraph("<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("num") + "<br><br><html>");
                    paragraph3.setAlignment(Element.ALIGN_LEFT);
                    document.add(paragraph3);
                }
               
            Paragraph paragraph4 = new Paragraph("Your total Balance is Rs "+balance);
            paragraph4.setAlignment(Element.ALIGN_LEFT);
            document.add(paragraph4);
            }
            
            
            
            
        document.close(); 
        rs.close();                
            c1.s.close();
        JOptionPane.showMessageDialog(null,"PDF created successfully!");
    
        } catch (SQLException ex) {
            Logger.getLogger(Pdf2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pdf2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Pdf2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        new Pdf2("").setVisible(true);
    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
