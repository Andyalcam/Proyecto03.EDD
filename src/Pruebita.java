import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;

public class Pruebita {
    public static void main(String[] args){

        Juego juego = new Juego();

        //juego.iniciar();

        String palabra = "futuro";
        List<String> secuencia = new List();
        secuencia.add(0,"O");
        secuencia.add(0,"F");
        secuencia.add(0,"I");
        secuencia.add(0,"A");
        secuencia.add(0,"R");
        secuencia.add(0,"A");
        secuencia.add(0,"C");
        secuencia.add(0,"E");
        secuencia.add(0,"B");
        //juego.validacionSec(secuencia,palabra);
        int ind = juego.find(juego.getDiccionario(), palabra);
        System.out.println(ind);


    }
}
