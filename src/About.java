/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing .border.Border;

//make the class to form the about section with using jframe and action listener
public class About extends JFrame implements ActionListener{
//    make instances of jbutton , jlabel , 2 font, textarea, and string
    JButton b1;
    JLabel l1;
    Font f,f1;
    TextArea t1;
    String s;
//    make constructor for the automation of the about section 
    public About(){
//make object of container class to get the content panel for the jframe
        Container content=this.getContentPane();
//        content.setBackground(Color.yellow);
//        set the layout to null because the default is border layout which is not suitable for the this project
        setLayout(null);
//        make object of jbutton class with title
        b1=new JButton("Exit");
//        add jbutton to the jframe
        add(b1);
//        set the bounds of the jbutton with x and y coordinate and width and height as parameter
        b1.setBounds(180, 430, 120,20);
//        add the action listener to jbutton
        b1.addActionListener(this);
//        make object of font class with type , style and size as parameter
        f=new Font("RALEWAY",Font.BOLD,100);
//        set the font of the entire jframe to f
        setFont(f);
//        make obejct of string and add the info about the project
        s=        "                             About Projects                         \n"
                + "\nElectricity Billing System is a software based Application "
                +"developed in java programming language. The project aims at serving "
                +"the department of electricity by computerizing the billing system. "
                +"It mainly focuses on the calculations of Units consumed during the "
                +"specified time and money to be paid to electricity offices. "
                +"This computerized system will make the overall billing system easy, "
                +"accessible ,comfortable and effective for consumers.\n\n";
//        make object of textarea with title as s , rowcount , columns count and add the scrollbar feature in the parameter
        t1=new TextArea(s,10,40,Scrollbar.VERTICAL);
//        set the editable feature of the textarea to false 
        t1.setEditable(false);
//        set the bounds of the textarea
        t1.setBounds(20, 100, 450, 300);
//        add the textarea to jframe
        add(t1);
//        make another object of font class 
        f1=new Font("RALEWAY",Font.BOLD,16);
//        set the font to textarea
        t1.setFont(f1);
        
//        Container content=this.getContentPane();
//                make obejct of jlabel class with title
        l1=new JLabel("About Project");
//        add jlabel to jframe
        add(l1);
//        set the bounds of jlabel
        l1.setBounds(170,10,180,80);
//        set the foreground of the jlabel to red
        l1.setForeground(Color.red);
//        also set the font of the jlabel with intiate  the font class with type , style and size as parameter
        l1.setFont(new Font("RALEWAY",Font.BOLD,20));
//        this shows which side of the screen it shows up
        setBounds(700,220,500,550);
//        set the visiblity of the jframe to true
        setVisible(true);
    }
//    override the method to initiate the action event
    @Override
    public void actionPerformed(ActionEvent ae){
//        dispose the jframe while clicking the jbutton
        dispose();
    }
//    make the main method for the about file to initiate
    public static void main(String args[]){
//            new About().setSize(700,300);
            new About();
            new About().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
