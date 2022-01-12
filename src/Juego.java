import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Juego {

    private String[] diccionario;
    private List<String> secuencia;

    public Juego(){
        leerDiccionario();
        obtenerSecuencia();
        Collections.shuffle(secuencia);
    }

    public void setSecuencia(List<String> secuencia) {
        if(secuencia.size() != 0)
            secuencia.clear();
        this.secuencia = secuencia;
    }

    public String[] getDiccionario() {
        return diccionario;
    }

    public List<String> getSecuencia() {
        return secuencia;
    }

    private void leerDiccionario(){
        int contador = 0;

        try {
            FileReader fr = new FileReader("src/Diccionario.txt");
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int numLineas = (int)br.lines().count();
            diccionario = new String[numLineas];
            FileReader fr2 = new FileReader("src/Diccionario.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            while ((linea=br2.readLine()) != null){
                diccionario[contador++] = linea;
            }
        }catch (Exception e){
            System.out.println("Diccionario no válido");
        }
    }

    private void obtenerSecuencia(){
        secuencia = new ArrayList<>();
        String[] vocales = {"A","E","I","O","U"};
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int rnd = random.nextInt(5);
            secuencia.add(vocales[rnd]);
        }

        for (int i = 0; i < 6; i++) {
            int rnd2 = random.nextInt(26) + 65;
            secuencia.add((char)(rnd2)+"");
        }

    }

    public void iniciar(){
        System.out.print("Tu secuencia de letras es:");
        for (String letra : secuencia) {
            System.out.print(" " + letra);
        }
        System.out.println();
    }

    public void validacionSec(List<String> secuencia, String palabra){
        boolean valida = false;
        char[] letras =palabra.toCharArray();
        //siguiente:
        for(int i=0; i<letras.length; i++){
            String aux = letras[i] + "";
            System.out.println(aux + " " + secuencia.contains(aux));
            if(secuencia.contains(aux)){
                valida = true;
            }else{
                System.out.println("Tu palabra no es válida");
                break;
            }
            /*for(int j=0; j< secuencia.size(); j++){
                String aux = letras[i] + "";
                if (aux.equalsIgnoreCase(secuencia.get(j))){
                    //System.out.println("Tu palabra es válida");
                    //continue siguiente;
                    break;
                }else{
                    System.out.println("Tu palabra no es valida, la letra " + aux + " no pertenece a tu secuencia original");
                    break;
                }
            }*/
        }
        if (valida){
            System.out.println("Tu palabra es válida");
        }

        /*String palabraDiccionario = "";
        if(palabra.equalsIgnoreCase(palabraDiccionario)){

        }*/
    }

}
