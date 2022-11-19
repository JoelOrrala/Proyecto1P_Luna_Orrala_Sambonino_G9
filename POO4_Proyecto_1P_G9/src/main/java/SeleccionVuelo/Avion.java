/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SeleccionVuelo;
import java.util.ArrayList;
import manejoArchivos.ManejoArchivos;

/**
 *
 * @author Giovanni
 */
public class Avion {
    private String codigo;
    private int capacidad;
    private ArrayList<Asiento> listaAsiento;

    public Avion(String codigo, int capacidad) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.listaAsiento = cargarAsientos();
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

    public ArrayList<Asiento> getListaAsiento() {
        return listaAsiento;
    }

    public void setListaAsiento(ArrayList<Asiento> listaAsiento) {
        this.listaAsiento = listaAsiento;
    }
    
    public ArrayList<Asiento> cargarAsientos(){
        ArrayList<String> lecturaAsientos = ManejoArchivos.LeeFichero("asientos.txt");
        ArrayList<Asiento> listaAsiento = new ArrayList<>();
        lecturaAsientos.remove(0);
        for (String linea: lecturaAsientos){
            String[] datosAsiento = linea.split(",");
            String codigoAvion = datosAsiento[0],numAsiento = datosAsiento[1];
            Disponibilidad dispo = Disponibilidad.valueOf(datosAsiento[2]);
            if (codigoAvion.equals(this.codigo)){
                listaAsiento.add(new Asiento(codigoAvion,numAsiento,dispo));
            }
        }
  
        return listaAsiento; 
    }
   
}
