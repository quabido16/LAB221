/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesmanagement;

import java.util.Scanner;
import sun.awt.EmbeddedFrame;

/**
 *
 * @author hii
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        Display display = new Display();
        Input input = new Input();
        EmployeeManagement e = new EmployeeManagement();
        do {
            display.displayMenu();
            choice = input.getAnInteger("Let's select optione: ", "Please enter the integer number", 1, 6);

            switch (choice) {
                case 1:
                    e.addEmployee();
                    break;
                case 2:
                    e.updateEmployee();
                    break;
                case 3:
                    e.removeEmployee();
                    break;
                case 4:
                    e.searchByName();
                    break;
                case 5:
                    e.sortBySalary();
                    break;
                case 6:
                    System.out.println("See you next time");
            }
        } while (choice != 6);

    }

}
