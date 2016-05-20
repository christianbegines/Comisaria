package Datos;

import Modelo.Multa;
import Modelo.Policia;
import java.awt.Image;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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

    public List<Multa> obtenerMultasPolicia(Integer idPoliciaBuscador, String orden) throws SQLException {
        List<Multa> listaMultasPolicia = new ArrayList();
        PreparedStatement ps = this.con.prepareStatement("SELECT * FROM multas where idPolicia = ? ORDER BY " + orden);
        ps.setInt(1, idPoliciaBuscador);
        ResultSet res = ps.executeQuery();
        while (res.next()) {
            Integer id = res.getInt("id");
            String descripcion = res.getString("descripcion");
            Integer idPolicia = res.getInt("idPolicia");
            
            Multa m = new Multa(id, descripcion, idPolicia);
            
            if (res.getDate("fecha") != null) {
                m.setFecha(res.getTimestamp("fecha").toLocalDateTime());
            }
            if (res.getDouble("importe") != 0) {
                m.setImporte(res.getDouble("importe"));
            }
            if (res.getString("nifinfractor") != null) {
                m.setNifInfractor(res.getString("nifinfractor"));
            }
            if(res.getInt("idtipo")!=0){
                m.setIdTipo(res.getInt("idtipo"));
            }
            listaMultasPolicia.add(m);
        }
        
        return listaMultasPolicia;
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
