/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funcion;

import java.util.ArrayList;
import java.util.Random;

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
}
