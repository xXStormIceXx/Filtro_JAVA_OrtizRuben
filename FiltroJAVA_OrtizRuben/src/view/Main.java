/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import controller.*;
import view.*;
/**
 *
 * @author camper
 */
public class Main {
    public static void main(String[] args) {
        MenuView view = new MenuView();

        MisionController eventController = new MisionController(view);
        NinjaController staffController = new NinjaController(view);


        // Mostrar mensaje de bienvenida
        view.displayWelcomeMessage();

        boolean exit = false;

        while (!exit) {
            view.displayMainMenu();
            int option = MenuView.getUserInput();

            switch (option) {
                case 1 -> eventController.handleMisionMenu();
                case 2 -> staffController.handleNinjaMenu();
                case 3 -> {
                    exit = true;
                    System.out.println("\nThank you for using Misiones Ninja System! Goodbye!");
                    view.displayFarewellMessage();
                }
                default -> view.displayInvalidOptionMessage();
            }
        }
    }
}
