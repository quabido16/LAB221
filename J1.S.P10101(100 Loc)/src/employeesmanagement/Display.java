/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesmanagement;

import java.util.ArrayList;

/**
 *
 * @author hii
 */
public class Display {
    public void displayMenu(){
        System.out.println("==========Welcome to Employees Management==========");
        System.out.println("1. Add employee");
        System.out.println("2. Update employee");
        System.out.println("3. Remove employee");
        System.out.println("4. Search employee");
        System.out.println("5. Sort employee by salary");
        
    }
    public void DisplayElementofList(ArrayList<Employee> EmployeeList, int index) {
        
       
        System.out.format("%3d%10s%10s%15s%30s%20s%12s%5s%10d%10s\n",
                EmployeeList.get(index).getId(), EmployeeList.get(index).getFirstName(), EmployeeList.get(index).getLastName(),
                EmployeeList.get(index).getPhone(), EmployeeList.get(index).getEmaail(), EmployeeList.get(index).getAddress(), EmployeeList.get(index).getDob(),
                EmployeeList.get(index).getSex(), EmployeeList.get(index).getSalary(), EmployeeList.get(index).getAgency());
    }
    public void DisplayAllList(ArrayList<Employee> EmployeeList) {
        System.out.println("The Employees List: ");
        System.out.format("%3s%10s%10s%15s%30s%20s%12s%5s%10s%10s\n", "Id", "First Name",
                "Last Name", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Agency");
        //loop use to access each element of arraylist from begining to the end
        for (int i = 0; i < EmployeeList.size(); i++) {
            DisplayElementofList(EmployeeList, i);
        }
    }
}
