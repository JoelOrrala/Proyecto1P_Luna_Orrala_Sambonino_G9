/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SeleccionVuelo;

/**
 *
 * @author joelorrala
 */
public class vueloReservado {
    private TipoVuelo tipo;
    private Tarifa tarifa;
    private String asientoAsignado;

    public vueloReservado(TipoVuelo tipo, Tarifa tarifa, String asientoAsignado) {
        this.tipo = tipo;
        this.tarifa = tarifa;
        this.asientoAsignado = asientoAsignado;
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
    
    
    
}
