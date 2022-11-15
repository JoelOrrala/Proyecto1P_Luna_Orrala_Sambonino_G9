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
        ArrayList<String> lecturaClientes = ManejoArchivos.LeeFichero("clientes.txt");
        ArrayList<String> lecturaOperadores = ManejoArchivos.LeeFichero("operadores.txt");
        
        int numUsuarios = lecturaUsuarios.size()-1;
        for (int i = 1;i <= numUsuarios;i++){
            String[] datos = lecturaUsuarios.get(i).split(",");
            String[] sepNomApe = datos[1].split(" ");
            int edad = Integer.parseInt(datos[2]);
            
            if (datos[6].equals(Perfil.S)){
 
                int numClientes = lecturaClientes.size()-1;
                int indice = 1;
                while (indice <= numClientes){
                    String[] datosCliente = lecturaClientes.get(indice).split(",");
                    if (datosCliente[0].equals(datos[0])){
                        int numTarjeta = Integer.parseInt(datosCliente[1]);
                        usuarios.add(new Cliente(datos[0],sepNomApe[0],sepNomApe[1],edad,datos[3],datos[4],datos[5],numTarjeta));
                        indice = numClientes + 1;
                    }
                    indice+=1;
                }
                
            }else if(datos[6].equals(Perfil.O)){
              
                int numOperadores = lecturaOperadores.size()-1;
                int indice = 1;
                while (indice <= numOperadores){
                    String[] datosOperador = lecturaOperadores.get(indice).split(",");
                    if (datosOperador[0].equals(datos[0])){
                        double sueldoOperador = Double.parseDouble(datosOperador[1]);
                        usuarios.add(new Operador(datos[0],sepNomApe[0],sepNomApe[1],edad,datos[3],datos[4],datos[5],sueldoOperador));
                        indice = numOperadores + 1;
                    }
                    indice+=1;
                }
                
            }else if(datos[6].equals(Perfil.V)){
   
                int numVIP = lecturaClientes.size()-1;
                int indice = 1;
                while (indice <= numVIP){
                    String[] datosClienteVIP = lecturaClientes.get(indice).split(",");
                    if (datosClienteVIP[0].equals(datos[0])){
                        int millas = Integer.parseInt(datosClienteVIP[3]);
                        if (datosClienteVIP[4].equals("GOLD PASS")){
                            usuarios.add(new ClienteVIP(datos[0],sepNomApe[0],sepNomApe[1],edad,datos[3],datos[4],datos[5],Rango.GOLD_PASS,millas);
                           
                        }else if (datosClienteVIP[4].equals("PLATINUM PASS")){
                            usuarios.add(new ClienteVIP(datos[0],sepNomApe[0],sepNomApe[1],edad,datos[3],datos[4],datos[5],Rango.PLATINUM_PASS,millas);
                        }
                        
                        indice = numVIP + 1;
                    }
                    indice+=1;
                }
            }
            
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
