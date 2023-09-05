/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Random;

/**
 *
 * @author hii
 */
public class Cat extends Pet{
    private static final double MAX_SPEED = 30.0;
    
    public Cat(String id, String name, int yob, double weight) {
        super(id, name, yob, weight);
    }

    @Override
    public double run() {
        return new Random().nextDouble() * MAX_SPEED;
    }

    @Override
    public void showProfile() {
        String msg = String.format("|%6s|%-15s|%4d|%4.1f|%4.1f|", id, name, yob, weight, run());
        System.out.println(msg);
    }




    
}
