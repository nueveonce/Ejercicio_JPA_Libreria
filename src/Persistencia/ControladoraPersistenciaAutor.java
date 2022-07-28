
package Persistencia;

import Entidades.Autor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistenciaAutor {
    
    AutorJpaController autorJPA = new AutorJpaController();
    
    public void crearAutor(Autor a){
        try {
            autorJPA.create(a);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistenciaAutor.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
    }
}
