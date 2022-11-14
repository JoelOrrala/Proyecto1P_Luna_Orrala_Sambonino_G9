package Usuario;
/**
 *
 * @author L.Luna
 */
public abstract class Usuario {
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String correo;
    protected String usuario;
    protected String contrasenia;
    protected Perfil perfil;

    public Usuario(String cedula, String nombre, String apellido, int edad, String correo, String usuario, String contrasenia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula = " + cedula + ", nombre = " + nombre + ", apellido = " + apellido + ", edad = " + edad + ", correo = " + correo + ", usuario = " + usuario + ", contrasenia = " + contrasenia + ", perfil = " + perfil + '}';
    }
    
    public void consultarReserva(){
    }
}
