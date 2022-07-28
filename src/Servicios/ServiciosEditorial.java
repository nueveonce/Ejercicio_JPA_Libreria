package Servicios;

import Entidades.Editorial;
import Persistencia.EditorialJpaController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiciosEditorial {

    EditorialJpaController editorialJPA = new EditorialJpaController();
    Scanner leer = new Scanner(System.in);

    public void crearEditorial() throws Exception {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el nombre de la editorial");
        String nombre = leer.next();

        Editorial ed = new Editorial(1, nombre, true);
        editorialJPA.create(ed);

    }

    public void modificarEditorial() {
        Editorial a = new Editorial();
        mostrarEditorial();
        System.out.println("INGRESE LA EDITORIAL A EDITAR");
        Integer buscar = leer.nextInt();

        a = editorialJPA.findEditorial(buscar);
        System.out.println("Ingrese el nuevo nombre");
        String nombre = leer.next();
        a.setNombre(nombre);
        try {
            editorialJPA.edit(a);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    public void mostrarEditorial() {

        List<Editorial> editorial = new ArrayList();
        editorial = editorialJPA.findEditorialEntities();
        for (Editorial editorial1 : editorial) {
            if (editorial1.getAlta().equals(true)) {
                System.out.println(editorial1);
            }
        }
    }

    public void borrarEditorial() {
        Editorial ed = new Editorial();
        mostrarEditorial();
        System.out.println("INGRESE EL AUTOR A BORRAR");
        Integer buscar = leer.nextInt();

        ed = editorialJPA.findEditorial(buscar);

        ed.setAlta(false);
        try {
            editorialJPA.edit(ed);
        } catch (Exception ex) {
            Logger.getLogger(ServiciosAutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public Editorial buscarPorId(Integer editorialId){
      return editorialJPA.findEditorial(editorialId);
  }
}
