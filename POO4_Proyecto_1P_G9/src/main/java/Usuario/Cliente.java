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
import java.util.Date;

/**
 *
 * clase cliente
 */
public class Cliente extends Usuario {

    /**
     * numero de tarjeta del cliente
     */
    protected String numeroTarjeta;

    /**
     *
     * @param cedula dato del cliente
     * @param nombre dato del cliente
     * @param apellido dato del cliente
     * @param edad dato del cliente
     * @param correo dato del cliente
     * @param usuario dato del cliente
     * @param contrasenia dato del cliente
     * @param perfil dato del cliente
     * @param numeroTarjeta dato del cliente
     */
    public Cliente(String cedula, String nombre, String apellido, int edad, String correo, String usuario, String contrasenia, Perfil perfil, String numeroTarjeta) {
        super(cedula, nombre, apellido, edad, correo, usuario, contrasenia, perfil);
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     *
     * @return numero de tarjeta del cliente
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     *
     * @param numeroTarjeta numero de tarjeta del cliente
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * metodo compra de ticket
     */
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
        String ans = "s";
        char continuarP;
        Vuelo vueloIda = null;
        Tarifa tarifaIda = null;
        Tarifa tarifaVuelta = null;
        Vuelo vueloRegreso = null;
        double subtotal = 0;
        String identif = "";
        ArrayList<vueloReservado> vuelosReservados = new ArrayList<>();
        String ans1 = "n";
        if (ans.equals("s")) {
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

            for (int i = 0; i < lecturaAviones.size(); i++) {
                String[] outboundPlane = lecturaAviones.get(i).split(",");
                String[] itinerary = lecturaItinerarios.get(i).split(",");
                if (listaCodigoAvion.get(opida).equals(outboundPlane[0])) {
                    String codigo = (String) listaCodigoAvion.get(opida);
                    int capacidad = Integer.parseInt(outboundPlane[1]);
                    Avion avIda = new Avion(codigo, capacidad);
                    for (String v : lecturaVuelos) {
                        String[] outboundFligth = v.split(",");
                        if (listaavionidad.get(opida).equals(outboundFligth[0])) {
                            String[] duration = itinerary[5].split(":");
                            String duracionS = duration[0] + "." + duration[1];
                            double durationD = Double.parseDouble(duracionS);
                            Itinerario iti = new Itinerario(itinerary[1], itinerary[2], itinerary[3], durationD);
                            var double1 = Double.parseDouble((String) listaprecios.get(opida));
                            Vuelo outFlight = new Vuelo(avIda, outboundFligth[0], double1, iti, outboundFligth[2], outboundFligth[3], Integer.parseInt(outboundFligth[6]));
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
                tarifaIda = Tarifa.ECONOMY;

            }
            if (opta.equals("B")) {
                nuevoprecioida = precioida + 60;
                tarifaIda = Tarifa.PREMIUM_ECONOMY;

            }
            if (opta.equals("C")) {
                nuevoprecioida = precioida + 90;
                tarifaIda = Tarifa.PREMIUM_BUSINESS;

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

            for (int t = 0; t < lecturaAviones.size(); t++) {
                String[] returnPlane = lecturaAviones.get(t).split(",");
                String[] itinerary2 = lecturaItinerarios.get(t).split(",");
                if (listaCodigoAvion.get(opvuelta).equals(returnPlane[0])) {
                    String codigo2 = (String) listaCodigoAvion.get(opvuelta);
                    int capacidad2 = Integer.parseInt(returnPlane[1]);
                    Avion avRegreso = new Avion(codigo2, capacidad2);
                    for (String vue : lecturaVuelos) {
                        String[] returnFligth = vue.split(",");
                        if (listaavionidad.get(opvuelta).equals(returnFligth[0])) {
                            String[] duration2 = itinerary2[5].split(":");
                            String duracion2S = duration2[0] + "." + duration2[1];
                            double duration2D = Double.parseDouble(duracion2S);
                            Itinerario iti2 = new Itinerario(itinerary2[1], itinerary2[2], itinerary2[3], duration2D);
                            var double2 = Double.parseDouble((String) listaprecios.get(opvuelta));
                            Vuelo retFlight = new Vuelo(avRegreso, returnFligth[0], double2, iti2, returnFligth[2], returnFligth[3], Integer.parseInt(returnFligth[6]));
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
                tarifaVuelta = Tarifa.ECONOMY;

            }
            if (opta1.equalsIgnoreCase("B")) {
                nuevopreciovuelta = preciovuelta + 60;
                tarifaVuelta = Tarifa.PREMIUM_ECONOMY;
            }
            if (opta1.equalsIgnoreCase("C")) {
                nuevopreciovuelta = preciovuelta + 90;
                tarifaVuelta = Tarifa.PREMIUM_BUSINESS;
            }
            subtotal = nuevopreciovuelta + nuevoprecioida;
            System.out.println("El subtotal de tu vuelo es : " + subtotal);

            System.out.print("Desea Continuar (s/n): ");
            ans1 = sc.nextLine().toLowerCase();

            if (ans1.equals("s")) {

                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
                System.out.printf("%35s\n", "PASO2");
                System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++++");

                System.out.println("--------ASIENTOS-------");
                //Asiento reservado de ida
                vueloReservado vueloReservadoIda = new vueloReservado(vueloIda, TipoVuelo.IDA, tarifaIda);
                vueloReservadoIda.almacenarVR();
                var asientoIda = vueloReservadoIda.getAsientoAsignado();
                System.out.println("Para tu vuelo de IDA " + vueloReservadoIda.getCodigoVR() + " se le ha asignado el vuelo: " + asientoIda);

                //Asiento reservado de regreso
                vueloReservado vueloReservadoRegreso = new vueloReservado(vueloRegreso, TipoVuelo.VUELTA, tarifaVuelta);
                vueloReservadoRegreso.almacenarVR();
                var asientoVuelta = vueloReservadoRegreso.getAsientoAsignado();

                System.out.println("Para tu vuelo de RETORNO " + vueloReservadoRegreso.getCodigoVR() + " se le ha asignado el vuelo: " + asientoVuelta);

                //Vuelos reservados
                vuelosReservados.add(vueloReservadoIda);
                vuelosReservados.add(vueloReservadoRegreso);

                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
                System.out.printf("%35s\n", "PASO3");
                System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++++");

                System.out.println("-------------DATOS PASAJEROS------------");
                System.out.println("Completa los datos del pasajero:");

                System.out.println("Nombre: " + this.nombre);
                System.out.println("Apellido: " + this.apellido);
                System.out.println("Correo: " + this.correo);

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
                    System.out.println("Cedula: " + this.cedula);
                } else if (tp == 2) {
                    System.out.print("Número de documento: ");
                    identif = sc.nextLine();
                }
                System.out.print("¿Desea guardar los datos del pasajero y continuar al pago (s/n)?: ");
                continuarP = sc.nextLine().toLowerCase().charAt(0);
                if (continuarP == 's') {
                    System.out.println("Ha completado el paso 3");

                    if (continuarP == 's') {
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
                        System.out.printf("%35s\n", "PASO4");
                        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++++");

                        double totalFinal = 0.00;
                        System.out.println("Descripcion: ");
                        System.out.println("");
                        System.out.println("Subtotal: " + subtotal);
                        double iva = (subtotal / 100) * 12;
                        if (!(this instanceof ClienteVIP) || this.getPerfil() == Perfil.S) {
                            System.out.println("Descuento: 0% (Cliente Estandar)");
                            System.out.println("Descuento: 0% (Cliente Estandar)");
                            System.out.printf("Total: %.2f%n", subtotal);
                            System.out.printf("IVA: %.2f%n", iva);
                            System.out.printf("TOTAL A PAGAR: %.2f%n", (subtotal + iva));
                            totalFinal = (subtotal + iva);
                            System.out.println("");
                        } else if (this instanceof ClienteVIP || this.getPerfil() == Perfil.V) {
                            ClienteVIP clientevip = (ClienteVIP) this;
                            if (clientevip.getTipoVIP() == Rango.GOLD_PASS) {
                                System.out.println("Descuento: 20% (cliente vip GOLDEN PASS)");
                                System.out.println("Subtotal" + subtotal);
                                double descuento = (subtotal / 100) * 20;
                                double total = (subtotal - descuento);
                                System.out.printf("Total: %.2f%n", total);
                                System.out.printf("IVA: %.2f%n", iva);
                                System.out.printf("TOTAL A PAGAR: %.2f%n", (subtotal + iva));
                                totalFinal = (total + iva);
                                System.out.println("");
                            } else if (clientevip.getTipoVIP() == Rango.PLATINUM_PASS) {
                                System.out.println("Descuento: 30% (cliente vip PLATINUM PASS)");
                                System.out.println("Subtotal" + subtotal);
                                double descuento = (subtotal / 100) * 30;
                                double total = (subtotal - descuento);
                                System.out.printf("Total: %.2f%n", total);
                                System.out.printf("IVA: %.2f%n", iva);
                                System.out.printf("TOTAL A PAGAR: %.2f%n", (subtotal + iva));
                                totalFinal = (total + iva);
                                System.out.println("");
                            }
                        }
                        System.out.println("Formas de pago:");
                        System.out.println("1.Tarjeta de credito");
                        System.out.println("2.Millas");
                        System.out.println("");
                        Date fechaRegistro = new Date();
                        int j = 0;
                        while (j == 0) {
                            System.out.println("Elije tu forma de pago: ");
                            int fp = sc.nextInt();
                            sc.nextLine();
                            if (fp == 1) {
                                System.out.println("Ingrese el numero de Tarjeta de credito: ");
                                String tc = sc.nextLine();
                                Reserva reservationTicket = new Reserva(vuelosReservados, fechaRegistro, this, (subtotal + iva));
                                String reservaTicket = reservationTicket.getGenerarCodigoReserva();
                                System.out.println("¿Estas seguro de pagar el vuelo (s/n)?: ");
                                char continuarPagoV = sc.nextLine().toLowerCase().charAt(0);
                                if (continuarPagoV == 's') {
                                    pagoTicket(tc, reservationTicket, totalFinal);
                                    System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + reservaTicket);
                                    reservationTicket.almacenarReserva();

                                }
                                j = 1;
                            } else if (fp == 2) {
                                if (!(this instanceof ClienteVIP) || this.getPerfil() == Perfil.S) {
                                    System.out.println("Usted no puede pagar con millas .....");
                                } else if (this instanceof ClienteVIP || this.getPerfil() == Perfil.V) {
                                    ClienteVIP clientVIP = (ClienteVIP) this;
                                    Reserva reservationTicket = new Reserva(vuelosReservados, fechaRegistro, this, (subtotal + iva));
                                    String reservaTicket = reservationTicket.getGenerarCodigoReserva();
                                    System.out.println("¿Estas seguro de pagar el vuelo (s/n)?: ");
                                    char continuarPagoV = sc.nextLine().toLowerCase().charAt(0);
                                    if (continuarPagoV == 's') {
                                        clientVIP.pagoTicket(clientVIP.getMillas(), reservationTicket, totalFinal);
                                        System.out.println("Has comprado tu vuelo. El codigo de reserva es: " + reservaTicket);
                                        reservationTicket.almacenarReserva();

                                    }
                                    j = 1;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     *
     */
    @Override
    public void consultarReservas() {
        ArrayList<String> lecturaReservas = ManejoArchivos.LeeFichero("reservas.txt");
        lecturaReservas.remove(0);
        ArrayList<String> lecturaVuelos = ManejoArchivos.LeeFichero("vuelos.txt");
        lecturaVuelos.remove(0);
        ArrayList<String> lecturaItinerarios = ManejoArchivos.LeeFichero("itinerarios.txt");
        lecturaItinerarios.remove(0);
        String horasale = null;
        String horallega = null;
        String avion = null;

        for (int h = 0; h < lecturaReservas.size(); h++) {
            String[] reservas = lecturaReservas.get(h).split(",");
            String nombres = reservas[2];
            String vuelo = reservas[1];
            for (int i = 0; i < lecturaVuelos.size(); i++) {
                String[] vuelos = lecturaVuelos.get(i).split(",");
                String codvuelo = vuelos[0];
                if (codvuelo.equals(vuelo)) {
                    avion = vuelos[1];
                    String itinerario = vuelos[4];
                    for (int j = 0; j < lecturaItinerarios.size(); j++) {
                        String[] itinerarios = lecturaItinerarios.get(j).split(",");
                        String coditinerario = itinerarios[0];
                        if (coditinerario.equals(itinerario)) {
                            horasale = itinerarios[3];
                            horallega = itinerarios[4];
                        }
                    }
                }
            }
            System.out.println("");
            System.out.println("NOMBRES: " + nombres);
            System.out.println("CEDULA: " + this.cedula);
            System.out.println("VUELO: " + vuelo);
            System.out.println("HORA SALIDA: " + horasale);
            System.out.println("HORA LLEGADA: " + horallega);
            System.out.println("AVION: " + avion);
            Random aleatorio = new Random();
            var aleat = aleatorio.nextInt(1, 11);
            System.out.println("Puerta de embargue: " + aleat);
        }

    }

    /**
     *
     * @param numeroTarjeta numero de tarjeta del cliente
     * @param reserva reserva del cliente
     * @param totalxpagar total a pagar
     */
    public void pagoTicket(String numeroTarjeta, Reserva reserva, double totalxpagar) {
        System.out.println("");
        Pago pago1 = new Pago(reserva.getFechaReserva(), MetodoPago.TC, totalxpagar + (totalxpagar * 0.10), reserva);
        pago1.almacenarPago();
    }
}
