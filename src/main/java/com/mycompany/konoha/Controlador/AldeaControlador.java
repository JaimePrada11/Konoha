package com.mycompany.konoha.Controlador;

import com.mycompany.konoha.Modelo.Clases.Aldea;
import com.mycompany.konoha.Modelo.Persistencia.BDConexion;
import com.mycompany.konoha.Modelo.Persistencia.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;


public class AldeaControlador {

    public static boolean registarAldea(String nombre) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());

        String query = "INSERT INTO Aldeas (Nombre) VALUES (?);";
        return CRUD.insertarDB(query, nombre);
    }

    public static boolean actualizarAldea(Integer id, String nombre) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());

        String query = "UPDATE Aldeas SET Nombre = '" + nombre + "' WHERE IDAldea = ? ;";
        return CRUD.actualizarDB(query, id);
    }

    public static boolean eliminarAldea(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String query = "DELETE FROM Aldeas WHERE IDAldea= ?;";
        return CRUD.eliminarDB(query, id);
    }

    public static Aldea obtenerAldea(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String sql = "SELECT * FROM Aldeas WHERE IDAldea=" + id + ";";
        ResultSet rs = CRUD.consultaDB(sql);
        Aldea h1 = new Aldea();

        try {
            if (rs.next()) {
                h1.setIdAldea(rs.getInt("IDAldea"));
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

    public static List<Aldea> listarAldeas() throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        List<Aldea> listaAldeas = new ArrayList<>();
        try {
            String sql = "SELECT * from Aldeas";

            ResultSet rs = CRUD.consultaDB(sql);

            while (rs.next()) {
                Aldea h1 = new Aldea();
                h1.setIdAldea(rs.getInt("IDAldea"));
                h1.setNombre(rs.getString("Nombre"));
                listaAldeas.add(h1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return listaAldeas.stream()
                .sorted(Comparator.comparing(Aldea::getIdAldea)) 
                .collect(Collectors.toList());
    }
}
