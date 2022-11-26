/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservas;
import static Funcion.Funcion.generarLetraAleatoria;
import SeleccionVuelo.Vuelo;
import SeleccionVuelo.vueloReservado;
import java.util.ArrayList;
import Usuario.Cliente;
import manejoArchivos.ManejoArchivos;
/**                                                                                                                                                                                                                                                                                                                                                               
 *
 * @author joelorrala
 */
public class Reserva {
 
    private String codigo;
    private ArrayList<vueloReservado> listaVuelos;
    private String fechaReserva;
    private Cliente cliente;
    private double valorPagar;
    
    public Reserva(ArrayList<vueloReservado> listaVuelos,String fechaReserva,Cliente cliente,double valorPagar){
        this.codigo = generarCodigoReserva();
        this.listaVuelos = listaVuelos;
        this.fechaReserva = fechaReserva;
        this.cliente = cliente;
        this.valorPagar = valorPagar;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public ArrayList<vueloReservado> getListaVuelos(){
        return listaVuelos;
    }
    
    public void setListaVuelos(ArrayList<vueloReservado> listaVuelos){
        this.listaVuelos = listaVuelos;
    }
    
    public String getFechaReserva(){
        return fechaReserva;
    }
    
    public void setFechaReserva(String fechaReserva){
        this.fechaReserva = fechaReserva;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    public double getValorPagar(){
        return valorPagar;
    }
    
    private String generarCodigoReserva(){
        String codigo = ""; 
        for (int i = 1; i <= 5; i++){
            codigo += generarLetraAleatoria();
        }
        return codigo;
    }
    public String getGenerarCodigoReserva(){
        return generarCodigoReserva();
    }
    
    public void almacenarReserva() {
        for (vueloReservado v: listaVuelos){
            ManejoArchivos.EscribirArchivo("reservas.txt", codigo + "," + v.getVueloSeleccionado().getCodigo() + "," + cliente.getNombre() + " " + cliente.getApellido() + "," + fechaReserva + "," + valorPagar);
        }
    }
   
    public void consultarReserva(){
     
    }
    
}
