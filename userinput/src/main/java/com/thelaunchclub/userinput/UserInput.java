package com.thelaunchclub.userinput;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class UserInput {

    public static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Gets inputs given by users.
     *
     * @param stringContent
     */
    public static String getString(String stringContent) {
        System.out.println(stringContent);
        return SCANNER.next().trim();
    }
}
