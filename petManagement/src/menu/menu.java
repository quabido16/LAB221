/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import input.MyToy;
import java.util.ArrayList;

/**
 *
 * @author hii
 */
public class menu {
    private ArrayList<String> optionList = new ArrayList<>();
    
    public void addNewOption(String newOption){
        optionList.add(newOption);
    }
    
    public void printMenu(){
        if(optionList.isEmpty()){
            System.out.println("There is no item in the menu");
        }
        System.out.println("\n-------------------------------");
        for (String s : optionList) {
            System.out.println(s);
        }
    }
    public int getChoice(){
        int maxOption = optionList.size() - 1;
        String input = "Choose [1..." + maxOption + "]: ";
        String error = "You are required to choose the option 1..." + maxOption;
        return MyToy.getAnInteger(input, error, 1, maxOption);
    }
}
