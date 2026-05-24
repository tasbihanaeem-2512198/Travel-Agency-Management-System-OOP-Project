/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Rao
 */

public class Signup extends JFrame implements ActionListener{
   JButton create,back;
   JTextField tfname,tfusername,tfpassword,tfanswer;
   Choice security;
    Signup(){
        setBounds(350,200,900,360); //setBound function is a combinatin of setsize and setlocation
        getContentPane().setBackground(new Color(61, 141, 122));
        setLayout(null);
        
        
        JPanel p1=new JPanel();
        p1.setBackground(new Color(238, 238, 238));  //133,193,233
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblusername= new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(50,20,125,25);
        p1.add(lblusername);
        
        tfusername= new JTextField();
        tfusername.setBounds(190,20,180,25);
        //tfusername.setBorder(BorderFactory.createEmptyBorder());
        tfusername.setBorder(new LineBorder(Color.BLACK));
        p1.add(tfusername);
        
        JLabel lblname= new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        lblname.setBounds(50,60,125,25);
        p1.add(lblname);
        
        tfname= new JTextField();
        tfname.setBounds(190,60,180,25);
        //tfname.setBorder(BorderFactory.createEmptyBorder());
        tfname.setBorder(new LineBorder(Color.BLACK));
        p1.add(tfname);
        
         JLabel lblpassword= new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpassword.setBounds(50,100,125,25);
        p1.add(lblpassword);
        
        tfpassword= new JTextField();
        tfpassword.setBounds(190,100,180,25);
      //  tfpassword.setBorder(BorderFactory.createEmptyBorder()); 
        tfpassword.setBorder(new LineBorder(Color.BLACK));
        p1.add(tfpassword);
        
        JLabel lblsecurity= new JLabel("Security Question");
        lblsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
        lblsecurity.setBounds(50,140,140,25);
        p1.add(lblsecurity);
        
        
        security= new Choice();
        security.add("What is your childhood nickname?");
        security.add("What is your favourite country to visit?");
        security.add("What is your favourite food?");
        security.add("Enter the last 2 digits of your phone number.");
        security.setBounds(190,140,230,25);
        p1.add(security);
        
         
        JLabel lblanswer= new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lblanswer.setBounds(50,180,140,25);
        p1.add(lblanswer);
        
        
        tfanswer= new JTextField();
        tfanswer.setBounds(190,180,180,25);
       // tfanswer.setBorder(BorderFactory.createEmptyBorder());
        tfanswer.setBorder(new LineBorder(Color.BLACK));
        p1.add(tfanswer);
        
        
        create=new JButton("Create");
        create.setBackground(new Color(47,160,132));
        create.setForeground(Color.BLACK);
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        create.setBorder(new LineBorder(Color.BLACK));
        p1.add(create);
        
        back=new JButton("Back");
        back.setBackground(new Color(47,160,132));
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.setBorder(new LineBorder(Color.BLACK));
        back.addActionListener(this);
        p1.add(back);
        
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==create){
             String username=tfusername.getText();
             String name=tfname.getText();
             String password=tfpassword.getText();
             String question=security.getSelectedItem();
             String answer=tfanswer.getText();
             
             String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
             try{
                 Connectivity c=new Connectivity();
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "Account Created Successfully");
                 setVisible(false);
                 new Login();
             }catch(Exception e){
                 e.printStackTrace();
             }
         }
         else if(ae.getSource()==back){
             setVisible(false);
             new Login();
         }
    }
    public static void main(String[] args){
        new Signup();
    }
    
}
