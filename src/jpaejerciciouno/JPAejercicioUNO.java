package jpaejerciciouno;

import Entidades.Autor;
import Persistencia.ControladoraPersistenciaAutor;
import Servicios.ServiciosAutor;
import Servicios.ServiciosEditorial;
import Servicios.ServiciosLibro;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JPAejercicioUNO {

    public static void main(String[] args) {
        ServiciosAutor servAutor = new ServiciosAutor();
        ServiciosEditorial servEditorial = new ServiciosEditorial();
        ServiciosLibro servLibro = new ServiciosLibro();
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
                case 6: {// CREAR EDITORIAL
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
                case 9:// CONSULTAR LIBRO
                        servLibro.mostrarLibro();
                    break;
                case 10:{
                try {
                    //CREAR LIBRO
                    servLibro.crearLibro();
                } catch (Exception ex) {
                    Logger.getLogger(JPAejercicioUNO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                    break;
                case 11://MODIFICAR LIBRO
                    break;
                case 12://ELIMINAR LIBRO
                    break;
                case 13://Buscar Autor por nombre
                    servAutor.buscarPorNombre();
                    break;
                case 14://Buscar libro por ISBN
                        System.out.println(servLibro.buscarPorIsbn());
                    break;
                case 15://Buscar libro por titulo
                    break;
                case 16://Buscar libro/s por nombre de  autor
                    break;
                case 17://Buscar libro/s por nombre por editorial
                    break;
                default:

                    break;
            }

        } while (opcion != 0);
    }

    public static void menu() {
        System.out.println(" ------- AUTOR ------- ");
        System.out.println("1 - Consultar un Autor");
        System.out.println("2 - Crear un Autor");
        System.out.println("3 - Modificar un Autor");
        System.out.println("4 - Eliminar un Autor");
        System.out.println(" ------- EDITORIAL ------- ");
        System.out.println("5 - Consultar Editorial");
        System.out.println("6 - Crear Editorial");
        System.out.println("7 - Modificar Editorial");
        System.out.println("8 - Eliminar Editorial");
        System.out.println(" ------- LIBRO ------- ");
        System.out.println("9 - Consultar Libros");
        System.out.println("10 - Crear un libro");
        System.out.println("11 - Modificar un libro");
        System.out.println("12 - Eliminar un libro");
        System.out.println(" ------- BUSQUEDAS ------- ");
        System.out.println("13- Buscar Autor por nombre");
        System.out.println("14 - Buscar libro por ISBN");
        System.out.println("15 - Buscar libro por titulo");
        System.out.println("16 - Buscar libro/s por nombre de  autor");
        System.out.println("17 - Buscar libro/s por editorial");

        System.out.println("0 - SALIR");
        System.out.print("OPCION: ");
    }

}
