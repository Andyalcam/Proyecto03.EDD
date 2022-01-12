import java.util.Scanner;

public class Turno extends Thread{

    Juego juego;

    public Turno(Juego juego){
        this.juego = juego;
    }

    @Override
    public void run(){
        while(Juego.cronometro.isAlive()){
            Scanner in = new Scanner(System.in);
            System.out.println("Ingresa una palabra");
            String aux = in.nextLine();
            juego.validacionSec(juego.getSecuencia(), aux);
        }
    }

}
