package com.thelaunchclub.childmodule3;

import java.util.Scanner;

import org.osgi.service.component.annotations.Component;

@Component
public class Multiplication {
    
    public static int multiply() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number for multiplication");
        int a = scanner.nextInt();
        System.out.println("Enter second number for multiplication");
        int b = scanner.nextInt();
        return a * b;
    }
}
