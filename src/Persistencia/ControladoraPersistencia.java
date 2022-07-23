
package Persistencia;

import Entidades.Autor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    AutorJpaController autorJPA = new AutorJpaController();
    
    public void crearAutor(Autor a){
        try {
            autorJPA.create(a);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
