
package com.mycompany.konoha.Controlador;

import com.mycompany.konoha.Modelo.Clases.Aldea;
import com.mycompany.konoha.Modelo.Clases.Ninja;
import com.mycompany.konoha.Modelo.Clases.Rango;
import com.mycompany.konoha.Modelo.Persistencia.BDConexion;
import com.mycompany.konoha.Modelo.Persistencia.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NinjaControlador {
    
    public static boolean registarNinja(String nombre, String idIdentificacion, Aldea aldea, Rango rango) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        
        String query = "INSERT INTO Ninjas (Nombre, idIdentificacion, IDRango, IDAldea) VALUES (?, ?, ?, ?);";
        return CRUD.insertarDB(query, nombre, rango.getIdRango(), aldea.getIdAldea());
    }

    public static boolean actualizarNinja(Integer id, String nombre, String idIdentificacion, Aldea aldea, Rango rango) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());

        String query = "UPDATE Ninjas SET Nombre = '"+ nombre + "', idIdentificacion= +'"+ idIdentificacion +"', IDRango='"
                + rango.getIdRango() +"',IDAldea='" + aldea.getIdAldea() +"'  WHERE IDNinja = ?;";
        
        
        return CRUD.actualizarDB(query, id);
    }

    public static boolean eliminarNinja(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String query = "DELETE FROM Ninjas WHERE IDNinja= ?;";
        return CRUD.eliminarDB(query, id);
    }

    public static Ninja obtenerHabilidad(Integer id) throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        String sql = "SELECT * FROM Ninjas WHERE IDNinja=" + id + ";";
        ResultSet rs = CRUD.consultaDB(sql);
        Ninja n1 = new Ninja();

        try {
            if (rs.next()) {
                n1.setIdNinja(rs.getInt("IDHabilidad"));
                n1.setNombre(rs.getString("Nombre"));
                n1.setIdIdentificacion(rs.getString("idIdentificacion"));
                int rango = rs.getInt("IDRango");
                Rango r = RangoControlador.obtenerRango(rango);
                n1.setRango(r);
                
                int aldea = rs.getInt("IDAldea");
                Aldea a = AldeaControlador.obtenerAldea(aldea);
                n1.setAldea(a);
                

                CRUD.closeConnection();
            } else {
                CRUD.closeConnection();
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return n1;
    }

    
        public static List<Ninja> listarNinjas() throws SQLException {
        CRUD.setConnection(BDConexion.getConexion());
        List<Ninja> listaNinjas = new ArrayList<>();
        try {
            String sql = "SELECT * from Ninjas";

            ResultSet rs = CRUD.consultaDB(sql);

            while (rs.next()) {
                Ninja n1 = new Ninja();
                n1.setIdNinja(rs.getInt("IDHabilidad"));
                n1.setNombre(rs.getString("Nombre"));
                n1.setIdIdentificacion(rs.getString("idIdentificacion"));
                int rango = rs.getInt("IDRango");
                Rango r = RangoControlador.obtenerRango(rango);
                n1.setRango(r);
                
                int aldea = rs.getInt("IDAldea");
                Aldea a = AldeaControlador.obtenerAldea(aldea);
                n1.setAldea(a);
                
                
                listaNinjas.add(n1);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            CRUD.closeConnection();
        }

        return listaNinjas;
    }
    
}
