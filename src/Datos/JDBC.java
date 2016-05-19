package Datos;

import Modelo.Multa;
import Modelo.Policia;
import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public List<Policia> obtenerPolicias(String orden) throws SQLException {
        Image i;
        List<Policia> listaPolis = new ArrayList<>();
        PreparedStatement ps = this.con.prepareStatement("SELECT * FROM policia ORDER BY " + orden);
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
                String foto = res.getString("foto");
                p.setFoto(Paths.get(foto));
            } else {
                Path rutaIcono = Paths.get("/Imagenes/iconoanonimo.png");
                p.setFoto(rutaIcono);
            }
            listaPolis.add(p);
        }
        return listaPolis;
    }
    public void obtenerMultasPolicia(Integer idPolicia){
        
        
    }

    public int borrarPorIdPolicia(int idPolicia) throws SQLException {
        String sql = "DELETE FROM policia WHERE idPolicia = ?";
        PreparedStatement ps = this.con.prepareStatement(sql);
        ps.setInt(1, idPolicia);
        String sqlMultas = "DELETE FROM multas WHERE idPolicia = ?";
        PreparedStatement psMultas = this.con.prepareStatement(sqlMultas);
        psMultas.setInt(1, idPolicia);
        psMultas.executeUpdate();
        return ps.executeUpdate();
    }
}
