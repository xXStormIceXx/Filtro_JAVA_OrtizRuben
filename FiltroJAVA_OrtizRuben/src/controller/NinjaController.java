/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.NinjaModel;
import model.HabiliadesModel;
import view.MenuView;
/**
 *
 * @author camper
 */
public class NinjaController {
    private MenuView view;
    private NinjaModel ninjaModel;
    private HabilidadesModel habilidadesModel;

    public NinjaController(MenuView view) {
        this.view = view;
        this.ninjaModel = new NinjaModel();
        this.habilidadesModel = new HabilidadesModel();
    }

    public void handleNinjaMenu() {
        boolean back = false;
        while (!back) {
            view.displayNinjaMenu();
            int option = getValidIntegerInput();

            switch (option) {
                case 1:
                    handleNinjaOperations();
                    break;
                case 2:
                    handleHabilidadesOperations();
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    view.displayInvalidOptionMessage();
                    break;
            }
        }
    }

    private void handleNinjaOperations() {
        boolean back = false;
        while (!back) {
            view.displayManageStaffMenu();
            int option = getValidIntegerInput();

            switch (option) {
                case 1:
                    createNinja();
                    break;
                case 2:
                    viewNinja();
                    break;
                case 3:
                    updateNinja();
                    break;
                case 4:
                    deleteNinja();
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

    private void handleHabilidadesOperations() {
        boolean back = false;
        while (!back) {
            view.displayHabilidadesMenu();
            int option = getValidIntegerInput();

            switch (option) {
                case 1:
                    createHabilidades();
                    break;
                case 2:
                    viewHabilidades();
                    break;
                case 3:
                    updateHabilidades();
                    break;
                case 4:
                    deleteHabilidades();
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

    private void createNinja() {
    System.out.println("\n╔════════════════════════════════════════════════════════════════════════════╗");
    System.out.println("║                           Crear Nuevo Ninja                                ║");
    System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");

    System.out.print("╔═> Enter Ninja name: ");
    String name = view.getUserInputString();

    System.out.print("╔═> Enter identificador: ");
    int identificador = getValidIntegerInput();

    System.out.print("╔═> Enter cumpleaños (YYYY-MM-DD): ");
    String cumpleanos = view.getUserInputString();

    System.out.print("╔═> Enter estado (Mision asignada, Ninguna Mision, Mision Iniciada, Mision Terminada): ");
    String estado = view.getUserInputString();

    System.out.print("╔═> Enter Habilidad ID: ");
    int habilidadesId = getValidIntegerInput();

    if (!HabilidadesModel.habilidadesExists(habilidadesId)) {
        System.out.println("╚═> Error: Habilidad ID does not exist.");
        return;
    }

    System.out.print("╔═> Enter Mision ID (or press Enter to skip): ");
    String misionIdInput = view.getUserInputString();
    Integer misionId = misionIdInput.isEmpty() ? null : Integer.parseInt(misionIdInput);

    System.out.print("╔═> Enter Actividad Ninja ID (or press Enter to skip): ");
    String actividadNinjaIdInput = view.getUserInputString();
    Integer actividadNinjaId = actividadNinjaIdInput.isEmpty() ? null : Integer.parseInt(actividadNinjaIdInput);

    boolean created = ninjaModel.createNinja(name, identificador, cumpleanos, estado, habilidadesId, misionId, actividadNinjaId);
    if (created) {
        System.out.println("╚═> Ninja created successfully.");
    } else {
        System.out.println("╚═> Failed0 to create Ninja.");
    }
}


private void viewNinja() {
    System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
    System.out.println("║                                                                 List of Ninja                                                                          ║");
    System.out.println("╠══════════════════════╦════════════════════════════════╦═══════════════════════════════╦════════════════════════╦════════════╦════════════╦═════════════╣");
    System.out.printf("║ %-20s ║ %-30s ║ %-29s ║ %-22s ║ %-10s ║ %-10s ║ %-10s ║ \n", "ID - Name", "Identifier", "Birthdate", "Status", "Role ID", "Event ID", "Personal ID");
    System.out.println("╠══════════════════════╬════════════════════════════════╬═══════════════════════════════╬════════════════════════╬════════════╬════════════╬═════════════╣");

    for (String ninja : ninjaModel.getAllStaff()) {
        String[] details = staff.split(","); // Asumiendo que los detalles del staff están separados por comas
        System.out.printf("║ %-20s ║ %-30s ║ %-29s ║ %-22s ║ %-10s ║ %-10s ║ %-11s ║ \n", details[0], details[1], details[2], details[3], details[4], details[5], details[6]);
    }

    System.out.println("╚══════════════════════╩════════════════════════════════╩═══════════════════════════════╩════════════════════════╩════════════╩════════════╩═════════════╝\n");
}

    
    private void updateNinja() {
        try {
            System.out.print("Enter the Staff ID you want to update: ");
            int ninjaId = getValidIntegerInput();

            if (!ninjaExists(ninjaId)) {
                System.out.println("Error: Staff member with ID " + ninjaId + " does not exist.");
                return;
            }

            System.out.print("Enter new staff name (or press Enter to skip): ");
            String name = view.getUserInputString();

            System.out.print("Enter new identifier (or press Enter to skip): ");
            String identificadorInput = view.getUserInputString();
            Integer identificador = identificadorInput.isEmpty() ? null : Integer.parseInt(identificadorInput);

            System.out.print("Enter new birthdate (or press Enter to skip): ");
            String cumpleanos = view.getUserInputString();

            System.out.print("Enter new status (or press Enter to skip): ");
            String estado = view.getUserInputString();

            System.out.print("Enter new role ID (or press Enter to skip): ");
            String habilidadesIdInput = view.getUserInputString();
            Integer habilidadesId = habilidadesIdInput.isEmpty() ? null : Integer.parseInt(habilidadesIdInput);

            if (habilidadesId != null && !habilidadesModel.habilidadesExists(habilidadesId)) {
                System.out.println("Error: Role ID does not exist.");
                return;
            }

            System.out.print("Enter new event ID (or press Enter to skip): ");
            String misionIdInput = view.getUserInputString();
            Integer misionId = misionIdInput.isEmpty() ? null : Integer.parseInt(misionIdInput);

            System.out.print("Enter new personal activity ID (or press Enter to skip): ");
            String actividadNinjaIdInput = view.getUserInputString();
            Integer actividadNinjaId = actividadNinjaIdInput.isEmpty() ? null : Integer.parseInt(actividadNinjaIdInput);

            boolean updated = ninjaModel.updateNinja(misionId, name, identificador, cumpleanos, estado, habilidadesId, misionId, actividadNinjaId);
            if (updated) {
                System.out.println("Staff updated successfully.");
            } else {
                System.out.println("Failed to update staff.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while updating staff: " + e.getMessage());
        }
    }

    private void deleteNinja() {
        try {
            System.out.print("Enter the Staff ID you want to delete: ");
            int ninjaId = getValidIntegerInput();

            if (!staffExists(ninjaId)) {
                System.out.println("Error: Staff member with ID " + ninjaId + " does not exist.");
                return;
            }

            boolean deleted = ninjaModel.deleteNinja(ninjaId);
            if (deleted) {
                System.out.println("Staff deleted successfully.");
            } else {
                System.out.println("Failed to delete staff.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while deleting staff: " + e.getMessage());
        }
    }

    private void createHabilidades() {
        try {
            System.out.print("Enter habilidades name: ");
            String habilidadesName = view.getUserInputString();

            boolean created = habilidadesModel.createHabilidades(habilidadesName);
            if (created) {
                System.out.println("Role created successfully.");
            } else {
                System.out.println("Failed to create role.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while creating role: " + e.getMessage());
        }
    }

    private void viewHabilidades() {
    System.out.println("\n╔═══════════════════════════════════════════════════╗");
    System.out.println("║                Listar Habilidades                 ║");
    System.out.println("╠═══════════════════════════════════════════════════╣");

    for (String habilidades : habilidadesModel.getAllHabilidades()) {
        System.out.printf("║ %-49s ║\n", habilidades);
    }

    System.out.println("╚═══════════════════════════════════════════════════╝\n");
}


    private void updatehabilidades() {
        try {
            System.out.print("Enter the Role ID you want to update: ");
            int habilidadesId = getValidIntegerInput();

            System.out.print("Enter new role name (or press Enter to skip): ");
            String habilidadesName = view.getUserInputString();

            boolean updated = habilidadesModel.updateHabilidades(habilidadesId, habilidadesName);
            if (updated) {
                System.out.println("Role updated successfully.");
            } else {
                System.out.println("Failed to update role.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while updating role: " + e.getMessage());
        }
    }

    private void deleteHabilidades() {
        try {
            System.out.print("Enter the Role ID you want to delete: ");
            int habilidadesId = getValidIntegerInput();

            boolean deleted = habilidadesModel.deleteHabilidades(habilidadesId);
            if (deleted) {
                System.out.println("Role deleted successfully.");
            } else {
                System.out.println("Failed to delete role.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while deleting role: " + e.getMessage());
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

    private boolean ninjaExists(int ninjaId) {
        return ninjaModel.getMisionDetails(ninjaId) != null;
    }
}