import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pruebita {
    public static void main(String[] args){

        Juego juego = new Juego();

        //juego.iniciar();

        String palabra = "FRESAS";
        List<String> secuencia = new ArrayList<>();
        secuencia.add("O");
        secuencia.add("F");
        secuencia.add("I");
        secuencia.add("A");
        secuencia.add("R");
        secuencia.add("A");
        secuencia.add("S");
        secuencia.add("E");
        secuencia.add("J");
        juego.validacionSec(secuencia,palabra);
    }
}
