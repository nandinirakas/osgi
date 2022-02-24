package com.atmo.subtraction;

import java.util.Scanner;

import org.osgi.service.component.annotations.Component;

@Component
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

