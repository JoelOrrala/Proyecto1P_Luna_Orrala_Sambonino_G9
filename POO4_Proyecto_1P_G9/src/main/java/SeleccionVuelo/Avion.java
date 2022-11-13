/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SeleccionVuelo;
import java.util.ArrayList;

/**
 *
 * @author Giovanni
 */
public class Avion {
    private String codigo;
    private int capacidad;
    private ArrayList<Integer> listaAsiento;

    public Avion(String codigo, int capacidad, ArrayList<Integer> listaAsiento) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.listaAsiento = listaAsiento;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<Integer> getListaAsiento() {
        return listaAsiento;
    }

    public void setListaAsiento(ArrayList<Integer> listaAsiento) {
        this.listaAsiento = listaAsiento;
    }
    
    

}
