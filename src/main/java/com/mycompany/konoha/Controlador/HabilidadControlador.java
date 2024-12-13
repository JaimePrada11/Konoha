package com.mycompany.konoha.Controlador;

import com.mycompany.konoha.Modelo.Persistencia.BDConexion;
import com.mycompany.konoha.Modelo.Persistencia.CRUD;
import com.mycompany.konoha.Modelo.Clases.Habilidad;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabilidadControlador {

    public static boolean registarHabilidad(String nombre) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());

        String query = "INSERT INTO Habilidades (Nombre) VALUES (?);";
        return CRUD.insertarDB(query, nombre);
    }

    public static boolean actualizarHabilidad(Integer id, String nombre) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());

        String query = "UPDATE Habilidades SET Nombre = ?, WHERE IDHabilidad = ?;";
        return CRUD.actualizarDB(query, id, nombre);
    }

    public static boolean eliminarHabilidad(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String query = "DELETE FROM Habilidades WHERE IDHabilidad= ?;";
        return CRUD.eliminarDB(query, id);
    }

    public static Habilidad obtenerHabilidad(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String sql = "SELECT * FROM Habilidades WHERE IDHabilidad=" + id + ";";
        ResultSet rs = CRUD.consultaDB(sql);
        Habilidad h1 = new Habilidad();

        try {
            if (rs.next()) {
                h1.setIdHabilidad(rs.getInt("IDHabilidad"));
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

    
    public static List<Habilidad> listarAnimales() throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        List<Habilidad> listaHabilidaes = new ArrayList<>();
        try {
            String sql = "SELECT * from Habilidades";

            ResultSet rs = CRUD.consultaDB(sql);

            while (rs.next()) {
                Habilidad h1 = new Habilidad();
                h1.setIdHabilidad(rs.getInt("IDHabilidad"));
                h1.setNombre(rs.getString("Nombre"));
                listaHabilidaes.add(h1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return listaHabilidaes;
    }

}
