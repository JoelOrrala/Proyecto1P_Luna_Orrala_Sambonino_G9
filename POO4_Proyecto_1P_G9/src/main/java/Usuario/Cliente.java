package Usuario;

import static Funcion.Funcion.obtenerFechasVuelos;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author L.Luna
 */
import SeleccionVuelo.*;
import Reservas.*;
import java.util.Random;
import manejoArchivos.*;
import Sistema.*;
import java.util.Date;

public class Cliente extends Usuario {
//public class Cliente {
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
        ArrayList<String> lecturaAviones = ManejoArchivos.LeeFichero("aviones.txt");
        lecturaAviones.remove(0);
        Scanner sc = new Scanner(System.in);
        
        ArrayList<String> origenes = new ArrayList<>();
        System.out.println("---ORIGEN-----");
        int ind = 1;
        for (int i = 0; i < lecturaItinerarios.size(); i++) {
            String[] inti = lecturaItinerarios.get(i).split(",");
            if (origenes.contains(inti[1]) == false) {
                System.out.println(ind + ". " + inti[1]);
                origenes.add(inti[1]);
                ind++;
            }
        }

        System.out.print("Elige punto de Partida: ");
        int ppIngreso = sc.nextInt();
        sc.nextLine();

        String puntoOrigen = origenes.get(ppIngreso - 1);

        ArrayList<String> fechas1 = obtenerFechasVuelos(puntoOrigen);
        String fsalida = fechas1.get(0);

        System.out.println("---DESTINO-----");
        ArrayList<String> llegadas = new ArrayList<>();
        ind = 1;
        for (int i = 0; i < lecturaItinerarios.size(); i++) {
            String[] inti = lecturaItinerarios.get(i).split(",");
            if (llegadas.contains(inti[2]) == false) {
                System.out.println(ind + ". " + inti[2]);
                llegadas.add(inti[2]);
                ind++;
            }
        }

        System.out.print("Elige punto de LLegada: ");
        int pll = sc.nextInt();
        sc.nextLine();

        String puntoLlegada = llegadas.get(pll - 1);

        ArrayList<String> fechas2 = obtenerFechasVuelos(puntoLlegada);
        String fregreso = fechas2.get(0);

        System.out.println("FECHA DE SALIDA: " + fsalida);
        System.out.println("FECHA DE RETORNO: " + fregreso);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
        System.out.printf("%30s\n", "PASO1");
        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("--------Vuelos Disponibles IDA-------------");
        int cont1 = 1;
        ArrayList listaavionidad = new ArrayList();
        ArrayList listaprecios = new ArrayList();
        ArrayList listaCodigoAvion = new ArrayList();
        for (int i = 0; i < lecturaItinerarios.size(); i++) {
            String[] inti = lecturaItinerarios.get(i).split(",");
            if (puntoOrigen.equals(inti[1])) {
                for (int j = 0; j < lecturaVuelos.size(); j++) {
                    String[] invu = lecturaVuelos.get(j).split(",");
                    if (inti[0].equals(invu[4])) {
                        System.out.println("---------" + cont1 + "------------");
                        System.out.println("CODIGO: " + invu[0]);
                        listaavionidad.add(invu[0]);
                        System.out.println("HORA SALIDA : " + inti[3]);
                        System.out.println("HORA LLEGADA : " + inti[4]);
                        System.out.println("DURACION : " + inti[5]);
                        System.out.println("AVION: " + invu[1]);
                        listaCodigoAvion.add(invu[1]);
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
        Vuelo vueloIda;
        for (int i = 0; i < lecturaAviones.size(); i++) {
            String[] outboundPlane = lecturaAviones.get(i).split(",");
            String [] itinerary = lecturaItinerarios.get(i).split(",");
            if (listaCodigoAvion.get(opida).equals(outboundPlane[0])) {
                String codigo = (String) listaCodigoAvion.get(opida);
                int capacidad = Integer.parseInt(outboundPlane[1]);
                Avion avIda = new Avion(codigo, capacidad);
                for (String v : lecturaVuelos) {
                    String[] outboundFligth = v.split(",");
                    if (listaavionidad.get(opida).equals(outboundFligth[0])) {
                        String[] duration = itinerary[5].split(":");
                        String duracionS = duration[0]+"."+duration[1];
                        double durationD = Double.parseDouble(duracionS);
                        Itinerario iti = new Itinerario(itinerary[1],itinerary[2],itinerary[3],durationD);
                        Vuelo outFlight = new Vuelo(avIda, outboundFligth[0], (double)listaprecios.get(5), iti, outboundFligth[2], outboundFligth[3]);
                        vueloIda = outFlight;
                        }
            }   
        }
        }
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
        for (int p = 0; p < lecturaItinerarios.size(); p++) {
            String[] inti = lecturaItinerarios.get(p).split(",");
            if (puntoLlegada.equals(inti[1])) {
                for (int j = 0; j < lecturaVuelos.size(); j++) {
                    String[] invu = lecturaVuelos.get(j).split(",");
                    if (inti[0].equals(invu[4])) {
                        System.out.println("---------" + cont2 + "------------");
                        System.out.println("CODIGO: " + invu[0]);
                        listaavionvuelta.add(invu[5]);
                        System.out.println("HORA SALIDA : " + inti[3]);
                        System.out.println("HORA LLEGADA : " + inti[4]);
                        System.out.println("DURACION : " + inti[5]);
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
        Vuelo vueloRegreso;
        for (int t = 0; t < lecturaAviones.size(); t++) {
            String[] returnPlane = lecturaAviones.get(t).split(",");
            String [] itinerary2 = lecturaItinerarios.get(t).split(",");
            if (listaCodigoAvion.get(opvuelta).equals(returnPlane[0])) {
                String codigo2 = (String) listaCodigoAvion.get(opvuelta);
                int capacidad2 = Integer.parseInt(returnPlane[1]);
                Avion avRegreso = new Avion(codigo2, capacidad2);
                for (String vue : lecturaVuelos) {
                    String[] returnFligth = vue.split(",");
                    if (listaavionidad.get(opvuelta).equals(returnFligth[0])) {
                        String[] duration2 = itinerary2[5].split(":");
                        String duracion2S = duration2[0]+"."+duration2[1];
                        double duration2D = Double.parseDouble(duracion2S);
                        Itinerario iti2 = new Itinerario(itinerary2[1],itinerary2[2],itinerary2[3],duration2D);
                        Vuelo retFlight = new Vuelo(avRegreso, returnFligth[0], (double)listapreciosvuelta.get(5), iti2, returnFligth[2], returnFligth[3]);
                        vueloRegreso = retFlight;
                        }
            }   
        }
        }
        Double preciovuelta = Double.valueOf(listapreciosvuelta.get(opvuelta).toString());
        String avionvuelta = listaavionvuelta.get(opvuelta).toString();

        System.out.println("TARIFAS: ");
        System.out.println("A. ECONOMY (+0)");
        System.out.println("B. Premium Economy (+60)");
        System.out.println("C. Premium business (+90)");

        System.out.print("Elija la Tarifa para tu vuelo: ");
        String opta1 = sc.nextLine();

        double nuevopreciovuelta = 0;
        if (opta1.equalsIgnoreCase("A")) {
            nuevopreciovuelta = preciovuelta;

        }
        if (opta1.equalsIgnoreCase("B")) {
            nuevopreciovuelta = preciovuelta + 60;

        }
        if (opta1.equalsIgnoreCase("C")) {
            nuevopreciovuelta = preciovuelta + 90;

        }
        double subtotal = nuevopreciovuelta + nuevoprecioida;
        System.out.println("El subtotal de tu vuelo es : " + subtotal);

        System.out.print("Desea Continuar (s/n): ");
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
            for (int q = 0; q < valorDado; q++) {
                String[] inti = lecturaItinerarios.get(q).split(",");
                disp = inti[2];
                if (disp == "S") {
                    asasig = inti[1];
                }

            }
        }

        //asientovuelta
        String asasigv = "";
        String dispv = "N";
        while (dispv.equals("N")) {
            Random r = new Random();
            int valorDado = r.nextInt(lecturaAsientos.size());
            for (int k = 0; k < valorDado; k++) {
                String[] inti = lecturaItinerarios.get(k).split(",");
                dispv = inti[2];
                asasigv = inti[1];

            }
        }
        System.out.println("Para tu vuelo de ida " + avionida + " se te ha asignado el asiento: " + asasig);
        System.out.println("Para tu vuelo de retorno " + avionvuelta + " se te ha asignado el asiento: " + asasigv);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
        System.out.printf("%35s\n", "PASO3");
        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("-------------DATOS PASAJEROS------------");
        System.out.println("Completa los datos del pasajero:");

        System.out.print("Fecha de nacimiento: ");
        String fnac = sc.nextLine();
        System.out.print("Genero (1.Masculino - 2. Femenino): ");
        int gen = sc.nextInt();
        sc.nextLine();
        if (gen == 1) {
            String genero = "Masculino";
        } else {
            String genero = "Femenino";
        }
        System.out.print("Nacionalidad: ");
        String nac = sc.nextLine();
        System.out.print("Tipo de documento (1.cedula - 2. pasaporte): ");
        int tp = sc.nextInt();
        sc.nextLine();
        if (tp == 1) {
            System.out.print("Número de documento: ");
            String identif = sc.nextLine();
        } else if (tp == 2) {
            System.out.print("Número de documento: ");
            String identif = sc.nextLine();
        }
        System.out.print("¿Desea guardar los datos del pasajero y continuar al pago (s/n)?");
        String ans = sc.nextLine();

        System.out.println("Ha completado el paso 3");

        char continuarP = sc.nextLine().toLowerCase().charAt(0);
        if (continuarP == 's') {
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
            System.out.printf("%35s\n", "PASO4");
            System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++++");
//        ArrayList<String> lecturaClientes = ManejoArchivos.LeeFichero("clientes.txt");
//        lecturaUsuarios.remove(0);

            System.out.println("Descripcion: ");
            System.out.println("");
            System.out.println("Subtotal: " + subtotal);
            System.out.println("Descuento: 0% (Cliente Estandar)");
            System.out.println("Total: " + subtotal);
            double iva = (subtotal / 100) * 12;
            System.out.println("IVA: 12%" + iva);
            System.out.println("TOTAL A PAGAR: " + (subtotal + iva));
            System.out.println("");
            System.out.println("Formas de pago:");
            System.out.println("1.Tarjeta de credito");
            System.out.println("2.Millas");
            System.out.println("");
            int j = 0;
            while (j == 0) {
                System.out.println("Elije tu forma de pago: ");
                int fp = sc.nextInt();
                sc.nextLine();
                if (fp == 1) {
                    System.out.println("Ingrese el numero de Tarjeta de credito: ");
                    String tc = sc.nextLine();
                    sc.nextLine();
                    pagoTicket(tc);
                    j = 1;
                } else {
                    System.out.println("Usted no puede pagar con millas .....");
                }
            }
        }

    }
    @Override
    public void consultarReservas(){
        System.out.println("xd");
    }

    public void pagoTicket(String numeroTarjeta) {
        Date fechaRegistro = new Date();
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Estas seguro de pagar el vuelo (s/n)?: ");
        char continuarPagoV = sc.nextLine().toLowerCase().charAt(0);
        if (continuarPagoV=='s'){
            System.out.println("");
            //vueloReservado vueloreservaIda = new vueloReservado(vuelo, TipoVuelo.IDA, Tarifa.ECONOMY)
            System.out.println("Has comprado tu vuelo. El codigo de reserva es: ");
        }
    }
    
//    public static void main(String[] args) {
//        Cliente c = new Cliente();
//        c.comprarTicket();
//    }

}

