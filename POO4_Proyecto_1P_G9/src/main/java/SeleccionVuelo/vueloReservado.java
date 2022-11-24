/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SeleccionVuelo;

import static Funcion.Funcion.generarNumeroAleatorio;
import java.util.ArrayList;

/**
 *
 * @author joelorrala
 */
public class vueloReservado {
    private Vuelo vueloSeleccionado;
    private TipoVuelo tipo;
    private Tarifa tarifa;
    private String asientoAsignado;

    public vueloReservado(Vuelo vueloSeleccionado,TipoVuelo tipo, Tarifa tarifa) {
        this.vueloSeleccionado = vueloSeleccionado;
        this.tipo = tipo;
        this.tarifa = tarifa;
        this.asientoAsignado = generarAsiento();
    }

    public TipoVuelo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVuelo tipo) {
        this.tipo = tipo;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public String getAsientoAsignado() {
        return asientoAsignado;
    }

    public void setAsientoAsignado(String asientoAsignado) {
        this.asientoAsignado = asientoAsignado;
    }

    private String generarAsiento() {
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
    
//    public static void main(String[] args){
//        Avion a = new Avion("Airbus A319",61);
//        Vuelo v = new Vuelo(a,"LA1437",482.89,new Itinerario(),"1/11/2022","1/11/2022");
//        vueloReservado vr = new vueloReservado(v,TipoVuelo.IDA,Tarifa.ECONOMY);
//        System.out.println(vr.generarAsiento());
//    }
    
}
