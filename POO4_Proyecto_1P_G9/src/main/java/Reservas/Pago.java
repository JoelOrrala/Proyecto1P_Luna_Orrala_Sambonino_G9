/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reservas;

import static Funcion.Funcion.generarNumeroAleatorio;
import manejoArchivos.ManejoArchivos;
import java.util.Date;

/**
 *
 * @author joelorrala
 */
public class Pago {
    private Date fechaPago;
    private String idPago;
    private MetodoPago metodoPago;
    private double totalPagarFinal;
    private Reserva reserva;
    
    public Pago(Date fechaPago,MetodoPago metodoPago,double totalPagarFinal,Reserva reserva){
        this.idPago = generarCodigoPago();
        this.fechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.totalPagarFinal = totalPagarFinal;
        this.reserva = reserva;
    }
    
    public Date getFechaPago(){
        return fechaPago;
    }
    
    public void setFechaPago(Date fechaPago){
        this.fechaPago = fechaPago;
    }
    
    public String getIdPago(){
        return idPago;
    }
    
    public MetodoPago getMetodoPago(){
        return metodoPago;
    }
    
    public double getTotalPagarFinal(){
        return totalPagarFinal;
    }
    
    public Reserva getReserva(){
        return reserva;
    }
    
    private String generarCodigoPago(){
        String codigo = "";
        for (int i = 1; i <= 4; i++){
            int numero = generarNumeroAleatorio(0,10);
            codigo += numero;
        }
        return codigo;
    }
    
    public void almacenarPago(){
        ManejoArchivos.EscribirArchivo("pagos.txt",idPago+","+reserva.getCodigo()+","+totalPagarFinal+","+metodoPago);
    }
}
