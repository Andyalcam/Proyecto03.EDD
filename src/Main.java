import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase main encargada de simular el juego para interactuar con el usuario
 * @author Andrea Alvarado Camacho
 * @author Alfonso Mondragón Segoviano
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        Scanner on = new Scanner(System.in);

        int opc;
        boolean excep;

        try {
            System.out.println("\t*** BIENVENIDO ***");
                excep = true;
                while (excep) {
                    Juego juego = new Juego();
                    try {
                        System.out.println("\n\t\t*** Menu ***");
                        System.out.println("--------------------------------------------");
                        System.out.println("1. Jugar");
                        System.out.println("2. Mostrar estadisticas");
                        System.out.println("3. Salir");
                        System.out.println("--------------------------------------------");
                        System.out.println("Ingresa una opción");

                        opc = on.nextInt();

                        switch (opc) {
                            case 1:
                                juego.iniciar();
                                System.out.println("\nEl juego terminó...\t¿Qué deseas hacer?\n");
                                break;
                            case 2:
                                System.out.println("\n" + juego.obtenerEstadisticas());
                                break;
                            case 3:
                                System.out.println("Ayoos :3");
                                excep = false;
                                break;
                            default:
                                System.out.println("Elige una opción del menu plis :c\n");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(e+"\tDebes ingresar un número\tIntentalo de nuevo\n");
                        on.next();
                    }
                }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Ingresa un diccionario válido");
        }
    }
}
