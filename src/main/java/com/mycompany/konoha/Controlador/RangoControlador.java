
package com.mycompany.konoha.Controlador;

import com.mycompany.konoha.Modelo.Clases.Rango;
import com.mycompany.konoha.Modelo.Persistencia.BDConexion;
import com.mycompany.konoha.Modelo.Persistencia.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class RangoControlador {
    
        public static boolean crearRango(String nombre, Rango.Tipo tipo) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());

        String query = "INSERT INTO Rangos(Nombre, Tipo) VALUES (?,?);";
        return CRUD.insertarDB(query, nombre, tipo.name());
    }

    public static boolean actualizarRango(Integer id, String nombre, Rango.Tipo tipo) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());

        String query = "UPDATE Rangos SET Nombre = ?, Tipo = ? WHERE IDRango = ?;";
        return CRUD.actualizarDB(query, nombre, tipo.name(), id);
    }

    public static boolean eliminarRango(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String query = "DELETE FROM Rangos WHERE IDRango = ?;";
        return CRUD.eliminarDB(query, id); 
    }

    public static Rango obtenerRango(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String sql = "SELECT * FROM Rangos WHERE IDRango =" + id + ";";
        ResultSet rs = CRUD.consultaDB(sql);
        Rango r1 = new Rango();

        try {
            if (rs.next()) {
                r1.setIdRango(rs.getInt("IDRango"));
                r1.setNombre(rs.getString("Nombre"));
                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return r1;
    }

    
    public static List<Rango> listarRangos() throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        List<Rango> listaRangos = new ArrayList<>();
        try {
            String sql = "SELECT * from Rangos";

            ResultSet rs = CRUD.consultaDB(sql);

            while (rs.next()) {
                Rango rango = new Rango();
                rango.setIdRango(rs.getInt("IDRango"));
                rango.setNombre(rs.getString("Nombre"));
                listaRangos.add(rango);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return listaRangos.stream()
                .filter(r -> r.getNombre() != null && !r.getNombre().isEmpty())
                .collect(Collectors.toList());
    }
    
}
