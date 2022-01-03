import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.io.*;

public class Main extends JPanel{
    
    /*static Main main = new Main();
    static JFrame window = new JFrame("Maze");*/
    //static List<Element> list = new List<>();

    /*@Override
    public void paint(Graphics g) {
        super.paint(g);
        maze.paint(g);
    }

    public static void initComponents(){
        window.add(main);
        window.setSize(650,672);
        window.setLocation(350,40);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(false);
    }*/

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Scanner on = new Scanner(System.in);

        int opc;
        boolean volver = true, excep;
        //Utilidades util = new Utilidades();
        //binarySearchTree = util.leerObjetoArchivo("src/BancoDePreguntas/BancoDePreguntas.dat");

        try {
            System.out.println("\t*** BIENVENIDO ***");
            do {
                System.out.println("\nPresiona enter para jugar");
                in.nextLine();

                //util.escribirObjetosArchivo("src/BancoDePreguntas/BancoDePreguntas.dat", binarySearchTree);

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
                                //list.clear();
                                break;
                            case 2:
                                //binarySearchTree.preOrdenQuestions();
                                System.out.println("estadisticas");
                                break;
                            case 3:
                                //util.escribirObjetosArchivo("src/BancoDePreguntas/BancoDePreguntas.dat", binarySearchTree);
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
            System.out.println("Ingresa un diccionario válido");
        }
    }
}