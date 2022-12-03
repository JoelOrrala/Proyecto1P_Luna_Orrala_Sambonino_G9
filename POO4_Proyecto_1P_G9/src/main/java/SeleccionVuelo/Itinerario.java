
package SeleccionVuelo;

/**
 *
 * @author Giovanni
 */

public class Itinerario {

    private String ciudadOrigen;
    private String ciudadDestino;
    private String horaSalida;
    private String horallegada;
    private double duracion;

    /**
     * Constructor de la clase Itinerario
     *
     * @param ciudadOrigen Ciudad de donde parte el avion
     * @param ciudadDestino Ciudad de donde llegará el avion
     * @param horaSalida Hora del vuelo
     * @param duracion Duracion del vuelo
     */
    
    public Itinerario(String ciudadOrigen, String ciudadDestino, String horaSalida, double duracion) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.horaSalida = horaSalida;
        this.duracion = duracion;
    }

    /**
     * Metodo get de la variable ciudadOrigen
     * @return La ciudad de origen como String
     */
    
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    /**
     * Metodo set de variable ciudadOrigen
     * @param ciudadOrigen Argumento de tipo String para cambiar la ciudad de
     * origen
     */
    
    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    /**
     * Metodo get de la variable ciudadDestino
     * @return La ciudad de destino como tipo String 
     */
    
    public String getCiudadDestino() {
        return ciudadDestino;
    }
    
    /**
     * Metodo set de la variable ciudadDestino
     * @param ciudadDestino Argumento de tipo String para cambiar
     * la ciudad de destino
     */
    
    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    /**
     * Metodo get de la variable horaSalida
     * @return La hora de salida del vuelo
     */
    
    public String getHoraSalida() {
        return horaSalida;
    }
    
    /**
     * Metodo set de la variable horaSalida
     * @param horaSalida Argumento de tipo String para cambiar
     * la hora de salida
     */
    
    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    /**
     * Metodo get de la variable horaLlegada
     * @return La hora de llegada del vuelo
     */
    public String getHorallegada() {
        return horallegada;
    }

    /**
     * Metodo set de la variable horaLlegada
     * @param horallegada Argumento de tipo String para cambiar
     * la hora de llegada
     */
    
    public void setHorallegada(String horallegada) {
        this.horallegada = horallegada;
    }

    /**
     * Metodo get de la variable duracion
     * @return La duracion del vuelo
     */
    
    public double getDuracion() {
        return duracion;
    }

    /**
     * Metodo set de la variable duracion
     * @param duracion Argumento de tipo double para cambiar la
     * duracion del vuelo
     */
    
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

}
