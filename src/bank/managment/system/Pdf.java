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
import javax.swing.*;

public class Pdf {
    String pinnumber;
    String n,e,ca,phone;
    
    Pdf(String pinnumber){
        this.pinnumber=pinnumber;
        
        
                    Conn c=new Conn();
		try	{     
              ResultSet r = c.s.executeQuery("select * from signup32 inner join signup on signup32.formno= signup.formno  where pinnumber = '"+pinnumber+"' ");
                  while(r.next()){
                      n=r.getString("name");
                      
                      e=r.getString("email");
                      
                      ca=r.getString("cardnumber");
                      
                      phone=r.getString("phone");
                      
                  }
                   
                  
                  
                  Document document = new Document();
                  FileOutputStream outputStream = new FileOutputStream("card.pdf");
                  PdfWriter.getInstance(document, outputStream);
                  document.open();
                  
                  Paragraph paragraph1 = new Paragraph("UNITY BANK");
                  paragraph1.setAlignment(Element.ALIGN_CENTER);
                  document.add(paragraph1);
                  
                  Paragraph paragraph2 = new Paragraph("NAME : " +n);
                  paragraph2.setAlignment(Element.ALIGN_LEFT);
                  document.add(paragraph2);
                  
                  Paragraph paragraph3 = new Paragraph("CARD NUMBER : "+ca);
                  paragraph3.setAlignment(Element.ALIGN_LEFT);
                  document.add(paragraph3);
                  
                  Paragraph paragraph4 = new Paragraph("E-MAIL : "+e );
                  paragraph4.setAlignment(Element.ALIGN_LEFT);
                  document.add(paragraph4);
                  
                  Paragraph paragraph5 = new Paragraph("PHONE NUMBER : "+phone );
                  paragraph5.setAlignment(Element.ALIGN_LEFT);
                  document.add(paragraph5);
                  
                 
                  
               document.close();
               r.close();
               c.s.close(); 
        JOptionPane.showMessageDialog(null,"PDF created successfully!"); 
                     
                     
     }  catch (SQLException ex) {
            Logger.getLogger(PDFGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Pdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
    
    
    }
    
    public static void main(String[] args) {
        new Pdf("").setVisible(true);
    }

    void setVisible(boolean b) {
       
    }

    

    
    
}
