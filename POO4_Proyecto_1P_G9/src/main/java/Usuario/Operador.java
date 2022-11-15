package Usuario;
/**
 *
 * @author L.Luna
 */
public class Operador extends Usuario {
    double sueldo;
    
    public Operador(String cedula, String nombre, String apellido, int edad, String correo, String usuario, String contrasenia, double sueldo){
        super(cedula,nombre,apellido,edad,correo,usuario,contrasenia);
        this.sueldo=sueldo;
    }
    
    public double getSueldo(){
        return sueldo;
    }
    
    public void setSueldo(double sueldo){
        this.sueldo = sueldo;
    }
    
    @Override
    public void consultarReserva(){
    }
    
}
