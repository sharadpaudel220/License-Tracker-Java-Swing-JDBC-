//login for am
package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class login  implements ActionListener{

        JFrame f;
        JLabel l1,l2;
        JTextField t1;
        JPasswordField t2;
        JButton b1,b2;

     login(){
    	
        f=new JFrame("Admin Panel");

        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        f.add(l1);
        
        t1=new JTextField(15);

        f.add(t1);
       
        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        f.add(l2);
  
        t2=new JPasswordField(15);

        f.add(t2);
       
        b1 = new JButton("Login");
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLUE);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");

        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLUE);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setLayout(new FlowLayout());
        f.setSize(300,300);
        f.setLocation(400,300);
        f.setVisible(true);
      
     }

    public void actionPerformed(ActionEvent ae){

        try{
            Conn c1 = new Conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from login where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.st2.executeQuery(q); 
            if(rs.next()){
                new details().f.setVisible(true);
                f.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(false);
            }
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(ae.getSource()==b2) {
        	f.dispose();
   	 }
        
    }
    
    //main method
    public static void main(String[] arg){
        login l=new login();
    }
}