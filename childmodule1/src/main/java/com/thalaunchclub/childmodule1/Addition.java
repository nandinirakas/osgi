package com.thalaunchclub.childmodule1;

import java.util.Scanner;

import org.osgi.service.component.annotations.Component;

@Component
public class Addition {
    
    public static int add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number for addition");
        int a = scanner.nextInt();
        System.out.println("Enter second number for addition");
        int b = scanner.nextInt();
        return a + b;
    }
}
