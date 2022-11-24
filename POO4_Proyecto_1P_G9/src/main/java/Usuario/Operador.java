package Usuario;

import SeleccionVuelo.Avion;
import java.util.ArrayList;
import manejoArchivos.ManejoArchivos;

/**
 *
 * @author L.Luna
 */
public class Operador extends Usuario {
    double sueldo;
    
    public Operador(String cedula, String nombre, String apellido, int edad, String correo, String usuario, String contrasenia, Perfil perfil, double sueldo){
        super(cedula,nombre,apellido,edad,correo,usuario,contrasenia,perfil);
        this.sueldo=sueldo;
    }
    
    public double getSueldo(){
        return sueldo;
    }
    
    public void setSueldo(double sueldo){
        this.sueldo = sueldo;
    }
    
    @Override
    public void consultarReservas(){
        ArrayList<String> lecturaAviones = ManejoArchivos.LeeFichero("aviones.txt");
        lecturaAviones.remove(0);
        ArrayList<String> lecturaVuelos = ManejoArchivos.LeeFichero("vuelos.txt");
        lecturaVuelos.remove(0);
        ArrayList<String> lecturaVuelosReserva = ManejoArchivos.LeeFichero("vuelosReserva.txt");
        lecturaVuelosReserva.remove(0);
        
        ArrayList<Avion> aviones = new ArrayList<>();
        for (String linea : lecturaVuelos) {
            String[] datosVuelo = linea.split(",");
            String codigo = datosVuelo[0];
            int capacidad = Integer.parseInt(datosVuelo[1]);
            aviones.add(new Avion(codigo,capacidad));
        }
        
        
       
    }
    
    public void consultarUsuarios(ArrayList<Usuario> lista){
        for (Usuario u: lista){
            if (u.getPerfil() == Perfil.S){
                Cliente c = (Cliente)u;
                System.out.printf("%s %s,CLIENTE ESTÁNDAR,%s%n",c.getNombre(),c.getApellido(),c.getCedula());
            }else if (u.getPerfil() == Perfil.V){
                ClienteVIP cvip = (ClienteVIP)u;
                System.out.printf("%s %s,CLIENTE VIP,%s,%s%n",cvip.getNombre(),cvip.getApellido(),cvip.getTipoVIP(),cvip.getCedula());
            }else if (u.getPerfil() == Perfil.O){
                Operador o = (Operador)u;
                System.out.printf("%s %s,OPERADOR,%.2f,%s%n",o.getNombre(),o.getApellido(),o.getSueldo(),o.getCedula());
            }
        }
    }
    
}
