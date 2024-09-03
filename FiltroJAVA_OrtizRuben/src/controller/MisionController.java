/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import model.MisionModel;
import view.MenuView;
/**
 *
 * @author camper
 */
public class MisionController {
    private MenuView view;
    private MisionModel eventModel;

    public MisionController(MenuView view) {
        this.view = view;
        this.eventModel = new MisionModel();
    }

    public void handleMisionMenu() {
        boolean back = false;
        while (!back) {
            view.displayMisionMenu();
            int option = getValidIntegerInput();

            switch (option) {
                case 1:
                    createMision();
                    break;
                case 2:
                    viewMision();
                    break;
                case 3:
                    handleUpdateMision;
                    break;
                case 4:
                    deleteMision();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    view.displayInvalidOptionMessage();
                    break;
            }
        }
    }

    private void createMision()
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║              Crear Nueva Mision              ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        System.out.print("╔═> Enter event name: ");
        String name = view.getUserInputString();

        System.out.print("╔═> Enter country: ");
        String continente = view.getUserInputString();

        System.out.print("╔═> Enter city: ");
        String aldea = view.getUserInputString();

        System.out.print("╔═> Enter address: ");
        String distrito = view.getUserInputString();

        System.out.print("╔═> Enter maximum people capacity: ");
        int maxCapacidadNinja = getValidIntegerInput();

        System.out.print("╔═> Enter maximum store capacity: ");
        int maxCapacidadMision = getValidIntegerInput();

        System.out.print("╔═> Enter event date (YYYY-MM-DD): ");
        LocalDate date = getValidDateInput();

        System.out.print("╔═> Enter event time (HH:MM:SS): ");
        Time time = getValidTimeInput();

        System.out.print("╔═> Enter organizer: ");
        String organizador = view.getUserInputString();

        System.out.print("╔═> Enter age rating: ");
        int rango_clasificacion = getValidIntegerInput();

        System.out.print("╔═> Enter status (active, finished, pending): ");
        String estado = view.getUserInputString();

        misionModel.createMision(name, continente, aldea, distrito, maxCapacidadNinja, maxCapacidadMision, date, time, organizador, rango_clasificacion, estado);
    }

    private void viewMision() {
        System.out.println("\n╔═════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                                                                                                Lista de Misiones                                                                                                                                    ║");
        System.out.println("╠════════════╦════════════════════════════════════════╦══════════════════════════════════╦═══════════════════════════╦═══════════════════════════╦═════════════════╦═════════════════╦════════════════════╦═════════════════╦══════════════════════╦══════════════════════╦══════════════╦════════════╣");
        System.out.printf("║ %-10s ║ %-38s ║ %-32s ║ %-25s ║ %-25s ║ %-15s ║ %-15s ║ %-18s ║ %-15s ║ %-20s ║ %-20s ║ %-12s ║ %-10s ║\n",
                          "ID", "Name", "Country", "City", "Address", "Max People", "Max Stores", "Max Restaurants", "Date", "Time", "Organizer", "Age Rating", "Status");
        System.out.println("╠════════════╬════════════════════════════════════════╬══════════════════════════════════╬═══════════════════════════╬═══════════════════════════╬═════════════════╬═════════════════╬════════════════════╬═════════════════╬══════════════════════╬══════════════════════╬══════════════╬════════════╣");

        for (String mision : misionModel.getAllMisionWithDetails()) {
            String[] details = mision.split("\n");

            if (details.length >= 13) {
                String id = getValue(details[1]);
                String name = getValue(details[2]);
                String continente = getValue(details[3]);
                String aldea = getValue(details[4]);
                String distrito = getValue(details[5]);
                String maxCapacidadNinja = getValue(details[6]);
                String maxCapacidadMision = getValue(details[7]);
                String date = getValue(details[9]);
                String time = getValue(details[10]);
                String organizador = getValue(details[11]);
                String rango_clasificacion = getValue(details[12]);
                String estado = getValue(details[13]);

                System.out.printf("║ %-10s ║ %-38s ║ %-32s ║ %-25s ║ %-25s ║ %-15s ║ %-15s ║ %-18s ║ %-15s ║ %-20s ║ %-20s ║ %-12s ║ %-10s ║\n",
                                  id, name, continente, aldea, distrito, maxCapacidadNinja, maxCapacidadMision, date, time, organizador, rango_clasificacion, estado);
            }
        }

        System.out.println("╚════════════╩════════════════════════════════════════╩══════════════════════════════════╩═══════════════════════════╩═══════════════════════════╩═════════════════╩═════════════════╩════════════════════╩═════════════════╩══════════════════════╩══════════════════════╩══════════════╩════════════╝\n");
    }

    private String getValue(String line) {
        String[] parts = line.split(": ");
        return parts.length > 1 ? parts[1] : "";
    }

    private void handleUpdateMisionMenu() {
        System.out.print("Enter the Event ID you want to update: ");
        int misionId = getValidIntegerInput();
        
        if (!eventExists(misionId)) {
            System.out.println("Error: Event with ID " + misionId + " does not exist.");
            return;
        }

        boolean returnToPrevious = false;
        while (!returnToPrevious) {
            view.displayUpdateMisionMenu();
            int option = getValidIntegerInput();

            switch (option) {
                case 1:
                    updateMisionStatus(misionId);
                    break;
                case 2:
                    updateMision(misionId);
                    break;
                case 3:
                    returnToPrevious = true;
                    break;
                default:
                    view.displayInvalidOptionMessage();
                    break;
            }
        }
    }

    private void updateMisionStatus(int misionId) {
        System.out.print("Enter new status (active, finished, pending): ");
        String status = view.getUserInputString();
        boolean updated = misionModel.updateMisionStatus(misionId, estado);
        if (updated) {
            System.out.println("Event status updated successfully.");
        } else {
            System.out.println("Failed to update event status.");
        }
    }

    private void updateMision(int misionId) {
        System.out.println("Leave a field blank to skip updating it.");

        System.out.print("Enter new event name (or press Enter to skip): ");
        String name = view.getUserInputString();
        name = name.isEmpty() ? null : name;

        System.out.print("Enter new country (or press Enter to skip): ");
        String continente = view.getUserInputString();
        continente = continente.isEmpty() ? null : continente;

        System.out.print("Enter new city (or press Enter to skip): ");
        String aldea = view.getUserInputString();
        aldea = aldea.isEmpty() ? null : aldea;

        System.out.print("Enter new address (or press Enter to skip): ");
        String distrito = view.getUserInputString();
        distrito = distrito.isEmpty() ? null : distrito;

        System.out.print("Enter new maximum people capacity (or press Enter to skip): ");
        Integer maxCapacidadNinja = getValidIntegerInputOrNull();

        System.out.print("Enter new maximum store capacity (or press Enter to skip): ");
        Integer maxCapacidadMision = getValidIntegerInputOrNull();

        System.out.print("Enter new event date (YYYY-MM-DD, or press Enter to skip): ");
        LocalDate date = getValidDateInputOrNull();

        System.out.print("Enter new event time (HH:MM:SS, or press Enter to skip): ");
        Time time = getValidTimeInputOrNull();

        System.out.print("Enter new organizer (or press Enter to skip): ");
        String organizador = view.getUserInputString();
        organizador = organizador.isEmpty() ? null : organizador;

        System.out.print("Enter new age rating (or press Enter to skip): ");
        Integer rango_clasificacion = getValidIntegerInputOrNull();

        System.out.print("Enter new status (active, finished, pending, or press Enter to skip): ");
        String estado = view.getUserInputString();
        esatdo = estado.isEmpty() ? null : estado;

        boolean updated = misionModel.updateMision(misionId, name, continente, aldea, distrito, maxCapacidadNinja, maxCapacidadMision, date, time, organizador, rango_clasificacion, estado);
        if (updated) {
            System.out.println("Event updated successfully.");
        } else {
            System.out.println("Failed to update event.");
        }
    }

    private void deleteMision() {
        System.out.print("Enter the Event ID you want to delete: ");
        int misionId = getValidIntegerInput();

        if (!misionExists(misionId)) {
            System.out.println("Error: Event with ID " + misionId + " does not exist.");
            return;
        }

        boolean deleted = MisionModel.deleteMisionAndDependencies(misionId);
        if (deleted) {
            System.out.println("Event and all dependencies deleted successfully.");
        } else {
            System.out.println("Failed to delete event and dependencies.");
        }
    }

    private int getValidIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(view.getUserInputString());
            } catch (NumberFormatException e) {
                view.displayInvalidOptionMessage();
            }
        }
    }

    private Integer getValidIntegerInputOrNull() {
        String input = view.getUserInputString();
        return input.isEmpty() ? null : Integer.parseInt(input);
    }

    private LocalDate getValidDateInput() {
        while (true) {
            try {
                return LocalDate.parse(view.getUserInputString());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in YYYY-MM-DD format.");
            }
        }
    }

    private LocalDate getValidDateInputOrNull() {
        String input = view.getUserInputString();
        return input.isEmpty() ? null : LocalDate.parse(input);
    }

    private Time getValidTimeInput() {
        while (true) {
            try {
                return Time.valueOf(view.getUserInputString());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid time format. Please enter the time in HH:MM:SS format.");
            }
        }
    }

    private Time getValidTimeInputOrNull() {
        String input = view.getUserInputString();
        return input.isEmpty() ? null : Time.valueOf(input);
    }

    private boolean misionExists(int misionId) {
        return !misionModel.getMisionDetails(misionId).isEmpty();
    }
}

