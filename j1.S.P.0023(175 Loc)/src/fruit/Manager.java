package fruit;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Manager {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Fruit> listFruit = new ArrayList<>();
    static Hashtable<String, ArrayList<Fruit>> order = new Hashtable<String, ArrayList<Fruit>>();

    //thêm 1 loại quả
    public void addNewFruit() {
        while (true) {
            String id, origin;
            String name;
            int price;
            int quantity;
            while (true) {
                id = GetData.getString("Input ID fruit", "Please don't not leave bank");
                if (checkID(id) != null) {
                    System.out.println("ID is exist, enter again");
                } else {
                    break;
                }
            }
            name = GetData.getString("Input name fruit", "Please don't not leave bank");
            price = GetData.getAnInteger("Input price fruit", "Please input number price fruit");
            quantity = GetData.getAnInteger("Input number quantity", "Please input number quantity");
            origin = GetData.getString("Input origin fruit", "Please don't not leave bank");
            listFruit.add(new Fruit(id, name, price, quantity, origin));
            if (!checkOrder("Do you want to continue (Y/N)? ")) {
                System.out.println("===List fruit created====");
                displayListFruit();
                break;
            }
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
    public void displayListOrder(ArrayList<Fruit> listOrder) {
        double total = 0;

        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit fruit : listOrder) {
            System.out.printf("%15s%15d%15d$%15d$\n", fruit.getFruitName(),
                    fruit.getQuantity(), fruit.getPrice(),
                    fruit.getPrice() * fruit.getQuantity());
            total += fruit.getPrice() * fruit.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    public Fruit checkID(ArrayList<Fruit> lo, String id) {
        for (Fruit fruit : lo) {
            if (fruit.getFruitID().equalsIgnoreCase(id)) {
                return fruit;
            }

        }
        return null;
    }

    public Fruit getFruitByItem(int item) {
        int count = 0;
        for (Fruit fruit : listFruit) {
            if (fruit.getQuantity() != 0) {
                count++;
            }
            if (count == item) {
                return fruit;

            }

        }
        return null;
    }

    public void shopping() {
        if (listFruit.isEmpty()) {
            System.err.println("No have item.");
            return;
        }
        ArrayList<Fruit> orderList = new ArrayList<>();
        while (true) {
            displayListFruit();
            int item = GetData.getAnInteger("Input number item", "Please input number integer", 1, listFruit.size() + 1);

            int quantity = GetData.getAnInteger("Input the quantity", "Please input integer");
            Fruit fruit = getFruitByItem(item);
            //order trùng id thì chỉ update thôi ko thêm
            if (checkID(orderList, fruit.getFruitID()) == null) {
                orderList.add(new Fruit(fruit.getFruitID(), fruit.getFruitName(), fruit.getPrice(),
                        fruit.getQuantity(), fruit.getOrigin()));
            } else {
                System.out.println("You have already selected this item, update");
                orderList.get(item - 1).setQuantity(orderList.get(item - 1).getQuantity() + quantity);
            }
            if (checkOrder("Would you like to choose more fruit?(Y/N) ")) {
                //listFruit.get(item).setPrice(quantity * listFruit.get(item).getPrice());
                break;
            }
        }
        displayListOrder(orderList);
        String name = GetData.getString("Input name customer", "Please input string name");
        order.put(name, orderList);
        System.out.println("Add order successfull, thank you for buying!");
    }

    //hiện thị danh sách hàng đặt của từng người
    public void showOrder() {
        if (order.isEmpty()) {
            System.out.println("No items is list");
        } else {
            System.out.println("====List order====");
            for (String name : order.keySet()) {
                System.out.println("Customer: " + name);
                ArrayList<Fruit> lo = order.get(name);
                displayListOrder(lo);
            }

        }
    }

}
