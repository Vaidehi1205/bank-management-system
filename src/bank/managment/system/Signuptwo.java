package bank.managment.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Signuptwo extends JFrame implements ActionListener{
    
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton yes,no,ayes,ano ;
    JComboBox Religion ,Category,Education,Income,Occupation;
    String formno;
    
    Signuptwo(String formno){
        
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM");
        
        JLabel additionalDetails=new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,28));
        additionalDetails.setBounds(280,40,450,40);
        add(additionalDetails);
        
        
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        
      
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        Religion = new JComboBox(valReligion);
        Religion.setBounds(300,140,400,30);
        Religion.setBackground(Color.WHITE);
        add(Religion);
        
        
        JLabel category=new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100,180,150,30);
        add(category);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
        Category = new JComboBox(valCategory);
        Category.setBounds(300,180,400,30);
        Category.setBackground(Color.WHITE);
        add(Category);
        
                    
        JLabel income=new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100,220,150,30);
        add(income);
        
        String valIncome[]={"NULL","<1,50,000","<,50,000","<5,00,000","Upto 10,00,000"};
        Income = new JComboBox(valIncome);
        Income.setBounds(300,220,400,30);
        Income.setBackground(Color.WHITE);
        add(Income);
       
        
        JLabel educational=new JLabel("Educational");
        educational.setFont(new Font("Raleway",Font.BOLD,20));
        educational.setBounds(100,260,150,30);
        add(educational);
        
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        qualification.setBounds(100,290,150,30);
        add(qualification);
        
        String valEdu[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        Education= new JComboBox(valEdu);
        Education.setBounds(300,260,400,30);
        Education.setBackground(Color.WHITE);
        add(Education);
        
        
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100,330,150,30);
        add(occupation);
        
        String valOccupation[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        Occupation= new JComboBox( valOccupation);
        Occupation.setBounds(300,330,400,30);
        Occupation.setBackground(Color.WHITE);
        add(Occupation);
        
        
        JLabel pan_no=new JLabel("Pan No*:");
        pan_no.setFont(new Font("Raleway",Font.BOLD,20));
        pan_no.setBounds(100,370,150,30);
        add(pan_no);
        
        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,370,400,30);
        add(panTextField);
        
        
        JLabel aadhar=new JLabel("Aadhar No*:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,410,150,30);
        add(aadhar);
        
        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,410,400,30);
        add(aadharTextField);
        
        
        JLabel senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,450,150,30);
        add(senior);
        
        yes=new JRadioButton("Yes");
        yes.setBounds(300,450,70,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no=new JRadioButton("No");
        no.setBounds(370,450,90,30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup seniorgroup=new ButtonGroup();
        seniorgroup.add(yes);
        seniorgroup.add(no);
        
        
        JLabel exist_account=new JLabel("Existing Account:");
        exist_account.setFont(new Font("Raleway",Font.BOLD,20));
        exist_account.setBounds(100,490,180,30);
        add(exist_account);
        
        ayes=new JRadioButton("Yes");
        ayes.setBounds(300,490,70,30);
        ayes.setBackground(Color.WHITE);
        add(ayes);
        
        ano=new JRadioButton("No");
        ano.setBounds(370,490,70,30);
        ano.setBackground(Color.WHITE);
        add(ano);
        
        ButtonGroup accountgroup=new ButtonGroup();
        accountgroup.add(ayes);
        accountgroup.add(ano);
    
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620,550,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
    
        setSize(1550,850);
        setLocation(0,0);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        
       
        String religion= (String)Religion.getSelectedItem();
        String category= (String)Category.getSelectedItem();
        String income= (String)Income.getSelectedItem();
        String education= (String)Education.getSelectedItem();
        String occupation= (String)Occupation.getSelectedItem();
        
        String pan= panTextField.getText();
        String aadhar= aadharTextField.getText();
        
        
        
        String senior=null;
        if(yes.isSelected()){
            senior="Yes";
        }else if(no.isSelected()){
            senior="No";
        }
        
    
        String account=null;
        if(ayes.isSelected()){
            account="Yes";
        }else if(ano.isSelected()){
            account="No";
        }
        
        
        
        try{
         if(pan.length()>10||pan.length()<10){
            JOptionPane.showMessageDialog(null, "Pan number Should be 0f 10 digits");           
        }else if(aadhar.length()>12||aadhar.length()<12){
            JOptionPane.showMessageDialog(null, "Aadhar number Should be 0f 12 digits");           
        }else{
            Conn c=new Conn();
            String query="INSERT INTO signup2 VALUES('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+aadhar+"','"+senior+"','"+account+"')";
            c.s.executeUpdate(query);
          
            setVisible(false);
            new Signup3(formno).setVisible(true);
         }
        }
                        
        catch(Exception e){   
        System.out.println(e);
        }                        
    }
    
    
    public static void main(String[] args){
        new Signuptwo("");
    } 
}

