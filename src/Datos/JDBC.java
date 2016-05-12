/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author daw1
 */
public class JDBC {

    private Connection con;
    private String bD = "comisari";
    private String usr = "root";
    private String pass = "root";
    private String url = "jdbc:mysql://localhost:3306/" + bD;

    public Connection nuevaConexion() {
        try {
            this.con = DriverManager.getConnection(url, usr, pass);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Christian cabrooon importa el SQL al workbench", "Error conectando a la base de datos", JOptionPane.ERROR_MESSAGE);
        }
        return this.con;
    }
}
