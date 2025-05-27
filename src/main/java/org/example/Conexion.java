package org.example;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String url= "jdbc:mysql://localhost:3306/jpaprueba";
    private static final String usuario = "root";
    private static final String contrasenia = "";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(url, usuario, contrasenia);
        } catch (SQLException e) {
            System.out.println("Error al conectar la base de datos: ");
            e.printStackTrace();
            return null;
        }
    }
}
