
package Reservas;

import static Funcion.Funcion.generarNumeroAleatorio;
import manejoArchivos.ManejoArchivos;
import java.util.Date;

/**
 * Pago representa el registro del pago de los tickets que contiene la reserva
 * del usuario
 *
 * @author joelorrala
 */
public class Pago {

    private Date fechaPago;
    private String idPago;
    private MetodoPago metodoPago;
    private double totalPagarFinal;
    private Reserva reserva;

    /**
     * Crea un Pago recibiendo como parámetros la fecha de pago, el método, el
     * total y la reserva
     *
     * @param fechaPago fecha en que se realizó el pago de la reserva
     * @param metodoPago método con el cual fue pagada la reserva
     * @param totalPagarFinal valor final que se pagó por la reserva
     * @param reserva reserva que el usuario pagó
     */
    public Pago(Date fechaPago, MetodoPago metodoPago, double totalPagarFinal, Reserva reserva) {
        this.idPago = generarCodigoPago();
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.totalPagarFinal = totalPagarFinal;
        this.reserva = reserva;
    }

    /**
     * Devuelve la fecha en que se realizó el pago
     *
     * @return fecha de pago
     */
    public Date getFechaPago() {
        return fechaPago;
    }

    /**
     * Cambia la fecha de pago
     *
     * @param fechaPago fecha de pago
     */
    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * Retorna el código único del pago
     *
     * @return ID del pago
     */
    public String getIdPago() {
        return idPago;
    }

    /**
     * Retorna el método de pago
     *
     * @return método de pago
     */
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    /**
     * Retorna el total que se pagó
     *
     * @return valor final se pagó
     */
    public double getTotalPagarFinal() {
        return totalPagarFinal;
    }

    /**
     * Retorna la reserva que se pagó
     *
     * @return reserva pagada
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * Retorna un código aleatorio de 4 dígitos que solo contiene números
     *
     * @return código para el pago
     */
    private String generarCodigoPago() {
        String codigo = "";
        for (int i = 1; i <= 4; i++) {
            int numero = generarNumeroAleatorio(0, 10);
            codigo += numero;
        }
        return codigo;
    }

    /**
     * Almacena en el archivo pagos.txt el pago al que se hace referencia
     */
    public void almacenarPago() {
        ManejoArchivos.EscribirArchivo("pagos.txt", idPago + "," + reserva.getCodigo() + "," + totalPagarFinal + "," + metodoPago);
    }
}
