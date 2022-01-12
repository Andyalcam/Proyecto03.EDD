public class Cronometro extends Thread{

    @Override
    public void run(){
        for(int i = 0; i < 10; i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }

    }

}