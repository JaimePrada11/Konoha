/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.konoha;

import com.mycompany.konoha.Modelo.Persistencia.BDConexion;
import java.sql.Connection;

/**
 *
 * @author camper
 */
public class Konoha {

    public static void main(String[] args) {
        
        Connection con = BDConexion.getConexion();
        
        
    }
}
