/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import data.Cabin;
import menu.menu;

/**
 *
 * @author hii
 */
public class PetManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu m = new menu();
        m.addNewOption("Welcome to Pet Care System");
        m.addNewOption("1. Add a new dog profile");
        m.addNewOption("2. Add a new cat profile");
        m.addNewOption("3. Search a pet profile by id");
        m.addNewOption("4. Update a pet profile by id");
        m.addNewOption("5. Remove a pet profile by id");
        m.addNewOption("6. Print the pet list ascending by id");
        m.addNewOption("7. Print the pet list asscending by name");
        m.addNewOption("8. Quit");
        Cabin c = new Cabin();
        int choice; 
        do {
            m.printMenu();
            choice = m.getChoice();
            
            switch (choice) {
                case 1:
                    c.addDog();
                    break;
                case 2:
                    c.addCat();
                    break;
                case 3:
                    c.searchPetByID();
                    break;
                case 4:
                    c.updatePet();
                    break;
                case 5:
                    c.removePetByID();
                    break;
                case 6:
                   c.printPetListAscendingByID();
                    break;
                case 7:
                    c.printPetListAscendingByName();
                    break;
                case 8:
                    System.out.println("See you the next time!!!");
                    break;

            }

        } while (choice != 8);

    }

}
