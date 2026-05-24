 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;

/**
 *
 * @author Rao
 */
//thread class will call run method
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    
    public void run(){
        try{
             for(int i=1;i<=101;i++){
                   int max=bar.getMaximum();
                   int value=bar.getValue();
                   
                   if(value<max){
                       bar.setValue(bar.getValue()+1);
                   }
                   else{
                       setVisible(false);
                       new Dashboard(username);
                   }
                   Thread.sleep(80);
             }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    Loading(String username){
        this.username=username;
        t=new Thread(this);
    setBounds(500,200,650,400);
    getContentPane().setBackground(new Color(61, 141, 122));
    setLayout(null);
    
    JLabel text=new JLabel("Explore-X Travel Agency");
    text.setBounds(130,20,600,60);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("Raleway",Font.BOLD,35));
    add(text);
    
     bar=new JProgressBar();
    bar.setBounds(150,100,300,35);
    bar.setBackground(Color.WHITE);
    bar.setForeground(new Color(168, 35, 35)); //217 104 104
    bar.setStringPainted(true);
    bar.setBorder(new LineBorder(Color.BLACK));
    add(bar);
    
    JLabel loading=new JLabel("Loading,please wait...");
    loading.setBounds(230,130,200,30);
    loading.setForeground(Color.WHITE);
    loading.setFont(new Font("Raleway",Font.BOLD,16));
    add(loading);
    
    JLabel lblusername=new JLabel("Welcome, "+username+"!");
    lblusername.setBounds(20,210,400,40);
    lblusername.setForeground(Color.WHITE);
    lblusername.setFont(new Font("Raleway",Font.BOLD,16));
    add(lblusername);
    
    t.start();
    setVisible(true);
    }
    
    public static void main(String[] args){
        new Loading("");
    }
}
