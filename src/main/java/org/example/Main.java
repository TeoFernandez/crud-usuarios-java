package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        //Crear nuevo usuario
        Usuario nuevo = new Usuario("Teo Fernández", "teo@gmail.com");
        dao.agregarUsuario(nuevo);
        Usuario nuevo1 = new Usuario("Nicolas Garcia", "nicolas@gmail.com");
        dao.agregarUsuario(nuevo1);

        //Mostrar todos
        List<Usuario> usuarios = dao.obtenerUsuarios();
        System.out.println("\nLista de usuarios:");

        for(Usuario u : usuarios){
            System.out.println(u.getId() + " - " +
                                u.getNombre() + " - " +
                                u.getEmail() + " - ");
        }

        //Actualizar usuario (por ejemplo el ID 1)
        Usuario actualizado = new Usuario(1,"Juan Perez", "nuevo@gmail.com");
        dao.actualizarUsuarios(actualizado);

        //Eliminar usuario (por ejemplo, el ID 2)
        dao.eliminarUsuario(3);
    }
}