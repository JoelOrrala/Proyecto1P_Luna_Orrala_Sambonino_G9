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
 * @author Giovanni
 */
public class Sistema_de_compra_tickets {
    
    private  ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private Scanner sc;
 
    public Sistema_de_compra_tickets(){
        sc = new Scanner(System.in);
        usuarios = new ArrayList<>(); 
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
    
    public void GenerarUsuarios(){
        ArrayList<String> lecturaUsuarios = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<String> lecturaClientes = ManejoArchivos.LeeFichero("clientes.txt");
        ArrayList<String> lecturaOperadores = ManejoArchivos.LeeFichero("operadores.txt");
        
        int numUsuarios = lecturaUsuarios.size()-1;
        for (int i = 1;i <= numUsuarios;i++){
            String[] datos = lecturaUsuarios.get(i).split(",");
            String[] sepNomApe = datos[1].split(" ");
            int edad = Integer.parseInt(datos[2]);
            String cedula = datos[0],nombre = sepNomApe[0] ,apellido = sepNomApe[1], correo = datos[3], usuario = datos[4],contrasenia = datos[5];
                    
            if (datos[6].equals(String.valueOf(Perfil.S))){
 
                int numClientes = lecturaClientes.size()-1;
                int indice = 1;
                while (indice <= numClientes){
                    String[] datosCliente = lecturaClientes.get(indice).split(",");
                    if (datosCliente[0].equals(cedula)){
                        String numTarjeta = datosCliente[1];
                        usuarios.add(new Cliente(cedula,nombre,apellido,edad,correo,usuario,contrasenia,Perfil.S,numTarjeta));
                        indice = numClientes;
                    }
                    indice+=1;
                }
                
            }else if(datos[6].equals(String.valueOf(Perfil.O))){
              
                int numOperadores = lecturaOperadores.size()-1;
                int indice = 1;
                while (indice <= numOperadores){
                    String[] datosOperador = lecturaOperadores.get(indice).split(",");
                    if (datosOperador[0].equals(cedula)){
                        double sueldoOperador = Double.parseDouble(datosOperador[1]);
                        usuarios.add(new Operador(cedula,nombre,apellido,edad,correo,usuario,contrasenia,Perfil.O,sueldoOperador));
                        indice = numOperadores;
                    }
                    indice+=1;
                }
                
            }else if(datos[6].equals(String.valueOf(Perfil.V))){
   
                int numVIP = lecturaClientes.size()-1;
                int indice = 1;
                while (indice <= numVIP){
                    String[] datosClienteVIP = lecturaClientes.get(indice).split(",");
                    if (datosClienteVIP[0].equals(cedula)){
                        String numTarjeta = datosClienteVIP[1];
                        int millas = Integer.parseInt(datosClienteVIP[3]);
                        if (datosClienteVIP[2].equals("GOLDEN PASS")){
                            usuarios.add(new ClienteVIP(cedula,nombre,apellido,edad,correo,usuario,contrasenia,Perfil.V,numTarjeta,Rango.GOLD_PASS,millas));
                        }else if (datosClienteVIP[2].equals("PLATINUM PASS")){
                            usuarios.add(new ClienteVIP(cedula,nombre,apellido,edad,correo,usuario,contrasenia,Perfil.V,numTarjeta,Rango.PLATINUM_PASS,millas));
                        }
                        
                        indice = numVIP;
                    }
                    indice+=1;
                }
            }
            
        }
    }
    
    public static void mostrarBienvenida(){
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++"+"\n");
        System.out.printf("%35s\n","BIENVENIDO AL SISTEMA");
        System.out.println("\n"+"+++++++++++++++++++++++++++++++++++++++++++++++++");
    }
    
    public void mostrarMenu(){
        
    }
    
//    public void verificarDatosCliente(){
//        
//    }
    
    public void iniciarSesion(){
        GenerarUsuarios();
        mostrarBienvenida();
        System.out.print("USUARIO: ");
        String usuarioIngreso = sc.nextLine();
        System.out.print("CONTRASEÑA: ");
        String contraseñaIngreso = sc.nextLine();
        
        System.out.println(usuarios);
        
    }
    
    public static void main(String[] args) {
        
        Sistema_de_compra_tickets sistema = new Sistema_de_compra_tickets();
        sistema.iniciarSesion();
      
    }
}
