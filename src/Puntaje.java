import java.io.Serializable;

public class Puntaje implements Serializable {

    List<String> secuencia;
    List<Integer> puntuaciones = new List<>();

    public Puntaje(List<String> secuencia, int puntos){
        this.secuencia = secuencia;
        puntuaciones.add(puntos);
    }

    public List<String> getSecuencia(){
        return secuencia;
    }

    public void addPuntos(int newPuntos){
        puntuaciones.add(newPuntos);
    }

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

    public String toString(){
        return "La secuencia " + secuencia + " tiene las puntuaciones: " + mejoresTres().toStringAux();
    }
}