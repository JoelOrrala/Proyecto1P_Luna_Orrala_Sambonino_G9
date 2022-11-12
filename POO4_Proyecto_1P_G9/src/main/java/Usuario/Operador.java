package Usuario;
/**
 *
 * @author L.Luna
 */
public class Operador extends Usuario {
    Double sueldo;
    
    public Operador(String cedula, String apellido, int edad, String correo, String usuario, String contrasenia, Double sueldo){
        super(cedula,apellido,edad,correo,usuario,contrasenia);
        this.sueldo=sueldo;
    }
}
