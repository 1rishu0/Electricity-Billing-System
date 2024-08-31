package electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PayBill extends JFrame implements ActionListener{

    JLabel l1,l2,l3,l4,l5,l6;
    JLabel l11,l12,l13,l14,l15;
    JLabel title;
    Choice c1;
    JButton b1,b2;
    String meter;
    
    PayBill(String meter){
        
        this.meter=meter;
        setLayout(null);
        
        setBounds(550,220,900,600);
        
        title=new JLabel("Electricity Bill");
        title.setBounds(120,5,400,30);
        title.setFont(new Font("Tahome",Font.BOLD,24));
        add(title);
        
        l1=new JLabel("Meter No");
        l1.setBounds(35,80,200,20);
        add(l1);
        
        l11=new JLabel();
        l11.setBounds(300,80,200,20);
        add(l11);
        
        l2=new JLabel("Name");
        l2.setBounds(35,140,200,20);
        add(l2);
        
        l12=new JLabel();
        l12.setBounds(300,140,200,20);
        add(l12);
        
        l3=new JLabel("Month");
        l3.setBounds(35,200,200,20);
        add(l3);
        
        c1=new Choice();
        c1.setBounds(300,200,200,20);
        c1.add("January");
        c1.add("February");
        c1.add("March");
        c1.add("April");
        c1.add("May");
        c1.add("June");
        c1.add("July");
        c1.add("August");
        c1.add("September");
        c1.add("October");
        c1.add("November");
        c1.add("December");
        add(c1);
        
        l4=new JLabel("Units");
        l4.setBounds(35,260,200,20);
        add(l4);
        
        l13=new JLabel();
        l13.setBounds(300,260,200,20);
        add(l13);
        
        l5=new JLabel("Total Bill");
        l5.setBounds(35,320,200,20);
        add(l5);
        
        l14=new JLabel();
        l14.setBounds(300,320,200,20);
        add(l14);
        
        l6=new JLabel("Status");
        l6.setBounds(35,380,200,20);
        add(l6);
        
        l15=new JLabel();
        l15.setBounds(300,380,200,20);
        add(l15);
        
        try{
            
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from customer where meter ='"+meter+"'");
            while(rs.next()){
                
                l11.setText(rs.getString("meter"));
                l12.setText(rs.getString("name"));
            }
            
            rs=c.s.executeQuery("select * from bill where meter='"+meter+"' AND month='January'");
            
            while(rs.next()){
                
                l13.setText(rs.getString("units"));
                l14.setText(rs.getString("total_bill"));
                l15.setText(rs.getString("status"));
            }
            
        }catch(Exception e){}
        
        c1.addItemListener(new ItemListener(){
            
           public void itemStateChanged(ItemEvent ie){
               
               try{
                   
                   Conn c=new Conn();
                   ResultSet rs=c.s.executeQuery("select * from bill where meter ='"+meter+"' AND month='"+c1.getSelectedItem()+"'");
                   while(rs.next()){
                       
                       l13.setText(rs.getString("units"));
                       l14.setText(rs.getString("total bill"));
                       l15.setText(rs.getString("status"));
                   }
               }catch(Exception e){}
           } 
        });
        
        b1=new JButton("Pay");
        b1.setBounds(100,460,100,25);
        add(b1);
        
        b2=new JButton("Back");
        b2.setBounds(230,460,100,25);
        add(b2);
        
        b1.setBackground(Color.black);
        b2.setBackground(Color.black);
        
        b1.setForeground(Color.white);
        b2.setForeground(Color.white);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2=i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel l21=new JLabel(i3);
        l21.setBounds(400,120,600,300);
        add(l21);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource()==b1){
            
            try{
                
                Conn c=new Conn();
                c.s.executeUpdate("update bill status ='Paid' where meter='"+meter+"' AND month='"+c1.getSelectedItem()+"'");
            }catch(Exception e){}
            
            this.setVisible(false);
            new Paytm(meter).setVisible(true);
            
        }else if(ae.getSource()==b2){
            
            this.setVisible(false);
        }
    }
    
    public static void main(String arg[]){
        
        new PayBill("").setVisible(true);
    }
}
