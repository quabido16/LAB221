/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesmanagement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author hii
 */
public class EmployeeManagement {

    ArrayList<Employee> list = new ArrayList<>();

    public boolean checkID(int id) {
        if (list.isEmpty()) {
            return false;
        } else {
            for (Employee e : list) {
                if (e.getId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addEmployee() {
        int id;
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } //hoặc hiện thị list vừa nhập ở đây
        while (true) {
            id = Input.getAnInteger("Input the id", "Please input integer number (>0)", 1, Integer.MAX_VALUE);
            boolean checkExist = checkID(id);
            if (checkExist) {
                continue;
            } else {
                break;
            }
        }
        //sử dụng Regular Expression
        String firstName = Input.getString("Input the First Name", "Please don't empty, please input First Name");
        String lastName = Input.getString("Input the Last Name", "Please don't empty, please input Last Name");
        String phone = Input.getString("Input phone (10 numbers)", "Please enter the corrcet format", "^0[983]{1}\\d{8}$");
        //^0 bắt đầu bằng 0
        //[893]{1} số tiếp theo là 8, 9, 3 và chỉ xuất hiện 1 lần
        //d{8} nhập đủ 8 chữ số
        String email = Input.getString("Input email: ", "Please enter the corrcet format",
                "^[a-zA-Z0-9]+@([a-z]{2,6}\\.[a-z]{2,6}|[a-z]{2,6}\\.[a-z]{2,6}\\.[a-z]{2,6})*$");
        //khớp tất cả các chữ thường hoa và số 0 - 9
        //+ khớp kí tự trc nó 1 hoặc nhiều lần
        //* khớp kí tự 0 hoặc nhiều lần
        //[a-zA-Z]{2,6}:khớp ký tự trong bộ từ 2 đến 6 lần
        String address = Input.getString("Input address", "Please enter the corrcet format");
        String dob = Input.getString("Input employee birthday[dd//MM//yyyy] ", "Please enter the corrcet format", "\\d{1,2}[/]\\d{1,2}[/]\\d{4}");
        String sex = Input.getString("Input employee's gender ", "Please enter the correct format");
        int salary = Input.getAnInteger("Input the salary(>=0)", "Please enter corect format", 0, Integer.MAX_VALUE);
        String agency = Input.getString("Input employee agency", "Please don't empty, enter again");
        list.add(new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency));
    }

    public int searchId(int id) {
        int index = -1;
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Employee e : list) {
                if (id == e.getId()) {
                    index = list.indexOf(e);
                }
            }
        }
        return index;
    }

    public void updateEmployee() {
        int id;
        int index;
        int choice;
        while (true) {
            //hiện thị danh sách
            id = Input.getAnInteger("Input id employee", "Please input the integer number", 1, Integer.MAX_VALUE);
            index = searchId(id);
            if (index == -1) {
                System.out.println("Can't find employee, enter again");
                continue;
            } else {
                break;
            }
        }
        do {
            System.out.println("Choose update option:");
            System.out.println("1: Update first name of employee.");
            System.out.println("2: Update lastname of employee.");
            System.out.println("3: Update phone number of employee.");
            System.out.println("4: Update email of employee.");
            System.out.println("5: Update address of employee.");
            System.out.println("6: Update birthday of employee.");
            System.out.println("7: Udate gender of employee.");
            System.out.println("8: Update salary of employee.");
            System.out.println("9: Update agency of employee.");
            System.out.println("10: Update Id of emloyee.");
            choice = Input.getAnInteger("Let's choose option", "Please enter the integer number", 1, 10);
            switch (choice) {
                case 1:
                    String FirstName = Input.getString("Input the First Name", "Please don't empty, please input First Name");
                    list.get(index).setFirstName(FirstName);
                    break;
                case 2:
                    String LastName = Input.getString("Input the Last Name", "Please don't empty, please input Last Name");
                    list.get(index).setLastName(LastName);
                    break;
                case 3:
                    //^0: 0 must be is the first digit of phone number
                    //[9843]{1}: choose 1 number in [9843]
                    //\d{8}: a string need 9 number
                    //$: point the end of the line
                    String phone = Input.getString("Input phone (10 numbers)", "Please enter the corrcet format", "^0[983]{1}\\d{8}$");
                    list.get(index).setPhone(phone);
                    break;
                case 4:
                    //^: access position start of line
                    //[a-zA-Z0-9]: match all character begin lower case to upercase form a to z and digit in 0 to 9
                    //+: check unlimited times imposible
                    //@: a string must be have character @
                    //\.:match character . 
                    //[a-zA-Z]{2,6}:match character in set from 2 to 6 times
                    //|: Boolean OR for 2 case email
                    //*: check all previous token unlimited times
                    //$: point the end of line
                    String email = Input.getString("Input email: ", "Please enter the corrcet format",
                            "^[a-zA-Z0-9]+@([a-z]{2,6}\\.[a-z]{2,6}|[a-z]{2,6}\\.[a-z]{2,6}\\.[a-z]{2,6})*$");
                    list.get(index).setEmaail(email);
                    break;
                case 5:
                    String address = Input.getString("Input address", "Please enter the corrcet format");
                    list.get(index).setAddress(address);
                    break;
                case 6:
                    String dob = Input.getString("Input employee birthday[dd//MM//yyyy] ", "Please enter the corrcet format", "\\d{1,2}[/]\\d{1,2}[/]\\d{4}");
                    list.get(index).setDob(dob);
                    break;
                case 7:
                    String sex = Input.getString("Input employee's gender ", "Please enter the correct format");
                    list.get(index).setSex(sex);
                    break;
                case 8:
                    int salary = Input.getAnInteger("Input the salary(>=0)", "Please enter corect format", 0, Integer.MAX_VALUE);

                    list.get(index).setSalary(salary);
                    break;
                case 9:
                    String agency = Input.getString("Input employee agency", "Please don't empty, enter again");
                    list.get(index).setAgency(agency);
                    break;
                case 10:
                    System.out.println("see you next time");
                    
            }
        } while (choice != 10);
    }
    public void removeEmployee(){
        //hiển thị
        
        int id;
        int index;
        while(true){
            id = Input.getAnInteger("Input id employee", "Please input integer number", 0, Integer.MAX_VALUE);
            index = searchId(id);
            if(index == -1){
                System.out.println("Can't find employee, enter again");
                continue;
            }else{
                break;
            }
        }
        list.remove(id);
        //hiển thị
    }
    
    public void searchByName(){
        String name = Input.getString("Input the name", "Please input the name");
        int index = 0;
        
        for (int i = 0; i < list.size(); i++) {
            String fullName = list.get(i).getFirstName() + " " + list.get(i).getLastName();
            if(fullName.contains(name)){
                index = i;
            }
        }
        
        if(index == 0){
            System.out.println("Employee does't exist");
        }else{
            System.out.format("%3s%10s%10s%15s%30s%20s%12s%5s%10s%10s\n", "Id", "First Name",
                    "Last Name", "Phone Number", "Email", "Address", "Birthday", "Gender", "Salary", "Agency");
        }
    }
    
    
    public void sortBySalary(){
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getSalary() == o2.getSalary()) {
                    return o1.getId() - o2.getId();
                } else {
                    return o1.getSalary() - o2.getSalary();
                }
            }
        });
    }
}
