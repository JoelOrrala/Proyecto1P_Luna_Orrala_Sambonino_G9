package Usuario;

import ProcesoReserva.Rango;

/**
 *
 * @author L.Luna
 */
public class ClienteVIP extends Cliente{
    private Rango tipoVIP;
    private int millas;
    
    public ClienteVIP(String cedula, String nombre, String apellido, int edad, String correo, String usuario, String contrasenia, int numeroTarjeta, Rango tipoVIP, int millas){
        super(cedula,nombre,apellido,edad,correo,usuario,contrasenia,numeroTarjeta);
        this.tipoVIP = tipoVIP;
        this.millas = millas;
    }
}
