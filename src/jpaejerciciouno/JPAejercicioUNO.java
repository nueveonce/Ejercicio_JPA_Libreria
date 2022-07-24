package jpaejerciciouno;

import Entidades.Autor;
import Persistencia.ControladoraPersistenciaAutor;
import Servicios.ServiciosAutor;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JPAejercicioUNO {

    public static void main(String[] args) {
        ServiciosAutor a = new ServiciosAutor();
        Scanner leer = new Scanner(System.in);
     
        int opcion; 
        do {
            menu();
            switch (opcion = leer.nextInt()) {
                case 1:
                    break;
                case 2: {
                    try {
                        a.crearAutor();
                    } catch (Exception ex) {
                        Logger.getLogger(JPAejercicioUNO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 3:
                    try {
                        a.modificarAutor();
                    } catch (Exception e) {
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                default:
                    System.out.println("INGRESE UNA OPCION VALIDA");
                    break;
            }

        } while (opcion != 0);
    }

    public static void menu() {
        System.out.println("1 - Consultar un Autor");
        System.out.println("2 - Crear un Autor");
        System.out.println("3 - Modificar un Autor");
        System.out.println("4 - Eliminar un Autor");
        System.out.println("");
        System.out.println("5 - Consultar un Autor");
        System.out.println("6 - Crear un Autor");
        System.out.println("7 - Modificar un Autor");
        System.out.println("8 - Eliminar un Autor");
        System.out.println("");
        System.out.println("9 - Consultar un Autor");
        System.out.println("10 - Crear un Autor");
        System.out.println("11 - Modificar un Autor");
        System.out.println("12 - Eliminar un Autor");
        System.out.println("");
        System.out.println("0 - SALIR");
        System.out.print("OPCION: ");
    }

}
