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
    private char disponibilidad;

    public Asiento(String numAsiento, char disponibilidad) {
        this.numAsiento = numAsiento;
        this.disponibilidad = disponibilidad;
    }

    public String getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }

    public char getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(char disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
}
