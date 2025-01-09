/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.konoha;

import com.mycompany.konoha.Controlador.AldeaControlador;
import com.mycompany.konoha.Controlador.HabilidadControlador;
import com.mycompany.konoha.Controlador.NinjaControlador;
import com.mycompany.konoha.Controlador.RangoControlador;
import com.mycompany.konoha.Modelo.Clases.Habilidad;
import com.mycompany.konoha.Modelo.Persistencia.BDConexion;
import com.mycompany.konoha.Vista.MisionMenu;
import com.mycompany.konoha.Vista.NinjaMenu;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFileChooser;
import com.mycompany.konoha.Modelo.Clases.Ninja;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Konoha {

    public static void main(String[] args) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {

        Connection con = BDConexion.getConexion();
//         String path = "C:\\Users\\LENOVO\\Documents\\NetBeansProjects\\Konoha";  // Cambia esta ruta por la que desees
//
//        String nombreArchivo = "miArchivo.txt";
//
//        File miDirectorio = new File(path);
//
//        if (!miDirectorio.exists()) {
//            System.out.println("El directorio no existe. Creando el directorio...");
//            miDirectorio.mkdirs();  
//        }
//
//        File archivo = new File(miDirectorio, nombreArchivo);
//
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
//            List<Ninja> ninjas = NinjaControlador.listarNinjas();
//            
//            oos.writeObject(ninjas);
//            System.out.println("Lista de ninjas escrita correctamente en el archivo.");
//        } catch (IOException e) {
//            System.out.println("Ocurrió un error al escribir en el archivo.");
//            e.printStackTrace();
//        }
//        
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
//            List<Ninja> ninjas = (List<Ninja>) ois.readObject();
//
//            System.out.println("Lista de ninjas leída del archivo:");
//            for (Ninja ninja : ninjas) {
//                System.out.println("Nombre: " + ninja.getNombre() + ", Edad: " + ninja.getAldea());
//            }
//        }    }

        // NinjaMenu.showMenu();
        // MisionMenu.showMenu();
        //System.out.println(NinjaControlador.obtenerNinja(5));
        // NinjaControlador.listarNinjas().forEach(System.out::println);
    }
}

