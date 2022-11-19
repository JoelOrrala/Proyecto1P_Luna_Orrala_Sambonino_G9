/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Sistema;
import ProcesoReserva.Rango;
import ProcesoReserva.Reserva;
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
                System.out.print("Ingrese opcion:");
                entrada = sc.nextLine();
                switch (entrada) {
                    case "1":

                        break;
                    case "2":

                        break;
                    case "3":

                        break;

                    default:
                        //la opción ingreada no esta dentro de las opciones del menú
                        System.out.println("Opción inválida");
                        break;

                }
            } while (!entrada.equals("3"));

        } else {
            String entrada = "";
            do {
                System.out.println("1. Consultar usuarios");
                System.out.println("2. Consultar reservas");
                System.out.println("3. Salir");
                System.out.print("Ingrese opción: ");
                entrada = sc.nextLine();
                switch (entrada) {
                    case "1":

                        break;
                    case "2":

                        break;
                    case "3":

                        break;

                    default:
                        //la opción ingreada no esta dentro de las opciones del menú
                        System.out.println("Opción inválida");
                        break;

                }
            } while (!entrada.equals("3"));
        }

    }
    
//    public void verificarDatosCliente(){
//        
//    }
    
    public void iniciarSesion(){
        mostrarBienvenida();
        System.out.print("USUARIO: ");
        String usuarioIngreso = sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contraseniaIngreso = sc.nextLine();
        int vueltas = 1;
        for (Usuario u : usuarios){
           
            if (usuarioIngreso.equals(u.getUsuario()) && contraseniaIngreso.equals(u.getContrasenia())){
                    mostrarMenu(u);
            }
            vueltas++;
            
        }
        
        if(vueltas > usuarios.size()){
                System.out.println("usuario o contraseña incorrectos");
            }
        
    }
    
    public static void main(String[] args) {
        
        Sistema_de_compra_tickets sistema = new Sistema_de_compra_tickets();
        sistema.iniciarSesion();
      
    }
}
