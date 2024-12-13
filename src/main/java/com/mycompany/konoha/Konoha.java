/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.konoha;

import com.mycompany.konoha.Controlador.HabilidadControlador;
import com.mycompany.konoha.Modelo.Clases.Habilidad;
import com.mycompany.konoha.Modelo.Persistencia.BDConexion;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author camper
 */
public class Konoha {

    public static void main(String[] args) throws SQLException {
        
        Connection con = BDConexion.getConexion();

    }
}
