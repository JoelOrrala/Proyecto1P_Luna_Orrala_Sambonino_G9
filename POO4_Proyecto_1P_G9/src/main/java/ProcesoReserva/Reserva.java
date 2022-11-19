/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcesoReserva;
import SeleccionVuelo.vueloReservado;
import java.util.ArrayList;
import Usuario.Cliente;
/**
 *
 * @author joelorrala
 */
public class Reserva {
    private static final char[] letras = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
        'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
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
            int indice = (int) (Math.random() * letras.length);
            codigo += letras[indice];
        }
        return codigo;
    }
    
    public void consultarReserva(Cliente c){
        
    }
    
}
