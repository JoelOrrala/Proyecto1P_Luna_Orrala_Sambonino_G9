/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcesoReserva;

/**
 *
 * @author joelorrala
 */
public class Pago {
    private String fechaPago;
    private String idPago;
    private MetodoPago metodoPago;
    
    public String getFechaPago(){
        return fechaPago;
    }
    
    public void setFechaPago(String fechaPago){
        this.fechaPago = fechaPago;
    }
    
    public String getIdPago(){
        return idPago;
    }
    
    public void setIdPago(String idPago){
        this.idPago = idPago;
    }
    
    public MetodoPago getMetodoPago(){
        return metodoPago;
    }
    
}
