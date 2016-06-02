package Datos;

import Modelo.Multa;
import Modelo.Policia;
import Modelo.TipoMulta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
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
        PreparedStatement ps = null;
        if (p.getIdPolicia() != null && p.getNumPlaca() != null && p.getNombre() != null) {
            String sql = "INSERT INTO policia (idPolicia,numplaca,nombre,foto,edad,departamento) VALUES(?,?,?,?,?,?)";
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, p.getIdPolicia());
            ps.setString(2, p.getNumPlaca());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getFoto().toString());
            ps.setInt(5, p.getEdad());
            ps.setString(6, p.getDepartamento());
        } else {
            throw new ErrorDatos();
        }

        return ps.executeUpdate();
    }

    public int insertarMultas(Multa m) throws SQLException {
        PreparedStatement ps = null;
        String sql = "insert into multas (descripcion,fecha,importe,idpolicia,nifinfractor,idtipo) values(?,?,?,?,?,?)";
        if (m.getIdPolicia() != null || m.getDescripcion() != null) {
            ps = this.con.prepareStatement(sql);
            ps.setString(1, m.getDescripcion());
            ps.setTimestamp(2, Timestamp.valueOf(m.getFecha()));
            ps.setDouble(3, m.getImporte());
            ps.setInt(4, m.getIdPolicia());
            ps.setString(5, m.getNifInfractor());
            ps.setInt(6, m.getIdTipo());
        } else {
            throw new ErrorDatos();
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
        if (!numPlaca.isEmpty()) {
            sql = "SELECT * FROM multas WHERE idPolicia IN ( SELECT idPolicia FROM policia WHERE numPlaca = ? ) ORDER BY " + orden + " DESC";
            ps = this.con.prepareStatement(sql);
            ps.setString(1, numPlaca);
        } else {
            sql = "SELECT * FROM multas WHERE idPolicia IN ( SELECT idPolicia FROM policia WHERE nombre like concat('%',?,'%') ) ORDER BY " + orden + " DESC";
            ps = this.con.prepareStatement(sql);
            ps.setString(1, nombre);
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

    public int actualizarPolicia(Policia p) throws SQLException, IOException {
        File rutaAbsoluta = new File(".");
        String sql = "UPDATE policia SET numplaca = ?,nombre = ?, edad = ?, departamento = ?, foto = ? WHERE idpolicia = ?";
        PreparedStatement ps = this.con.prepareStatement(sql);
        ps.setString(1, p.getNumPlaca());
        ps.setString(2, p.getNombre());
        ps.setInt(3, p.getEdad());
        ps.setString(4, p.getDepartamento());
        if (p.getFoto()!=null) {
             ps.setString(5, p.getFoto().toString());
        }else{
            Path rutaIcono = Paths.get(rutaAbsoluta.getCanonicalPath() + "/src/Imagenes/iconoanonimo.jpg");
            ps.setString(5, rutaIcono.toString());
        }
       
        ps.setInt(6, p.getIdPolicia());
        return ps.executeUpdate();

    }

    public List<TipoMulta> obtenerTiposMulta() throws SQLException {
        List<TipoMulta> listaTipos = new ArrayList<>();
        PreparedStatement ps = this.con.prepareStatement("select * from multastipo");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String descripcion = rs.getString("descripcion");
            Double importe = rs.getDouble("importe");
            TipoMulta tipoMulta = new TipoMulta(id, descripcion);
            if (importe != 0) {
                tipoMulta.setImporte(importe);
            }
            listaTipos.add(tipoMulta);

        }
        return listaTipos;
    }

    public int insertarPoliciasPorLista(Policia p) throws  SQLException {
        int resultado = 0;
        String sql = "insert into policia (idPolicia,nombre,numplaca,edad,departamento,foto) values(?,?,?,?,?,?)";
        PreparedStatement ps;       
            ps = this.con.prepareStatement(sql);
            ps.setInt(1,p.getIdPolicia());
            ps.setString(2,p.getNombre());
            ps.setString(3,p.getNumPlaca());
            ps.setInt(4,p.getEdad());
            ps.setString(5, p.getDepartamento());
            ps.setString(6,p.getFoto().toString());
            System.out.println(p.getNumPlaca());
            resultado = ps.executeUpdate();
            
        return resultado;
    }
}
