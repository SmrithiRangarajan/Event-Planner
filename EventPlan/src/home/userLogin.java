
package home;

import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import eventplan.*;
import java.util.Date;
import java.text.SimpleDateFormat;

//file handling
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class userLogin extends JFrame{
    public String uname, uemail, udate;
    public String unum, uguest, uevent;
    public JButton e;
    public static int usernum = 1;
    public String guest;
    public userLogin(){
        setTitle("User Login");
        setSize(1000,680);
        setLayout(new FlowLayout());
        
        ImageIcon i = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\calender.jpg");
        //setBackground(Color.BLACK);
        
        JPanel bg = new JPanel();
        bg.setPreferredSize(new Dimension(1000,680));
        
        bg.setBackground(Color.darkGray);
       
        
        JLabel form = new JLabel(i);
        form.setPreferredSize(new Dimension(800,680));
        //form.setBackground(Color.black);
        
        add(bg);
        bg.add(form);
        
        
        JLabel l1 = new JLabel("User Login");
        l1.setBackground(Color.darkGray);
        l1.setFont(new Font("Futura", Font.BOLD, 40));
        l1.setPreferredSize(new Dimension(800,100));
        Dimension size = l1.getPreferredSize();
        l1.setBounds(300,10, size.width, size.height);
        
        form.add(l1);
        
        JLabel username = new JLabel("Username : ");
        username.setFont(new Font("Futura", Font.LAYOUT_NO_START_CONTEXT, 18));
        username.setBounds(100, 160, 120,30);
        JTextField user = new JTextField();
        
        user.setBounds(270, 160, 150,30);
        
        JLabel pw = new JLabel("Password : ");
        pw.setFont(new Font("Futura", Font.LAYOUT_NO_START_CONTEXT, 18));
        pw.setBounds(100,200, 100,30);
        JPasswordField pass = new JPasswordField();
        pass.setBounds(270, 200, 150, 30);
        
        JCheckBox showpw = new JCheckBox("Show Password");
        showpw.setBackground(Color.DARK_GRAY);
        showpw.setForeground(Color.white);
        showpw.setBounds(280,240,130,20);
        showpw.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
           if (e.getSource() == showpw) {
                if (showpw.isSelected()) {
                    pass.setEchoChar((char) 0);
                } else {
                    pass.setEchoChar('*');
                }
            }
        }});
        
        JLabel email = new JLabel("Email ID : ");
        email.setFont(new Font("Futura", Font.LAYOUT_NO_START_CONTEXT, 18));
        email.setBounds(100, 270, 100, 30);
        JTextField em = new JTextField();
        em.setBounds(270, 270, 180, 30);
        
        JLabel ph = new JLabel("Contact no. : ");
        ph.setFont(new Font("Futura", Font.LAYOUT_NO_START_CONTEXT, 18));
        ph.setBounds(100,320,180,30);
        JTextField phone = new JTextField();
        phone.setBounds(270,320,150,30);
        //JLabel label = new JLabel();
        //label.setForeground(Color.red);
        phone.addKeyListener(new KeyAdapter() {
        public void keyPressed(KeyEvent ke) {
            String value = phone.getText();
            int l = value.length();
            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
               phone.setEditable(true);
               //label.setText("");
            } else if(ke.getKeyChar() >= 'a' && ke.getKeyChar() <= 'z') {
               phone.setEditable(false);
               JOptionPane.showMessageDialog(form, "Invalid Input!");
               phone.setEditable(true);
               //label.setText("* Invalid input!");
            }
         }
      });
        
        JLabel p = new JLabel("Number of Guests : ");
        p.setFont(new Font("Futura", Font.LAYOUT_NO_START_CONTEXT, 18));
        p.setBounds(100,370,200,30);
        String people[] = {"50-100", "100-500", "500-1000", "above 1000"};
        JComboBox ppl = new JComboBox(people);
        ppl.setBounds(270,370,150,30);
        
        
        
        JLabel date = new JLabel("Date of Event : ");
        date.setFont(new Font("Futura", Font.LAYOUT_NO_START_CONTEXT, 18));
        date.setBounds(100,420,150,30);
        JDateChooser d = new JDateChooser();
        d.setBounds(270, 420,150,30);
        
        /*JLabel month = new JLabel("Month : ");
        month.setBounds(100,420,100,20);
        JMonthChooser m = new JMonthChooser();
        m.setBounds(200,420,150,20);
        
        JLabel year = new JLabel("Year : ");
        year.setBounds(100,450,100,20);
        JYearChooser y = new JYearChooser();
        y.setBounds(200,450,100,20);*/
        
        
        //String d[] = {"1","2","3","4","5","6","7","8","09,"10","11","12","13","14","15","16","17","18","19","20","21","22","23"
        
        e = new JButton("Book an Event");
        e.setBounds(340,550,160,30);
        e.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae) {
           
           if(user.getText().isEmpty() || pass.getText().isEmpty() || em.getText().isEmpty() || phone.getText().isEmpty() || d.getDateFormatString().isEmpty()){
                   JOptionPane.showMessageDialog(form, "Please fill all the details to continue", "Error", JOptionPane.ERROR_MESSAGE);
            }
           else if(usernum > 3){
               JOptionPane.showMessageDialog(form, "sorry! reached maximum entries for the day");
           } else {
                   uname = user.getText();
                   uemail = em.getText();
                   unum = phone.getText();
                   uguest = (String)ppl.getSelectedItem();
                   if(uguest.equals("50-100"))
                       guest = "85";
                   else if(uguest.equals("100-500"))
                       guest = "250";
                   else if(uguest.equals("500-1000"))
                       guest = "750";
                   else
                       guest = "1200";
                   
                   Date seldate = d.getDate();
                   SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
                   udate = dateformat.format(seldate);
                   
                   createFr c = new createFr();
                   uevent = c.choice;
                   
                   String filename = "user_" + usernum + ".txt";
                   File f = new File(filename);
                   try{
                       FileWriter fw = new FileWriter(f, true); //setting the append parameter to true
                       fw.write("Name : " + uname + "\n");
                       fw.write("Email : " + uemail + "\n");
                       fw.write("Contact no. : " + unum + "\n");
                       //fw.write("Total : " + evetotal + "\n");
                       fw.write("Date of Event : " + udate + "\n");
                       fw.write("No. of Guests : " + uguest + "\n");
                       fw.close();
                   }catch (IOException ex) {
                       ex.printStackTrace();
                   }
                   usernum++;
                   dispose();
                   createFr cr = new createFr();
                   cr.setLocationRelativeTo(null);
                   cr.setVisible(true);
                }
            }
        });
        
        form.add(username);
        form.add(user);
        form.add(pw);
        form.add(pass);
        form.add(showpw);
        form.add(email);
        form.add(em);
        form.add(ph);
        form.add(phone);
        form.add(p);
        form.add(ppl);
        form.add(date);
        form.add(d);
        //form.add(month);
        //form.add(m);
        //form.add(year);
        //form.add(y);
        form.add(e);
        
        //RESET BUTTON
        JButton reset = new JButton("Reset");
        reset.setBounds(680,10,100,30); 
        
        JLabel label = new JLabel();
        
        reset.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            int res = JOptionPane.showConfirmDialog(form, "are you sure you want to reset?", "Reset", JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(res == JOptionPane.YES_OPTION){
                user.setText("");
                pass.setText("");
                showpw.setSelected(false);
                em.setText("");
                phone.setText("");
                ppl.setSelectedIndex(0);
                d.setCalendar(null);
            }
            else {
                label.setText("you selected : No");
                //d.setDate();
            }
        }
        });
        
        form.add(reset);
        
        //BACK BUTTON
        ImageIcon backb = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\back.jpg");
        JButton back = new JButton(backb);
        //back.setText("Back");
        
        back.setBounds(10,10,40,40);
        //back.setBackground(Color.darkGray);
        JLabel label1 = new JLabel();
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            if(user.getText().isEmpty() && pass.getText().isEmpty() && em.getText().isEmpty() && phone.getText().isEmpty()){
                dispose();
                event ev = new event();
                ev.setLocationRelativeTo(null);
                ev.setVisible(true);
            } else {
                int result = JOptionPane.showConfirmDialog(form, "discard changes?", "Return", JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
               if(result == JOptionPane.YES_OPTION){
                   dispose();
                   event ev = new event();
                   ev.setLocationRelativeTo(null);
                   ev.setVisible(true);
               }
               else {
                   label1.setText("you selected : No");
               }
            }
        }
        });
        
        
        form.add(back);
        
    }
    public static void main(String[] args){
        userLogin us = new userLogin();
        us.setLocationRelativeTo(null);
        us.setVisible(true);
    }

    
}


