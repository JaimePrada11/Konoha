/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.konoha.Vista;

import com.mycompany.konoha.Modelo.Clases.Rango;
import com.mycompany.konoha.Controlador.AldeaControlador;
import com.mycompany.konoha.Controlador.NinjaControlador;
import static com.mycompany.konoha.Controlador.NinjaControlador.listarNinjas;
import com.mycompany.konoha.Controlador.RangoControlador;
import com.mycompany.konoha.Modelo.Clases.Aldea;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class NinjaMenu {
    
    
    public static void showMenu() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do {
            System.out.println("\n--- Ninja Menu ---");
            System.out.println("1. Añadir ninja");
            System.out.println("2. Actualizar ninja");
            System.out.println("3. Eliminar Ninja ");
            System.out.println("4. Listar todos los ninjas");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 ->
                    registarNinja();
                case 2 ->
                    actualizarNinja();
                case 3 ->
                    eliminarNinja();
                case 4 ->
                    listarNinjas();
                case 5 ->
                    addHabilidades();
                case 0 ->
                    System.out.println("Adios");
                default ->
                    System.out.println("Opcion invalida.");
            }
        } while (option != 0);
    }

    private static int mostrarAldeas() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        List<Aldea> Aldeas = AldeaControlador.listarAldeas();

        System.out.println("\n--- Selecciona la aldea ---");
        for (int i = 0; i < Aldeas.size(); i++) {
            System.out.println((i + 1) + ". " + Aldeas.get(i).getNombre());
        }

        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Ingresa el numero de la aldea: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice > 0 && choice <= Aldeas.size()) {
                    validChoice = true;
                } else {
                    System.out.println("Opcion invalida.");
                }
            } else {
                System.out.println("Invalido.");
                scanner.nextLine(); 
            }
        }

        return Aldeas.get(choice - 1).getIdAldea();
    }
    
    private static int mostrarRangos() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        List<Rango> rangos = RangoControlador.listarRangos();

        System.out.println("\n--- Selecciona el rango del ninja ---");
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + ". " + rangos.get(i).getNombre());
        }

        int choice = 0;
        boolean validChoice = false;
        while (!validChoice) {
            System.out.print("Ingresa el numero del rango: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice > 0 && choice <= rangos.size()) {
                    validChoice = true;
                } else {
                    System.out.println("Opcion invalida.");
                }
            } else {
                System.out.println("Invalido.");
                scanner.nextLine(); 
            }
        }

        return rangos.get(choice - 1).getIdRango();
    }
    
    
    
    private static void registarNinja() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- REGISTAR NINJA ---");

        System.out.print("Ingrese el nombre ");
        String nombre = scanner.nextLine();
        while (nombre.isEmpty()) {
            System.out.print("Invalido: ");
            nombre = scanner.nextLine();
        }

        System.out.print("Ingrese el identificador: ");
        String identificador = scanner.nextLine();
        while (identificador.isEmpty()) {
            System.out.print("No puede estar vacio ");
            identificador = scanner.nextLine();
        }
       
        int Aldeas = mostrarAldeas();
        Aldea s = AldeaControlador.obtenerAldea(Aldeas);
        int Rango = mostrarRangos();
        Rango r = RangoControlador.obtenerRango(Rango);

        scanner.nextLine();

        NinjaControlador.registarNinja(nombre, identificador, s, r) ;
  
        
    }

    private static void addHabilidades() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void actualizarNinja() throws SQLException {
        Scanner scanner = new Scanner(System.in);
            Integer id = null;

            System.out.print("Ingresa el id del ninja: ");

            try {
                id = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalido");
                return;
            }
            
            
            System.out.print("Ingrese el nombre ");
        String nombre = scanner.nextLine();
        while (nombre.isEmpty()) {
            System.out.print("Invalido: ");
            nombre = scanner.nextLine();
        }

        System.out.print("Ingrese el identificador: ");
        String identificador = scanner.nextLine();
        while (identificador.isEmpty()) {
            System.out.print("Description cannot be empty. Please enter a valid description: ");
            identificador = scanner.nextLine();
        }

       
        int Aldeas = mostrarAldeas();
        Aldea s = AldeaControlador.obtenerAldea(Aldeas);
        int Rango = mostrarRangos();
        Rango r = RangoControlador.obtenerRango(Rango);

        scanner.nextLine();
        
        NinjaControlador.actualizarNinja(id, nombre, identificador, s, r);


    }

    private static void eliminarNinja() {

        try {
            Scanner scanner = new Scanner(System.in);
            Integer id = null;

            System.out.print("Ingresa el id del ninja: ");

            try {
                id = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalido");
                return;
            }

            boolean result = NinjaControlador.eliminarNinja(id);

            if (result) {
                System.out.println("Eliminado.");
            } else {
                System.out.println("Ninja no encontrado o no se puede eliminar");
            }

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


}
