/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11_tritd;

import data.Cabinet;
import option.menu;

/**
 *
 * @author hii
 */
public class Lab11_triTD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        menu m1 = new menu("FruitShop");
        m1.addNewOption("1. Create fruit");
        m1.addNewOption("2. Update fruit");
        m1.addNewOption("3. View orders");
        m1.addNewOption("4. Shopping (for buyer)");
        m1.addNewOption("5. Exit");
        int choice;
        Cabinet c = new Cabinet();
        do {
            m1.printMenu();
            choice = m1.getChoice();
            switch (choice) {
                case 1:
                    c.addNewFruit(c.yesNoqs("Do you want to continue(Y/N) ?"));
                    break;
                case 2:
                    c.updateFruid();
                    break;
                case 3:
                    c.showOrder();
                    break;
                case 4:
                    c.shopping();
                    
                    break;

                case 5:

                    System.out.println("See you next time!!!");
                    return;
            }
        } while (choice != 5);

    }

}
