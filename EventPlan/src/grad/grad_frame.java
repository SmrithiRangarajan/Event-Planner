package grad;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import home.*;
import eventplan.*;

public class grad_frame extends JFrame {
    int total,ppr=0,cpr=0,mpr=0,capr=0,popr=0;
    int musicprice=0, cakeprice, venueprice, foodprice=0, evetotal;
    String t = Integer.toString(total);
    public grad_frame(){
        setTitle("GRADUATION");
        setSize(1000,680);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new FlowLayout());
        
        //taking data from userlogin page
        userLogin u = new userLogin();
        //int guests = Integer.parseInt(u.guest);
        int guests = 20;
        JPanel contentpane = new JPanel();
        contentpane.setSize(1000,680);
        contentpane.setLayout(null);
        contentpane.setBackground(Color.darkGray);
        //contentpane.setLayout(new GridBagLayout());
        JTabbedPane tb = new JTabbedPane();
        
        //icon used for the tabs
        ImageIcon icon1 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\cake.jpg");
        ImageIcon icon2 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\venue.jpg");
        ImageIcon icon3 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\food.jpg");
        ImageIcon icon4 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\music.jpg");
       
        JPanel p1 = new JPanel(); //p1 is the panel for venue
        p1.setPreferredSize(new Dimension(900,550));
        p1.setBackground(Color.gray);
        p1.setLayout(new GridBagLayout());
        
        JPanel p2 = new JPanel();
        p2.setBackground(Color.gray);
        p2.setLayout(null);
        
        JPanel p3 = new JPanel();
        p3.setBackground(Color.gray);
        
        JPanel p4 = new JPanel();
        p4.setBackground(Color.gray);
        
        //FOR VENUE
        
        ImageIcon i1 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\bdayV1.jpg");
        ImageIcon i2 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\phal.jpg");
        ImageIcon i3 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\bdayV3.jpg");
        ImageIcon i4 = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\bdayV4.jpg");
        
        JButton b1 = new JButton(i1);
        b1.setPreferredSize(new Dimension(300,300));
        JButton b2 = new JButton(i2);
        b2.setPreferredSize(new Dimension(300,300));
        JButton b3 = new JButton(i3);
        b3.setPreferredSize(new Dimension(300,300));
        JButton b4 = new JButton(i4);
        b4.setPreferredSize(new Dimension(300,300));
        
        Border br = BorderFactory.createLineBorder(Color.black); //border for the panel
        
        JPanel pan1 = new JPanel(); //each panel for a pic of venue
        pan1.setBackground(Color.black);
        pan1.setBorder(br);
        //pan1.setLayout(new CardLayout());
        JPanel pan2 = new JPanel();
        pan2.setBackground(Color.black);
        pan2.setBorder(br);
        
        JPanel pan3 = new JPanel();
        pan3.setBackground(Color.black);
        pan3.setBorder(br);
        
        JPanel pan4 = new JPanel();
        pan4.setBackground(Color.black);
        pan4.setBorder(br);
        
        
        pan1.add(b1);
        pan2.add(b2);
        pan3.add(b3);
        pan4.add(b4);
        
        ImageIcon next = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\next.jpg");
        JButton bNext = new JButton(next);
        bNext.setPreferredSize(new Dimension(60,60));
        
        ImageIcon prev = new ImageIcon("C:\\Users\\smrit\\OneDrive\\Desktop\\java project\\prev.jpg");
        JButton bPrev = new JButton(prev);
        bPrev.setPreferredSize(new Dimension(60,60));
        bPrev.setEnabled(false);
        
        bNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                 
                p1.remove(pan2);
                p1.add(pan1);
                
                p1.remove(pan3);
                p1.add(pan4);
                p1.remove(bNext);
                p1.add(bNext);
                bNext.setEnabled(false);
                bPrev.setEnabled(true);
        
                p1.repaint();
            }
        });
        
        bPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                p1.remove(pan1);
                p1.add(pan2);
                
                p1.remove(pan4);
                p1.add(pan3);
                p1.remove(bNext);
                p1.add(bNext);
                bPrev.setEnabled(false);
                bNext.setEnabled(true);
             
                p1.repaint();
            }
        });
        
        p1.add(bPrev);
        p1.add(pan2);
        p1.add(pan3);
        p1.add(bNext);
        
      
        //WHEN A VENUE IS SELECTED
        
        b1.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            pan1.setBackground(Color.white);
            venueprice = 5500; //price
            pan2.setBackground(Color.black);
            pan3.setBackground(Color.black);
            pan4.setBackground(Color.black);
            
        }
        });
        
        b2.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            pan2.setBackground(Color.white);
            venueprice = 7500;
            pan1.setBackground(Color.black);
            pan3.setBackground(Color.black);
            pan4.setBackground(Color.black);
            
        }
        });
        
        b3.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            pan3.setBackground(Color.white);
            venueprice = 6000;
            pan1.setBackground(Color.black);
            pan2.setBackground(Color.black);
            pan4.setBackground(Color.black);
        }
        });
        
        b4.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            pan4.setBackground(Color.white);
            venueprice = 7300;
            pan1.setBackground(Color.black);
            pan2.setBackground(Color.black);
            pan3.setBackground(Color.black);
        }
        });
        
        
        //FOR CATERING
        
        //initialising price
        int pri = 0;
        JButton buf = new JButton("Buffet");
        buf.setBackground(Color.black);
        buf.setForeground(Color.white);
        buf.setFont(new Font("Futura", Font.ITALIC , 20));
        buf.setBounds(10,30,200,80);
        
        JButton al = new JButton("à la carte");
        al.setForeground(Color.white);
        al.setFont(new Font("Futura", Font.ITALIC , 20));
        al.setBackground(Color.black);
        al.setBounds(10,230,200,80); 
        
        JButton bar = new JButton("Outdoor barbecue");
        bar.setForeground(Color.white);
        bar.setBackground(Color.black);
        bar.setBounds(10,430,200,80);
        bar.setFont(new Font("Futura", Font.ITALIC , 20));
        
        
        p2.add(buf);
        p2.add(al);
        p2.add(bar);
        
        //buffet panel
        JPanel buff = new JPanel();
        buff.setBounds(230,2,665,530);
        buff.setBackground(Color.black);
        buff.setLayout(null);
        buff.setVisible(false); //intially it shouldn't be seen
        p2.add(buff);
        //checkboxes for buffet defined in global
        JCheckBox bbuf = new JCheckBox("Breakfast buffet");
        JCheckBox lbuf = new JCheckBox("Lunch buffet");
        JCheckBox dbuf = new JCheckBox("Dinner buffet");
        JLabel bt = new JLabel();
        JLabel bpr = new JLabel();
        
        //a la carte panel
        JPanel alc = new JPanel();
        alc.setBounds(230,2,665,530); 
        alc.setBackground(Color.black);
        alc.setLayout(null);
        alc.setVisible(false);
        p2.add(alc);
        //checkboxes for a la carte defined in global
        JCheckBox bal = new JCheckBox("Breakfast");
        JCheckBox lal = new JCheckBox("Lunch");
        JCheckBox dal = new JCheckBox("Dinner");
        JLabel apr = new JLabel();
        JLabel at = new JLabel();
        
        //barbecue panel
        JPanel barb = new JPanel();
        barb.setBounds(230,2,665,530); 
        barb.setBackground(Color.black);
        barb.setLayout(null);
        barb.setVisible(false);
        p2.add(barb);
        //checkboxes for barbecue defined in global
        JCheckBox panneer = new JCheckBox("panneer (80/-)");
        JCheckBox corn = new JCheckBox("corn (70/-)");
        JCheckBox mush = new JCheckBox("mushrooms (100/-)");
        JCheckBox potat = new JCheckBox("potatoes (70/-)");
        JCheckBox cap = new JCheckBox("capsicum (65/-)");
        JLabel tot = new JLabel();
        
       
        
              
        //when clicked on buffet button
        buf.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
            //alc.setVisible(false);
            //buff.setBounds(230,10,690,530);
            //buff.setBackground(Color.black);
            JLabel l1 = new JLabel();
            //switching when selected
            while(bal.isSelected() == true || lal.isSelected() == true || dal.isSelected() == true) {
                        int res = JOptionPane.showConfirmDialog(alc, "switch to buffet?", "Switch", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                        if(res == JOptionPane.YES_OPTION){
                            //JOptionPane.getRootFrame().dispose();
                            //l1.setText("selected : yes");
                            buff.setVisible(true);
                            //bal.setSelected(true);
                            alc.setVisible(false);
                            bal.setSelected(false);
                            lal.setSelected(false);
                            dal.setSelected(false);
                            apr.setText("");
                            at.setText("");
                            foodprice = 0;
                            //bal.setSelected(true);
                            break;
                        }
                        else if(res == JOptionPane.NO_OPTION){
                            buff.setVisible(false);
                            l1.setText("selected : No");
                            break;
                        }
                        
            }
            
            while(panneer.isSelected() == true || corn.isSelected() == true || cap.isSelected() == true || mush.isSelected() == true || potat.isSelected() == true) {
                        int res = JOptionPane.showConfirmDialog(barb, "switch to buffet?", "Switch", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                        if(res == JOptionPane.YES_OPTION){
                            //JOptionPane.getRootFrame().dispose();
                            //l1.setText("selected : yes");
                            buff.setVisible(true);
                            //bal.setSelected(true);
                            barb.setVisible(false);
                            panneer.setSelected(false);
                            corn.setSelected(false);
                            cap.setSelected(false);
                            mush.setSelected(false);
                            potat.setSelected(false);
                            tot.setText("");
                            total = 0;
                            foodprice = 0;
                            t = "0";
                            
                            
                            //bal.setSelected(true);
                            break;
                        }
                        else if(res == JOptionPane.NO_OPTION){
                            buff.setVisible(false);
                            l1.setText("selected : No");
                            break;
                        }
                        
            }
            
            
            JLabel b = new JLabel("Buffet"); //Heading
            b.setFont(new Font("Futura", Font.ITALIC , 55));
            b.setBounds(250,3,150,50);
            b.setForeground(Color.white);
            buff.add(b);
            
            
            bbuf.setBounds(30,90,250,60);
            bbuf.setFont(new Font("Serif", Font.BOLD , 25));
            bbuf.setBackground(Color.black);
            bbuf.setForeground(Color.white);
            
            
            lbuf.setBounds(30,170,250,60);
            lbuf.setFont(new Font("Serif", Font.BOLD , 25));
            lbuf.setBackground(Color.black);
            lbuf.setForeground(Color.white);
            
            dbuf.setBounds(30,250,250,60);
            dbuf.setFont(new Font("Serif", Font.BOLD , 25));
            dbuf.setForeground(Color.white);
            dbuf.setBackground(Color.black);
            
            JLabel time = new JLabel("Time : ");
            time.setForeground(Color.white);
            time.setBounds(520,400,50,40);
            JLabel price = new JLabel("Price : ");
            price.setBounds(520,450,50,40);
            price.setForeground(Color.white);
            
            //to display time and price
            //JLabel bt = new JLabel();
            bt.setForeground(Color.white);
            bt.setBounds(560,400,120,40);
            //JLabel bpr = new JLabel();
            bpr.setForeground(Color.white);
            bpr.setBounds(560,450,90,40);
            
            //breakfast buffet
            
            bbuf.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        lbuf.setSelected(false);
                        dbuf.setSelected(false);
                        //JOptionPane.showConfirmDialog(buf, "hi");
                        int pri = 850;
                        String p = Integer.toString(pri);
                        foodprice = 850*guests;
                        //String t = "7:30-10:30";
                        bpr.setText(p + "/-");
                        bt.setText("7:30am-10:30am");
                    }
                }
                });
            
            //lunch buffet
            
            lbuf.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        bbuf.setSelected(false);
                        dbuf.setSelected(false);
                        //JOptionPane.showConfirmDialog(buf, "hi");
                        int pri = 880;
                        String p = Integer.toString(pri);
                        foodprice = 880*guests;
                        //String t = "7:30-10:30";
                        bpr.setText(p + "/-");
                        bt.setText("1:30pm-3:30pm");
                    }
                }
                });
            
            //dinner buffet
            
            dbuf.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        lbuf.setSelected(false);
                        bbuf.setSelected(false);
                        //JOptionPane.showConfirmDialog(buf, "hi");
                        int pri = 900;
                        String p = Integer.toString(pri);
                        foodprice = 900*guests;
                        //String t = "7:30-10:30";
                        bpr.setText(p + "/-");
                        bt.setText("7:30pm-10:30pm");
                    }
                }
                });
            
            buff.add(bbuf);
            buff.add(lbuf);
            buff.add(dbuf);
            buff.add(time);
            buff.add(price);
            buff.add(bpr);
            buff.add(bt);
            
            //initial visibility
            if(bal.isSelected() == false && lal.isSelected() == false && dal.isSelected() == false && panneer.isSelected() == false && corn.isSelected() == false && cap.isSelected() == false && mush.isSelected() == false && potat.isSelected() == false){
                buff.setVisible(true);
                alc.setVisible(false);
                barb.setVisible(false);
            }
        }
        });
        
        //WHEN CLICKED ON A LA CARTE BUTTON
        al.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae) {
            //buff.setVisible(false);
            JLabel l2 = new JLabel();
            //switching when selected
            while(bbuf.isSelected() == true || lbuf.isSelected() == true || dbuf.isSelected() == true) {
                        int res = JOptionPane.showConfirmDialog(buff, "switch to à la carte?", "Switch", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                        if(res == JOptionPane.YES_OPTION){
                            //JOptionPane.getRootFrame().dispose();
                            //l1.setText("selected : yes");
                            alc.setVisible(true);
                            buff.setVisible(false);
                            //bal.setSelected(true);
                            bbuf.setSelected(false);
                            lbuf.setSelected(false);
                            dbuf.setSelected(false);
                            bpr.setText("");
                            bt.setText("");
                            foodprice = 0;
                            
                            //bal.setSelected(true);
                            break;
                        }
                        else if(res == JOptionPane.NO_OPTION){
                            alc.setVisible(false);
                            l2.setText("selected : No");
                            break;
                        }
                        
            }
            
            while(panneer.isSelected() == true || corn.isSelected() == true || cap.isSelected() == true || mush.isSelected() == true || potat.isSelected() == true) {
                        int res = JOptionPane.showConfirmDialog(barb, "switch to à la carte?", "Switch", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                        if(res == JOptionPane.YES_OPTION){
                            //JOptionPane.getRootFrame().dispose();
                            //l1.setText("selected : yes");
                            alc.setVisible(true);
                            barb.setVisible(false);
                            //bal.setSelected(true);
                            panneer.setSelected(false);
                            corn.setSelected(false);
                            cap.setSelected(false);
                            mush.setSelected(false);
                            potat.setSelected(false);
                            tot.setText("");
                            total = 0;
                            foodprice = 0;
                            t="0";
                            //bal.setSelected(true);
                            break;
                        }
                        else if(res == JOptionPane.NO_OPTION){
                            alc.setVisible(false);
                            l2.setText("selected : No");
                            break;
                        }
                        
            }
            
            JLabel a = new JLabel("À la carte"); //Heading
            a.setFont(new Font("Futura", Font.ITALIC , 55));
            a.setBounds(220,3,250,50);
            a.setForeground(Color.white);
            alc.add(a);
            
            
            bal.setBounds(30,90,250,60);
            bal.setFont(new Font("Serif", Font.BOLD , 25));
            bal.setBackground(Color.black);
            bal.setForeground(Color.white);
            
            
            lal.setBounds(30,170,250,60);
            lal.setFont(new Font("Serif", Font.BOLD , 25));
            lal.setBackground(Color.black);
            lal.setForeground(Color.white);
            
            
            dal.setBounds(30,250,250,60);
            dal.setFont(new Font("Serif", Font.BOLD , 25));
            dal.setForeground(Color.white);
            dal.setBackground(Color.black);
            
            JLabel menu = new JLabel("pick your cuisine : ");
            menu.setForeground(Color.white);
            menu.setFont(new Font("Futura", Font.ITALIC , 20));
            //menu.setForeground(Color.black);
            menu.setBounds(30,340,180,30); 
            String m[] = {"Indian", "International", "Fusion"};
            JComboBox me = new JComboBox(m);
            me.setBounds(200,340,100,30);
            
            //time and price labels
            JLabel time = new JLabel("Time : ");
            time.setForeground(Color.white);
            time.setBounds(520,400,50,40);
            JLabel price = new JLabel("Price : ");
            price.setBounds(520,450,50,40);
            price.setForeground(Color.white);
            
           //to display time and price
            //JLabel t = new JLabel();
            at.setForeground(Color.white);
            at.setBounds(560,400,120,40);
            //JLabel pr = new JLabel();
            apr.setForeground(Color.white);
            apr.setBounds(560,450,90,40);
            
            //breakfast
            
            bal.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    
                    if(ie.getStateChange() == 1){
                        lal.setSelected(false);
                        dal.setSelected(false);
                        //JOptionPane.showConfirmDialog(buf, "hi");
                        int pri = 850;
                        String p = Integer.toString(pri);
                        foodprice = 850*guests;
                        //String t = "7:30-10:30";
                        apr.setText(p + "/-");
                        at.setText("8:00am-11:00am");
                    }
                    
                }
                });
            
            //lunch
            lal.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        bal.setSelected(false);
                        dal.setSelected(false);
                        //JOptionPane.showConfirmDialog(buf, "hi");
                        int pri = 880;
                        String p = Integer.toString(pri);
                        foodprice = 880*guests;
                        //String t = "7:30-10:30";
                        apr.setText(p + "/-");
                        at.setText("1:30pm-3:30pm");
                    }
                }
                });
            
            //dinner
            dal.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        lal.setSelected(false);
                        bal.setSelected(false);
                        //JOptionPane.showConfirmDialog(buf, "hi");
                        int pri = 900;
                        String p = Integer.toString(pri);
                        foodprice = 900*guests;
                        //String t = "7:30-10:30";
                        apr.setText(p + "/-");
                        at.setText("8:00pm-11:30pm");
                    }
                }
                });
            
            alc.add(bal);
            alc.add(lal);
            alc.add(dal);
            alc.add(menu);
            alc.add(me);
            alc.add(time);
            alc.add(price);
            alc.add(apr);
            alc.add(at);
            
            //intial visibility
            if(bbuf.isSelected() == false && lbuf.isSelected() == false && dbuf.isSelected() == false && panneer.isSelected() == false && corn.isSelected() == false && cap.isSelected() == false && mush.isSelected() == false && potat.isSelected() == false){
                alc.setVisible(true);
                buff.setVisible(false);
                barb.setVisible(false);
                
            }
            
        }
        });
        
        //WHEN CLICKED ON BARBECUE BUTTON
        bar.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae) {
            //String t = Integer.toString(total);
            tot.setText("Total : " + t + "/-");
            tot.setBackground(Color.black);
            tot.setForeground(Color.white);
            tot.setBounds(300,450,100,50);
            //JLabel l3 = new JLabel();
            while(bbuf.isSelected() == true || lbuf.isSelected() == true || dbuf.isSelected() == true) {
                        int res = JOptionPane.showConfirmDialog(buff, "switch to outdoor barbecue?", "Switch", JOptionPane.YES_NO_OPTION,
                           JOptionPane.QUESTION_MESSAGE);

                        if(res == JOptionPane.YES_OPTION){
                           //JOptionPane.getRootFrame().dispose();
                           //l1.setText("selected : yes");
                           barb.setVisible(true);
                           alc.setVisible(false);
                           buff.setVisible(false);
                           //bal.setSelected(true);
                           bbuf.setSelected(false);
                           lbuf.setSelected(false);
                           dbuf.setSelected(false);
                           bt.setText("");
                           bpr.setText("");
                           foodprice = 0;
                           //tot.setText("Total : 0/-");

                           //bal.setSelected(true);
                           break;
                        }
                        else if(res == JOptionPane.NO_OPTION){
                           barb.setVisible(false);
                           //l3.setText("selected : No");
                           break;
                        }

            }
            
            while(bal.isSelected() == true || lal.isSelected() == true || dal.isSelected() == true) {
                        int res = JOptionPane.showConfirmDialog(alc, "switch to outdoor barbecue?", "Switch", JOptionPane.YES_NO_OPTION,
                           JOptionPane.QUESTION_MESSAGE);

                        if(res == JOptionPane.YES_OPTION){
                           //JOptionPane.getRootFrame().dispose();
                           //l1.setText("selected : yes");
                           barb.setVisible(true);
                           alc.setVisible(false);
                           buff.setVisible(false);
                           //bal.setSelected(true);
                           bal.setSelected(false);
                           lal.setSelected(false);
                           dal.setSelected(false);
                           at.setText("");
                           apr.setText("");
                           foodprice = 0;
                           //tot.setText("Total : 0/-");

                           //bal.setSelected(true);
                           break;
                        }
                        else if(res == JOptionPane.NO_OPTION){
                           barb.setVisible(false);
                           //l3.setText("selected : No");
                           break;
                        }

            }
            
            JLabel c = new JLabel("Outdoor barbecue"); //Heading
            c.setFont(new Font("Futura", Font.ITALIC , 45));
            c.setBounds(150,3,450,50);
            c.setForeground(Color.white);
            barb.add(c);
            
            JLabel ch = new JLabel("Choose your grills : ");
            ch.setFont(new Font("Futura", Font.ITALIC , 25));
            ch.setBounds(30,80,450,40);
            ch.setForeground(Color.white);
            barb.add(ch);
            
            panneer.setBounds(30,120,250,60);
            panneer.setFont(new Font("Serif", Font.BOLD , 20));
            panneer.setBackground(Color.black);
            panneer.setForeground(Color.white);
            
            corn.setBounds(30,170,250,60);
            corn.setFont(new Font("Serif", Font.BOLD , 20));
            corn.setBackground(Color.black);
            corn.setForeground(Color.white);
            
            mush.setBounds(30,220,250,60);
            mush.setFont(new Font("Serif", Font.BOLD , 20));
            mush.setBackground(Color.black);
            mush.setForeground(Color.white);
            
            cap.setBounds(30,270,250,60);
            cap.setFont(new Font("Serif", Font.BOLD , 20));
            cap.setBackground(Color.black);
            cap.setForeground(Color.white);
            
            potat.setBounds(30,320,250,60);
            potat.setFont(new Font("Serif", Font.BOLD , 20));
            potat.setBackground(Color.black);
            potat.setForeground(Color.white);
            
            
            
            //price calculation
            panneer.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ce) {
                if(ce.getStateChange() == ItemEvent.SELECTED){
                    total += 80;
                    //ppr = 80;
                    //tot.setText("Total : " + t);
                }
                else {
                    total -= 80;
                    //ppr = 0;
                    //tot.setText("Total : " + total);
                }
                foodprice += total;
                tot.setText("Total : " + total + "/-");
            }
            });
            corn.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ce) {
                if(ce.getStateChange() == ItemEvent.SELECTED){
                    total += 70;
                    //cpr = 70;
                    //tot.setText("Total : " + total);
                }
                else {
                    total -= 70;
                    //cpr = 0;
                }
                foodprice += total;
                tot.setText("Total : " + total + "/-");
            }
            });
            mush.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ce) {
                if(ce.getStateChange() == ItemEvent.SELECTED){
                    total += 100;
                    //mpr = 100;
                    //tot.setText("Total : " + total);
                }
                else{
                    total -= 100;
                    //mpr = 0;
                }
                foodprice = total;
                tot.setText("Total : " + total + "/-");
            }
            });
            cap.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ce) {
                if(ce.getStateChange() == ItemEvent.SELECTED){
                    total += 65;
                    //capr = 65;
                    //tot.setText("Total : " + total);
                }
                else{
                    total -= 65;
                    //capr = 65;
                }
                foodprice = total;
                tot.setText("Total : " + total + "/-");
            }
            });
            potat.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ce) {
                if(ce.getStateChange() == ItemEvent.SELECTED){
                    total += 70;
                    //popr = 70;
                    //tot.setText("Total : " + total);
                }
                else{
                    total -= 70;
                    //popr = 70;
                }
                foodprice = total;
                tot.setText("Total : " + total + "/-");
            }
            });
            
            //total = pprice + cprice + mprice + caprice + potprice;
            
            //foodprice = total;
            
            
            barb.add(panneer);
            barb.add(corn);
            barb.add(cap);
            barb.add(mush);
            barb.add(potat);
            barb.add(tot);
            
            
            if(bbuf.isSelected() == false && lbuf.isSelected() == false && dbuf.isSelected() == false && bal.isSelected() == false && lal.isSelected() == false && dal.isSelected() == false){
                barb.setVisible(true);
                alc.setVisible(false);
                buff.setVisible(false);
            }
        }
        });
        
        
       //FOR MUSIC
       
       JPanel mus = new JPanel();
       mus.setPreferredSize(new Dimension(900,550));
       mus.setBackground(Color.black);
       mus.setLayout(null);
       
       JLabel ml = new JLabel("Choose your genre : ");
       ml.setFont(new Font("Futura", Font.BOLD , 40));
       ml.setBounds(10,10,400,50);
       //ml.setBackground(Color.red);
       ml.setForeground(Color.white);
       
       JCheckBox ch1 = new JCheckBox("softrock");
       ch1.setFont(new Font("Futura", Font.BOLD , 25));
       ch1.setBounds(20,80,150,30);
       ch1.setBackground(Color.lightGray);
       JCheckBox ch2 = new JCheckBox("indie");
       ch2.setFont(new Font("Futura", Font.BOLD , 25));
       ch2.setBounds(20,140,150,30);
       ch2.setBackground(Color.lightGray);
       JCheckBox ch3 = new JCheckBox("pop");
       ch3.setFont(new Font("Futura", Font.BOLD , 25));
       ch3.setBounds(20,200,150,30);
       ch3.setBackground(Color.lightGray);
       JCheckBox ch4 = new JCheckBox("fusion");
       ch4.setFont(new Font("Futura", Font.BOLD , 25));
       ch4.setBounds(20,260,150,30);
       ch4.setBackground(Color.lightGray);
       
       JLabel mprice = new JLabel("Price : 0/-");
       mprice.setForeground(Color.white);
       mprice.setBounds(750,450,100,20);
       mus.add(mprice);
       
       ch1.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        ch2.setSelected(false);
                        ch3.setSelected(false);
                        ch4.setSelected(false);
                        musicprice = 500;
                        mprice.setText("Price : 500/-");
                    }
                }
       });
       
       ch2.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        ch1.setSelected(false);
                        ch3.setSelected(false);
                        ch4.setSelected(false);
                        musicprice = 500;
                        mprice.setText("Price : 500/-");
                    }
                }
       });
       
       ch3.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        ch1.setSelected(false);
                        ch2.setSelected(false);
                        ch4.setSelected(false);
                        musicprice = 550;
                        mprice.setText("Price : 550/-");
                    }
                }
       });
       
       ch4.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        ch1.setSelected(false);
                        ch2.setSelected(false);
                        ch3.setSelected(false);
                        musicprice = 580;
                        mprice.setText("Price : 580/-");
                    }
                }
       });
       
       mus.add(ml);
       mus.add(ch1);
       mus.add(ch2);
       mus.add(ch3);
       mus.add(ch4);
       //mus.add(mprice);

       p3.add(mus);

       
       //FOR CAKES
       JPanel cek = new JPanel();
       cek.setPreferredSize(new Dimension(900,550));
       cek.setBackground(Color.black);
       cek.setLayout(null);
       
       JLabel cl = new JLabel("Choose your flavour : ");
       cl.setFont(new Font("Futura", Font.ITALIC , 40));
       cl.setBounds(10,10,500,50);
       //ml.setBackground(Color.red);
       cl.setForeground(Color.white);
       
       //flavours
       JCheckBox cch1 = new JCheckBox("vanilla");
       cch1.setFont(new Font("Futura", Font.BOLD , 25));
       cch1.setBounds(20,80,230,30);
       cch1.setBackground(Color.white);
       JCheckBox cch2 = new JCheckBox("strawberry");
       cch2.setFont(new Font("Futura", Font.BOLD , 25));
       cch2.setBounds(20,140,230,30);
       cch2.setBackground(Color.pink);
       JCheckBox cch3 = new JCheckBox("kiwi");
       cch3.setFont(new Font("Futura", Font.BOLD , 25));
       cch3.setBounds(20,200,230,30);
       cch3.setBackground(Color.green);
       JCheckBox cch4 = new JCheckBox("dark chocolate");
       cch4.setFont(new Font("Futura", Font.BOLD , 25));
       cch4.setBounds(20,260,230,30);
       cch4.setBackground(Color.lightGray);
       JCheckBox cch5 = new JCheckBox("mango");
       cch5.setFont(new Font("Futura", Font.BOLD , 25));
       cch5.setBounds(20,320,230,30);
       cch5.setBackground(Color.orange);
       
       JLabel cprice = new JLabel("Price : 0/-");
       cprice.setForeground(Color.white);
       cprice.setBounds(750,450,100,20);
       cek.add(cprice);
       
       cch1.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        cch2.setSelected(false);
                        cch3.setSelected(false);
                        cch4.setSelected(false);
                        cch5.setSelected(false);
                        cakeprice = 300;
                        cprice.setText("Price : 300/-");
                    }
                }
       });
       
       cch2.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        cch1.setSelected(false);
                        cch3.setSelected(false);
                        cch4.setSelected(false);
                        cch5.setSelected(false);
                        cakeprice = 300;
                        cprice.setText("Price : 300/-");
                    }
                }
       });
       
       cch3.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        cch1.setSelected(false);
                        cch2.setSelected(false);
                        cch4.setSelected(false);
                        cch5.setSelected(false);
                        cakeprice = 350;
                        cprice.setText("Price : 350/-");
                    }
                }
       });
       
       cch4.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        cch1.setSelected(false);
                        cch2.setSelected(false);
                        cch3.setSelected(false);
                        cch5.setSelected(false);
                        cakeprice = 380;
                        cprice.setText("Price : 380/-");
                    }
                }
       });
       
       cch5.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent ie){
                    if(ie.getStateChange() == 1){
                        cch1.setSelected(false);
                        cch2.setSelected(false);
                        cch3.setSelected(false);
                        cch4.setSelected(false);
                        cakeprice = 380;
                        cprice.setText("Price : 380/-");
                    }
                }
       });
       
       
       
       cek.add(cl);
       cek.add(cch1);
       cek.add(cch2);
       cek.add(cch3);
       cek.add(cch4);
       cek.add(cch5);
       
       p4.add(cek);
       
       //CALCULATE BUTTON
       
       JButton calculate = new JButton("Calculate Total");
       calculate.setBackground(Color.lightGray);
       calculate.setBounds(55,400,150,30);
       cek.add(calculate);
       //CONFIRM BUTTON
       JButton book = new JButton("BOOK");
       book.setBackground(Color.lightGray);
       book.setBounds(55,450,150,30);
       cek.add(book);
       
       book.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent ae){
           int res = JOptionPane.showConfirmDialog(cek, "Confirm and book?", "Book", JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
           if(res == JOptionPane.YES_OPTION) {
               JOptionPane.showMessageDialog(cek, "successfully booked!");
               dispose();
               event eve = new event();
               eve.setLocationRelativeTo(null);
               eve.setVisible(true);
           }
       }
       });
       
       calculate.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent ae) {
           int res = JOptionPane.showConfirmDialog(cek, "Confirm and calculate?", "Total", JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
           if(res == JOptionPane.YES_OPTION) {
               evetotal = musicprice + cakeprice + foodprice + venueprice;
               String msg = "total bill : " + evetotal + "/-";
               JOptionPane.showMessageDialog(cek, msg);
           }
       }
       });
       
       
        
        //MAKING SURE EVERY CATEGORY IS CHOSEN
        JLabel ch = new JLabel();
        tb.addChangeListener(new ChangeListener(){
        public void stateChanged(ChangeEvent ce) {
            if(tb.getSelectedIndex() == 1) {
                if(pan1.getBackground().equals(Color.white) || pan2.getBackground().equals(Color.white) || pan3.getBackground().equals(Color.white) || pan4.getBackground().equals(Color.white)){
                    ch.setText("pressed");
                }
                else {
                   tb.setSelectedIndex(0);
                   JOptionPane.showMessageDialog(p1, "Please select a venue to proceed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if(tb.getSelectedIndex() == 2) {
                if(pan1.getBackground().equals(Color.white) || pan2.getBackground().equals(Color.white) || pan3.getBackground().equals(Color.white) || pan4.getBackground().equals(Color.white) || foodprice != 0 ){
                    ch.setText("pressed");
                }
                else {
                   tb.setSelectedIndex(0);
                   JOptionPane.showMessageDialog(p1, "Please select the previous options to proceed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            if(tb.getSelectedIndex() == 3) {
                if(pan1.getBackground().equals(Color.white) || pan2.getBackground().equals(Color.white) || pan3.getBackground().equals(Color.white) || pan4.getBackground().equals(Color.white) || bbuf.isSelected() == true || lbuf.isSelected() == true || dbuf.isSelected() == true || lal.isSelected() == true || bal.isSelected() == true || dal.isSelected()==true || panneer.isSelected()==true || corn.isSelected()==true || mush.isSelected()==true || potat.isSelected()==true || cap.isSelected()==true){
                    ch.setText("pressed");
                }
                else {
                   tb.setSelectedIndex(0);
                   JOptionPane.showMessageDialog(p1, "Please select the previous options to proceed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        });
        
        
        
        
        
        
        
        tb.addTab("Venue",icon2, p1, "Choose the venue");
        tb.addTab("Catering", icon3,p2, "Choose the food");
        tb.addTab("Music/DJ",icon4, p3, "Choose the music");
        tb.addTab("Cakes", icon1,p4, "Choose your cake");
        
        
        tb.setBounds(40,40,900,600);
        contentpane.add(tb);
        
        //TITLE (HEADING)
        JLabel bday = new JLabel("GRADUATION!");
        bday.setForeground(Color.white);
        bday.setFont(new Font("futura", Font.BOLD, 20));
        bday.setBounds(450,10,130,20);
        
        contentpane.add(bday);
        
        //BACK BUTTON
        JButton back = new JButton("Back");
        //back.setForeground(Color.white);
        back.setBounds(10,10,70,20);
        contentpane.add(back);
        //contentpane.add(back);
        
        JLabel lab = new JLabel();
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae) {
            int result = JOptionPane.showConfirmDialog(tb, "Choose another event?", "Return", JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION) {
                dispose();
                createFr fr = new createFr();
                fr.setLocationRelativeTo(null);
                fr.setVisible(true);
            }
            else {
                lab.setText("you selected : No");
            }
        }
        });
        add(contentpane);
    }
    
    public static void main(String[] args){
        grad_frame gf = new grad_frame();
        gf.setLocationRelativeTo(null);
        gf.setVisible(true);
    }

}



