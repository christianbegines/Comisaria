package Datos;

import Modelo.Multa;
import Modelo.Policia;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
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

    public int insertaPolicia(Policia p) throws SQLException {
        PreparedStatement ps;
        if (p.getEdad() == null && p.getDepartamento() == null) {
            String sql = "INSERT INTO policia (idPolicia,numplaca,nombre,foto) VALUES(?,?,?,?)";
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, p.getIdPolicia());
            ps.setString(2, p.getNumPlaca());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getFoto().toString());
        } else if (p.getEdad() == null) {
            String sql = "INSERT INTO policia (idPolicia,numplaca,nombre,foto,departamento) VALUES(?,?,?,?,?)";
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, p.getIdPolicia());
            ps.setString(2, p.getNumPlaca());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getFoto().toString());
            ps.setString(5, p.getDepartamento());
        } else if (p.getDepartamento() == null) {
            String sql = "INSERT INTO policia (idPolicia,numplaca,nombre,foto,edad) VALUES(?,?,?,?,?)";
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, p.getIdPolicia());
            ps.setString(2, p.getNumPlaca());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getFoto().toString());
            ps.setInt(5, p.getEdad());
        } else {
            String sql = "INSERT INTO policia (idPolicia,numplaca,nombre,foto,edad,departamento) VALUES(?,?,?,?,?,?)";
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, p.getIdPolicia());
            ps.setString(2, p.getNumPlaca());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getFoto().toString());
            ps.setInt(5, p.getEdad());
            ps.setString(6, p.getDepartamento());
        }

        return ps.executeUpdate();
    }

    public int getMaxIdPolicia() throws SQLException {
        String sql = "SELECT max(idPolicia) AS 'idPolicia' FROM policia";
        PreparedStatement ps = this.con.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        res.next();
        return res.getInt("idPolicia");
    }

    public int cuentaPolicias() throws SQLException {
        String sql = "SELECT count(*) AS 'cuenta' FROM policia";
        PreparedStatement ps = this.con.prepareStatement(sql);
        ResultSet res = ps.executeQuery();
        res.next();
        return res.getInt("cuenta");
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
                Path rutaIcono = null;
                p.setFoto(rutaIcono);
            }
            listaPolis.add(p);
        }
        return listaPolis;
    }

    public List<Multa> obtenerMultasPolicia(Policia p, String orden) throws SQLException {
        List<Multa> listaMultasPolicia = new ArrayList();
        PreparedStatement ps = this.con.prepareStatement("SELECT * FROM multas where idPolicia = ? ORDER BY " + orden);
        ps.setInt(1, p.getIdPolicia());
        ResultSet res = ps.executeQuery();
        while (res.next()) {
            Integer id = res.getInt("id");
            String descripcion = res.getString("descripcion");
            Integer idPolicia = res.getInt("idPolicia");
            Multa m = new Multa(id, descripcion, idPolicia);
            if (res.getDate("fecha") != null) {
                LocalDateTime fecha = res.getTimestamp("fecha").toLocalDateTime();
                m.setFecha(fecha);
            }
            if (res.getDouble("importe") != 0) {
                m.setImporte(res.getDouble("importe"));
            }
            if (res.getString("nifinfractor") != null) {
                m.setNifInfractor(res.getString("nifinfractor"));
            }
            if (res.getInt("idtipo") != 0) {
                m.setIdTipo(res.getInt("idtipo"));
            }
            listaMultasPolicia.add(m);
        }

        return listaMultasPolicia;
    }

    public List<Multa> obtenerMultasPolicia(String numPlaca, String nombre, String orden) throws SQLException {
        List<Multa> listaMultasPolicia = new ArrayList();
        String sql;
        PreparedStatement ps;
        if (numPlaca != null) {
            sql = "SELECT * FROM multas WHERE idPolicia IN(SELECT idPolicia FROM policia WHERE numPlaca=?) ORDER BY " + orden + "DESC";
            ps = this.con.prepareStatement(sql);
            ps.setString(1,numPlaca);
        } else {
            sql = "SELECT * FROM multas WHERE idPolicia IN(SELECT idPolicia FROM policia WHERE nombre like '%?%') ORDER BY " + orden + "DESC";
            ps = this.con.prepareStatement(sql);
            ps.setString(1,nombre);
        }      
        ResultSet res = ps.executeQuery();
        while (res.next()) {
            Integer id = res.getInt("id");
            String descripcion = res.getString("descripcion");
            Integer idPolicia = res.getInt("idPolicia");
            Multa m = new Multa(id, descripcion, idPolicia);
            if (res.getDate("fecha") != null) {
                LocalDateTime fecha = res.getTimestamp("fecha").toLocalDateTime();
                m.setFecha(fecha);
            }
            if (res.getDouble("importe") != 0) {
                m.setImporte(res.getDouble("importe"));
            }
            if (res.getString("nifinfractor") != null) {
                m.setNifInfractor(res.getString("nifinfractor"));
            }
            if (res.getInt("idtipo") != 0) {
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

    public List<Multa> obtenerMultas(String orden) throws SQLException {
        List<Multa> listaMultasPolicia = new ArrayList();
        PreparedStatement ps = this.con.prepareStatement("SELECT * FROM multas ORDER BY " + orden + " DESC ");

        ResultSet res = ps.executeQuery();
        while (res.next()) {
            Integer id = res.getInt("id");
            String descripcion = res.getString("descripcion");
            Integer idPolicia = res.getInt("idPolicia");
            Multa m = new Multa(id, descripcion, idPolicia);
            if (res.getDate("fecha") != null) {
                LocalDateTime fecha = res.getTimestamp("fecha").toLocalDateTime();
                m.setFecha(fecha);
            }
            if (res.getDouble("importe") != 0) {
                m.setImporte(res.getDouble("importe"));
            }
            if (res.getString("nifinfractor") != null) {
                m.setNifInfractor(res.getString("nifinfractor"));
            }
            if (res.getInt("idtipo") != 0) {
                m.setIdTipo(res.getInt("idtipo"));
            }
            listaMultasPolicia.add(m);
        }

        return listaMultasPolicia;

    }
}
