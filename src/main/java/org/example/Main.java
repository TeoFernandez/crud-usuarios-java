package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== MENÚ CRUD DE USUARIOS =====");
            System.out.println("1. Agregar usuario");
            System.out.println("2. Ver todos los usuarios");
            System.out.println("3. Editar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el email: ");
                    String email = scanner.nextLine();
                    dao.agregarUsuario(new Usuario(nombre, email));
                    break;

                case 2:
                    List<Usuario> usuarios = dao.obtenerUsuarios();
                    System.out.println("\n--- Lista de Usuarios ---");
                    for (Usuario u : usuarios) {
                        System.out.println("ID: " + u.getId() + " | Nombre: " + u.getNombre() + " | Email: " + u.getEmail());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID del usuario a editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo email: ");
                    String nuevoEmail = scanner.nextLine();
                    dao.actualizarUsuarios(new Usuario(idEditar, nuevoNombre, nuevoEmail));
                    break;

                case 4:
                    System.out.print("Ingrese el ID del usuario a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    dao.eliminarUsuario(idEliminar);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("❌ Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}