
package Servicios;

import Entidades.Libro;
import Persistencia.LibroJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServiciosLibro {
    LibroJpaController libroJPA= new LibroJpaController();
    
    Scanner leer = new Scanner(System.in);

    public void crearLibro() throws Exception {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre de la editorial");
        String nombre = leer.next();

        Libro ed = new Libro();
        libroJPA.create(ed);

    }

    public void modificarLibro() {
        Libro a = new Libro();
        mostrarLibro();
        System.out.println("INGRESE EL ID DEL LIBRO A EDITAR");
        Long buscar = leer.nextLong();

        a = libroJPA.findLibro(buscar);
        System.out.println("Ingrese el nuevo nombre");
        String titulo = leer.next();
        a.setTitulo(titulo);
        try {
            libroJPA.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarLibro() {

        List<Libro> libro = new ArrayList();
        libro = libroJPA.findLibroEntities();
        for (Libro libro1 : libro) {
            if (libro1.getAlta().equals(true)) {
                System.out.println(libro1);
            }
        }
    }

    public void borrarLibro() {
        Libro lib = new Libro();
        mostrarLibro();
        System.out.println("INGRESE EL AUTOR A BORRAR");
        Long buscar = leer.nextLong();

        lib = libroJPA.findLibro(buscar);

        lib.setAlta(false);
        try {
            libroJPA.edit(lib);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
