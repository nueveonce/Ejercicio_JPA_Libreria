package jpaejerciciouno;

import Entidades.Autor;
import Persistencia.ControladoraPersistencia;

public class JPAejercicioUNO {

    public static void main(String[] args) {

        Autor titular = new Autor(1, "walter risso", true);

        ControladoraPersistencia control = new ControladoraPersistencia();
        control.crearAutor(titular);
    }

}
