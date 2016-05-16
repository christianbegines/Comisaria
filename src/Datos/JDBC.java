/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Policia;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Policia> obtenerPolicias() throws SQLException {
        Image i;
        List<Policia> listaPolis = new ArrayList<>();
        PreparedStatement ps = this.con.prepareStatement("SELECT * FROM policia");
        ResultSet res = ps.executeQuery();
        while (res.next()) {
            String nombre = res.getString("nombre");
            Integer idPolicia = Integer.parseInt(res.getString("idPolicia"));
            String numPlaca = res.getString("numPlaca");
            Policia p = new Policia(idPolicia, nombre, numPlaca);
            if (res.getString("edad") != null) {
                p.setEdad(Integer.parseInt(res.getString("edad")));
            }
            if (res.getString("departamento") != null) {
                p.setDepartamento(res.getString("departamento"));
            }
            if (res.getString("foto") != null) {
                i = Toolkit.getDefaultToolkit().getImage(getClass().getResource(res.getString("foto")));
                p.setFoto(i);
            }
            listaPolis.add(p);
        }
        return listaPolis;
    }
}
