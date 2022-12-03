/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SeleccionVuelo;

import static Funcion.Funcion.generarNumeroAleatorio;
import java.util.ArrayList;
import manejoArchivos.ManejoArchivos;

/**
 *
 * @author joelorrala
 */
public class vueloReservado {

    private String codigoVR;
    private Vuelo vueloSeleccionado;
    private TipoVuelo tipo;
    private Tarifa tarifa;
    private String asientoAsignado;

    /**
     * Constructor de la clase VueloReservado
     *
     * @param vueloSeleccionado vuelo seleccionado
     * @param tipo Tipo de vuelo que pueden llegar a ser IDA o VUELTA
     * @param tarifa Tarifa del vuelo
     */
    public vueloReservado(Vuelo vueloSeleccionado, TipoVuelo tipo, Tarifa tarifa) {
        this.codigoVR = generarCodigoVR();
        this.vueloSeleccionado = vueloSeleccionado;
        this.tipo = tipo;
        this.tarifa = tarifa;
        this.asientoAsignado = asignarAsiento();
    }

    /**
     * Metodo get la variable codigoVR
     *
     * @return El codigo correspondiente al vuelo reservado
     */
    public String getCodigoVR() {
        return codigoVR;
    }

    /**
     * Metodo get de la variable vueloSeleccionado
     *
     * @return El vuelo seleccionado
     */
    public Vuelo getVueloSeleccionado() {
        return vueloSeleccionado;
    }

    /**
     * Metodo get de la variable tipoTipo
     *
     * @return Un tipo de vuelo
     */
    public TipoVuelo getTipo() {
        return tipo;
    }

    /**
     * Metodo set de la variable tipo
     *
     * @param tipo Argumento del TipoVuelo;
     */

    public void setTipo(TipoVuelo tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo get de la variable tarifa
     *
     * @return La tarifa del vuelo seleccionado
     */
    public Tarifa getTarifa() {
        return tarifa;
    }

    /**
     * Metodo set de la tarifa
     *
     * @param tarifa Argumento de tipo Tarifa
     */

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    /**
     * Metodo get de asientoAsignado
     *
     * @return Asiento asignado
     */
    public String getAsientoAsignado() {
        return asientoAsignado;
    }

    /**
     * Metodo set de la variable asientoAsignado
     *
     * @param asientoAsignado Argumento de tipo String del asientoAsignado
     */
    public void setAsientoAsignado(String asientoAsignado) {
        this.asientoAsignado = asientoAsignado;
    }

    /**
     * Metodo que te asigna un asiento
     *
     * @return Asiento
     */
    private String asignarAsiento() {
        ArrayList<Asiento> listaAsiento = vueloSeleccionado.getAvion().getListaAsiento();
        boolean disponible = false;
        String asiento = "";
        while (disponible == false) {
            int indAleatorio = generarNumeroAleatorio(0, listaAsiento.size());
            Asiento a = listaAsiento.get(indAleatorio);
            if (a.getDisponibilidad() == Disponibilidad.S) {
                asiento += a.getNumAsiento();
                a.setDisponibilidad(Disponibilidad.N);
                disponible = true;
            }
        }
        return asiento;
    }

    /**
     * Genera el codigo del vuelo Reservado
     *
     * @return Codigo del vuelo Reservado
     */
    private String generarCodigoVR() {
        String codigo = "";
        for (int i = 1; i <= 4; i++) {
            int numero = generarNumeroAleatorio(0, 10);
            codigo += numero;
        }
        return codigo;
    }

    /**
     * Almacena el codigo del vueloReservado
     */
    public void almacenarVR() {
        ManejoArchivos.EscribirArchivo("vuelosReserva.txt", codigoVR + "," + vueloSeleccionado.getCodigo() + "," + tipo + "," + tarifa + "," + asientoAsignado);
    }

}
