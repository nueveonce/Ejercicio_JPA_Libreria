package Servicios;

import Entidades.Autor;
import Persistencia.AutorJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServiciosAutor {

    AutorJpaController autorJPA = new AutorJpaController();

    public void crearAutor() throws Exception {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre del Autor");
        String nombre = leer.next();

        Autor a = new Autor(1, nombre, true);
        autorJPA.create(a);

    }

    public void modificarAutor() {
        Scanner leer= new Scanner(System.in);
        mostrarAutores();
        System.out.println("INGRESE EL AUTOR A EDITAR");
        
    }
    public void mostrarAutores(){
        
        List<Autor> autor= new ArrayList();
        autor=autorJPA.findAutorEntities();
        for (Autor autor1 : autor) {
            System.out.println(autor1);            
        }
    }
}
