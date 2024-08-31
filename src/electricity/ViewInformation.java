package electricity;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewInformation extends JFrame implements ActionListener{
    
    JButton b1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JLabel l11,l12,l13,l14,l15,l16,l17;
    
    ViewInformation(String meter){
        
        setBounds(600,250,850,650);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel title=new JLabel("VIEW CUSTOMER INFORMATION");
        title.setBounds(250,0,500,40);
        title.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(title);
        
        l1=new JLabel("Name");
        l1.setBounds(70,80,100,20);
        add(l1);
        
        l11=new JLabel();
        l11.setBounds(250,80,100,20);
        add(l11);
        
        l2=new JLabel("Meter Number");
        l2.setBounds(70,140,100,20);
        add(l2);
        
        l12=new JLabel();
        l12.setBounds(250,140,100,20);
        add(l12);
        
        l3=new JLabel("Address");
        l3.setBounds(70,200,100,20);
        add(l3);
        
        l13=new JLabel();
        l13.setBounds(250,200,100,20);
        add(l13);
        
        l4=new JLabel("City");
        l4.setBounds(70,260,100,20);
        add(l4);
        
        l14=new JLabel();
        l14.setBounds(250,260,100,20);
        add(l14);
        
        l5=new JLabel("State");
        l5.setBounds(500,80,100,20);
        add(l5);
        
        l15=new JLabel();
        l15.setBounds(650,80,100,20);
        add(l15);
        
        l6=new JLabel("Email");
        l6.setBounds(500,140,100,20);
        add(l6);
        
        l16=new JLabel();
        l16.setBounds(650,140,150,20);
        add(l16);
        
        l7=new JLabel("Phone");
        l7.setBounds(500,200,100,20);
        add(l7);
        
        l17=new JLabel();
        l17.setBounds(650,200,100,20);
        add(l17);
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where meter='"+meter+"'");
            
            while(rs.next()){
                
                l11.setText(rs.getString(1));
                l12.setText(rs.getString(2));
                l13.setText(rs.getString(3));
                l14.setText(rs.getString(4));
                l15.setText(rs.getString(5));
                l16.setText(rs.getString(6));
                l17.setText(rs.getString(7));
                
            }
        }catch(Exception e){}
        
        b1=new JButton("Back");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(350,340,100,25);
        b1.addActionListener(this);
        add(b1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,300 ,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        l8=new JLabel(i3);
        l8.setBounds(20,350,600,300);
        add(l8);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        this.setVisible(false);
    }
    
    public static void main(String args[]){
        
        new ViewInformation("").setVisible(true);
    }
}
