package Usuario;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author L.Luna
 */
import SeleccionVuelo.*;
import java.util.Random;
import manejoArchivos.*;
import Sistema.*;

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
        ArrayList<String> lecturaAsientos = ManejoArchivos.LeeFichero("asientos.txt");
        lecturaAsientos.remove(0);
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
        ArrayList listaavionidad = new ArrayList();
        ArrayList listaprecios = new ArrayList();
        for (int i = 0; i < lecturaItinerarios.size(); i++) {
            String[] inti = lecturaItinerarios.get(i).split(",");
            if (po.equals(inti[1])) {
                for (int j = 0; j < lecturaVuelos.size(); j++) {
                    String[] invu = lecturaVuelos.get(j).split(",");
                    if (inti[0].equals(invu[4])) {
                        System.out.println("---------" + cont1 + "------------");
                        System.out.println("CODIGO: " + invu[0]);
                        listaavionidad.add(invu[0]);
                        System.out.println("HORA SALIDA : " + inti[3]);
                        System.out.println("HORA LLEGADA : " + inti[4]);
                        System.out.println("DURACION : " + inti[4]);
                        System.out.println("AVION: " + invu[1]);
                        System.out.println("PRECIO : " + invu[5]);
                        listaprecios.add(invu[5]);
                        System.out.println("COSTO MILLAS : " + invu[6]);
                        cont1++;
                    }
                }
            }
        }

        System.out.print("Elije el vuelo de ida: ");
        int opida = sc.nextInt();
        sc.nextLine();
        opida = opida - 1;
        Double precioida = Double.valueOf(listaprecios.get(opida).toString());
        String avionida = listaavionidad.get(opida).toString();

        System.out.println("TARIFAS: ");
        System.out.println("A. ECONOMY (+0)");
        System.out.println("B. Premium Economy (+60)");
        System.out.println("C. Premium business (+90)");

        System.out.print("Elija la Tarifa para tu vuelo: ");
        String opta = sc.nextLine();

        double nuevoprecioida = 0;
        if (opta.equals("A")) {
            nuevoprecioida = precioida;

        }
        if (opta.equals("B")) {
            nuevoprecioida = precioida + 60;

        }
        if (opta.equals("C")) {
            nuevoprecioida = precioida + 90;

        }

        System.out.println("--------Vuelos Disponibles VUELTA-------------");
        int cont2 = 1;
        ArrayList listaavionvuelta = new ArrayList();
        ArrayList listapreciosvuelta = new ArrayList();
        for (int i = 0; i < lecturaItinerarios.size(); i++) {
            String[] inti = lecturaItinerarios.get(i).split(",");
            if (pall.equals(inti[1])) {
                for (int j = 0; j < lecturaVuelos.size(); j++) {
                    String[] invu = lecturaVuelos.get(j).split(",");
                    if (inti[0].equals(invu[4])) {
                        System.out.println("---------" + cont2 + "------------");
                        System.out.println("CODIGO: " + invu[0]);
                        listaavionvuelta.add(invu[5]);
                        System.out.println("HORA SALIDA : " + inti[3]);
                        System.out.println("HORA LLEGADA : " + inti[4]);
                        System.out.println("DURACION : " + inti[4]);
                        System.out.println("AVION: " + invu[1]);
                        System.out.println("PRECIO : " + invu[5]);
                        listapreciosvuelta.add(invu[5]);
                        System.out.println("COSTO MILLAS : " + invu[6]); 
                        cont2++;
                    }
                }
            }
        }
        System.out.print("Elije el vuelo de ida: ");
        int opvuelta = sc.nextInt();
        sc.nextLine();
        opvuelta = opvuelta - 1;
        Double preciovuelta = Double.valueOf(listapreciosvuelta.get(opvuelta).toString());
        String avionvuelta = listaavionvuelta.get(opvuelta).toString();
        
        System.out.println("TARIFAS: ");
        System.out.println("A. ECONOMY (+0)");
        System.out.println("B. Premium Economy (+60)");
        System.out.println("C. Premium business (+90)");

        System.out.print("Elija la Tarifa para tu vuelo: ");
        String opta1 = sc.nextLine();

        double nuevopreciovuelta = 0;
        if (opta1.equals("A")) {
            nuevopreciovuelta = preciovuelta;

        }
        if (opta1.equals("B")) {
            nuevopreciovuelta = preciovuelta + 60;

        }
        if (opta1.equals("C")) {
            nuevopreciovuelta = preciovuelta + 90;

        }
        double subtotal = nuevopreciovuelta + nuevoprecioida;
        System.out.println("El subtotal de tu vuelo es : " + subtotal);

        System.out.print("Desea Continuar s/n: ");
        String continuar = sc.nextLine();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
        System.out.printf("%35s\n", "PASO2");
        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("--------ASIENTOS-------");
        //asiento ida
        String asasig = "";
        String disp = "N";
        while (disp.equals("N")) {
            Random r = new Random();
            int valorDado = r.nextInt(lecturaAsientos.size());
            for (int i = 0; i < valorDado; i++) {
                String[] inti = lecturaItinerarios.get(i).split(",");
                disp = inti[2];
                asasig = inti[1];

            }
        }
        //asientovuelta
        String asasigv = "";
        String dispv = "N";
        while (dispv.equals("N")) {
            Random r = new Random();
            int valorDado = r.nextInt(lecturaAsientos.size());
            for (int i = 0; i < valorDado; i++) {
                String[] inti = lecturaItinerarios.get(i).split(",");
                dispv = inti[2];
                asasigv = inti[1];

            }
        }
        System.out.println("Para tu vuelo de ida " + avionida + " se te ha asignado el asiento: "+asasig);
        System.out.println("Para tu vuelo de retorno " + avionvuelta + " se te ha asignado el asiento: "+asasigv);
        
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
        System.out.printf("%35s\n", "PASO3");
        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++++");
        
        System.out.println("-------------DATOS PASAJEROS------------");
        
        System.out.println("Fecha de nacimiento: ");
        String fnac = sc.nextLine();
        System.out.println("Genero (1.Masculino - 2. Femenino): ");
        int gen = sc.nextInt();
        sc.nextLine();
        if (gen == 1){
            String genero = "Masculino";
        }
        else{
            String genero = "Femenino";
        }
        System.out.println("Nacionalidad: ");
        String nac = sc.nextLine();
        System.out.println("Tipo de documento (1.cedula - 2. pasaporte): ");
        int tp = sc.nextInt();
        sc.nextLine();
        System.out.println("¿Desea guardar los datos del pasajero y continuar al pago (s/n)?");
        String ans = sc.nextLine();
        
        System.out.println("Ha completado el paso 3");
        
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
        System.out.printf("%35s\n", "PASO4");
        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++++");
        
        System.out.println("Descripcion: ");
        System.out.println("");
        System.out.println("Subtotal: "+subtotal);
        System.out.println("Descuento: ");
        System.out.println("Total: ");
        System.out.println("IVA: ");
        System.out.println("TOTAL A PAGAR: ");
        System.out.println("");
        System.out.println("Formas de pago:");
        System.out.println("Tarjeta de credito");
        System.out.println("Millas");
        System.out.println("");
        System.out.println("Elije tu forma de pago: ");
        int fp = sc.nextInt();
        sc.nextLine();
        if (fp == 1){
            System.out.println("Ingrese el numero de Tarjeta de credito: ");
            String tc = sc.nextLine();
            sc.nextLine();
        }
        else {
            System.out.println("Estamos descontando sus millas.....");
        }
        System.out.println("¿Estas seguro de pagar el vuelo (s/n)?: ");
        System.out.println("");
        System.out.println("Has comprado tu vuelo. El codigo de reserva es: ");
    }

    @Override
    public void consultarReservas() {

    }

    public double pagoTicket(String numeroTarjeta) {
        return 0.0;
    }

}
