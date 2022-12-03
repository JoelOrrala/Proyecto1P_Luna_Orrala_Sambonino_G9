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
public class ClienteVIP extends Cliente {

    private Rango tipoVIP;
    private int millas;

    /**
     *
     * @param cedula dato del cliente
     * @param nombre dato del cliente
     * @param apellido dato del cliente
     * @param edad dato del cliente
     * @param correo dato del cliente
     * @param usuario dato del cliente
     * @param contrasenia dato del cliente
     * @param perfil dato del cliente
     * @param numeroTarjeta dato del cliente
     * @param tipoVIP dato del cliente
     * @param millas dato del cliente
     */
    public ClienteVIP(String cedula, String nombre, String apellido, int edad, String correo, String usuario, String contrasenia, Perfil perfil, String numeroTarjeta, Rango tipoVIP, int millas) {
        super(cedula, nombre, apellido, edad, correo, usuario, contrasenia, perfil, numeroTarjeta);
        this.tipoVIP = tipoVIP;
        this.millas = millas;
    }

    /**
     *
     * @return tipo vip del cliente
     */
    public Rango getTipoVIP() {
        return tipoVIP;
    }

    /**
     *
     * @param tipoVIP tipo de vip del cliente
     */
    public void setTipoVIP(Rango tipoVIP) {
        this.tipoVIP = tipoVIP;
    }

    /**
     *
     * @return millas del cliente
     */
    public int getMillas() {
        return millas;
    }

    /**
     *
     * @param millas millas del cliente
     */
    public void setMillas(int millas) {
        this.millas = millas;
    }

    /**
     *
     */
    @Override
    public void consultarReservas() {
        super.consultarReservas();
    }

    /**
     *
     * @param numeroTarjeta numero de tarjeta de credito
     * @param reserva reserva del cliente
     * @param totalxpagar total a pagar
     */
    @Override
    public void pagoTicket(String numeroTarjeta, Reserva reserva, double totalxpagar) {
        super.pagoTicket(numeroTarjeta, reserva, totalxpagar);
    }

    /**
     *
     * @param millas millas del cliente
     * @param reserva reserva del cliente
     * @param total total a pagar
     */
    public void pagoTicket(int millas, Reserva reserva, double total) {

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
        } else if (millas - totalmillas >= 0) {

            Date fechaPago = new Date();
            int resta = millas - totalmillas;
            Pago pago = new Pago(fechaPago, MetodoPago.M, total, reserva);
            pago.almacenarPago();
        }
    }
}
