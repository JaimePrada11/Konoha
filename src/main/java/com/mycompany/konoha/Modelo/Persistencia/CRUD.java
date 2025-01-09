
package com.mycompany.konoha.Modelo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class CRUD {

    public static Connection con; 
    public static Statement stmt = null;
    public static ResultSet rs = null; 

    public static Connection setConnection(Connection connection) throws SQLException {
        if (connection == null) {
            throw new IllegalArgumentException("La conexión proporcionada es nula.");
        }
        if (!connection.isValid(2)) {
            throw new IllegalArgumentException("La conexión proporcionada no es válida.");
        }
        CRUD.con = connection;
        return connection;
    }

    public static Connection getConnection() {
        return con;
    }

    private static void closeConnection(Connection con) {
        if (con != null) {
            try {
                if (!con.isClosed()) { 
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error al cerrar la conexión", ex);
            }
        }
    }

    public static ResultSet consultaDB(String query, Object... params) {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error en la consulta SELECT: " + query, e);
            return null;
        }
    }

    public static boolean insertarDB(String query, Object... params) {
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error en la consulta INSERT: " + query, ex);
            return false;
        }
    }

    public static boolean eliminarDB(String query, Object... params) {
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error en la consulta DELETE: " + query, ex);
            return false;
        }
    }

    public static boolean actualizarDB(String query, Object... params) {
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error en la consulta UPDATE: " + query, ex);
            return false;
        }
    }

    public static boolean setAutoCommitDB(boolean param) {
        try {
            if (con != null) {
                con.setAutoCommit(param);
            } else {
                throw new SQLException("La conexión no ha sido inicializada.");
            }
            return true;
        } catch (SQLException sqlex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error al establecer el modo autoCommit", sqlex);
            return false;
        }
    }

    public static boolean commitDB() {
        try {
            if (con != null) {
                con.commit();
                return true;
            } else {
                throw new SQLException("La conexión no ha sido inicializada.");
            }
        } catch (SQLException sqlex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error al hacer commit", sqlex);
            return false;
        }
    }

    public static boolean rollbackDB() {
        try {
            if (con != null) {
                con.rollback();
                return true;
            } else {
                throw new SQLException("La conexión no ha sido inicializada.");
            }
        } catch (SQLException sqlex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, "Error al hacer rollback", sqlex);
            return false;
        }
    }

    public static void closeConnection() {
        closeConnection(con);
    }
}
