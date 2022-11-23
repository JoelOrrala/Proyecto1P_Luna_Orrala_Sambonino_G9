/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservas;
import static Funcion.Funcion.generarLetraAleatoria;
import SeleccionVuelo.vueloReservado;
import java.util.ArrayList;
import Usuario.Cliente;
/**                                                                                                                                                                                                                                                                                                                                                               
 *
 * @author joelorrala
 */
public class Reserva {
 
    private String codigo;
    private ArrayList<vueloReservado> listaVuelos;
    private String fechaReserva;
    private Cliente cliente;
    
    public Reserva(ArrayList<vueloReservado> listaVuelos,String fechaReserva,Cliente cliente){
        this.codigo = generarCodigoReserva();
        this.listaVuelos = listaVuelos;
        this.fechaReserva = fechaReserva;
        this.cliente = cliente;
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
    
    private String generarCodigoReserva(){
        String codigo = ""; 
        for (int i = 1; i <= 5; i++){
            codigo += generarLetraAleatoria();
        }
        return codigo;
    }
    
    public void consultarReserva(Cliente c){
        
    }
    
}
