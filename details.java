//Option to select your desired operations like: Add, Remove, View and Update License Detail
package project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

class details implements ActionListener {
    
    JFrame f;
    JLabel l1, l2;
    JButton b1, b2, b3, b4;

    details() {
        f = new JFrame("Options");
        f.setBackground(Color.white);
        f.setLayout(null);


        l2 = new JLabel("License Details");
        l2.setBounds(200, 20, 200, 40);
        l2.setFont(new Font("serif", Font.BOLD, 25));
        l2.setForeground(Color.black);
        f.add(l2);

        b1 = new JButton("Add");
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.addActionListener(this);
        f.add(b1);

        b2 = new JButton("View");
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.addActionListener(this);
        f.add(b2);

        b3 = new JButton("Remove");
        b3.setFont(new Font("serif", Font.BOLD, 15));
        b3.addActionListener(this);
        f.add(b3);

        b4 = new JButton("Update");
        b4.setFont(new Font("serif", Font.BOLD, 15));
        b4.addActionListener(this);
        f.add(b4);

    
        f.setLayout(new GridLayout(0,1));
        
        f.setSize(400, 400);
        f.setLocation(450, 200);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            f.setVisible(false);
            new Add_License();
        }
        if (ae.getSource() == b2) {
            f.setVisible(false);
            new View_License();
        }

        if (ae.getSource() == b3) {
            f.setVisible(false);
            new Remove_License();
        }

        if (ae.getSource() == b4) {
            f.setVisible(false);
            try {
                new Update_License("Update License");
            } catch (SQLException e) {
    
            	// TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
    //main method
    public static void main(String[ ] arg) {
        details d = new details();
    }
}

