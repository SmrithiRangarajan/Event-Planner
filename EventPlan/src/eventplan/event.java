package eventplan;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;
import home.*;


public class event extends JFrame {
    public event(){
        
        
        setTitle("Home Page");
        setSize(1000,680);
        
        //setContentPane(new JLabel(new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\evep.jpg")));
        setLayout(new GridBagLayout());
        
        JPanel contentpane = new JPanel();
        contentpane.setLayout(new BorderLayout());
        
        
        ImageIcon icon = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\evep.jpg");
        JLabel l = new JLabel(icon);
        //l.setLayout(new FlowLayout());
        l.setPreferredSize(new Dimension(1000,680));
        
        Border br = BorderFactory.createLineBorder(Color.black);
        //JPanel p1 = new JPanel();
        //p1.setLayout(new BorderLayout());
        //p1.add(l);
        JButton b1 = new JButton();
        //b.setBounds(500, 640, 100, 100);
        b1.setPreferredSize(new Dimension(100,30));
        b1.setBackground(Color.WHITE);
        Dimension size1 = b1.getPreferredSize();
        b1.setBounds(220, 460, size1.width, size1.height);
        b1.setForeground(Color.blue);
        b1.setBorder(br);
        b1.setText("User Login");
        
        JButton b2 = new JButton();
        b2.setPreferredSize(new Dimension(100,30));
        b2.setBackground(Color.WHITE);
        Dimension size2 = b2.getPreferredSize();
        b2.setBounds(680, 210, size2.width, size2.height);
        b2.setForeground(Color.blue);
        b2.setBorder(br);
        b2.setText("Admin Login");
        //l.add(b);
        
        l.add(b1);
        l.add(b2);
        //l.add(b);
        //l.add(p1,BorderLayout.SOUTH);
        
        //add(b);
        //contentpane.add(l);
        add(l, new GridBagConstraints());
        
        b1.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
               dispose();
               userLogin ulog = new userLogin();
               
               //createFr cfr = new createFr();
               ulog.setLocationRelativeTo(null);
               //bf.setBackground(Color.GRAY);
               ulog.setVisible(true);
            }
        });
        
        b2.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
               dispose();
               adminLogin alog = new adminLogin();
               
               //createFr cfr = new createFr();
               alog.setLocationRelativeTo(null);
               //bf.setBackground(Color.GRAY);
               alog.setVisible(true);
            }
        });
    }
    
    public static void main(String[] args) {
        event fr = new event();
        fr.setSize(1000,680);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);
    }

}

