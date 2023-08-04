
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, income, occupation, education;
    JTextField pan, aadhar;
    String formno;
    
    SignupTwo(String formno){
        this.formno = formno;
        setTitle("New Account Application Form - Page 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel lblreligion = new JLabel("Religion:");
        lblreligion.setFont(new Font("Raleway", Font.BOLD, 20));
        lblreligion.setBounds(100, 140, 100, 30);
        add(lblreligion);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "christian", "other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel lblcategory = new JLabel("Category:");
        lblcategory.setFont(new Font("Raleway", Font.BOLD, 20));
        lblcategory.setBounds(100, 190, 200, 30);
        add(lblcategory);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel lblincome = new JLabel("Income:");
        lblincome.setFont(new Font("Raleway", Font.BOLD, 20));
        lblincome.setBounds(100, 240, 200, 30);
        add(lblincome);
        
        String valIncome[] = {"null", "< 1,00,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel lbleducation = new JLabel("Educational");
        lbleducation.setFont(new Font("Raleway", Font.BOLD, 20));
        lbleducation.setBounds(100, 290, 200, 30);
        add(lbleducation);
        
        JLabel lblqualification = new JLabel("Qualification:");
        lblqualification.setFont(new Font("Raleway", Font.BOLD, 20));
        lblqualification.setBounds(100, 315, 200, 30);
        add(lblqualification);
        
        String educationValues[] = {"10th", "12th", "UG", "PG", "PHD", "Others"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel lbloccupation = new JLabel("Occupation:");
        lbloccupation.setFont(new Font("Raleway", Font.BOLD, 20));
        lbloccupation.setBounds(100, 390, 200, 30);
        add(lbloccupation);
        
        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Farmer", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel lblpan = new JLabel("PAN Number:");
        lblpan.setFont(new Font("Raleway", Font.BOLD, 20));
        lblpan.setBounds(100, 440, 200, 30);
        add(lblpan);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
       
        JLabel lblaadhar = new JLabel("Aadhar Number:");
        lblaadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        lblaadhar.setBounds(100, 490, 200, 30);
        add(lblaadhar);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        JLabel lblcitizen = new JLabel("Senior Citizen:");
        lblcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        lblcitizen.setBounds(100, 540, 200, 30);
        add(lblcitizen);
        
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(400, 540, 100, 30);
        sno.setBackground(Color.white);
        add(sno);
        
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(syes);
        citizengroup.add(sno);
        
        JLabel pincode = new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(400, 590, 100, 30);
        eno.setBackground(Color.white);
        add(eno);
        
        ButtonGroup eagroup = new ButtonGroup();
        eagroup.add(eyes);
        eagroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 630, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        setSize(850, 720);
        setLocation(220, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sformno = ""+formno;
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()){
            seniorcitizen = "Yes";
        } else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        
        String existingaccount = null;
        if (eyes.isSelected()){
            existingaccount = "Yes";
        } else if(eno.isSelected()){
            existingaccount = "No";
        } 
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
       
        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values ( '"+sformno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+seniorcitizen+"', '"+existingaccount+"', '"+span+"', '"+saadhar+"' )";
            c.s.executeUpdate(query);
            
            //Signup 3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
    
}
