
package home;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import bday.*;
import meeting.*;
import wedding.*;
import grad.*;
import eventplan.*;


public class createFr extends JFrame{
    String choice;
    public createFr(){
        setTitle("Events");
        setSize(1000,680);
    
        //To add icon to a button, use the Icon class(under swing), which will allow you to add an image to the button.
        JPanel contentpane = new JPanel();
        contentpane.setBackground(Color.lightGray);
        contentpane.setPreferredSize(new Dimension(1000,680));
        ImageIcon i = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\gray.jpg");
        JLabel l = new JLabel(i);
        l.setPreferredSize(new Dimension(800,680));
        JPanel img = new JPanel();
        img.setPreferredSize(new Dimension(600,580));
        img.setLayout(new GridLayout(2,2,5,5));
        img.setBackground(Color.darkGray);
        Border br = BorderFactory.createLineBorder(Color.darkGray);
        img.setBorder(br);
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\bday.jpg");
        ImageIcon i2 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\corp anni.jpg");
        ImageIcon i3 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\wedding.jpg");
        ImageIcon i4 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\farewell.png");

        JButton b1 = new JButton(i1);
        b1.setBorder(br);
      
        JButton b2 = new JButton(i2);
        b2.setBorder(br);
       
        JButton b3 = new JButton(i3);
        b3.setBorder(br);
        
        JButton b4 = new JButton(i4);
        b4.setBorder(br);
        
        JLabel heading = new JLabel("Pick an Event!");
        heading.setForeground(Color.white);
        heading.setFont(new Font("futura", Font.BOLD, 30));
        heading.setBounds(295,10,300,40);
        
        l.add(heading);
        
        //HOME BUTTON
        JButton home = new JButton();
        home.setText("Home");
        home.setBounds(700,10,80,30); 
        
        JLabel ho = new JLabel();
        
        home.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            int opt = JOptionPane.showConfirmDialog(l, "Unsave and exit?", "Home", JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(opt == JOptionPane.YES_OPTION){
                dispose();
                event ev = new event();
                ev.setLocationRelativeTo(null);
                ev.setVisible(true);                
            }
            else {
                ho.setText("you selected : No");
            }
        }
        });
        l.add(home);
        
        //BACK BUTTON
        ImageIcon backb = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\back.jpg");
        JButton back = new JButton("Logout");
        back.setBounds(10,10,80,30);
        JLabel ba = new JLabel();
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
               int opt = JOptionPane.showConfirmDialog(l, "Logout?", "Logout", JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
               if(opt == JOptionPane.YES_OPTION){
                    dispose();
                    userLogin ul = new userLogin();
                    ul.setLocationRelativeTo(null);
                    ul.setVisible(true);
               }
               else {
                   ba.setText("you selected : No");
               }
        }
        });
        l.add(back);
        
        img.add(b1);
        img.add(b2);
        img.add(b3);
        img.add(b4);
        img.setBounds(105,70,600,550); 
        
        l.add(img);
        contentpane.add(l);
        add(contentpane);
        
        b1.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
               choice = "birthday";
               dispose();
               bday_frame  bf = new bday_frame();
               bf.setLocationRelativeTo(null);
               //bf.setBackground(Color.GRAY);
               bf.setVisible(true);
               
            }
        });
        
        b2.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
               choice = "Business meeting";
               dispose();
               meet_frame  mf = new meet_frame();
               mf.setLocationRelativeTo(null);
               //bf.setBackground(Color.GRAY);
               mf.setVisible(true);
               
            }
        });
        
        b3.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
               choice = "Engagement";
               dispose();
               wed_frame  wf = new wed_frame();
               wf.setLocationRelativeTo(null);
               //bf.setBackground(Color.GRAY);
               wf.setVisible(true);
               
            }
        });
        
        b4.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
               choice = "Graduation";
               dispose();
               grad_frame  gf = new grad_frame();
               gf.setLocationRelativeTo(null);
               //bf.setBackground(Color.GRAY);
               gf.setVisible(true);
               
            }
        });
    }
    public static void main(String[] args){
        createFr cr = new createFr();
        cr.setLocationRelativeTo(null);
        cr.setVisible(true);
    }
}
