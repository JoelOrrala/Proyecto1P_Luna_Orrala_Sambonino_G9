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
    private Avion avion;
    private String codigo;
    private double precio;
    private Itinerario Itinerario;
    private String fechaSalida;
    private String fechaLLegada;

    public Vuelo(Avion avion,String codigo, double precio, Itinerario codigoItinerario, String fechaSalida, String fechaLLegada) {
        this.avion = avion;
        this.codigo = codigo;
        this.precio = precio;
        this.Itinerario = codigoItinerario;
        this.fechaSalida = fechaSalida;
        this.fechaLLegada = fechaLLegada;
    }
    
    public Avion getAvion(){
        return avion;
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

    public Itinerario getItinerario() {
        return Itinerario;
    }

    public void setCodigoItinerario(Itinerario Itinerario) {
        this.Itinerario = Itinerario;
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
