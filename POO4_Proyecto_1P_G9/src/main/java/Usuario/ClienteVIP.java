package Usuario;

import Reservas.Rango;

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
//        this.millas = 1000;
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
        
    }
    
    public void pagoTicket(String numeroTarjeta){
        
    }
    
    public void pagoTicket(int millas){
        
    }
}
