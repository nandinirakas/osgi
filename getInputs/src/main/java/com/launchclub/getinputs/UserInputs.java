package com.launchclub.getinputs;

import java.util.Scanner;

public class UserInputs {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String getString(String stringContent) {
        System.out.println(stringContent);
        return SCANNER.next().trim();
    }
}
