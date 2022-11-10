/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcesoReserva;
import java.util.ArrayList;
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
    
    public ArrayList<vueloReservado> getVuelos(){
        return vuelos;
    }
    
    public String getFechaReserva(){
        return fechaReserva;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void consultarReserva(){
        
    }
}
