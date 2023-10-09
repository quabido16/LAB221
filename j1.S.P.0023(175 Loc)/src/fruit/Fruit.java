/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit;

/**
 *
 * @author hii
 */
public class Fruit {
    private String fruitID;
    private String fruitName;
    private int price;
    private int quantity;
    private String origin;

    public Fruit() {
    }

    public Fruit(String fruitID, String fruitName, int price, int quantity, String origin) {
        this.fruitID = fruitID;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public String getFruitID() {
        return fruitID;
    }

    public void setFruitID(String fruitID) {
        this.fruitID = fruitID;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    
}
