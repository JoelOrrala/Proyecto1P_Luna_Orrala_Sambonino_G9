package Usuario;

import SeleccionVuelo.Avion;
import SeleccionVuelo.Itinerario;
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
     
        ArrayList<String> lecturaAsientos = ManejoArchivos.LeeFichero("asientos.txt");
        lecturaAsientos.remove(0);
        ArrayList<String> lecturaVuelos = ManejoArchivos.LeeFichero("vuelos.txt");
        lecturaVuelos.remove(0);
        ArrayList<String> lecturaReservas = ManejoArchivos.LeeFichero("reservas.txt");
        lecturaReservas.remove(0);

        System.out.println("---------------------------------------------");
        for (String lineaV : lecturaVuelos) {
            String[] datosVuelos = lineaV.split(",");
            String codigoVuelo = datosVuelos[0], codigoAvion = datosVuelos[1];
            int cantidadReser = 0;
            for (String lineaA : lecturaAsientos) {
                String[] datosAsi = lineaA.split(",");
                if (codigoAvion.equals(datosAsi[0]) && datosAsi[2].equals("N")) {
                    cantidadReser++;
                }
            }

            for (String lineaR : lecturaReservas){
                String[] datosRe = lineaR.split(",");
                if (codigoVuelo.equals(datosRe[1])){
                    cantidadReser++;
                }      
            }
            
            System.out.println("VUELO: "+codigoVuelo);
            System.out.println("CANTIDAD RESERVADOS: "+cantidadReser);
            System.out.println("---------------------------------------------");
            
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
