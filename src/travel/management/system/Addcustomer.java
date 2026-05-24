/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;

/**
 *
 * @author Rao
 */

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;
public class Addcustomer extends JFrame implements ActionListener {
    
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfnumber,tfaddress,tfcountry,tfemail,tfphonenumber;
    JRadioButton rfemale,rmale;
    JButton add,back;
    Addcustomer(String username){
         setBounds(450,200,850,550);
         
         setLayout(null);
         getContentPane().setBackground(new Color(246, 255, 220));
         
         JLabel text=new JLabel("Add Personal Details");
         text.setBounds(50,15,300,25);
         text.setForeground(Color.BLACK);
         text.setFont(new Font("Tahoma",Font.BOLD,20));
         add(text);
         
         
         JLabel lblusername=new JLabel("Username");
         lblusername.setBounds(30,50,150,25);
         add(lblusername);
         labelusername=new JLabel();
         labelusername.setBounds(220,50,150,25);
         add(labelusername);
         
         
         JLabel lblid=new JLabel("Id");
         lblid.setBounds(30,90,150,25);
         add(lblid);
         
          comboid= new JComboBox(new String[] {"Passport","Customer ID","Company ID"});
          comboid.setBounds(220,90,150,25);
          comboid.setBackground(Color.WHITE);
          add(comboid);
          
          
         JLabel lblnumber=new JLabel("Number");
         lblnumber.setBounds(30,130,150,25);
         add(lblnumber);
         
         tfnumber=new JTextField();
         tfnumber.setBounds(220,130,150,25);
         add(tfnumber);
         
         
          
         JLabel lblname=new JLabel("Name");
         lblname.setBounds(30,170,150,25);
         add(lblname);
         
         labelname=new JLabel();
         labelname.setBounds(220,170,150,25);
         add(labelname);
         
         JLabel lblgender=new JLabel("Gender");
         lblgender.setBounds(30,210,150,25);
         add(lblgender);
         
         rmale=new JRadioButton("Male");
         rmale.setBounds(220,210,70,25);
         rmale.setBackground(new Color(246, 255, 220));
         add(rmale);
         
         
         rfemale=new JRadioButton("Female");
         rfemale.setBounds(300,210,70,25);
         rfemale.setBackground(new Color(246, 255, 220));
         add(rfemale);
         
         
         ButtonGroup bg=new ButtonGroup();
         bg.add(rmale);
         bg.add(rfemale);
         
         
           
         JLabel lblcountry=new JLabel("Country");
         lblcountry.setBounds(30,250,150,25);
         add(lblcountry);
         
          
         tfcountry=new JTextField();
         tfcountry.setBounds(220,250,150,25);
         add(tfcountry);
         
         
          
         JLabel lbladdress=new JLabel("Address");
         lbladdress.setBounds(30,290,150,25);
         add(lbladdress);
         
         tfaddress=new JTextField();
         tfaddress.setBounds(220,290,150,25);
         add(tfaddress);
         
        
         
          
         JLabel lblphonenumber=new JLabel("Phone Number");
         lblphonenumber.setBounds(30,330,150,25);
         add(lblphonenumber);
         
         tfphonenumber=new JTextField();
         tfphonenumber.setBounds(220,330,150,25);
         add(tfphonenumber);
         
         JLabel lblemail=new JLabel("Email");
         lblemail.setBounds(30,370,150,25);
         add(lblemail);
         
          
         tfemail=new JTextField();
         tfemail.setBounds(220,370,150,25);
         add(tfemail);
         
         
         add=new JButton("Add");
         add.setBackground(new Color(47,160,132));
         add.setForeground(Color.BLACK);
         add.setBounds(70,430,100,25);
         add.addActionListener(this);
         add.setBorder(new LineBorder(Color.BLACK));
         add(add);
         
         back=new JButton("Back");
         back.setBackground(new Color(47,160,132));
         back.setForeground(Color.BLACK);
         back.setBounds(220,430,100,25);
         back.addActionListener(this);
         back.setBorder(new LineBorder(Color.BLACK));
         add(back);
ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add-user.png"));
Image i2 = i1.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(400, 40, 450, 400);  //(400, 40, 450, 420);
add(image);


try{
    Connectivity c=new Connectivity();
    ResultSet rs = c.s.executeQuery("SELECT * FROM account WHERE username = '" + username + "'");
    while(rs.next()){
        labelusername.setText(rs.getString("username"));
        labelname.setText(rs.getString("name"));
        
    }
}
catch(Exception e){
    e.printStackTrace();
} 
         setVisible(true);
         
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String username=labelusername.getText();
            String id=(String)comboid.getSelectedItem();
            String number=tfnumber.getText();
            String name=labelname.getText();
            String gender=null;
            if(rmale.isSelected()){
                gender="Male";
            }
            else{
               gender="Female" ;
            }
            String country=tfcountry.getText();
            String address=tfaddress.getText();
            String phonenumber=tfphonenumber.getText();
            String email=tfemail.getText();
            try{
                Connectivity c=new Connectivity();
              String query = "INSERT INTO customer VALUES ('" + username + "','" + id + "','" + number + "','" + name + "','" + gender + "','" + country + "','" + address + "','" + phonenumber + "','" + email + "')";
              c.s.executeUpdate(query);
              
              JOptionPane.showMessageDialog(null,"Customer Details Added Scuccessfully");
              setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        
        else{
            setVisible(false);
        }
    }
    
    
    public static void main(String[] args){
        new Addcustomer("");
    }
    
}
