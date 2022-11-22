/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcion;

import java.util.ArrayList;
import java.util.Random;
import manejoArchivos.ManejoArchivos;

/**
 *
 * @author joelorrala
 */
public class Funcion {
    private static final char[] letras = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
        'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    
//    public static ArrayList<String[]> generarArreglo(){
//        ArrayList<String> arreglo = new ArrayList<>();
//        return arreglo;
//    }

    public static int generarNumeroAleatorio(int a, int b) {
        Random generado = new Random();
        int numero = generado.nextInt(a, b);
        return numero;
    }
    
    public static char generarLetraAleatoria() {
        int indice = (int) (Math.random() * letras.length);
        char letraAleatoria = letras[indice];
        return letraAleatoria;
    }
  
    public static ArrayList<String> obtenerFechas(String puntoOP) {
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
                    if (lineaVue[4].equals(lineaIte[0])){
                        if (fechas.contains(lineaVue[2])==false){
                            fechas.add(lineaVue[2]);
                        
                        }
                    }
                }
            }
        }
        return fechas;

    }
    
//    public static void main(String[] args){
//        Funcion f = new Funcion();
//        f.obtenerFechas("GUAYAQUIL");
//    
//    }
    
}
