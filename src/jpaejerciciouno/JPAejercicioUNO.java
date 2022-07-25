package jpaejerciciouno;

import Entidades.Autor;
import Persistencia.ControladoraPersistenciaAutor;
import Servicios.ServiciosAutor;
import Servicios.ServiciosEditorial;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JPAejercicioUNO {

    public static void main(String[] args) {
        ServiciosAutor servAutor = new ServiciosAutor();
        ServiciosEditorial servEditorial = new ServiciosEditorial();
        Scanner leer = new Scanner(System.in);

        int opcion;
        do {
            menu();
            switch (opcion = leer.nextInt()) {
                case 1: // MOSTRAR AUTOR
                    servAutor.mostrarAutores();
                    break;

                case 2: // CREAR AUTOR
                    try {
                        servAutor.crearAutor();
                    } catch (Exception ex) {
                        Logger.getLogger(JPAejercicioUNO.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
                case 3:// MODIFICAR AUTOR
                    try {
                        servAutor.modificarAutor();
                    } catch (Exception e) {
                    }
                    break;
                case 4:// BORRAR AUTOR
                    servAutor.borrarAutor();
                    break;
                case 5:// MOSTRAR EDITORIAL
                    servEditorial.mostrarEditorial();
                    break;
                case 6: {
                        // CREAR EDITORIAL
                    try {

                        servEditorial.crearEditorial();
                    } catch (Exception ex) {
                        Logger.getLogger(JPAejercicioUNO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;
                case 7:// MODIFICAR EDITORIAL
                    servEditorial.modificarEditorial();
                    break;
                case 8: // BORRAR EDITORIAL
                    servEditorial.borrarEditorial();
                    break;
                case 9:
                    
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                default:

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
        System.out.println("5 - Consultar Editorial");
        System.out.println("6 - Crear Editorial");
        System.out.println("7 - Modificar Editorial");
        System.out.println("8 - Eliminar Editorial");
        System.out.println("");
        System.out.println("9 - Buscar Autor por nombre");
        System.out.println("10 - Buscar libro por ISBN");
        System.out.println("11 - Buscar libro por titulo");
        System.out.println("12 - Buscar libro/s por nombre de  autor");
        System.out.println("13 - Buscar libro/s por editorial");

        System.out.println("0 - SALIR");
        System.out.print("OPCION: ");
    }

}
