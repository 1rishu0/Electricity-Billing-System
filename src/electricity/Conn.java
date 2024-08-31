/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package electricity;

/**
 *
 * @author RISHAB
 */

import java.sql.*;
//make a whole class for the connection
public class Conn {
//    make instances of connection and statement class 
    Connection c;
    Statement s;
//    make constructor for the automation of the connection of JDBC
    public Conn() {
//        apply exception handling to the code 
        try{
//            make the connection with the class with forName
            Class.forName("com.mysql.cj.jdbc.Driver");
//        make object of connection class and get connection from drivermanager with location of database , user name , and password
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebs?zeroDateTimeBehavior=CONVERT_TO_NULL","root","rootpassword");
//make object of statement class and create statement through connection object            
            s=c.createStatement();
        }catch(Exception e){
//            in catching exception print e which the default respone for catching the exception
            System.out.println(e);
        } 
        
    }

    
}
