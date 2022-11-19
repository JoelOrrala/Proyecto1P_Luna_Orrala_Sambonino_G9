/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SeleccionVuelo;

/**
 *
 * @author Giovanni
 */
public class Asiento {
    private String numAsiento;
    private Disponibilidad disponibilidad;
    private String codigoAvion;

    public Asiento(String codigoAvion,String numAsiento, Disponibilidad disponibilidad) {
        this.codigoAvion = codigoAvion;
        this.numAsiento = numAsiento;
        this.disponibilidad = disponibilidad;
    }

    public String getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
 
    public String getCodigoAvion() {
        return codigoAvion;
    }
    
    @Override
    public String toString() {
        return "Asiento{" + "código avión = " + codigoAvion + ", número asiento = " + numAsiento + ", disponibilidad = " + disponibilidad + '}';
    }

    
}
