/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.konoha.Controlador;

import com.mycompany.konoha.Modelo.Clases.Mision;
import com.mycompany.konoha.Modelo.Clases.Ninja;
import com.mycompany.konoha.Modelo.Clases.Rango;
import com.mycompany.konoha.Modelo.Persistencia.BDConexion;
import com.mycompany.konoha.Modelo.Persistencia.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camper
 */
public class MisionControlador {
    
     public static boolean registarMision(String descripcion, Rango rango, String recompensas, LocalDate fechaInicio) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        
        String query = "INSERT INTO Misiones(Descripcion, IDRango, Recompensa,FechaInicio,FechaFin  ) VALUES (?, ?,?,?);";
        return CRUD.insertarDB(query, descripcion, rango.getIdRango(), recompensas, fechaInicio);
    }

    public static boolean actualizarNinja(Integer id, String descripcion, Rango rango, String recompensas, LocalDate fechaInicio) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());

        String query = "UPDATE Misiones SET Descripcion = '"+ descripcion + "', IDRango= +'"+ rango.getIdRango() +"', Recompensas='"
                + recompensas+"',fechaInicio='" +rango.getIdRango() +"'  WHERE IDMision = ?;";
        return CRUD.actualizarDB(query, id);
    }

    public static boolean eliminarNinja(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String query = "DELETE FROM Misiones WHERE IDMision= ?;";
        return CRUD.eliminarDB(query, id);
    }

    public static Mision obtenerHabilidad(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String sql = "SELECT * FROM Misiones WHERE IDMision=" + id + ";";
        ResultSet rs = CRUD.consultaDB(sql);
        Mision m1 = new Mision();

        try {
            if (rs.next()) {
                m1.setIdMision(rs.getInt("IDHabilidad"));
                m1.setDescripcion(rs.getString("Descripcion"));
                m1.setRecompensas(rs.getString("Recompensa"));
                int rango = rs.getInt("IDRango");
                Rango r = RangoControlador.obtenerRango(rango);
                m1.setRango(r);
                
                m1.setFechaInicio(rs.getDate("FechaInicio").toLocalDate());
                m1.setFechaFin(rs.getDate("FechaFin").toLocalDate());

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return m1;
    }

    
        public static List<Mision> listarMisiones() throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        List<Mision> listaMisiones = new ArrayList<>();
        try {
            String sql = "SELECT * from Misiones";

            ResultSet rs = CRUD.consultaDB(sql);

            while (rs.next()) {
                Mision m1 = new Mision();
                m1.setIdMision(rs.getInt("IDHabilidad"));
                m1.setDescripcion(rs.getString("Descripcion"));
                m1.setRecompensas(rs.getString("Recompensa"));
                int rango = rs.getInt("IDRango");
                Rango r = RangoControlador.obtenerRango(rango);
                m1.setRango(r);
                
                m1.setFechaInicio(rs.getDate("FechaInicio").toLocalDate());
                m1.setFechaFin(rs.getDate("FechaFin").toLocalDate());

                
                
                listaMisiones.add(m1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return listaMisiones;
    }
    
}
