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

    /**
     * @param codigo codigo del avion
     * @param capacidad cantidad
     */
    public Avion(String codigo, int capacidad) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.listaAsiento = cargarAsientos();
    }

    /**
     * Metodo get de la variable codigo
     *
     * @return el codigo del avion como String
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Metodo set de la variable codigo
     *
     * @param codigo Argumento para cambiar la variable codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo get de la variable capacidad
     *
     * @return La capacidad del avion de tipo int
     */
    
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Metodo set de la variable capacidad
     *
     * @param capacidad Argumento para cambiar la capacidad del avion
     */
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Metodo get del ArrayList de objetos de la clase Asiento
     *
     * @return Una lista de asientos
     */
    
    public ArrayList<Asiento> getListaAsiento() {
        return listaAsiento;
    }

    /**
     * Metodo set del ArrayList
     *
     * @param listaAsiento Lista de Objectos de la clase Asiento
     */
    
    public void setListaAsiento(ArrayList<Asiento> listaAsiento) {
        this.listaAsiento = listaAsiento;
    }

    /**
     * Metodo para cargar los asientos del asientos.txt en un ArrayList
     *
     * @return ArrayList de objetos de la clase Asiento con la informacion
     * sacada del asientos.txt
     */
    
    private ArrayList<Asiento> cargarAsientos() {
        ArrayList<String> lecturaAsientos = ManejoArchivos.LeeFichero("asientos.txt");
        ArrayList<Asiento> listaAsiento = new ArrayList<>();
        lecturaAsientos.remove(0);
        for (String linea : lecturaAsientos) {
            String[] datosAsiento = linea.split(",");
            String codigoAvion = datosAsiento[0], numAsiento = datosAsiento[1];
            Disponibilidad dispo = Disponibilidad.valueOf(datosAsiento[2]);
            if (codigoAvion.equals(this.codigo)) {
                listaAsiento.add(new Asiento(codigoAvion, numAsiento, dispo));
            }
        }
        return listaAsiento;
    }
}
