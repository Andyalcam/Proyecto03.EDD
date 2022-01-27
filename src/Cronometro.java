/**
 * Clase cronometro encargada de correr por cierto tiempo un hilo
 * @author Andrea Alvarado Camacho
 * @author Alfonso Mondragón Segoviano
 * @version 1.0
 */
public class Cronometro extends Thread{

    /**
     * Hilo que simulará el cronometro.
     */
    @Override
    public void run(){
        for(int i = 0; i < 60; i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        System.out.println("El tiempo se terminó, presiona enter.");
    }

}