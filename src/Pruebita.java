import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Pruebita {
    public static void main(String[] args){

        int contador = 0;

        try {
            FileReader fr = new FileReader("src/Diccionario.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            List<String> lista = new ArrayList<>();
            int numLineas = (int)br.lines().count();
            String[] arreglito = new String[numLineas];
            FileReader fr2 = new FileReader("src/Diccionario.txt");
            BufferedReader br2 = new BufferedReader(fr2);

            while ((linea=br2.readLine()) != null){
                //arreglito = util.agregarArreglo(linea);
                //lista.add(linea);
                arreglito[contador++] = linea;
            }
            for (int i=0; i<arreglito.length; i++){
                System.out.println(arreglito[i]);
            }
            //System.out.println(lista);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
