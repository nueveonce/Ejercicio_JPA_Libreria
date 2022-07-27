package Servicios;

import Entidades.Autor;
import Persistencia.AutorJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiciosAutor {

    AutorJpaController autorJPA = new AutorJpaController();
    Scanner leer = new Scanner(System.in);

    public ServiciosAutor() {
    }

    public void crearAutor() throws Exception {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre del Autor");
        String nombre = leer.next();

        Autor a = new Autor(1, nombre, true);
        autorJPA.create(a);

    }

    public void modificarAutor() {
        Autor a = new Autor();
        mostrarAutores();
        System.out.println("INGRESE EL AUTOR A EDITAR");
        Integer buscar = leer.nextInt();

        a = autorJPA.findAutor(buscar);
        System.out.println("Ingrese el nuevo nombre");
        String nombre = leer.next();
        a.setNombre(nombre);
        try {
            autorJPA.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarAutores() {

        List<Autor> autor = new ArrayList();
        autor = autorJPA.findAutorEntities();
        for (Autor autor1 : autor) {
            if (autor1.getAlta().equals(true)) {
                System.out.println(autor1);
            }
        }
    }

    public void borrarAutor() {
        Autor a = new Autor();
        mostrarAutores();
        System.out.println("INGRESE EL AUTOR A BORRAR");
        Integer buscar = leer.nextInt();

        a = autorJPA.findAutor(buscar);

        a.setAlta(false);
        try {
            autorJPA.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscarPorNombre() {
        System.out.println("Ingrese el Nombre del Autor a buscar: ");
        String nombre = leer.next();
        List<Autor> aut = autorJPA.findAutorNombre(nombre);
        for (Autor autor : aut) {
            System.out.println(autor.toString());
        }

    }
    
    public Autor buscarPorId(Integer id){    
        return autorJPA.findAutor(id);                   
    }
        

}
