package Usuario;
/**
 *
 * @author L.Luna
 */
public class Cliente extends Usuario {
    protected int numeroTarjeta;
    public Cliente(String cedula, String nombre, String apellido, int edad, String correo, String usuario, String contrasenia, int numeroTarjeta){
        super(cedula,nombre,apellido,edad,correo,usuario,contrasenia);
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
    
    public void comprarTicket(){
        
    }
    
    @Override
    public void consultarReserva(){
        
    }
    
}

