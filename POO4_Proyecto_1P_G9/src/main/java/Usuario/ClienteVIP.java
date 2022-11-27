package Usuario;

import Reservas.MetodoPago;
import Reservas.Pago;
import Reservas.Rango;
import Reservas.Reserva;
import SeleccionVuelo.Vuelo;
import SeleccionVuelo.vueloReservado;
import Usuario.Cliente;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author L.Luna
 */
public class ClienteVIP extends Cliente{
    private Rango tipoVIP;
    private int millas;
    
    public ClienteVIP(String cedula, String nombre, String apellido, int edad, String correo, String usuario, String contrasenia, Perfil perfil, String numeroTarjeta, Rango tipoVIP, int millas){
        super(cedula,nombre,apellido,edad,correo,usuario,contrasenia,perfil,numeroTarjeta);
        this.tipoVIP = tipoVIP;
        this.millas = millas;
    }
    
    public Rango getTipoVIP(){
        return tipoVIP;
    }
    
    public void setTipoVIP(Rango tipoVIP){
        this.tipoVIP = tipoVIP;
    }
    
    public int getMillas(){
        return millas;
    }
    
    public void setMillas(int millas){
        this.millas = millas;
    }
    
    @Override
    public void consultarReservas(){
        super.consultarReservas();
    }
     
    @Override
    public void pagoTicket(String numeroTarjeta, Reserva reserva, double totalxpagar){
        super.pagoTicket(numeroTarjeta,reserva,totalxpagar);
    }
    
    public void pagoTicket(int millas, Reserva reserva, double total){

        vueloReservado vueloIda = reserva.getListaVuelos().get(0);
        int millasVueloIda = vueloIda.getVueloSeleccionado().getPrecioMillas();
        vueloReservado vueloVuelta = reserva.getListaVuelos().get(1);
        int millasVueloVuelta = vueloVuelta.getVueloSeleccionado().getPrecioMillas();
        int totalmillas = millasVueloIda + millasVueloVuelta;
        if (millas - totalmillas < 0) {
            System.out.println("No le alcanza las millas");
            System.out.println("Debe pagar con tarjeta de credito: ");
            System.out.println("Ingrese el numero de Tarjeta de credito:");
            Scanner sc = new Scanner(System.in);
            String tc = sc.nextLine();
            this.pagoTicket(tc, reserva, total);
    }
    else if (millas-totalmillas >= 0){
  
            Date fechaPago = new Date();
            int resta = millas - totalmillas;
            Pago pago = new Pago(fechaPago, MetodoPago.M, total, reserva);
            pago.almacenarPago();
    }
    }
}
