/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormanagement;

import java.util.ArrayList;

public class Display {
    public void displayMenu(){
        System.out.println("==========Welcome to Employees Management==========");
        System.out.println("1. Add doctor");
        System.out.println("2. Update doctor");
        System.out.println("3. Delete doctor");
        System.out.println("4. Search doctor");
        System.out.println("5. Exit");
        
    }
    public void DisplayAllDoctor(ArrayList<Doctor> listFoundByName) {
        System.out.println("The doctor list");
       System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                    "Specialization", "Availability");
            for (int i = 0; i < listFoundByName.size(); i++) {
            System.out.printf("%-10s%-15s%-25s%-20d\n", listFoundByName.get(i).getCode(), listFoundByName.get(i).getName(),
                                listFoundByName.get(i).getSpecialization(), listFoundByName.get(i).getAvailability());
        }
       
        
    }
}
