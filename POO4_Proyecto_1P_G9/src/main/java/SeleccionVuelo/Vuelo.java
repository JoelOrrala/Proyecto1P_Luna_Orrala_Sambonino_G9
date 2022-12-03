package SeleccionVuelo;

/**
 *
 * @author Giovanni
 */
public class Vuelo {

    private Avion avion;
    private String codigo;
    private double precio;
    private Itinerario Itinerario;
    private String fechaSalida;
    private String fechaLLegada;
    private int precioMillas;

    /**
     * Constructor de la clase Vuelo
     *
     * @param avion avion asignado
     * @param codigo codigo del vuelo
     * @param precio precio del vuelo
     * @param codigoItinerario codigo itinerario relacionado al vuelo
     * @param fechaSalida Fecha de Salida del vuelo
     * @param fechaLLegada Fecha de llegada del vuelo
     * @param precioMillas Precio en metodo de pago Millas equivalente a precio
     */
    public Vuelo(Avion avion, String codigo, double precio, Itinerario codigoItinerario, String fechaSalida, String fechaLLegada, int precioMillas) {
        this.avion = avion;
        this.codigo = codigo;
        this.precio = precio;
        this.Itinerario = codigoItinerario;
        this.fechaSalida = fechaSalida;
        this.fechaLLegada = fechaLLegada;
        this.precioMillas = precioMillas;
    }

    /**
     * Metodo get de la variable avion
     *
     * @return Avion correspondiente al vuelo
     */

    public Avion getAvion() {
        return avion;
    }

    /**
     * Metodo get de la variable codigo
     *
     * @return El codigo del vuelo de tipo String
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Metodo set de la variable codigo
     *
     * @param codigo Argumento de tipo String para cambiar el codigo del vuelo
     */

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo get de la variable Precio
     *
     * @return El precio del vuelo de tipo double
     */

    public double getPrecio() {
        return precio;
    }

    /**
     * Metodo set de la variable precio
     *
     * @param precio Argumento de tipo double del precio del vuelo
     */

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metodo get de la variable Itinerario
     *
     * @return El itinerario correspondiente al vuelo
     */

    public Itinerario getItinerario() {
        return Itinerario;
    }

    /**
     * Metodo set de la variable Itinerario
     *
     * @param Itinerario Argumento de objeto de tipo Itinerario
     */

    public void setCodigoItinerario(Itinerario Itinerario) {
        this.Itinerario = Itinerario;
    }

    /**
     * Metodo get de la variable fechaSalida
     *
     * @return La fecha de salida del vuelo
     */
    public String getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Metodo get de la variable precioMillas
     *
     * @return El precio en millas equivalente a la variable precio
     */
    public int getPrecioMillas() {
        return precioMillas;
    }

    /**
     * Metodo set de la variable precioMillas
     *
     * @param precioMillas Argumento de tipo int del precio en millas en vuelo
     */
    public void setPrecioMillas(int precioMillas) {
        this.precioMillas = precioMillas;
    }

    /**
     * Metodo set de la variable fechaSalida
     *
     * @param fechaSalida Argumento de tipo String de la fecha de salida del
     * vuelo
     */
    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Metodo set de la variable fechaLlegada
     *
     * @return La fecha de llegada del vuelo
     */

    public String getFechaLLegada() {
        return fechaLLegada;
    }

    /**
     * Metodo set de la variable fechaLlegada
     *
     * @param fechaLLegada Argumento de tipo String de la fecha de llegada del
     * vuelo
     */

    public void setFechaLLegada(String fechaLLegada) {
        this.fechaLLegada = fechaLLegada;
    }

}
