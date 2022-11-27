/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Sistema;
import Reservas.Rango;
import Reservas.Reserva;
import SeleccionVuelo.vueloReservado;
import Usuario.Cliente;
import Usuario.ClienteVIP;
import Usuario.Operador;
import Usuario.Perfil;
import Usuario.Usuario;
import java.util.ArrayList;
import java.util.Scanner;
import manejoArchivos.ManejoArchivos;

/**
 *
 * @author joelorrala
 */
public class Sistema_de_compra_tickets {
    
    private  ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private Scanner sc;
 
    public Sistema_de_compra_tickets(){
        sc = new Scanner(System.in);
        usuarios = GenerarUsuarios(); 
        reservas = new ArrayList<>(); 
    }
    
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
    
//    public void setUsuarios(ArrayList<Usuario> usuarios){
//        this.usuarios = usuarios;
//    }
    
    public ArrayList<Reserva> getReservas(){
        return reservas;
    }
    
    public void setReservas(ArrayList<Reserva> reservas){
        this.reservas = reservas;
    }
    
    public ArrayList<Usuario> GenerarUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>(); 
        ArrayList<String> lecturaUsuarios = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<String> lecturaClientes = ManejoArchivos.LeeFichero("clientes.txt");
        ArrayList<String> lecturaOperadores = ManejoArchivos.LeeFichero("operadores.txt");
        lecturaUsuarios.remove(0);
        lecturaClientes.remove(0);
        lecturaOperadores.remove(0);
     
        for (String linea: lecturaUsuarios){
            String[] datos = linea.split(",");
            String[] sepNomApe = datos[1].split(" ");
            int edad = Integer.parseInt(datos[2]);
            String cedula = datos[0],nombre = sepNomApe[0] ,apellido = sepNomApe[1], correo = datos[3], usuario = datos[4],contrasenia = datos[5], perfil = datos[6];
            
            if (perfil.equals(String.valueOf(Perfil.S)) || perfil.equals(String.valueOf(Perfil.V))){
 
                for(String c: lecturaClientes){
                    String[] datosCliente = c.split(",");
                    if (datosCliente[0].equals(cedula)){
                        String numTarjeta = datosCliente[1];
                        int millas = Integer.parseInt(datosCliente[3]);
                        if (perfil.equals(String.valueOf(Perfil.S))){
                            usuarios.add(new Cliente(cedula,nombre,apellido,edad,correo,usuario,contrasenia,Perfil.S,numTarjeta));
                        } else if (perfil.equals(String.valueOf(Perfil.V))) {
                            if (datosCliente[2].equals("GOLDEN PASS")) {
                                usuarios.add(new ClienteVIP(cedula, nombre, apellido, edad, correo, usuario, contrasenia, Perfil.V, numTarjeta, Rango.GOLD_PASS, millas));
                            } else if (datosCliente[2].equals("PLATINUM PASS")) {
                                usuarios.add(new ClienteVIP(cedula, nombre, apellido, edad, correo, usuario, contrasenia, Perfil.V, numTarjeta, Rango.PLATINUM_PASS, millas));
                            }
                        }
                    }
                }
                
            }else if(perfil.equals(String.valueOf(Perfil.O))){
              
                for (String o: lecturaOperadores){
                    String[] datosOperador = o.split(",");
                    if (datosOperador[0].equals(cedula)){
                        double sueldoOperador = Double.parseDouble(datosOperador[1]);
                        usuarios.add(new Operador(cedula,nombre,apellido,edad,correo,usuario,contrasenia,Perfil.O,sueldoOperador));
                    }
                }
            }
        }
        return usuarios;
    }
    
    public static void mostrarBienvenida(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++"+"\n");
        System.out.printf("%35s\n","BIENVENIDO AL SISTEMA");
        System.out.println("\n"+"+++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    
    public void mostrarMenu(Usuario u) {
        if (u.getPerfil() == Perfil.S || u.getPerfil() == Perfil.V) {
            System.out.println("1. Comprar tickets aéreos");
            System.out.println("2. Consultar reservas");
            System.out.println("3. Salir");
            String entrada = "";
            do {
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

        } else if (u.getPerfil() == Perfil.O){
            String entrada = "";
            do {
                System.out.println("1. Consultar usuarios");
                System.out.println("2. Consultar reservas");
                System.out.println("3. Salir");
                System.out.print("Ingrese opción: ");
                entrada = sc.nextLine();
                
                Operador o = (Operador)u;
                
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
    
    public static boolean verificarDatosCliente(Usuario u,String usuarioIngreso,String contraseniaIngreso){
        if (usuarioIngreso.equals(u.getUsuario()) && contraseniaIngreso.equals(u.getContrasenia())){
            return true;
        }else{
            return false;
        }
    }
    
    public void iniciarSesion(){
        mostrarBienvenida();
        System.out.print("USUARIO: ");
        String usuarioIngreso = sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contraseniaIngreso = sc.nextLine();
        boolean encontro = false;
        int indice = 0;
        while (encontro == false && indice<usuarios.size()) {
            Usuario u = usuarios.get(indice);
            encontro = verificarDatosCliente(u,usuarioIngreso,contraseniaIngreso);
            if (encontro == true){
                mostrarMenu(u);
            }
            indice++;
        }
        if (encontro==false){
            System.out.println("usuario o contraseña incorrectos");
        }
    }
    
    public static void main(String[] args) {

        Sistema_de_compra_tickets sistema = new Sistema_de_compra_tickets();
        sistema.iniciarSesion();

    }
}
