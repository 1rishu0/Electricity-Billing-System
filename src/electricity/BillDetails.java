package electricity;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame{
    
    JTable t1;
    String x[]={"Meter Number","Month","Units","Total Bill","status"};
    String y[][]=new String[40][8];
    
    BillDetails(String meter){
        
        super("Bill Details");
        
        setSize(700,650);
        setLocation(600,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        t1=new JTable(y,x);
        
        try{
            
            Conn c=new Conn();
            
            String s1="select * from bill where meter="+meter;
            
            ResultSet rs=c.s.executeQuery(s1);
            
            t1.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException e){
            
            e.printStackTrace();
        }
        
        JScrollPane sp=new JScrollPane(t1);
        sp.setBounds(0,0,700,650);
        add(sp);
        
    }
    
    public static void main(String args[]){
        
        new BillDetails("").setVisible(true);
    }
}
