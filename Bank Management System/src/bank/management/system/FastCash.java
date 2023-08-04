
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton onehundred, fivehundred, thousand, twothousand, fivethousand, tenthousand, exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        this.pinnumber = pinnumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 840, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 720);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(215, 230, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        onehundred = new JButton("Rs 100");
        onehundred.setBounds(170, 305, 150, 30);
        onehundred.addActionListener(this);
        image.add(onehundred);
        
        fivehundred = new JButton("Rs 500");
        fivehundred.setBounds(355, 305, 150, 30);
        fivehundred.addActionListener(this);
        image.add(fivehundred);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(170, 340, 150, 30);
        thousand.addActionListener(this);
        image.add(thousand);
        
        twothousand = new JButton("Rs 2000");
        twothousand.setBounds(355, 340, 150, 30);
        twothousand.addActionListener(this);
        image.add(twothousand);
        
        fivethousand = new JButton("Rs 5000");
        fivethousand.setBounds(170, 375, 150, 30);
        fivethousand.addActionListener(this);
        image.add(fivethousand);
        
        tenthousand = new JButton("Rs 10000");
        tenthousand.setBounds(355, 375, 150, 30);
        tenthousand.addActionListener(this);
        image.add(tenthousand);
        
        exit = new JButton("BACK");
        exit.setBounds(355, 410, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900, 720);
        setLocation(200, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //Rs 500
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"' ");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }  
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"') ";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount +" Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        new FastCash("");
    }
}
