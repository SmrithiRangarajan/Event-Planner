
package addData;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import home.userLogin;
import java.io.BufferedReader;
import java.io.FileReader;

import home.*;

public class ViewData extends JFrame {
    public ViewData(){
        userLogin us = new userLogin();
        
        setTitle("Admin");
        setSize(1000,680);
        setLayout(new BorderLayout());
        
        JPanel jp1 = new JPanel();
        jp1.setPreferredSize(new Dimension(150, 680));
        jp1.setBackground(Color.black);
        //jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
        jp1.setLayout(new FlowLayout());
        JScrollPane spane = new JScrollPane(jp1);
        
        JPanel jp2 = new JPanel();
        jp2.setPreferredSize(new Dimension(850,680));
        jp2.setBackground(Color.gray);
        jp2.setLayout(new GridBagLayout());
        
        
        add(spane, BorderLayout.WEST);
        add(jp2, BorderLayout.EAST);
        
        int n = us.usernum;
        /*JButton home = new JButton("Home");
        home.setBounds(10,700,90,30);
        jp2.add(home);
        
        home.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae) {
            dispose();
            createFr fr = new createFr();
            fr.setLocationRelativeTo(null);
            fr.setVisible(true);
        }
        });*/
        
        JTextArea ta1 = new JTextArea();
        
        ta1.setEditable(false);
        ta1.setPreferredSize(new Dimension(700,500));
        //ta1.setBounds(30,30,700,500);
        ta1.setFont(new Font("Arial", Font.ITALIC, 30));
        jp2.add(ta1, new GridBagConstraints());
        ta1.setVisible(false);
        
        JTextArea ta2 = new JTextArea();
        ta2.setEditable(false);
        ta2.setPreferredSize(new Dimension(700,500));
        //ta2.setBounds(30,30,700,500);
        ta2.setFont(new Font("Arial", Font.ITALIC, 30));
        jp2.add(ta2, new GridBagConstraints());
        ta2.setVisible(false);
        
        
        JTextArea ta3 = new JTextArea();
       
        ta3.setEditable(false);
        ta3.setPreferredSize(new Dimension(700,500));
        //ta2.setBounds(30,30,700,500);
        ta3.setFont(new Font("Arial", Font.ITALIC, 30));
        jp2.add(ta3, new GridBagConstraints());
        ta3.setVisible(false);
        
        for(int i=1; i<n; i++){
            if(i==1){
                JButton button = new JButton("user1");
                button.setPreferredSize(new Dimension(150,30));
                button.setBackground(Color.lightGray);
                jp1.add(button);
                
                
                String filename = "user_1.txt";
                File file = new File(filename);
                try{
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = reader.readLine();
                    while (line != null) {
                        ta1.append(line + "\n");
                        line = reader.readLine();
                    }
                    reader.close();
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
                button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    ta1.setVisible(true);
                    ta2.setVisible(false);
                    ta3.setVisible(false);
                }
                });
            }
            
            else if(i==2){
                JButton button = new JButton("user2");
                button.setPreferredSize(new Dimension(150,30));
                button.setBackground(Color.lightGray);
                jp1.add(button);
                
                
                String filename = "user_2.txt";
                File file = new File(filename);
                try{
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = reader.readLine();
                    while (line != null) {
                        ta2.append(line + "\n");
                        line = reader.readLine();
                    }
                    reader.close();
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
                button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                    
                    ta2.setVisible(true);
                    ta1.setVisible(false);
                    ta3.setVisible(false);
                }
                });
            }
            
            else {
                JButton button = new JButton("user3");
                button.setPreferredSize(new Dimension(150,30));
                button.setBackground(Color.lightGray);
                jp1.add(button);
                
                String filename = "user_3.txt";
                File file = new File(filename);
                try{
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = reader.readLine();
                    while (line != null) {
                        ta3.append(line + "\n");
                        line = reader.readLine();
                    }
                    reader.close();
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
                button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {

                    ta3.setVisible(true);
                    ta1.setVisible(false);
                    ta2.setVisible(false);
                }
                });
            }
        
        }
        
    }
    public static void main(String args[]){
        
        //b.setPreferredSize(new Dimension(100,100));
        ViewData vd = new ViewData();
        vd.setLocationRelativeTo(null);
        vd.setVisible(true);
    }
}
