
package home;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import eventplan.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import addData.*;

public class adminLogin extends JFrame{
    public adminLogin(){
        setTitle("Admin Login");
        setSize(1000,680);

        ImageIcon i = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\calender.jpg");

        JPanel bg = new JPanel();
        bg.setPreferredSize(new Dimension(1000,680));
        bg.setBackground(Color.darkGray);
        
        JLabel form = new JLabel(i);
        form.setPreferredSize(new Dimension(800,680));
        
        add(bg);
        
        JLabel l1 = new JLabel("Admin Login");
        l1.setBackground(Color.darkGray);
        l1.setFont(new Font("Futura", Font.BOLD, 40));
        l1.setPreferredSize(new Dimension(800,100));
        Dimension size = l1.getPreferredSize();
        l1.setBounds(300,10, size.width, size.height);
        
        form.add(l1);
        
        JLabel username = new JLabel("Username : ");
        username.setFont(new Font("Futura", Font.LAYOUT_NO_START_CONTEXT, 20));
        username.setBounds(100, 160, 120,30);
        JTextField user = new JTextField();
        user.setBounds(270, 160, 150,30);
        
        JLabel pw = new JLabel("Password : ");
        pw.setFont(new Font("Futura", Font.LAYOUT_NO_START_CONTEXT, 20));
        pw.setBounds(100,200, 120,30);
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
        
        JButton e = new JButton("Login");
        e.setBounds(340,550,160,30);
        e.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae) {
           if(!user.getText().equals("admin") || !pass.getText().equals("adminpass")) {
                   JOptionPane.showMessageDialog(form, "Incorrect username or password", "Error", JOptionPane.WARNING_MESSAGE);
           }
           else if(user.getText().isEmpty() && pass.getText().isEmpty()){
                   JOptionPane.showMessageDialog(form, "Please fill all the details to continue");
           }else {
                   
                   dispose();
                   //userLogin u = new userLogin();
                   
                   ViewData vd = new ViewData();
                   vd.setLocationRelativeTo(null);
                   vd.setVisible(true);
                }
            }
        });
        
        form.add(username);
        form.add(user);
        form.add(pw);
        form.add(pass);
        form.add(showpw);
        form.add(e);
        
        
        //BACK BUTTON
        ImageIcon backb = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\back.jpg");
        JButton back = new JButton(backb);
        back.setBounds(10,10,40,40);
        JLabel label = new JLabel();
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            if(user.getText().isEmpty() && pass.getText().isEmpty()){
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
                   label.setText("you selected : No");
               }
            }
        }
        });
        
        form.add(back);
        bg.add(form);
    }
    
    public static void main(String[] args){
        adminLogin al = new adminLogin();
        al.setLocationRelativeTo(null);
        al.setVisible(true);
    }
  
}
