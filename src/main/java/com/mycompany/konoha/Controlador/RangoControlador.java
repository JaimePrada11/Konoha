
package com.mycompany.konoha.Controlador;

import com.mycompany.konoha.Modelo.Clases.Rango;
import com.mycompany.konoha.Modelo.Persistencia.BDConexion;
import com.mycompany.konoha.Modelo.Persistencia.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RangoControlador {
    
        public static boolean registarRango(String nombre) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());

        String query = "INSERT INTO RangosNinjas (Nombre) VALUES (?);";
        return CRUD.insertarDB(query, nombre);
    }

    public static boolean actualizarRango(Integer id, String nombre) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());

        String query = "UPDATE Aldeas SET RangosNinjas = '" + nombre + "' WHERE IDRango = ? ;";
        return CRUD.actualizarDB(query, id);
    }

    public static boolean eliminarRango(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String query = "DELETE FROM RangosNinjas WHERE IDRango= ?;";
        return CRUD.eliminarDB(query, id);
    }

    public static Rango obtenerRango(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String sql = "SELECT * FROM RangosNinjas WHERE IDRango=" + id + ";";
        ResultSet rs = CRUD.consultaDB(sql);
        Rango h1 = new Rango();

        try {
            if (rs.next()) {
                h1.setIdRango(rs.getInt("IDRango"));
                h1.setNombre(rs.getString("Nombre"));

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return h1;
    }

    
    public static List<Rango> listarRangos() throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        List<Rango> listaRangos = new ArrayList<>();
        try {
            String sql = "SELECT * from RangosNinjas";

            ResultSet rs = CRUD.consultaDB(sql);

            while (rs.next()) {
                Rango h1 = new Rango();
                h1.setIdRango(rs.getInt("IDRango"));
                h1.setNombre(rs.getString("Nombre"));
                listaRangos.add(h1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return listaRangos;
    }
    
}
