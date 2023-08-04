
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno){
        this.formno = formno;
        
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setTitle("New Account Application Form - Page 3");
        
        JLabel additionalDetails = new JLabel("Page 3: Account Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(280, 40, 400, 40);
        add(additionalDetails);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 100, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.white);
        r1.setBounds(100, 140, 150, 20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.white);
        r2.setBounds(350, 140, 250, 20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.white);
        r3.setBounds(100, 180, 250, 20);
        add(r3);
        
        r4 = new JRadioButton("Reccuring Deposite Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.white);
        r4.setBounds(350, 180, 250, 20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 250, 200, 30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4168");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 250, 300, 30);
        add(number);
        
        JLabel carddetails = new JLabel("Your 16 Digit Card Number");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetails.setBounds(100, 280, 300, 20);
        add(carddetails);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 320, 200, 30);
        add(pin);
        
        JLabel pindetails = new JLabel("Your 4 Digit Password");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetails.setBounds(100, 350, 300, 20);
        add(pindetails);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 320, 300, 30);
        add(pnumber);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 400, 200, 30);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 450, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 450, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 480, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 480, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 510, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 510, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my Knoeledge.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(100, 580, 900, 30);
        add(c7);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(300, 620, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(450, 620, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        setSize(850, 720);
        setLocation(220, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String accountType = null;
            if (r1.isSelected()){
                accountType = "Saving Account";
            } else if (r2.isSelected()){
                accountType = "Fixed Deposit Account";
            } else if (r3.isSelected()){
                accountType = "Current Account";
            } else if (r4.isSelected()){
                accountType = "Reccuring Deposite Account";
            }
            Random random = new Random();
            String cardnumber = ""+ Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = ""+Math.abs((random.nextLong() % 9000L) + 1000L );
            String facility = "";
            if (c1.isSelected()){
                facility = facility + " ATM Card";
            } else if (c2.isSelected()){
                facility = facility + " Internet Banking";
            } else if (c3.isSelected()){
                facility = facility + " MObile Banking";
            } else if (c4.isSelected()){
                facility = facility + " EMAIL & SMS Alerts";
            } else if (c5.isSelected()){
                facility = facility + " Cheque Book";
            }else if (c6.isSelected()){
                facility = facility + " E-Statement";
            }
            
            try{
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else{
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"' )";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "Card Number: "+ cardnumber + "\n Pin: "+ pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            } catch(Exception e){
                System.out.println(e);
            }
            
        } else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
    
}
