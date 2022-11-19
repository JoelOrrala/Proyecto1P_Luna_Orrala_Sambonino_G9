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
    
//    public static ArrayList<String[]> generarArreglo(){
//        ArrayList<String> arreglo = new ArrayList<>();
//        return arreglo;
//    }

    public static int generarNumeroAleatorio(int a, int b) {
        Random generado = new Random();
        int numero = generado.nextInt(a, b);
        return numero;
    }
}
