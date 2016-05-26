

package Modelo;

/**
 * Clase TipoMula, informa de los tipos de multas que se pueden realizar
 * @author christiabegines
 * @version beta1.0
 */
public class TipoMulta {
    
    private enum tiposMulta  { L, G , MG };
    
    private Integer id;
    private String descripcion;
    private Double importe;    
    private tiposMulta tipo;
    private int carnetPuntos;
    /**
     * Genera un tipo de multa con todos sus atributos;
     * @param id identificador de la multa;
     * @param descripcion Breve descripcion del suceso de la multa;
     * @param importe cantidad destinada a pagar la infraccion
     * @param carnetPuntos puntos que conlleva esta infraccion
     * @param tipo tipo de multa
     */
    public TipoMulta(Integer id, String descripcion, Double importe, int carnetPuntos, tiposMulta tipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.importe = importe;
        this.carnetPuntos = carnetPuntos;
        this.tipo=tipo;
    }
    /**
     * Genera una multa con sus minimos datos;
     * @param id identificador de la multa;
     * @param descripcion Breve descripcion de la multa;
     */
    public TipoMulta(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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

    public tiposMulta getTipo() {
        return tipo;
    }

    public void setTipo(tiposMulta tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public int getCarnetPuntos() {
        return carnetPuntos;
    }

    public void setCarnetPuntos(int carnetPuntos) {
        this.carnetPuntos = carnetPuntos;
    }

    @Override
    public String toString() {
        return id +" - "+ descripcion ;
    }

   
    
    @Override
    public String toString(){
      
    return descripcion;}
    
    
    
}
