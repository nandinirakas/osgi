package com.thelaunchclub.child1;

import java.util.Scanner;

public class Subtraction {
    
    public static int sub() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number for subtraction");
        int a = scanner.nextInt();
        System.out.println("Enter second number for subtraction");
        int b = scanner.nextInt();
        return a - b;
    }
}
