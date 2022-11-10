/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejoArchivos;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author joelorrala
 */
public class TrabajoConArchivos {
    
    /**
     * @param args the command line arguments
     */
     public static void main(String[] arg) {
         
//        ManejoArchivos.EscribirArchivo("archivosalida.txt","Hola!");
//        ManejoArchivos.EscribirArchivo("archivosalida.txt","Afios!");
//        ManejoArchivos.EscribirArchivo("archivosalida.txt","NUevo!");
        ManejoArchivos.LeeFichero("usuarios.txt");
        Date today = Calendar.getInstance().getTime();
         System.out.println(today);
        
        
    }
}
