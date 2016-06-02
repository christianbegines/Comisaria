/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Modelo.Policia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daw1
 */
public class ArchivosDAO {

    public List<Policia> obtenerPoliciasDeFicher(File fichero) throws FileNotFoundException, IOException {

        List<Policia> listaPolicia = new ArrayList();
        String idPolicia, nombre, numplaca, edad, departamento, foto;
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        Policia p;
        String linea = null;
        br.readLine();
        while ((linea = br.readLine()) != null) {
            String[] datos = new String[6];
            datos = linea.split(",");

            idPolicia = datos[0];
            nombre = datos[1];
            numplaca = datos[2];
            edad = datos[3];
            departamento = datos[4];
            if (!(foto = datos[5]).equalsIgnoreCase("NULL")) {
                foto = datos[5];
            } else {
                foto = "";
            }
            p = new Policia(Integer.parseInt(idPolicia), nombre, numplaca);
            if (edad != null) {
                p.setEdad(Integer.parseInt(edad));
            }
            if (departamento != null) {
                p.setDepartamento(departamento);
            }

            p.setFoto(Paths.get(foto));

            listaPolicia.add(p);
        }

        return listaPolicia;
    }
}
