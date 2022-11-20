package Usuario;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author L.Luna
 */
import SeleccionVuelo.*;
import manejoArchivos.*;
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
        ArrayList<String> lecturaIntinerarios =ManejoArchivos.LeeFichero("itinerarios.txt");
        lecturaIntinerarios.remove(0);
        Scanner sc = new Scanner (System.in);
        System.out.println("---ORIGEN-----");
        for (int i = 0; i < lecturaIntinerarios.size(); i++) {
            String[] inti = lecturaIntinerarios.get(i).split(",");
            System.out.println((i+1)+". "+inti[1]);
        }
        System.out.println("Elige punto de Partida: ");
        int pp = sc.nextInt();
        sc.nextLine();
        System.out.println("---DESTINO-----");
        for (int i = 0; i < lecturaIntinerarios.size(); i++) {
            String[] inti = lecturaIntinerarios.get(i).split(",");
            System.out.println((i+1)+". "+inti[1]);
        }
        System.out.println("Elige punto de LLegada: ");
        int pll = sc.nextInt();
        sc.nextLine();
    }
    
    @Override
    public void consultarReservas(){
        
    }
    
    public double pagoTicket(String numeroTarjeta){
        return 0.0;
    }
    
}

