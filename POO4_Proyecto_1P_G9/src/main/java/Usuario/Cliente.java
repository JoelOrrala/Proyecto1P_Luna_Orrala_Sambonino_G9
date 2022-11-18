package Usuario;
/**
 *
 * @author L.Luna
 */
public class Cliente extends Usuario {
    protected String numeroTarjeta;
    public Cliente(String cedula, String nombre, String apellido, int edad, String correo, String usuario, String contrasenia, Perfil perfil, String numeroTarjeta){
        super(cedula,nombre,apellido,edad,correo,usuario,contrasenia,perfil);
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public void comprarTicket(){
        
    }
    
    @Override
    public void consultarReserva(){
        
    }
    
}

