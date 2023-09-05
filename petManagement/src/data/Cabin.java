/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import input.MyToy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author hii
 */
public class Cabin {
    //hồ sơ các chú pet
    private ArrayList<Pet> petList = new ArrayList();
    //thêm chó
    public void addDog(){
        String id, name;
        int yob;
        double weight;
        int pos;
        do {
            id = MyToy.getID("Input Dog is Dxxxxx", "The format of id is Dxxxxx (X stands for a digit)", "^[D|d]\\d{5}$");
            pos = searchPetByID(id);
            if(pos>0)
                System.out.println("The dog id already exists.");
        } while (pos != -1);
        
        
        name = MyToy.getString("Input Dog name: ", "The Dog name is required");
        yob = MyToy.getAnInteger("Input Dog yob (2000 => 2020)", "The dog yob is required", 2000, 2020);
        weight = MyToy.getAnDouble("Input dog weight (0.1 => 99.0)", "The dog weight is required", 1.0, 99.0);
        petList.add(new Dog(id, name, yob, weight));
        System.out.println("A dog profile is added sucessfully");
    }
    //thêm mèo
    public void addCat(){
        String id, name;
        int yob;
        double weight;
        int pos;
        do {
            id = MyToy.getID("Input cat is Cxxxxx", "The format of id is Cxxxxx (X stands for a digit)", "^[C|c]\\d{5}$");
            pos = searchPetByID(id);
            if(pos>0)
                System.out.println("The cat id already exists.");
        } while (pos != -1);
        
        
        name = MyToy.getString("Input cat name: ", "The cat name is required");
        yob = MyToy.getAnInteger("Input cat yob", "The cat yob is required");
        weight = MyToy.getAnDouble("Input cat weight", "Weight is required");
        petList.add(new Cat(id, name, yob, weight));
        System.out.println("A dog profile is added sucessfully");
    }
    //nhập tìm kiếm thú = id
    public void searchPetByID(){
        String id;
        id = MyToy.getString("Input pet id: ", "Pet id is required");
        int x = searchPetByID(id);
        if(x == -1)
            System.out.println("Not found!!!!");
        else{
            System.out.println("Here is the Pet ");
            petList.get(x).showProfile();
        }
        
    }
    //hàm bổ trợ tìm thú (trùng id, tìm id)
    public int searchPetByID(String petID){
        if(petList.isEmpty())
            return -1;
        for (int i = 0; i < petList.size(); i++) {
            if(petList.get(i).getId().equalsIgnoreCase(petID))
               
                return i;
        }
        return -1;
    }
    
    //hàm cập nhật pet bởi ID
    public void updatePet(){
        String id;
        String newName;
        id = MyToy.getString("Input pet id", "Pet id is required");
        
        int x = searchPetByID(id);
        if(x == -1)
            System.out.println("Not found!!");
        else{
            System.out.println("Here is the Pet before updating");
            petList.get(x).showProfile();
            petList.get(x).setName(newName = MyToy.getString("input new name", "Name is required"));
            System.out.println("The pet info is updated successfully");
        }
    }
    
    //xóa pet bởi ID
    public void removePetByID(){
        String id;
        id = MyToy.getString("Input pet id", "Pet id is required");
        int x = searchPetByID(id);
        if(x == -1)
            System.out.println("Not found!!!");
        else
            petList.remove(x);
            System.out.println("Remove pet is successfully");
    }
    
    //sắp xếp pet theo tăng dần theo id
    public void printPetListAscendingByID(){
        if (petList.isEmpty()){
            System.out.println("The cage is empty.");
            return;
        }
        Collections.sort(petList);
        System.out.println("Here is the pet list");
        String header = String.format("|%-6s|%-15s|%4s|%4s|%4s|", "ID", "Name", "YOB", "WGHT", "SPD");
        System.out.println(header);
            for (int i = 0; i < petList.size(); i++) {
                petList.get(i).showProfile();
        }
    }
    
    public void printPetListAscendingByName(){
        if(petList.isEmpty()){
            System.out.println("Not found!!!");
            return;
        }
        Comparator nameBalance = new Comparator<Pet>() {
            @Override
            public int compare(Pet o1, Pet o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };
        Collections.sort(petList, nameBalance);
        System.out.println("Here is the pet list");
        String header = String.format("|%-6s|%-15s|%4s|%4s|%4s|", "ID", "Name", "YOB", "WGHT", "SPD");
        System.out.println(header);
        for (int i = 0; i < petList.size(); i++) {
            petList.get(i).showProfile();
        }
    }
}
