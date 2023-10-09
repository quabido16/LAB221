/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit;

import fruit.GetData;
import java.util.ArrayList;

/**
 *
 * @author hii
 */
public class Menu {
    private String nameMenu;
    private ArrayList<String> optionList = new ArrayList<>();

    public Menu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public void addNewOption(String newOption) {
        optionList.add(newOption);
    }

    public void printMenu() {
        if (optionList.isEmpty()){
            System.out.println("These are no items");
            return;
        }
        System.out.println("Welcome to " + nameMenu);
        
            for (String s : optionList) {
                
                System.out.println(s);
            }
        }
    public int getChoice(){
        String input = "Choose 1..." + optionList.size();
        String error = "Please input integer";
        return GetData.getAnInteger(input, error, 1, optionList.size());
        
    }
}
    


