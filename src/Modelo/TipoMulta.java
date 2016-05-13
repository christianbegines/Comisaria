/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author daw1
 */
public class TipoMulta {
    
    private int id;
    private String descripcion;
    private double importe;
    private enum tipos{L,G,MG};
    private int carnetPuntos;

    public TipoMulta(int id, String descripcion, double importe, int carnetPuntos) {
        this.id = id;
        this.descripcion = descripcion;
        this.importe = importe;
        this.carnetPuntos = carnetPuntos;
    }

    public TipoMulta(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getCarnetPuntos() {
        return carnetPuntos;
    }

    public void setCarnetPuntos(int carnetPuntos) {
        this.carnetPuntos = carnetPuntos;
    }
    
    
    
    
    
}
