package com.mycompany.konoha.Vista;

import com.mycompany.konoha.Controlador.MisionControlador;
import com.mycompany.konoha.Controlador.RangoControlador;
import com.mycompany.konoha.Modelo.Clases.Mision;
import com.mycompany.konoha.Modelo.Clases.Rango;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MisionMenu {

    public static void showMenu() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do {
            System.out.println("\n--- Mision Menu ---");
            System.out.println("1. Crear mision");
            System.out.println("2. Actualizar mision");
            System.out.println("3. Eliminar mision ");
            System.out.println("4. Listar todas las misiones");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opcion: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 ->
                    registarMision();
                case 2 ->
                    actualizarMision();
                case 3 ->
                    eliminarMision();
                case 4 ->
                    listarMision();
                case 0 ->
                    System.out.println("Exiting the system...");
                default ->
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 0);
    }

    private static int showRangos() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        List<Rango> rangos = RangoControlador.listarRangos();

        System.out.println("\n--- Selecciona el rango ---");
        for (int i = 0; i < rangos.size(); i++) {
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

    private static void registarMision() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- REGISTAR Mision ---");

        System.out.print("Ingrese la descripcion ");
        String descripcion = scanner.nextLine();
        while (descripcion.isEmpty()) {
            System.out.print("Invalido: ");
            descripcion = scanner.nextLine();
        }

        int Rango = showRangos();
        Rango r = RangoControlador.obtenerRango(Rango);

        System.out.print("Ingrese la recompensa: ");
        String recompensa = scanner.nextLine();
        while (recompensa.isEmpty()) {
            System.out.print("Description cannot be empty. Please enter a valid description: ");
            recompensa = scanner.nextLine();
        }

        LocalDate fechainicio = null;
        boolean validEntryDate = false;
        while (!validEntryDate) {
            System.out.print("Ingresa ala fecha de inicio de la mision (YYYY-MM-DD): ");
            String dateInput = scanner.nextLine().trim();
            try {
                fechainicio = LocalDate.parse(dateInput);
                validEntryDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato invalido (YYYY-MM-DD).");
            }
        }

        scanner.nextLine();

        MisionControlador.registarMision(descripcion, r, recompensa, fechainicio);

    }


    private static void eliminarNinja() {

        try {
            Scanner scanner = new Scanner(System.in);
            Integer id = null;

            System.out.print("Ingresa el id de la mision: ");

            try {
                id = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalido");
                return;
            }

            boolean result = MisionControlador.eliminarMision(id);

            if (result) {
                System.out.println("Eliminado.");
            } else {
                System.out.println("Mision no encontrado o no se puede eliminar");
            }

        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void actualizarMision() throws SQLException {
        
        Scanner scanner = new Scanner(System.in);
            Integer id = null;

            System.out.print("Ingresa el id de la mision: ");

            try {
                id = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalido");
                return;
            }
            
            System.out.print("Ingrese la descripcion ");
        String descripcion = scanner.nextLine();
        while (descripcion.isEmpty()) {
            System.out.print("Invalido: ");
            descripcion = scanner.nextLine();
        }

        int Rango = showRangos();
        Rango r = RangoControlador.obtenerRango(Rango);

        System.out.print("Ingrese la recompensa: ");
        String recompensa = scanner.nextLine();
        while (recompensa.isEmpty()) {
            System.out.print("Description cannot be empty. Please enter a valid description: ");
            recompensa = scanner.nextLine();
        }

        LocalDate fechainicio = null;
        boolean validEntryDate = false;
        while (!validEntryDate) {
            System.out.print("Ingresa ala fecha de inicio de la mision (YYYY-MM-DD): ");
            String dateInput = scanner.nextLine().trim();
            try {
                fechainicio = LocalDate.parse(dateInput);
                validEntryDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato invalido (YYYY-MM-DD).");
            }
        }

        scanner.nextLine();
        
        MisionControlador.actualizarMision(id, descripcion, r, recompensa, fechainicio, null);


    }

    private static void eliminarMision() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static void listarMision() throws SQLException {
        
        List<Mision> lista = MisionControlador.listarMisiones();
            lista.stream()
                    .sorted()
                    .forEach(System.out::println);


    }

}
