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

public class Manager {

    final Scanner sc = new Scanner(System.in);
    ArrayList<Fruit> listFruit = new ArrayList<>();
    Hashtable<String, ArrayList<Order>> hashMap = new Hashtable<String, ArrayList<Order>>();

    //thêm 1 loại quả
    public void addNewFruit(boolean x) {
        if (x == true) {
            String id, origin;
            String name;
            int price;
            int quantity;

            while (true) {
                id = myToys.getString("Input ID fruit", "Please don't not leave bank");
                if (checkID(id) != null) {
                    System.out.println("ID is exist, enter again");
                } else {
                    break;
                }
            }
            name = myToys.getString("Input name fruit", "Please don't not leave bank");
            price = myToys.getAnInteger("Input price fruit", "Please input number price fruit");
            quantity = myToys.getAnInteger("Input number quantity", "Please input number quantity");
            origin = myToys.getString("Input origin fruit", "Please don't not leave bank");
            listFruit.add(new Fruit(id, name, price, quantity, origin));
        } else {
            if (!listFruit.isEmpty()) {
                displayListFruit();
            }
            return;
        }
    }

    //xác nhận xem có chắc chắn muốn đặt hàng, thêm loại trái cây
    public boolean checkOrder(String x) {
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
    }

    public Fruit checkID(String id) {

        for (Fruit fruit : listFruit) {
            if (fruit.getFruitID().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }

    public void displayListFruit() {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : listFruit) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-20s%-10d$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    //hiện thị danh sách trong Order
    public void displayListOrder(ArrayList<Order> lo) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : lo) {
            System.out.printf("%15s%15d%15d$%15d$\n", order.getName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    public int checkID(ArrayList<Order> lo, int item) {
        if (lo.isEmpty()) {
            return -1;
        }

        for (int i = 0; i < lo.size(); i++) {
            if (lo.get(i).getId().equalsIgnoreCase(listFruit.get(item - 1).getFruitID())) {
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
        ArrayList<Order> orderList = new ArrayList<>();
        while (true) {
            displayListFruit();
            int item = myToys.getAnInteger("Input number item", "Please input number integer", 1, listFruit.size() + 1);

            int quantity = myToys.getAnInteger("Input the quantity", "Please input integer");

            //order trùng id thì chỉ update thôi ko thêm
            if (checkID(orderList, item) < 0) {
                orderList.add(new Order(listFruit.get(item - 1).getFruitID(), listFruit.get(item - 1).getFruitName(),
                        quantity, listFruit.get(item - 1).getPrice()));
            } else {
                System.out.println("You have already selected this item, update");
                orderList.get(item - 1).setQuantity(quantity);
            }
            if (checkOrder("Would you like to choose more fruit?(Y/N) ")) {
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
                ArrayList<Order> lo = hashMap.get(name);
                displayListOrder(lo);
            }

        }
    }

}
