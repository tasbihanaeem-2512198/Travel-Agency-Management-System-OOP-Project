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
import java.awt.event.*;
import javax.swing.border.*;
public class About extends JFrame implements ActionListener{
      About(){
          setBounds(600,200,500,550);
          setLayout(null);
          getContentPane().setBackground(new Color(61, 141, 122));
          
          JLabel l1=new JLabel("ABOUT US");
          l1.setBounds(180,10,150,90);
          l1.setForeground(Color.WHITE);
          l1.setFont(new Font("Tahoma",Font.BOLD,25));
          add(l1);
          
          String s="ExploreX Worldwide Travel Agency is a trusted and modern travel service provider dedicated to making travel easy, enjoyable, and accessible for everyone. We specialize in offering personalized travel solutions that match the needs, preferences, and budgets of our valued clients. Whether you are planning a short domestic trip or a long international journey, ExploreX is here to guide you every step of the way.\n" +
"\nAt ExploreX, we believe that travel is not just about reaching a destination—it is about experiencing new cultures, exploring breathtaking places, and creating lifelong memories. Our mission is to connect people with the world by providing smooth, reliable, and affordable travel services that remove the stress from planning your journey.\n" +
"\nWe offer a complete range of travel services including flight reservations, hotel bookings, holiday and tour packages, visa assistance, travel insurance guidance, and customized itineraries. Our expert team carefully plans each trip to ensure comfort, convenience, and value for money, so our customers can enjoy a hassle-free travel experience.\n" +
"\nOur agency works with a strong global network of airlines, hotels, and travel partners, allowing us to provide competitive prices and high-quality services. We continuously update our travel solutions to meet international standards and ensure that our clients receive the best possible experience wherever they travel.\n" +
"\nCustomer satisfaction is at the heart of everything we do. We take pride in offering 24/7 support, professional guidance, and quick response to all travel-related queries. Our goal is to build long-term trust with our clients by delivering services that exceed expectations.\n" +
"\nExploreX Worldwide Travel Agency is not just a travel company—it is your travel companion. From dream vacations to business trips and adventure tours, we make every journey smooth, safe, and memorable. With us, the world becomes easier to explore and more exciting to experience.\n" +
"\nExplore the world with confidence. Travel smart. Travel with ExploreX.";
          
          TextArea area=new TextArea(s,10,40,Scrollbar.VERTICAL);
          area.setEditable(false);
          area.setBounds(20,100,450,300);
          add(area);
          
          JButton back=new JButton("Back");
          back.setBounds(200,420,100,25);
          back.setBackground(new Color(47,160,132));
          back.addActionListener(this);
          back.setForeground(Color.BLACK);
          back.setBorder(new LineBorder(Color.BLACK)); 
          add(back);
          
          
          setVisible(true);
          
          
          
      }
      
      public void actionPerformed(ActionEvent ae){
          setVisible(false);
      }
       
      public static void main(String[] args){
           new About();
      }
}
