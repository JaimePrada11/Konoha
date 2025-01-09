package com.mycompany.konoha.Modelo.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BDConexion {

    private static final String url = "jdbc:mysql://localhost:3306/Konoha";
    private static final String user = "root";
    private static final String password = "J12345";
    
    private static Connection con = null;

    private static final Logger logger = Logger.getLogger(BDConexion.class.getName());

    private BDConexion() {
    }

    public static synchronized Connection getConexion() {
        try {
            if (con == null || con.isClosed() || !con.isValid(2)) {
                con = DriverManager.getConnection(url, user, password);
                logger.log(Level.INFO, "Conexión establecida correctamente.");
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al establecer la conexión: {0}", ex.getMessage());
            ex.printStackTrace();
        }

        return con;
    }

    public static void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                logger.log(Level.INFO, "Conexión cerrada correctamente.");
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Error al cerrar la conexión: {0}", ex.getMessage());
            ex.printStackTrace();
        }
    }
}
