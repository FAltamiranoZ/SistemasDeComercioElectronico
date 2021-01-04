/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escdebaile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Polupero
 */
public class TstConectionDerby {

    public static void main(String[] args) {

        String connectionURL = "jdbc:derby://localhost:1527/ejemplo";
        try {
            Connection conn = DriverManager.getConnection(connectionURL, "app", "app");
            System.out.println("Connection succesful");
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Connection failed");
        }
    }
}
