package electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame implements ActionListener{
    
    String meter;
    JButton b1;
    
    Paytm(String meter){
        
        this.meter=meter;
//        this pane is used for the website access 
        JEditorPane j=new JEditorPane();
//        it makes the text area uneditable
        j.setEditable(false);
        
        b1=new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(500,20,120,25);
        b1.addActionListener(this);
        add(b1);
        
        try{
            
            j.setPage("https://paytm.com/electricity-bill-payment");
            
        }catch(Exception e){
            
            j.setContentType("text/html");
            j.setText("<html>Could not Load!</html>");
            
        }
        
        JScrollPane scrollpane=new JScrollPane(j);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollpane);
        setPreferredSize(new Dimension(800,600));
        setSize(600,800);
        setLocation(250,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        this.setVisible(false);
        new PayBill(meter).setVisible(true);
    }
    
    public static void main(String args[]){
        
        new Paytm("").setVisible(true);
    }
}
