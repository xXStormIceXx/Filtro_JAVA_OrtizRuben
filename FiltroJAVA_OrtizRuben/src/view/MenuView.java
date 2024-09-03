/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
/**
 *
 * @author Ruben Ortiz
 */
public void displayMainMenu() {
        System.out.println("\n╔═══════════════════════════════════╗");
        System.out.println("║           Menu Principal          ║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.println("║                                   ║");
        System.out.println("║ 1. Event Options                  ║");
        System.out.println("║                                   ║");
        System.out.println("║ 2. Staff Options                  ║");
        System.out.println("║                                   ║");
        System.out.println("║ 3. Exit                          ║");
        System.out.println("║                                   ║");
        System.out.println("╚═══════════════════════════════════╝");
        System.out.print("Select an option: ");
        System.out.print("-> ");
    }

    // Menú de Opciones de Personal
    public void displayNinjaMenu() {
        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║       Menu Opciones Ninja        ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║                                  ║");
        System.out.println("║ 1. Gestionar Ninjas              ║");
        System.out.println("║                                  ║");
        System.out.println("║ 2. Gestionar Habilidades         ║");
        System.out.println("║                                  ║");
        System.out.println("║ 3. Menu Anterior                 ║");
        System.out.println("║                                  ║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.print("Select an option: ");
        System.out.print("-> ");
    }

    // Menú de Opciones de Roles
    public void displayHabilidadesMenu() {
        System.out.println("\n╔═════════════════════════════════╗");
        System.out.println("║    Menu Opciones Habilidades    ║");
        System.out.println("╠═════════════════════════════════╣");
        System.out.println("║                                 ║");
        System.out.println("║ 1. Crear Habilidad              ║");
        System.out.println("║                                 ║");
        System.out.println("║ 2. Ver Habilidades              ║");
        System.out.println("║                                 ║");
        System.out.println("║ 3. Actualizar Habilidad         ║");
        System.out.println("║                                 ║");
        System.out.println("║ 4. Borrar Habilidad             ║");
        System.out.println("║                                 ║");
        System.out.println("║ 5. Menu Anterior                ║");
        System.out.println("║                                 ║");
        System.out.println("╚═════════════════════════════════╝");
        System.out.print("Select an option: ");
        System.out.print("-> ");
    }

    // Menú de Opciones de Eventos
    public void displayMisionMenu() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║      Menu Opciones Mision      ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║                                ║");
        System.out.println("║ 1. Crear Mision                ║");
        System.out.println("║                                ║");
        System.out.println("║ 2. Ver Misiones                ║");
        System.out.println("║                                ║");
        System.out.println("║ 3. Actualizar Misiones         ║");
        System.out.println("║                                ║");
        System.out.println("║ 4. Borrar Misiones             ║");
        System.out.println("║                                ║");
        System.out.println("║ 5. Menu Anterior               ║");
        System.out.println("║                                ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.print("Select an option: ");
        System.out.print("-> ");
    }

    // Menú de Actualización de Eventos
    public void displayUpdateEventMenu() {
        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║  Menu Actualizacion Misiones   ║");
        System.out.println("╠════════════════════════════════╣");
        System.out.println("║                                ║");
        System.out.println("║ 1. Actualizar Estado           ║");
        System.out.println("║                                ║");
        System.out.println("║ 2. Actualizar Todas            ║");
        System.out.println("║                                ║");
        System.out.println("║ 3. Volver                      ║");
        System.out.println("║                                ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.print("Select an option: ");
        System.out.print("-> ");
    }

    // Menú de Gestión de Personal
    public void displayGestionNinjasMenu() {
        System.out.println("\n╔═════════════════════════════════╗");
        System.out.println("║      Menu Gestion Ninjas        ║");
        System.out.println("╠═════════════════════════════════╣");
        System.out.println("║                                 ║");
        System.out.println("║ 1. Agregar Ninja                ║");
        System.out.println("║                                 ║");
        System.out.println("║ 2. Ver Ninjas                   ║");
        System.out.println("║                                 ║");
        System.out.println("║ 3. Actualizar Ninjas            ║");
        System.out.println("║                                 ║");
        System.out.println("║ 4. Borrar Ninjas                ║");
        System.out.println("║                                 ║");
        System.out.println("║ 5. Menu Anterior                ║");
        System.out.println("║                                 ║");
        System.out.println("╚═════════════════════════════════╝");
        System.out.print("Select an option: ");
        System.out.print("-> ");
    }

    // Menú de Gestión de Roles
    public void displayGestionHabilidadesMenu() {
        System.out.println("\n╔═════════════════════════════════╗");
        System.out.println("║    Menu Gestion Habilidades     ║");
        System.out.println("╠═════════════════════════════════╣");
        System.out.println("║                                 ║");
        System.out.println("║ 1. Agregar Habilidad            ║");
        System.out.println("║                                 ║");
        System.out.println("║ 2. ver Habilidades              ║");
        System.out.println("║                                 ║");
        System.out.println("║ 3. Actualizar Habilidades       ║");
        System.out.println("║                                 ║");
        System.out.println("║ 4. Borrar Habilidades           ║");
        System.out.println("║                                 ║");
        System.out.println("║ 5. Menu Anterior                ║");
        System.out.println("║                                 ║");
        System.out.println("╚═════════════════════════════════╝");
        System.out.print("Select an option: ");
        System.out.print("-> ");
    }

    // Métodos de entrada de usuario
    public String getUserInputString() {
        return scanner.nextLine();
    }

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // Verifica si la entrada es un número
        while (!input.matches("\\d+")) { // \\d+ asegura que toda la cadena sea un número
            System.out.println("\nOops! That’s not a number. Try typing digits only, like 1, 2, or 3!");
            input = scanner.nextLine(); // Pide nuevamente la entrada
        }

        return Integer.parseInt(input); // Ahora es seguro convertir la entrada a un número
    }

    public void displayInvalidOptionMessage() {
        System.out.println("\nOops! Looks like you're trying to choose a non-existent option. Maybe you need a map? Please try again.");
    }

    public void displayMessage(String enter_ticket_name_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}