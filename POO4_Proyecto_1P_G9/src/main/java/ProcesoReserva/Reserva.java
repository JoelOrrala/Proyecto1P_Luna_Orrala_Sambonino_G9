/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcesoReserva;
import java.util.ArrayList;
import SeleccionVuelo.*;
import Usuario.Cliente;
/**
 *
 * @author joelorrala
 */
public class Reserva {
    private String codigo;
    private ArrayList<vueloReservado> vuelos;
    private String fechaReserva;
    private Cliente cliente;
    
    public String getCodigo(){
        return codigo;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public ArrayList<vueloReservado> getVuelos(){
        return vuelos;
    }
    
    public void setVueloReservado(ArrayList<vueloReservado> vuelos){
        this.vuelos = vuelos;
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
    
    public void consultarReserva(){
        
    }
}
