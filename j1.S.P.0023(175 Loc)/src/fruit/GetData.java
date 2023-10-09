/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fruit;

import java.util.Scanner;

//tất cả các hàm nhập xuất chặn tất cả các trường hợp
public class GetData {

    private static Scanner sc = new Scanner(System.in);

    //nhập số nguyên, chặn các TH
    public static int getAnInteger(String input, String error) {
        int n;
        while (true) {
            try {
                System.out.println(input);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(error);

            }
        }
    }

    public static int getAnInteger(String input, String error, int lowerBound, int upperBound) {
        int n;
        while (true) {
            try {
                System.out.println(input);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public static double getAnDouble(String input, String error, double lowerBound, double upperBound) {
        double n;
        while (true) {
            try {
                System.out.println(input);
                n = Double.parseDouble(sc.nextLine());

                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    //nhập số thực, chặn các TH
    public static double getAnDouble(String input, String error) {
        double n;
        while (true) {
            try {
                System.out.println(input);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    //nhập đúng định dạng ID
    public static String getID(String input, String error, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.println(input);
            id = sc.nextLine().trim();
            match = id.matches(format);
            if (id.isEmpty() || id.length() == 0 || match == false) {
                System.out.println(error);
            } else {
                return id;
            }
        }
    }

    //nhập chuỗi kí tự, chặn các TH
    public static String getString(String input, String error) {
        String msg;
        while (true) {
            System.out.println(input);
            msg = sc.nextLine().trim();
            if (msg.length() == 0 || msg.isEmpty()) {
                System.out.println(error);
          
            } else {
                return msg;
            }
        }
    }
}
