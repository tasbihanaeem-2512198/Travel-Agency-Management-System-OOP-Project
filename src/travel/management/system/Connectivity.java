/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travel.management.system;



/**
 *
 * @author Rao
 */
import java.sql.*;

public class Connectivity {
    Connection c;
    Statement s;

    Connectivity() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/travelmanagementsystem",
                "root",
                "Computerscience11"
            );
            s=c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
