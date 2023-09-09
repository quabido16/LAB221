/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;

import static java.lang.System.in;
import java.util.Scanner;

/**
 *
 * @author hii
 */
public class Bill {

    /**
     * @param args the command line arguments
     */
    final static private Scanner sc = new Scanner(System.in);

    private static int checkInputInt() {
        while (true) {
            try {
                int n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println("please input a number");
            }
        }
    }   
    private static int[] inputBill(){
        System.out.println("Input number bill:");
        int size = checkInputInt();
        int bill [] = new int[size];
        for (int i = 0; i < bill.length; i++) {
            System.out.print("Input value of bill " + (i + 1) + ":");
            bill[i] = checkInputInt();
        }
        
        return bill;
    }
    private static int totalBill(int[] bill){
        int total = 0;
        for (int i = 0; i < bill.length; i++) {
            total += bill[i];
        }
        return total;
        
    }
    private static int inputWallet(){
        System.out.print("Input value of wallet: ");
        int wallet = checkInputInt();
        return wallet;
    }
    private static boolean payMoney(int total, int value){
        if(total > value){
            return false;
        }
        return true;
    } 
    private static void printBill(int[] bill, int wallet){
        int totalBill = totalBill(bill);
        System.out.println("This is total bill: " + totalBill);
        if(payMoney(totalBill, wallet)){
            System.out.println("You can buy it");
        }else{
            System.out.println("Tou can't buy it");
        }
    }
    public static void main(String[] args) {
        int bill[] = inputBill();
        int wallet = inputWallet();
        printBill(bill, wallet);
        
    }
    
}
