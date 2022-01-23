import java.io.BufferedReader;
import java.io.FileReader;
import java.text.Normalizer;
import java.util.Random;
import java.util.Scanner;

public class Juego {

    private String[] diccionario;
    private List<String> secuencia;
    private List<String> palabras;
    private List<String> jugadores;
    private List<String> puntuaciones;
    private int puntuación;
    public static Cronometro cronometro;
    private Scanner in = new Scanner(System.in);

    public Juego(List<String> jugadores){
        leerDiccionario();
        this.jugadores = jugadores;
        palabras = new List<>();
        puntuaciones = new List();
        secuencia = new List<>();
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

    public String[] getDiccionario() {
        return diccionario;
    }

    public List<String> getSecuencia() {
        return secuencia;
    }

    public int getPuntuación() {
        return puntuación;
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
        System.out.println("Tu secuencia es: " + secuencia);
        cronometro = new Cronometro();
        cronometro.start();

        while(cronometro.isAlive()) {
            Scanner in = new Scanner(System.in);
            System.out.println("Ingresa una palabra");
            String aux = in.nextLine();
            validacionSec(aux);
        }

        System.out.println("Puntuacion Final: " + puntuación);

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
        for(int i = 0; i < jugadores.size(); i++){
            int opc = 0;
            boolean repe;
            do {
                try {
                    System.out.println("Es turno de " + jugadores.get(i) + ". Selecciona una opción");
                    System.out.println("1. Introducir Secuencia \n2. Secuencia Aleatoria");
                    repe = false;
                    opc = in.nextInt();

                    if(opc != 1 && opc != 2){
                        throw new IllegalArgumentException();
                    }

                } catch (Exception e) {
                    System.out.println("Ingresa solo números");
                    repe = true;
                    in.next();
                }
            }while(repe);

            if(opc == 1){
                Scanner scanner = new Scanner(System.in);
                do {
                    try {
                        System.out.println("Ingresa la secuencia de 9 letras Ej. OFIARASEJ");
                        String sec = scanner.nextLine();
                        if(sec.length() != 9){
                            throw new IllegalArgumentException();
                        }
                        sec = sec.toUpperCase();
                        char[] arrSecuencia = sec.toCharArray();
                        secuencia.clear();
                        for (char letra : arrSecuencia) {
                            secuencia.add(0, letra + "");
                        }
                        repe = false;
                    } catch (Exception e) {
                        System.out.println("Ingresa lo que se te pide no seas naco");
                        repe = true;
                    }
                }while(repe);
            }else if(opc == 2){
                obtenerSecuencia();
                revolver();
            }else{

            }

            jugar();

        }
    }

    public boolean validacionSec(String palabra){
        String auxPalabra = cleanString(palabra);
        auxPalabra = auxPalabra.toUpperCase();
        List<String> secAux = new List<>();
        for (int i = 0; i < secuencia.size(); i++) {
            secAux.add(0,secuencia.get(i));
        }

        boolean valida = false;
        char[] letras = auxPalabra.toCharArray();

        for(int i=0; i<letras.length; i++){
            String aux = letras[i] + "";
            if(secAux.contains(aux)){
                secAux.remove(aux);
                valida = true;
            }else{
                System.out.println("La letra que no esta es : " + aux);
                valida = false;
                System.out.println("Tu palabra no es válida");
                break;
            }
        }

        if(valida){
            palabra = palabra.toLowerCase();
            String[] arreglito = getDiccionario();
            int indice = find(arreglito,palabra);
            if(indice != -1){
                puntuar(palabra);
                return true;
            }else {
                System.out.println("Tu palabra no es válida, no esta en el diccionario");
                return false;
            }
        }
        return false;
    }

    private void puntuar(String palabra) {
        if(!palabras.contains(palabra)){
            int puntos = (int) Math.pow(palabra.length(),2);
            puntuación += puntos;
            palabras.add(0,palabra);
            System.out.println("Tu palabra es válida, sumas " + puntos + " puntos.");
        }else{
            System.out.println("Tu palabra es válida, pero ya fue ingresada, sumas 0 puntos");
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
            //System.out.println("mid: " + mid + ", lo: " + lo + ", hi: " + hi + ", arreglo: " + arr[mid] + " - elemento: " + elem);
            return mid;
        }
        if (cleanString(arr[mid]).compareTo(cleanString(elem)) < 0) { //Buscamos en la parte de la derecha
            //System.out.println("mid: " + mid + ", lo: " + lo + ", hi: " + hi + ", arreglo: " + arr[mid] + " - elemento: " + elem);
            return find(arr, elem, mid + 1, hi);
        } else { //Buscamos en la parte de la izquierda
            //System.out.println("mid: " + mid + ", lo: " + lo + ", hi: " + hi + ", arreglo: " + arr[mid] + " - elemento: " + elem);
            return find(arr, elem, lo, mid - 1);
        }
    }

    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }

}
