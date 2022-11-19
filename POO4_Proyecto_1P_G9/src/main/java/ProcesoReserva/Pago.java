/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcesoReserva;

import static Funcion.Funcion.generarNumeroAleatorio;

/**
 *
 * @author joelorrala
 */
public class Pago {
    private String fechaPago;
    private String idPago;
    private MetodoPago metodoPago;
    
    public Pago(String fechaPago,MetodoPago metodoPago){
        this.idPago = generarCodigoPago();
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
    }
    
    public String getFechaPago(){
        return fechaPago;
    }
    
    public void setFechaPago(String fechaPago){
        this.fechaPago = fechaPago;
    }
    
    public String getIdPago(){
        return idPago;
    }
    
    public MetodoPago getMetodoPago(){
        return metodoPago;
    }
    
    private String generarCodigoPago(){
        String codigo = "";
        for (int i = 1; i <= 4; i++){
            int numero = generarNumeroAleatorio(0,10);
            codigo += numero;
        }
        return codigo;
    }

}
