//To add new License Detail to the database 
package project;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class Add_License implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id15,id16,id17,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9;
    JButton b,b1,b2,b3;

    Add_License(int i){}
    
    Add_License(){
        f = new JFrame("Add License details ");
        f.setBackground(Color.white);
        f.setLayout(null);

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
       
        id8 = new JLabel("New License Details");
        id8.setBounds(320,30,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

        id1 = new JLabel("License ID");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);

        id2 = new JLabel("Name");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id3= new JLabel("Phone");
        id3.setBounds(50,200,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);

        id4= new JLabel("Address");  
        id4.setBounds(400,200,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);

       
        lab=new JLabel();
        lab.setBounds(200,450,250,200);
    	id15.add(lab);


        b = new JButton("Submit");
        b.setBackground(Color.BLUE);
        b.setForeground(Color.WHITE);
        b.setBounds(250,300,150,40);
        
        id15.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,300,150,40);
        
        id15.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(800,500);
        f.setLocation(400,150);
    }

    public void actionPerformed(ActionEvent ae){
        
        String a = t1.getText();
        String bb = t2.getText();
        String c = t3.getText();
        String d = t4.getText();
       
        if(ae.getSource() == b){
            try{
                Conn cc = new Conn();
                cc.addLicense(a, bb, c, d);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
                new details();
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }
         if(ae.getSource() == b1){
            f.setVisible(false);
            f.dispose();
            new details();
        }
       
        }
//main method
    
//    public static void main(String[ ] arg){
//        new Add_License();
//    }
}