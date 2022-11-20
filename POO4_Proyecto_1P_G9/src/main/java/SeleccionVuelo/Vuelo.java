/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SeleccionVuelo;

/**
 *
 * @author Giovanni
 */
public class Vuelo {
    private String codigo;
    private double precio;
    private Itinerario codigoItinerario;
    private String fechaSalida;
    private String fechaLLegada;

    public Vuelo(String codigo, double precio, Itinerario codigoItinerario, String fechaSalida, String fechaLLegada) {
        this.codigo = codigo;
        this.precio = precio;
        this.codigoItinerario = codigoItinerario;
        this.fechaSalida = fechaSalida;
        this.fechaLLegada = fechaLLegada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Itinerario getCodigoItinerario() {
        return codigoItinerario;
    }

    public void setCodigoItinerario(Itinerario codigoItinerario) {
        this.codigoItinerario = codigoItinerario;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLLegada() {
        return fechaLLegada;
    }

    public void setFechaLLegada(String fechaLLegada) {
        this.fechaLLegada = fechaLLegada;
    }
    
    
    
}
