/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Policia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author daw1
 */
public class JDBC {

    private Connection con;
    private String bD = "comisaria";
    private String usr = "root";
    private String pass = "root";
    private String url = "jdbc:mysql://localhost:3306/" + bD;

    public Connection nuevaConexion() throws SQLException {
        
            this.con = DriverManager.getConnection(url, usr, pass);
       
            
        
        return this.con;
    }
}
