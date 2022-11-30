/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcion;

import java.util.ArrayList;
import java.util.Random;
import manejoArchivos.ManejoArchivos;

/**
 * Funcion representa a todas las funciones creadas que se usan frecuentemente
 * en el sistema
 *
 * @author joelorrala
 */
public class Funcion {

    private static final char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * Devuelve un número entero aleatorio dado un limite
     *
     * @param a número donde empieza
     * @param b número donde termina (sin incluir)
     * @return
     */
    public static int generarNumeroAleatorio(int a, int b) {
        Random generado = new Random();
        int numero = generado.nextInt(a, b);
        return numero;
    }

    /**
     * Devuelve una letra aleatoria que se encuentra en el Array de la clase
     *
     * @return letra mayúscula
     */
    public static char generarLetraAleatoria() {
        int indice = (int) (Math.random() * letras.length);
        char letraAleatoria = letras[indice];
        return letraAleatoria;
    }

    /**
     * Devuelva las fechas disponibles de vuelo para la ciudad recibida
     *
     * @param puntoOP ciudad origen o llegada escogida por el usuario
     * @return
     */
    public static ArrayList<String> obtenerFechasVuelos(String puntoOP) {
        ArrayList<String> lecturaVuelos = ManejoArchivos.LeeFichero("vuelos.txt");
        lecturaVuelos.remove(0);
        ArrayList<String> lecturaItinerarios = ManejoArchivos.LeeFichero("itinerarios.txt");
        lecturaItinerarios.remove(0);

        ArrayList<String> fechas = new ArrayList<>();
        for (int i = 0; i < lecturaItinerarios.size(); i++) {
            String[] lineaIte = lecturaItinerarios.get(i).split(",");
            if (lineaIte[1].equals(puntoOP)) {
                for (int j = 0; j < lecturaVuelos.size(); j++) {
                    String[] lineaVue = lecturaVuelos.get(j).split(",");
                    if (lineaVue[4].equals(lineaIte[0])) {
                        if (fechas.contains(lineaVue[2]) == false) {
                            fechas.add(lineaVue[2]);

                        }
                    }
                }
            }
        }
        return fechas;

    }

}
