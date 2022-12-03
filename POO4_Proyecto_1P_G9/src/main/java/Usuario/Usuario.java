package Usuario;

/**
 *
 * @author L.Luna
 */
public abstract class Usuario {

    /**
     *
     */
    protected String cedula;
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String correo;
    protected String usuario;
    protected String contrasenia;
    protected Perfil perfil;

    /**
     *
     * @param cedula dato del usuario
     * @param nombre dato del usuario
     * @param apellido dato del usuario
     * @param edad dato del usuario
     * @param correo dato del usuario
     * @param usuario dato del usuario
     * @param contrasenia dato del usuario
     * @param perfil dato del usuario
     */
    public Usuario(String cedula, String nombre, String apellido, int edad, String correo, String usuario, String contrasenia, Perfil perfil) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.correo = correo;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.perfil = perfil;
    }

    /**
     *
     */
    public abstract void consultarReservas();

    /**
     *
     * @return cedula del usuario
     */
    public String getCedula() {
        return cedula;
    }

    /**
     *
     * @param cedula cedula del usuario
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     *
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return apellido del usuario
     */
    public String getApellido() {
        return apellido;
    }

    /**
     *
     * @param apellido apellido del usuario
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     *
     * @return edad del usuario
     */
    public int getEdad() {
        return edad;
    }

    /**
     *
     * @param edad edad del usuario
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     *
     * @return correo del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *
     * @param correo correo del usuario
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return nombre de usuario del usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *
     * @param usuario usuario del usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *
     * @return contrasenia del usuario
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     *
     * @param contrasenia contrasenia del usuario
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     *
     * @return perfil del usuario
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     *
     * @return to string de usuario
     */
    @Override
    public String toString() {
        return "Nombres = " + nombre + apellido
                + "Cedula = " + cedula;
    }

}
