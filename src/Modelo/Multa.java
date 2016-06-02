/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.time.LocalDateTime;


/**
 *
 * @author daw1
 */
public class Multa {
    private Integer id;
    private String descripcion;
    private LocalDateTime fecha;
    private Double importe;
    private Integer idPolicia;
    private String nifInfractor;
    private Integer idTipo;

    public Multa(Integer id, String descripcion, Integer idPolicia) {
        this.id = id;
        this.descripcion = descripcion;
        this.idPolicia = idPolicia;
    }

    public Multa(Integer id, String descripcion, LocalDateTime fecha, Double importe, Integer idPolicia, String nifInfractor, Integer idTipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.importe = importe;
        this.idPolicia = idPolicia;
        this.nifInfractor = nifInfractor;
        this.idTipo = idTipo;
    }

    public Multa() {
       
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Integer getIdPolicia() {
        return idPolicia;
    }

    public void setIdPolicia(Integer idPolicia) {
        this.idPolicia = idPolicia;
    }

    public String getNifInfractor() {
        return nifInfractor;
    }

    public void setNifInfractor(String nifInfractor) {
        this.nifInfractor = nifInfractor;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }
       
    public String datosMulta(){
        return "Multa Nº: "+ this.id + "\r\n"+
               "Descripcion :"+this.descripcion + "\r\n"+
               "Fecha :"+ this.fecha+"\r\n"+
               "Importe :"+this.importe+"\r\n"+
               "IdPolicia :"+this.idPolicia+"\r\n"+
               "NifInfractor :"+this.nifInfractor+"\r\n"+
               "IdTipo :" + this.idTipo;
        
    }
    
}
