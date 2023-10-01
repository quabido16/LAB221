/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import input.myToys;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author hii
 */
public class Cabinet {

    final Scanner sc = new Scanner(System.in);
    ArrayList<Fruit> listFruit = new ArrayList<>();
    Hashtable<String, ArrayList<order>> hashMap = new Hashtable<String, ArrayList<order>>();
    //thêm 1 loại quả
    public void addNewFruit(boolean x) {
        if (x == true) {
            String id, origin;
            String name;
            int price;
            int quantity;
            id = myToys.getString("Input ID fruit", "Please don't not leave bank");
            name = myToys.getString("Input name fruit", "Please don't not leave bank");
            price = myToys.getAnInteger("Input price fruit", "Please input number price fruit");
            quantity = myToys.getAnInteger("Input number quantity", "Please input number quantity");
            origin = myToys.getString("Input origin fruit", "Please don't not leave bank");
            listFruit.add(new Fruit(id, name, price, quantity, origin));
        } else {
            return;
        }
    }
    //xác nhận xem có chắc chắn muốn đặt hàng, thêm loại trái cây
    public boolean yesNoqs(String x) {
        System.out.println(x);
        String choose;
        choose = sc.nextLine();
        if (choose.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }
    //cập nhật trái cây
    public void updateFruid() {
        String id, origin;
        String name;
        int price;
        int quantity;
        id = myToys.getString("Input id", "Please input id");
        int x = checkID(id);
        System.out.println(x);
        if (x >= 0) {
            System.out.println("Update the fruit now");
            listFruit.get(x).setQuantity(myToys.getAnInteger("Input the new quantity", "Please input number quantity"));
        } else {
            if (yesNoqs("No search the id required. Can you create the new fruit(Y/N)")) {
                id = myToys.getString("Input ID fruit", "Please don't not leave bank");
                name = myToys.getString("Input name fruit", "Please don't not leave bank");
                price = myToys.getAnInteger("Input price fruit", "Please input number price fruit");
                quantity = myToys.getAnInteger("Input number quantity", "Please input number quantity");
                origin = myToys.getString("Input origin fruit", "Please don't not leave bank");
                listFruit.add(new Fruit(id, name, price, quantity, origin));
            } else {
                return;
            }
        }

    }

    public int checkID(String id) {
        if (listFruit.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < listFruit.size(); i++) {
            if (listFruit.get(i).getFruitID().equalsIgnoreCase(id)) {
                return i;
            }
        }

        return -1;
    }

   

    public void displayListFruit(ArrayList<Fruit> lf) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : lf) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-10d$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }
    //hiện thị danh sách trong Order
    public void displayListOrder(ArrayList<order> lo) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (order order : lo) {
            System.out.printf("%15s%15d%15d$%15d$\n", order.getName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }
    
    
    public int checkID(ArrayList<order> lo, int item) {
        if (lo.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < lo.size(); i++) {
            if (lo.get(i).getId().equalsIgnoreCase(listFruit.get(item-1).getFruitID())) {
                return i;
            }
        }

        return -1;
    }
    public void shopping() {
        if (listFruit.isEmpty()) {
            System.err.println("No have item.");
            return;
        }
        ArrayList<order> orderList = new ArrayList<>();
        while (true) {
            displayListFruit(listFruit);
            int item = myToys.getAnInteger("Input number item", "Please input number integer", 1, listFruit.size() + 1);

            int quantity = myToys.getAnInteger("Input the quantity", "Please input integer");
            
            //order trùng id thì chỉ update thôi ko thêm
            if(checkID(orderList, item) < 0){
                orderList.add(new order(listFruit.get(item-1).getFruitID(), listFruit.get(item-1).getFruitName(), quantity,listFruit.get(item-1).getPrice()));
            }else{
                System.out.println("You have already selected this item, update");
                orderList.get(item-1).setQuantity(quantity);
                
            }
            
            
            
            if (yesNoqs("Would you like to choose more fruit?(Y/N) ")) {
                //listFruit.get(item).setPrice(quantity * listFruit.get(item).getPrice());
                break;
            }
        }
        displayListOrder(orderList);
        String name = myToys.getString("Input name customer", "Please input string name");
        hashMap.put(name, orderList);
        System.out.println("Add order successfull, thank you for buying!");
    }
    //hiện thị danh sách hàng đặt của từng người
    public void showOrder() {
        if (hashMap.isEmpty()) {
            System.out.println("No items is list");
        } else {
            for (String name : hashMap.keySet()) {
                System.out.println("Customer: " + name);
                ArrayList<order> lo = hashMap.get(name);
                displayListOrder(lo);
            }

        }
    }

}
