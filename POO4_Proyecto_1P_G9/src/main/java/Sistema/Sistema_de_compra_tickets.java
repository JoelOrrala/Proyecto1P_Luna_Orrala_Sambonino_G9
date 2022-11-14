/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Sistema;
import ProcesoReserva.Reserva;
import Usuario.Cliente;
import Usuario.Operador;
import Usuario.Perfil;
import Usuario.Usuario;
import java.util.ArrayList;
import manejoArchivos.ManejoArchivos;

/**
 *
 * @author Giovanni
 */
public class Sistema_de_compra_tickets {
    
    private  ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    
    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }
    
    public void setUsuarios(ArrayList<Usuario> usuarios){
        this.usuarios = usuarios;
    }
    
    public ArrayList<Reserva> getReservas(){
        return reservas;
    }
    
    public void setReservas(ArrayList<Reserva> reservas){
        this.reservas = reservas;
    }
    
    public void cargarUsuarios(){
        ArrayList<String> lecturaUsuarios = ManejoArchivos.LeeFichero("usuarios.txt");
        int numUsuarios = lecturaUsuarios.size()-1;
        for (int i = 1;i <= numUsuarios;i++){
            String[] datos = lecturaUsuarios.get(i).split(",");
            String[] sepNomApe = datos[1].split(" ");
            int edad = Integer.parseInt(datos[2]);
            if (datos[6].equals(Perfil.S)){
                ArrayList<String> lecturaClientes = ManejoArchivos.LeeFichero("clientes.txt");
                int numClientes = lecturaClientes.size()-1;
                for (int j = 1;j <= numClientes ;j++){
                    String[] datosCliente = lecturaClientes.get(j).split(",");
                    if (datosCliente[0].equals(datos[0])){
                        int numTarjeta = Integer.parseInt(datosCliente[1]);
                        usuarios.add(new Cliente(datos[0],sepNomApe[0],sepNomApe[1],edad,datos[3],datos[4],datos[5],numTarjeta));
                    }
                }
                
            }else if(datos[6].equals(Perfil.O)){
                ArrayList<String> lecturaOperadores = ManejoArchivos.LeeFichero("operadores.txt");
                int numOperadores = lecturaOperadores.size()-1;
                for (int j = 1;j <= numOperadores ;j++){
                    String[] datosOperador = lecturaOperadores.get(j).split(",");
                    if (datosOperador[0].equals(datos[0])){
                        double sueldoOperador = Integer.parseInt(datosOperador[1]);
                        usuarios.add(new Operador(datos[0],sepNomApe[0],sepNomApe[1],edad,datos[3],datos[4],datos[5],sueldoOperador));
                    }
                }
            }else if(datos[6].equals(Perfil.V)){
                
            }
            
            // Usuario usuario = new Usuario(datos[0],sepNomApe[0],sepNomApe[1],edad,datos[3],datos[4],datos[5],datos[6]);
        }
    }
    
    public void mostrarMenu(){
        
        }
    
    public void verificarDatosCliente(){
        
    }
    
    public void iniciarSesion(){
        
    }
    
    public static void main(String[] args) {
        
    }
}
