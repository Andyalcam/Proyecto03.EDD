import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Juego {

    private String[] diccionario;
    private List<String> secuencia;
    public static Cronometro cronometro = new Cronometro();

    public Juego(){
        leerDiccionario();
        obtenerSecuencia();
        revolver();
    }

    /**
     * Método que genera números aleatorios entre 0 y max.
     */
    private int random(int max) {
        return (int) Math.round(Math.random() * max + 0.5);
    }

    /**
     * Método para revolver los elementos de la secuencia
     */
    public void revolver(){
        for(int i = 0; i < secuencia.size(); i++){
            int numRan = random(secuencia.size()-1);
            String temporal = secuencia.remove(numRan);
            secuencia.add(0,temporal);
        }
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

    public void jugar(){

        Turno turno = new Turno(this);

        cronometro.start();
        turno.start();

        while(cronometro.isAlive()) {

        }

        System.out.println("El tiempo se terminó, presiona enter.");


    }



    private void obtenerSecuencia(){
        secuencia = new List();
        String[] vocales = {"A","E","I","O","U"};
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int rnd = random.nextInt(5);
            secuencia.add(0,vocales[rnd]);
        }

        for (int i = 0; i < 6; i++) {
            int rnd2 = random.nextInt(26) + 65;
            secuencia.add(0,(char)(rnd2)+"");
        }
    }

    public void iniciar(){
        System.out.print("Tu secuencia de letras es: ");
        //for (int i=0; i<secuencia.size(); i++) {
            System.out.print(secuencia);
        //}
        System.out.println();
        jugar();
    }

    public void validacionSec(List<String> secuencia, String palabra){
        palabra = palabra.toUpperCase();
        List<String> secAux = secuencia;
        boolean valida = false;
        char[] letras =palabra.toCharArray();
        for(int i=0; i<letras.length; i++){
            String aux = letras[i] + "";
            if(secAux.contains(aux)){
                secAux.remove(aux);
                valida = true;
            }else{
                valida = false;
                System.out.println("Tu palabra no es válida");
                break;
            }
        }
        if (valida){
            palabra = palabra.toLowerCase();
            String[] arreglito = getDiccionario();
            int indice = find(arreglito,palabra);
            System.out.printf(indice + "");
            if(indice != -1){
                System.out.println(" " + arreglito[indice]);
                System.out.println("Tu palabra es válida");
            }else {
                System.out.println("Tu palabra no es válida, no esta en el diccionario");
            }
        }
    }

    /**
     * Método que busca la posición del elemento que quieras buscar (para el usuario).
     * @param arr - arreglo en el que buscaremos.
     * @param elem - elemento a buscar.
     * @return la posición del elemento a buscar.
     * -1 si no existe el elemento en el arreglo.
     */
    public int find(String[] arr, String elem){
        return find(arr, elem, 0, arr.length - 1);
    }

    /**
     * Método para buscar un elemento en un arreglo.
     * @param arr - arreglo en el que se va a buscar.
     * @param elem - elemento que buscamos.
     * @param lo - índice de inicio.
     * @param hi - índice de fin.
     * @return la posición del elemento que buscamos.
     * -1 si el elemento no existe en el arreglo.
     */
    private int find ( String[] arr, String elem, int lo, int hi){
        if (lo > hi) { //Si no existe el elemento
            return -1;
        }

        int mid = lo + ((hi - lo) / 2);

        if (arr[mid].compareTo(elem) == 0) {//Si el elemento es mid
            System.out.println("mid: " + mid + ", lo: " + lo + ", hi: " + hi + ", arreglo: " + arr[mid] + " - elemento: " + elem);
            return mid;
        }
        if (arr[mid].compareTo(elem) < 0) { //Buscamos en la parte de la derecha
            System.out.println("mid: " + mid + ", lo: " + lo + ", hi: " + hi + ", arreglo: " + arr[mid] + " - elemento: " + elem);
            return find(arr, elem, mid + 1, hi);
        } else { //Buscamos en la parte de la izquierda
            System.out.println("mid: " + mid + ", lo: " + lo + ", hi: " + hi + ", arreglo: " + arr[mid] + " - elemento: " + elem);
            return find(arr, elem, lo, mid - 1);
        }
    }

}
