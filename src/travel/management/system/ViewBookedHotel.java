package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.border.*;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JButton back;

    JLabel labelusername, labelhotel, labelpersons, labeldays, labelac, labelfood,
            labelid, labelnumber, labelphone, labelprice;

    ViewBookedHotel(String username) {

        setBounds(400, 200, 1000, 600);
        getContentPane().setBackground(new Color(246, 255, 220));
        setLayout(null);

        JLabel text = new JLabel("View Booked Hotel Details");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(60, 10, 300, 30);
        add(text);

        // Username
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 60, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 60, 150, 25);
        add(labelusername);

        // Hotel Name
        JLabel lblhotel = new JLabel("Hotel Name");
        lblhotel.setBounds(30, 100, 150, 25);
        add(lblhotel);

        labelhotel = new JLabel();
        labelhotel.setBounds(220, 100, 150, 25);
        add(labelhotel);

        // Persons
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(30, 140, 150, 25);
        add(lblpersons);

        labelpersons = new JLabel();
        labelpersons.setBounds(220, 140, 150, 25);
        add(labelpersons);

        // Days
        JLabel lbldays = new JLabel("Number of Days");
        lbldays.setBounds(30, 180, 150, 25);
        add(lbldays);

        labeldays = new JLabel();
        labeldays.setBounds(220, 180, 150, 25);
        add(labeldays);

        // AC
        JLabel lblac = new JLabel("AC / Non-AC");
        lblac.setBounds(30, 220, 150, 25);
        add(lblac);

        labelac = new JLabel();
        labelac.setBounds(220, 220, 150, 25);
        add(labelac);

        // Food
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(30, 260, 150, 25);
        add(lblfood);

        labelfood = new JLabel();
        labelfood.setBounds(220, 260, 150, 25);
        add(labelfood);

        // ID
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 300, 150, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(220, 300, 150, 25);
        add(labelid);

        // Number
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 340, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(220, 340, 150, 25);
        add(labelnumber);

        // Phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 380, 150, 25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(220, 380, 150, 25);
        add(labelphone);

        // Price
        JLabel lblprice = new JLabel("Total Price");
        lblprice.setBounds(30, 420, 150, 25);
        add(lblprice);

        labelprice = new JLabel();
        labelprice.setBounds(220, 420, 150, 25);
        add(labelprice);

        // Back Button
        back = new JButton("Back");
        back.setBackground(new Color(47,160,132));
        back.setBounds(130, 470, 100, 25);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        back.setBorder(new LineBorder(Color.BLACK));
        add(back);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/room.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(400, 0, 600, 700);
        add(image);

        // Database
        try {
            Connectivity conn = new Connectivity();

            String query = "SELECT * FROM bookhotel WHERE username='" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelhotel.setText(rs.getString("name"));
                labelpersons.setText(rs.getString("persons"));
                labeldays.setText(rs.getString("days"));
                labelac.setText(rs.getString("ac"));
                labelfood.setText(rs.getString("food"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewBookedHotel("tasbihanaeem");
    }
}