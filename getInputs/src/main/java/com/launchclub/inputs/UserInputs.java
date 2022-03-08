package com.launchclub.inputs;


import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UserInputs {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getString(String stringContent) {
        System.out.println(stringContent);
        return SCANNER.next().trim();
    }
}
