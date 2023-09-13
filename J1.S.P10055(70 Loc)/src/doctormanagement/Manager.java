/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctormanagement;

import java.util.ArrayList;

/**
 *
 * @author hii
 */
public class Manager {

    ArrayList<Doctor> list = new ArrayList<>();
    Display display = new Display();

    public void addDoctor() {
        String code = GetData.getString("Input the code: ", "Please input the code: ");
        String name = GetData.getString("Input name: ", "Please input name; ");
        String specialization = GetData.getString("Input specialization: ", "Please input specialization: ");
        int availability = GetData.getAnInteger("Input availability: ", "Please input availability: ");
        list.add(new Doctor(code, name, specialization, availability));

    }

    public int searchId(String code) {
        int index = -1;
        if (list.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Doctor d : list) {
                if (d.getCode().equals(code)) {
                    index = list.indexOf(d);
                }
            }
        }
        return index;
    }

    public void updateDoctor() {
        String code;
        int choice;
        if (list.isEmpty()) {
            System.out.println("List is empty");
        }
        //hiện thị các doctor
        display.DisplayAllDoctor(list);
        int index;
        while (true) {
            code = GetData.getString("Input the code: ", "Please input the code");
            index = searchId(code);
            if (index >= 0) {
                System.out.println("Updating: ");
                break;
            } else {
                continue;
            }
        }
        do {
            System.out.println("Choose update option:");
            System.out.println("1: Update name of doctor.");
            System.out.println("2: Update specialization of doctor.");
            System.out.println("3: Update availability of doctor.");
            System.out.println("4: Update code of doctor.");
            System.out.println("5.Quit");
            choice = GetData.getAnInteger("Let's choose option", "Please enter the integer number", 1, 5);
            switch (choice) {
                case 1:

                    String name = GetData.getString("Input name: ", "Please input name; ");
                    list.get(index).setName(name);
                    break;
                case 2:
                    String specialization = GetData.getString("Input specialization: ", "Please input specialization; ");
                    list.get(index).setSpecialization(specialization);
                    break;
                case 3:
                    int availability = GetData.getAnInteger("Input availability: ", "Please input availability: ");
                    list.get(index).setAvailability(availability);
                    break;

                case 4:
                    String codeD = GetData.getString("Input code: ", "Please input code: ");
                    list.get(index).setCode(codeD);
                    break;
            }
        } while (choice != 5);

    }

    public void deleteDoctor() {
        display.DisplayAllDoctor(list);
        String code = GetData.getString("Input code: ", "Please input code: ");
        int index = searchId(code);
        if (index >= 0) {
            list.remove(index);
        } else {
            System.out.println("List is empty");
            return;
        }

        System.out.println("Delete successfully");
        display.DisplayAllDoctor(list);
    }

    public void searchDoctor() {
        String name = GetData.getString("Input name: ", "Please input name; ");
        ArrayList<Doctor> listFoundByName = listFoundByName(name);
        if (listFoundByName.isEmpty()) {
            System.out.println("List is empty");
        } else {
            display.DisplayAllDoctor(listFoundByName);
        }

    }

    public ArrayList<Doctor> listFoundByName(String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : list) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}
