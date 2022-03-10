package com.thelaunchclub.userinput;

import java.util.Scanner;

public class UserInput {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String getString(String stringContent) {
        System.out.println(stringContent);
        return SCANNER.next().trim();
    }
}
