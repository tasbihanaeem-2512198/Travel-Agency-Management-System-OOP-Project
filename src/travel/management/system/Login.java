/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author Rao
 */
public class Login extends JFrame implements ActionListener{
    JButton login,signup,password;
    JTextField tfusername,tfpassword;
    Login(){
        setSize(900,400);
        setLocation(350,200);
        setLayout(null); //custom layout
        
        getContentPane().setBackground(Color.WHITE);
        JPanel p1=new JPanel();
        p1.setBackground(new Color(61, 141, 122));   //131,193,233 //0,126,110
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(200, 200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);
        
        JPanel p2=new JPanel();
        p2.setLayout(null);
       // p2.setBackground(new Color(168, 187, 163)); 
        p2.setBorder(new LineBorder(Color.BLACK));
        p2.setBounds(400,30,450,300);
        add(p2);
        
        JLabel lblusername= new JLabel("Enter Username:");
        lblusername.setBounds(60,20,150,25);
        lblusername.setFont(new Font("SAN SERIF",Font.BOLD,17));
        p2.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(60,60,300,30);
        //tfusername.setBorder(BorderFactory.createEmptyBorder());
         tfusername.setBorder(new LineBorder(Color.BLACK));
        p2.add(tfusername);
        
        
        
        JLabel lblpassword= new JLabel("Enter Password:");
        lblpassword.setBounds(60,110,150,25);
        lblpassword.setFont(new Font("SAN SERIF",Font.BOLD,17));
        p2.add(lblpassword);
        
       /* tfpassword = new JTextField();
        tfpassword.setBounds(60,150,300,30);
         tfpassword.setBorder(new LineBorder(Color.BLACK));
        //tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);*/
        
        
         tfpassword = new JPasswordField();
        tfpassword.setBounds(60,150,300,30);
         tfpassword.setBorder(new LineBorder(Color.BLACK));
        p2.add(tfpassword);
        
        login=new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(47,160,132));
        login.setForeground(Color.BLACK);
        login.setBorder(new LineBorder(Color.BLACK)); 
        login.addActionListener(this);
        p2.add(login);
        
        signup=new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(47,160,132));
        signup.setForeground(Color.BLACK);
        signup.setBorder(new LineBorder(Color.BLACK));
        signup.addActionListener(this);
        p2.add(signup);
        
        password=new JButton("Forget Password");
        password.setBounds(130,250,130,30);
        password.setBackground(new Color(47,160,132));
        password.setForeground(Color.BLACK);
        password.setBorder(new LineBorder(Color.BLACK));
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text=new JLabel("Trouble in login..");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.RED);
        p2.add(text);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==login){
            try{
               String username=tfusername .getText();
               String pass=tfpassword.getText();
              String query = "select * from account where username='" + username + 
               "' AND password='" + pass + "'";
              Connectivity c=new Connectivity();
              ResultSet rs=c.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
                  new Loading(username);
              }
              else{
                  JOptionPane.showMessageDialog(null,"Incorrect username or password");
              }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new Signup();
        }
        else{
            setVisible(false);
            new Forgetpassword();
        }
            
    }
    
    public static void main(String[] args){
        Login l=new Login();
        
        
    }
}
