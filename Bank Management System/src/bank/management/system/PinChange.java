
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener {
    
    JButton change, back;
    JPasswordField pin, repin;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 840, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 720);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 230, 300, 35);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165, 280, 180, 25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(320, 280, 180, 25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165, 320, 180, 25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(320, 320, 180, 25);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(350, 385, 150, 30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(350, 420, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 720);
        setUndecorated(true);
        setLocation(200, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change){
            try{
                String npin = pin.getText();
                String nrpin = repin.getText();

                if (!npin.equals(nrpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does Not Match!");
                    return;
                }
                
                if (npin.equals("") || nrpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter Pin!");
                    return;
                }
                Conn c = new Conn();
                String query1 = "update bank set pin = '"+nrpin+"' where pin = '"+pinnumber+"' ";
                String query2 = "update login set pin = '"+nrpin+"' where pin = '"+pinnumber+"' ";
                String query3 = "update signupthree set pin = '"+nrpin+"' where pin = '"+pinnumber+"' ";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch(Exception e){
                System.out.println(e);
            }
        } else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new PinChange("");
    }
}
