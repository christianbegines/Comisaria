

package Modelo;

/**
 * Clase TipoMula, informa de los tipos de multas que se pueden realizar
 * @author christiabegines
 * @version beta1.0
 */
public class TipoMulta {
    
    private int id;
    private String descripcion;
    private double importe;
    private enum tipos{L,G,MG};
    private int carnetPuntos;
    /**
     * Genera un tipo de multa con todos sus atributos;
     * @param id identificador de la multa;
     * @param descripcion Breve descripcion del suceso de la multa;
     * @param importe cantidad destinada a pagar la infraccion
     * @param carnetPuntos puntos que conlleva esta infraccion
     */
    public TipoMulta(int id, String descripcion, double importe, int carnetPuntos) {
        this.id = id;
        this.descripcion = descripcion;
        this.importe = importe;
        this.carnetPuntos = carnetPuntos;
    }
    /**
     * Genera una multa con sus minimos datos;
     * @param id identificador de la multa;
     * @param descripcion Breve descripcion de la multa;
     */
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
    
    @Override
    public String toString(){
      
    return descripcion;}
    
    
    
}
