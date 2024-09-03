/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import view.MenuView;
/**
 *
 * @author camper
 */
public class MenuController {
    private MenuView view;
    private MisionController misionController;

    public MenuController() {
        this.view = new MenuView();
        this.misionController = new MisionController(view);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            view.displayMainMenu();
            int option = view.getUserInput();

            switch (option) {
                case 1:
                    misionController.handleMisionMenu();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    view.displayInvalidOptionMessage();
                    break;
            }
        }
    }
}
