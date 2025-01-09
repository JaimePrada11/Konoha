package com.mycompany.konoha.Modelo.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BDConexion {

    private static final String URL = "jdbc:mysql://localhost:3306/Konoha";
    private static final String USER = "root";
    private static final String PASSWORD = "J12345";
    
    private static Connection con = null;

    private static final Logger logger = Logger.getLogger(BDConexion.class.getName());

    private BDConexion() {
    }

    public static synchronized Connection getConexion() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            
            return conexion;
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error trying to connect to database: " + e.getMessage());
            
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException closeEx) {
                    System.out.println("Error closing connection: " + closeEx.getMessage());
                }
            }
        }
        return null;
    }

    public static void closeConnection(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
