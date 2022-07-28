
package Servicios;

import Entidades.Autor;
import Entidades.Editorial;
import Entidades.Libro;
import Persistencia.LibroJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger; 


public class ServiciosLibro {
    LibroJpaController libroJPA= new LibroJpaController();    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public void crearLibro() throws Exception {
        ServiciosAutor servAutor= new ServiciosAutor();
        ServiciosEditorial servEditorial= new ServiciosEditorial();        

        System.out.print("Ingrese el titulo del libro: ");
        String nombre = leer.next();
        
        System.out.print("Ingrese el año del libro (AAAA): ");
        Integer anio = leer.nextInt();
        
        System.out.print("Ingrese la cantidad de Ejemplares");
        Integer ejemplares = leer.nextInt();        
              
        System.out.print("Ingrese el ID del autor");
        servAutor.mostrarAutores();
        Integer autorId= leer.nextInt();
        Autor autor= servAutor.buscarPorId(autorId);
                
        System.out.print("Ingrese el ID la Editorial");
        servEditorial.mostrarEditorial();
        Integer editorialId= leer.nextInt();
        Editorial editorial= servEditorial.buscarPorId(editorialId);
        System.out.println("-------------");
        System.out.println(editorial.toString());
        System.out.println("-------------");
        Libro ed = new Libro(nombre, anio, ejemplares, 0, 0, true, autor, editorial);
        libroJPA.createBook(ed);

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
    public Libro buscarPorIsbn(){
        System.out.println("Ingrese el Libro a buscar por ISBN: ");
        Long isbn=leer.nextLong();
        Libro a = libroJPA.findLibro(isbn);
        return a;
    }
            
}
