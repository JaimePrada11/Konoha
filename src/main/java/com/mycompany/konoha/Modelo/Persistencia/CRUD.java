
package com.mycompany.konoha.Modelo.Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CRUD {

    private static Connection con;
    private static final Logger LOGGER = Logger.getLogger(CRUD.class.getName());

    public static void setConnection(Connection connection) throws SQLException {
        if (connection == null || !connection.isValid(2)) {
            throw new IllegalArgumentException("La conexión proporcionada es nula o no es válida.");
        }
        con = connection;
    }

    public static ResultSet consultaDB(String query, Object... params) {
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error en la consulta SELECT", e);
            return null;
        }
    }

    public static boolean insertarDB(String query, Object... params) {
        return executeUpdate(query, params);
    }

    public static boolean borrarBD(String query, Object... params) {
        return executeUpdate(query, params);
    }

    public static boolean actualizarBD(String query, Object... params) {
        return executeUpdate(query, params);
    }

    private static boolean executeUpdate(String query, Object... params) {
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error en la consulta UPDATE/INSERT/DELETE", ex);
            return false;
        }
    }

    public static boolean setAutoCommitDB(boolean param) {
        try {
            if (con != null) {
                con.setAutoCommit(param);
                return true;
            } else {
                throw new SQLException("Conexión no inicializada.");
            }
        } catch (SQLException sqlex) {
            LOGGER.log(Level.SEVERE, "Error configurando autoCommit", sqlex);
            return false;
        }
    }

    public static boolean commitDB() {
        try {
            if (con != null) {
                con.commit();
                return true;
            } else {
                throw new SQLException("Conexión no inicializada.");
            }
        } catch (SQLException sqlex) {
            LOGGER.log(Level.SEVERE, "Error al hacer commit", sqlex);
            return false;
        }
    }

    public static boolean rollbackDB() {
        try {
            if (con != null) {
                con.rollback();
                return true;
            } else {
                throw new SQLException("Conexión no inicializada.");
            }
        } catch (SQLException sqlex) {
            LOGGER.log(Level.SEVERE, "Error al hacer rollback", sqlex);
            return false;
        }
    }

    public static boolean executeCommit(String statement) {
        if (setAutoCommitDB(false)) {
            if (executeUpdate(statement)) {
                if (commitDB()) {
                    BDConexion.closeConnection();
                    return true;
                }
            }
            rollbackDB();
            BDConexion.closeConnection();
        }
        return false;
    }
}