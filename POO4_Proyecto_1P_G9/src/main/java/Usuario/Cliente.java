package Usuario;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author L.Luna
 */
import SeleccionVuelo.*;
import manejoArchivos.*;

public class Cliente extends Usuario {
    
    protected String numeroTarjeta;
    
    public Cliente(String cedula, String nombre, String apellido, int edad, String correo, String usuario, String contrasenia, Perfil perfil, String numeroTarjeta) {
        super(cedula, nombre, apellido, edad, correo, usuario, contrasenia, perfil);
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }
    
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public void comprarTicket() {
        ArrayList<String> lecturaVuelos = ManejoArchivos.LeeFichero("vuelos.txt");
        lecturaVuelos.remove(0);
        ArrayList<String> lecturaItinerarios = ManejoArchivos.LeeFichero("itinerarios.txt");
        lecturaItinerarios.remove(0);
        Scanner sc = new Scanner(System.in);
        System.out.println("---ORIGEN-----");
        for (int i = 0; i < lecturaItinerarios.size(); i++) {
            String[] inti = lecturaItinerarios.get(i).split(",");
            System.out.println((i + 1) + ". " + inti[1]);
        }
        System.out.print("Elige punto de Partida: ");
        int pp = sc.nextInt();
        sc.nextLine();
        String fo = "";
        String po = "";
        for (int i = 0; i < pp; i++) {
            String[] inti = lecturaVuelos.get(i).split(",");
            fo = inti[2];
        }
        for (int i = 0; i < pp; i++) {
            String[] inti = lecturaItinerarios.get(i).split(",");
            po = inti[1];
            
        }
        
        System.out.println("---DESTINO-----");
        for (int i = 0; i < lecturaItinerarios.size(); i++) {
            String[] inti = lecturaItinerarios.get(i).split(",");
            System.out.println((i + 1) + ". " + inti[1]);
        }
        System.out.print("Elige punto de LLegada: ");
        int pll = sc.nextInt();
        sc.nextLine();
        String fll = "";
        String pall = "";
        for (int i = 0; i < pll; i++) {
            String[] inti = lecturaVuelos.get(i).split(",");
            fll = inti[2];
        }
        for (int i = 0; i < pll; i++) {
            String[] inti = lecturaItinerarios.get(i).split(",");
            pall = inti[1];
        }
        System.out.println("FECHA DE SALIDA: " + fo);
        System.out.println("FECHA DE RETORNO: " + fll);
        
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
        System.out.printf("%35s\n", "PASO1");
        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++++");
        
        System.out.println("--------Vuelos Disponibles IDA-------------");
        int cont1 = 1;
        for (int i = 0; i < lecturaItinerarios.size(); i++) {
            String[] inti = lecturaItinerarios.get(i).split(",");
            if (po.equals(inti[1])) {                
                for (int j = 0; j < lecturaVuelos.size(); j++) {
                    String[] invu = lecturaVuelos.get(j).split(",");
                    if (inti[0].equals(invu[4])) {
                        System.out.println("---------"+cont1+"------------");
                        System.out.println("CODIGO: " + invu[0]);
                        System.out.println("HORA SALIDA : " + inti[3]);
                        System.out.println("HORA LLEGADA : " + inti[4]);
                        System.out.println("DURACION : " + inti[4]);
                        System.out.println("AVION: " + invu[1]);
                        System.out.println("PRECIO : " + invu[5]);
                        System.out.println("COSTO MILLAS : " + invu[6]);
                        cont1++;
                    }
                }
            }          
        }
        
        System.out.println("Elije el vuelo de ida: ");
        int opida = sc.nextInt();
        sc.nextLine();
        
        System.out.println("TARIFAS: ");
        System.out.println("A. ECONOMY (+0)");
        System.out.println("B. Premium Economy (+60)");
        System.out.println("C. Premium business (+90)");
        
        System.out.println("Elija la Tarifa para tu vuelo: ");
        int opta = sc.nextInt();
        sc.nextLine();
        
        for (int i = 0; i < pp; i++) {
            String[] inti = lecturaVuelos.get(i).split(",");
            fo = inti[2];
        }
        
        int subt = ;
        System.out.println("El subtotal de tu vuelo es : "+ subt);
        
        System.out.println("--------Vuelos Disponibles VUELTA-------------");
        int cont2 = 1;
        for (int i = 0; i < lecturaItinerarios.size(); i++) {
            String[] inti = lecturaItinerarios.get(i).split(",");
            if (pall.equals(inti[1])) {
                for (int j = 0; j < lecturaVuelos.size(); j++) {
                    String[] invu = lecturaVuelos.get(j).split(",");
                    if (inti[0].equals(invu[4])) {
                        System.out.println("---------"+cont2+"------------");
                        System.out.println("CODIGO: " + invu[0]);
                        System.out.println("HORA SALIDA : " + inti[3]);
                        System.out.println("HORA LLEGADA : " + inti[4]);
                        System.out.println("DURACION : " + inti[4]);
                        System.out.println("AVION: " + invu[1]);
                        System.out.println("PRECIO : " + invu[5]);
                        System.out.println("COSTO MILLAS : " + invu[6]);
                        cont2++;
                    }
                }
            }
        }
        
    }
    
    @Override
    public void consultarReservas() {
        
    }
    
    public double pagoTicket(String numeroTarjeta) {
        return 0.0;
    }
    
}
