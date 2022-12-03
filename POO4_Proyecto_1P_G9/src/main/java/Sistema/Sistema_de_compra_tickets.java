
package Sistema;

import Reservas.Rango;
import Usuario.Cliente;
import Usuario.ClienteVIP;
import Usuario.Operador;
import Usuario.Perfil;
import Usuario.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import manejoArchivos.ManejoArchivos;

/**
 * Sistema_de_compra_tickets va representar a la ejecución de toda la aplicación
 * de compra
 *
 * @author joelorrala
 */
public class Sistema_de_compra_tickets {

    private ArrayList<Usuario> usuarios;
    private Scanner sc;

    /**
     * Inicializa las variables sc y usuario
     */
    public Sistema_de_compra_tickets() {
        sc = new Scanner(System.in);
        usuarios = GenerarUsuarios();
    }

    /**
     *
     * @return lista de usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Recorrerá los archivos: usuarios.txt, clientes.txt y operadores.txt para
     * finalmente crear los usuarios
     *
     * @return usuarios registrados en el sistema
     */
    public ArrayList<Usuario> GenerarUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<String> lecturaUsuarios = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<String> lecturaClientes = ManejoArchivos.LeeFichero("clientes.txt");
        ArrayList<String> lecturaOperadores = ManejoArchivos.LeeFichero("operadores.txt");
        lecturaUsuarios.remove(0);
        lecturaClientes.remove(0);
        lecturaOperadores.remove(0);

        for (String linea : lecturaUsuarios) {
            String[] datos = linea.split(",");
            String[] sepNomApe = datos[1].split(" ");
            int edad = Integer.parseInt(datos[2]);
            String cedula = datos[0], nombre = sepNomApe[0], apellido = sepNomApe[1], correo = datos[3], usuario = datos[4], contrasenia = datos[5], perfil = datos[6];

            if (perfil.equals(String.valueOf(Perfil.S)) || perfil.equals(String.valueOf(Perfil.V))) {

                for (String c : lecturaClientes) {
                    String[] datosCliente = c.split(",");
                    if (datosCliente[0].equals(cedula)) {
                        String numTarjeta = datosCliente[1];
                        int millas = Integer.parseInt(datosCliente[3]);
                        if (perfil.equals(String.valueOf(Perfil.S))) {
                            usuarios.add(new Cliente(cedula, nombre, apellido, edad, correo, usuario, contrasenia, Perfil.S, numTarjeta));
                        } else if (perfil.equals(String.valueOf(Perfil.V))) {
                            if (datosCliente[2].equals("GOLDEN PASS")) {
                                usuarios.add(new ClienteVIP(cedula, nombre, apellido, edad, correo, usuario, contrasenia, Perfil.V, numTarjeta, Rango.GOLD_PASS, millas));
                            } else if (datosCliente[2].equals("PLATINUM PASS")) {
                                usuarios.add(new ClienteVIP(cedula, nombre, apellido, edad, correo, usuario, contrasenia, Perfil.V, numTarjeta, Rango.PLATINUM_PASS, millas));
                            }
                        }
                    }
                }

            } else if (perfil.equals(String.valueOf(Perfil.O))) {

                for (String o : lecturaOperadores) {
                    String[] datosOperador = o.split(",");
                    if (datosOperador[0].equals(cedula)) {
                        double sueldoOperador = Double.parseDouble(datosOperador[1]);
                        usuarios.add(new Operador(cedula, nombre, apellido, edad, correo, usuario, contrasenia, Perfil.O, sueldoOperador));
                    }
                }
            }
        }
        return usuarios;
    }

    /**
     * Muestra el mensaje de bienvenida al usuario cuando entra al sistema
     */
    public static void mostrarBienvenida() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++" + "\n");
        System.out.printf("%35s\n", "BIENVENIDO AL SISTEMA");
        System.out.println("\n" + "+++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /**
     * Muestra el menú al usuario dependiendo de su tipo
     *
     * @param u Usuario que inició sesión en el sistema
     */
    public void mostrarMenu(Usuario u) {
        String entrada = "";

        if (u.getPerfil() == Perfil.S || u.getPerfil() == Perfil.V) {
            do {
                System.out.println("1. Comprar tickets aéreos");
                System.out.println("2. Consultar reservas");
                System.out.println("3. Salir");

                System.out.print("Ingrese opción:");
                entrada = sc.nextLine();
                switch (entrada) {
                    case "1":
                        if (u.getPerfil() == Perfil.S) {
                            Cliente c = (Cliente) u;
                            c.comprarTicket();
                        } else {
                            ClienteVIP cvip = (ClienteVIP) u;
                            cvip.comprarTicket();
                        }
                        break;
                    case "2":
                        if (u.getPerfil() == Perfil.S) {
                            Cliente c = (Cliente) u;
                            c.consultarReservas();
                        } else {
                            ClienteVIP cvip = (ClienteVIP) u;
                            cvip.consultarReservas();
                        }

                        break;
                    case "3":
                        System.out.println("Gracias por usar nuestro programa");

                        break;

                    default:
                        //la opción ingreada no esta dentro de las opciones del menú
                        System.out.println("Opción inválida");
                        break;

                }
            } while (!entrada.equals("3"));

        } else if (u.getPerfil() == Perfil.O) {

            do {
                System.out.println("1. Consultar usuarios");
                System.out.println("2. Consultar reservas");
                System.out.println("3. Salir");
                System.out.print("Ingrese opción: ");
                entrada = sc.nextLine();

                Operador o = (Operador) u;

                switch (entrada) {
                    case "1":
                        o.consultarUsuarios(usuarios);

                        break;
                    case "2":
                        o.consultarReservas();

                        break;
                    case "3":
                        System.out.println("Gracias por usar nuestro programa");

                        break;

                    default:
                        //la opción ingreada no esta dentro de las opciones del menú
                        System.out.println("Opción inválida");
                        break;

                }
            } while (!entrada.equals("3"));
        }

    }

    /**
     * Verifica que los datos ingresados por el usuario en uso sean o no del
     * usuario registrado seleccionado
     *
     * @param u usuario que ya pertenece al Arraylist de Usuarios del sistema
     * @param usuarioIngreso usuario ingresado por la usuario en uso
     * @param contraseniaIngreso contraseña ingresada por el usuario en uso
     * @return
     */
    public static boolean verificarDatosCliente(Usuario u, String usuarioIngreso, String contraseniaIngreso) {
        if (usuarioIngreso.equals(u.getUsuario()) && contraseniaIngreso.equals(u.getContrasenia())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Al iniciar el programa pide a usuario en uso que ingrese su usuario y
     * contraseña para ser verificados, y dar paso o no al resto del programa
     */
    public void iniciarSesion() {
        mostrarBienvenida();
        System.out.print("USUARIO: ");
        String usuarioIngreso = sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contraseniaIngreso = sc.nextLine();
        boolean encontro = false;
        int indice = 0;
        while (encontro == false && indice < usuarios.size()) {
            Usuario u = usuarios.get(indice);
            encontro = verificarDatosCliente(u, usuarioIngreso, contraseniaIngreso);
            if (encontro == true) {
                mostrarMenu(u);
            }
            indice++;
        }
        if (encontro == false) {
            System.out.println("usuario o contraseña incorrectos");
        }
    }

    /**
     * Main del programa
     *
     * @param args
     */
    public static void main(String[] args) {

        Sistema_de_compra_tickets sistema = new Sistema_de_compra_tickets();
        sistema.iniciarSesion();

    }
}
