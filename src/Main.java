import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Scanner on = new Scanner(System.in);

        List<String> jugadores = new List<>();

        int opc,numJugadores=0;
        boolean volver = true, excep, repe=true;

        try {
            System.out.println("\t*** BIENVENIDO ***");
            do {
                do {
                    try {
                        System.out.println("\nIngresa el numero de jugadores (1 - 4 jugadores)");
                        numJugadores = in.nextInt();
                        if (numJugadores <= 4 && numJugadores >= 1) {
                            repe = false;
                        } else {
                            System.out.println("Solo pueden jugar de 1 a 4 jugadores");
                            repe = true;
                        }
                    }catch (Exception e){
                        System.out.println("Debes ingresar un número");
                        repe = true;
                        in.next();
                    }
                }while (repe);
                for (int i=1; i<=numJugadores; i++){
                    jugadores.add(0, "Jugador " + i);
                }
                Juego juego = new Juego(jugadores);
                juego.iniciar();
                System.out.println("\nEl juego terminó...\t¿Qué deseas hacer?\n");

                excep = true;
                while (excep) {
                    try {
                        System.out.println("1. Volver a jugar");
                        System.out.println("2. Mostrar estadisticas");
                        System.out.println("3. Salir");
                        System.out.println("Ingresa una opción");

                        opc = on.nextInt();

                        switch (opc) {
                            case 1:
                                volver = true;
                                excep = false;
                                break;
                            case 2:
                                System.out.println("estadisticas");
                                break;
                            case 3:
                                volver = false;
                                excep = false;
                                break;
                            default:
                                System.out.println("Elige una opción del menu plis :c\n");
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("\tDebes ingresar un número\tIntentalo de nuevo\n");
                        on.next();
                        excep = true;
                    }
                }
            } while (volver);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Ingresa un diccionario válido");
        }
    }
}
