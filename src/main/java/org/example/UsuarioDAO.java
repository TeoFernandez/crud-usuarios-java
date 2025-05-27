package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void agregarUsuario(Usuario usuario){
        String sql = "INSERT INTO usuarios (nombre, email) VALUES  (?, ?)";

        try(Connection conn = Conexion.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.executeUpdate();
            System.out.println("Usuario agregado correctamente.");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> obtenerUsuarios(){
        List<Usuario>lista = new ArrayList<>();
        String sql= "SELECT * FROM usuarios";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){
                Usuario u = new Usuario(rs.getInt("id"),
                                        rs.getString("nombre"),
                                        rs.getString("email"));
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizarUsuarios(Usuario usuario){
        String sql = "UPDATE usuarios SET nombre=?, email=? WHERE id=?";

        try(Connection conn = Conexion.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setInt(3, usuario.getId());
            stmt.executeUpdate();
            System.out.println("Usuario Actualizado.");

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuario(int id){
        String sql= "DELATE FROM usuarios WHERE id=?";

        try(Connection conn = Conexion.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1,id);
            stmt.executeUpdate();
            System.out.println("Usuario eliminado.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
