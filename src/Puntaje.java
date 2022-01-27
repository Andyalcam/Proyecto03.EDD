import java.io.Serializable;
/**
 * Clase de puntajes para cada secuencia del juego Scrabble
 * @author Andrea Alvarado Camacho
 * @author Alfonso Mondragón Segoviano
 * @version 1.0
 */
public class Puntaje implements Serializable {

    List<String> secuencia;
    List<Integer> puntuaciones = new List<>();

    /**
     * Constructor pra un objeto de tipo Puntaje
     * @param secuencia - Lista con la secuencia de letras del juego
     * @param puntos - Puntos que se agrega a la Lista de puntuaciones que se han obtenido con esta secuencia
     */
    public Puntaje(List<String> secuencia, int puntos){
        this.secuencia = secuencia;
        puntuaciones.addScore(puntos);
    }

    /**
     * Metodo que regresa la lista con la secuencia de palabras del juego
     * @return Lista con la secuencia
     */
    public List<String> getSecuencia(){
        return secuencia;
    }

    /**
     * Metodo para añadir puntuaciones a la lista de puntuaciones de una secuencia
     * @param newPuntos - int con la puntuacion
     */
    public void addPuntos(int newPuntos){
        puntuaciones.addScore(newPuntos);
    }

    /**
     * Metodo que imprime los primeros tres puntajes de una secuencia de letras
     * @return Si la lista tiene mas de 3 elementos solo imprime los tres primeros, caso contrario imprime los que tenga
     */
    public List<Integer> mejoresTres(){
        List<Integer> aux = new List<>();
        if(puntuaciones.size() > 3){
            for (int i = 0; i < 3; i++) {
                aux.add(puntuaciones.get(i));
            }
            return aux;
        }else{
            return puntuaciones;
        }
    }

    /**
     * Metodo para imprimir en terminal un objeto de tipo Puntaje
     * @return Cadena con todos los datos del objeto
     */
    public String toString(){
        return "La secuencia " + secuencia + " tiene las puntuaciones: " + mejoresTres().toStringAux();
    }
}