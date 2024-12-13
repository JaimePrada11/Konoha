package com.mycompany.konoha.Modelo.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConexion {

    private static final String url = "jdbc:mysql://localhost:3306/Konoha";
    private static final String user = "campus2023";
    private static final String password = "campus2023";
    private static Connection con = null;

    private BDConexion() {
    }

    public static Connection getConexion() {

        try {
            con = DriverManager.getConnection(url, user, password);
            if (con != null && con.isValid(2)) {
            } else {
                System.out.println("Conexión fallida o no válida.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al establecer la conexión: " + ex.getMessage());
            ex.printStackTrace();
        }

        return con;
    }

    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
