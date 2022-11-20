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
        ArrayList<String> lecturaVuelos =ManejoArchivos.LeeFichero("vuelos.txt");
        lecturaVuelos.remove(0);
        Scanner sc = new Scanner (System.in);
        System.out.println("---ORIGEN-----");
        for (int i = 0; i < lecturaVuelos.size(); i++) {
            String[] inti = lecturaVuelos.get(i).split(",");
            System.out.println((i+1)+". "+inti[0]);
        }
        System.out.println("Elige punto de Partida: ");
        int pp = sc.nextInt();
        sc.nextLine();
        String fo = "";
        for (int i = 0; i < pp ; i++) {
            String[] inti = lecturaVuelos.get(i).split(",");
            fo = inti[2];
        }
                
        System.out.println("---DESTINO-----");
        for (int i = 0; i < lecturaVuelos.size(); i++) {
            String[] inti = lecturaVuelos.get(i).split(",");
            System.out.println((i+1)+". "+inti[0]);
        }
        System.out.println("Elige punto de LLegada: ");
        int pll = sc.nextInt();
        sc.nextLine();
        String fll = "";
        for (int i = 0; i < pll ; i++) {
            String[] inti = lecturaVuelos.get(i).split(",");
            fll = inti[2];
        }
        System.out.println("FECHA DE SALIDA: " + fo);
        System.out.println("FECHA DE RETORNO: "+ fll);
    }
    
    @Override
    public void consultarReservas(){
        
    }
    
    public double pagoTicket(String numeroTarjeta){
        return 0.0;
    }
    
}

