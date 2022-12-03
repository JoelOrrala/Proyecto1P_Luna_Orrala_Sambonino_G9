
package SeleccionVuelo;

/**
 *
 * @author Giovanni
 */
public class Asiento {
    private String numAsiento;
    private Disponibilidad disponibilidad;
    private String codigoAvion;
/**
 * 
 * @param codigoAvion dato del asiento
 * @param numAsiento dato del asiento
 * @param disponibilidad dato del asiento
 */

    public Asiento(String codigoAvion,String numAsiento, Disponibilidad disponibilidad) {
        this.codigoAvion = codigoAvion;
        this.numAsiento = numAsiento;
        this.disponibilidad = disponibilidad;
    }
    /**
     * Metodo get de la variable numAsiento
     * @return Devuelve el numero del asiento como String
     */
    public String getNumAsiento() {
        return numAsiento;
    }
/**
 * Metodo set de la variable numAsiento que sirve para cambiar
 * el numero de asiento
 * @param numAsiento Recibe un String como numero de Asiento
 */
    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }
/**
 * Metodo get de la variable disponibilidad que devuelve
 * la Disponibilidad del asiento que podria estar libre o ocupados
 * @return Devuelve la disponibilidad del asiento
 */
    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }
/**
 * Metodo set de la variable disponibilidad que sirve para cambiar
 * la disponibilidad del asiento
 * @param disponibilidad Recibe un argumento de tipo Disponibilidad
 */
    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
 /**
  * Metodo get de la variable codigoAvion
  * @return Devuelve el codigo del avion como String
  */
    public String getCodigoAvion() {
        return codigoAvion;
    }
/**
 * Metodo toString de la clase asiento sobreescrita de la clase Object
 * @return Un String con la informacion del asiento
 */
    @Override
    public String toString() {
        return "Asiento:" + "código avión = " + codigoAvion + ", número asiento = " + numAsiento + ", disponibilidad = " + disponibilidad + '}';
    }

    
}
