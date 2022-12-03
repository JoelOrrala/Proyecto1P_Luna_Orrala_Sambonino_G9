/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservas;

import static Funcion.Funcion.generarLetraAleatoria;
import SeleccionVuelo.vueloReservado;
import java.util.ArrayList;
import Usuario.Cliente;
import manejoArchivos.ManejoArchivos;
import java.util.Date;

/**
 * Reserva representa todos los datos de vuelos que el usuario reservó
 *
 * @author joelorrala
 */
public class Reserva {

    private String codigo;
    private ArrayList<vueloReservado> listaVuelos;
    private Date fechaReserva;
    private Cliente cliente;
    private double valorPagar;

    /**
     * Crea una reserva recibiendo como parámetros la lista de vuelos
     * reservados, la fecha en que se realizó la reserva, el cliente y valor a
     * pagar
     *
     * @param listaVuelos
     * @param fechaReserva
     * @param cliente
     * @param valorPagar
     */
    public Reserva(ArrayList<vueloReservado> listaVuelos, Date fechaReserva, Cliente cliente, double valorPagar) {
        this.codigo = generarCodigoReserva();
        this.listaVuelos = listaVuelos;
        this.fechaReserva = fechaReserva;
        this.cliente = cliente;
        this.valorPagar = valorPagar;
    }

    /**
     * Devuelve el código de la reserva
     *
     * @return código reserva
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Devuelve la lista de vuelos reservados
     *
     * @return vuelos reservados
     */
    public ArrayList<vueloReservado> getListaVuelos() {
        return listaVuelos;
    }

    /**
     * Cambia la lista de vuelos reservados
     *
     * @param listaVuelos lista de vuelos reservados
     */
    public void setListaVuelos(ArrayList<vueloReservado> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    /**
     * Devuelve la fecha de la reserva
     *
     * @return fecha reserva
     */
    public Date getFechaReserva() {
        return fechaReserva;
    }

    /**
     * Cambia la fecha de la reserva
     *
     * @param fechaReserva fecha de la reserva
     */
    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    /**
     * Devuelve el cliente al cual le pertenece la reserva
     *
     * @return cliente dueño de la reserva
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Cambia el cliente que hizo la reserva
     *
     * @param cliente cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Retorna el valor a pagar de la reserva
     *
     * @return valor a pagar
     */
    public double getValorPagar() {
        return valorPagar;
    }

    /**
     * Retorna el código generado para la reserva
     *
     * @return código reserva
     */
    public String getGenerarCodigoReserva() {
        return generarCodigoReserva();
    }

    /**
     * Devuelve un código aleatorio para la reserva, el cual posee únicamente
     * letras
     *
     * @return código para la reserva
     */
    private String generarCodigoReserva() {
        String codigo = "";
        for (int i = 1; i <= 5; i++) {
            codigo += generarLetraAleatoria();
        }
        return codigo;
    }

    /**
     * Almacena en el archivo reservas.txt la reserva a la que se hace
     * referencia
     */
    public void almacenarReserva() {
        for (vueloReservado v : listaVuelos) {
            ManejoArchivos.EscribirArchivo("reservas.txt", codigo + "," + v.getVueloSeleccionado().getCodigo() + "," + cliente.getNombre() + " " + cliente.getApellido() + "," + fechaReserva + "," + valorPagar);
        }
    }

}
