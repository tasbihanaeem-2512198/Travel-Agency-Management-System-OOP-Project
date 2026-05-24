/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;

/**
 *
 * @author Rao
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
public class BookHotel extends JFrame implements ActionListener {
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdays;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookpackage,back;
    BookHotel(String username){
        this.username=username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(new Color(246,255,220));
        
        JLabel text=new JLabel("Book Hotel");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        add(text);
        
        JLabel lblusername=new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,17));
        lblusername.setBounds(40,70,100,20);
        add(lblusername);

        labelusername=new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN,16));
        labelusername.setBounds(250,70,200,20);
        add(labelusername);

        JLabel lblpackage=new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblpackage.setBounds(40,110,150,20);
        add(lblpackage);

        chotel=new Choice();
        chotel.setBounds(250,110,200,20);
        add(chotel);
        try{
             Connectivity c=new Connectivity();
             ResultSet rs=c.s.executeQuery("select * from hotel ");
             while(rs.next()){
                 chotel.add(rs.getString("name"));
             }
             
        }catch(Exception e){
            e.printStackTrace();
        }
        

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblpersons);
        
        tfpersons =new JTextField("1");
        tfpersons.setBounds(250,150,200,25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No of Days");
        lbldays.setBounds(40,190,150,25);
        lbldays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldays);
        
        tfdays =new JTextField("1");
        tfdays.setBounds(250,190,200,25);
        add(tfdays);
        
         JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(40,230,150,25);
        lblac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblac);
        
        cac=new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,20);
        add(cac);
        
         
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40,270,150,25);
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblfood);
        
        cfood=new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,20);
        add(cfood);
        
       
        
        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblid.setBounds(40,310,150,20);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,310,200,25);
        add(labelid);
        
        
        JLabel lblnumber=new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblnumber.setBounds(40,350,150,25);
        add(lblnumber);
        
        labelnumber=new JLabel();
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);
        
        JLabel lblphone=new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblphone.setBounds(40,390,150,20);
        add(lblphone);
        
       labelphone=new JLabel();
        labelphone.setBounds(250,390,200,25);
        add(labelphone);
        
         JLabel lbltotal=new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltotal.setBounds(40,430,150,20);
        add(lbltotal);
        
        labelprice=new JLabel();
        labelprice.setBounds(250,430,200,25);
        add(labelprice);
        
        
        try{
            Connectivity conn=new Connectivity();

            String query="select * from customer where username='"+username+"'";
            System.out.println(query); // DEBUG

            ResultSet rs=conn.s.executeQuery(query);

           

            while(rs.next()){
               

                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
               
            }

        } catch(Exception e){
            e.printStackTrace(); // VERY IMPORTANT
        }
        
        checkprice=new JButton("Check Price");
        checkprice.setBackground(new Color(47,160,132));
        checkprice.setForeground(Color.BLACK);
        checkprice.setBounds(60,490,120,25);
        checkprice.addActionListener(this);
        checkprice.setBorder(new LineBorder(Color.BLACK));
        add(checkprice);
        
        bookpackage=new JButton("Book Hotel");
        bookpackage.setBackground(new Color(47,160,132));
        bookpackage.setForeground(Color.BLACK);
        bookpackage.setBounds(200,490,120,25);
        bookpackage.addActionListener(this);
        bookpackage.setBorder(new LineBorder(Color.BLACK));
        add(bookpackage);
        
        
        
        back=new JButton("Back");
        back.setBackground(new Color(47,160,132));
        back.setForeground(Color.BLACK);
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        back.setBorder(new LineBorder(Color.BLACK));
        add(back);
        
             
ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/hotel.jpg"));
Image i2 = i1.getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT);
ImageIcon i3 = new ImageIcon(i2);
JLabel image = new JLabel(i3);
image.setBounds(500, 0, 600,700); // 50 600 300
add(image);
     
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==checkprice){
        try{
        Connectivity c=new Connectivity();
        ResultSet rs=c.s.executeQuery("select *from hotel where  name='"+chotel.getSelectedItem()+"'");
        while(rs.next()){
            int cost=Integer.parseInt(rs.getString("costperperson"));
            int food=Integer.parseInt(rs.getString("foodincluded"));
            int ac=Integer.parseInt(rs.getString("acroom"));
            
            int persons=Integer.parseInt(tfpersons.getText());
            int days=Integer.parseInt(tfdays.getText());
            
            
            String acselected=cac.getSelectedItem();
            String foodselected=cfood.getSelectedItem();
            
            if(persons*days>0){
                int total=0;
                total+=acselected.equals("AC")?ac:0;
                total+=foodselected.equals("Yes")?food:0;
                total+=cost;
                total=total*persons*days;
                labelprice.setText("Rs "+total);
            }
            else{
                JOptionPane.showMessageDialog(null,"Please enter a valid number");
            }
            
        }
        }
    
    catch(Exception e){
            e.printStackTrace();
            }
    }
    else if(ae.getSource()==bookpackage){
        try{
     Connectivity c=new Connectivity();
    c.s.executeUpdate("INSERT INTO bookhotel VALUES ('"
        + labelusername.getText() + "','"
        + chotel.getSelectedItem() + "','"
        + tfpersons.getText() + "','"
        + tfdays.getText() + "','"
        + cac.getSelectedItem() + "','"
        + cfood.getSelectedItem() + "','"
        + labelid.getText() + "','"
        + labelnumber.getText() + "','"
        + labelphone.getText() + "','"
        + labelprice.getText() + "')");
     
     JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
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
        new BookHotel("tasbihanaeem");
    }
}

