package com.thalaunchclub.childmodule1;

import org.osgi.service.component.annotations.Component;

@Component
public class Welcome {

    public static void greetings() {
        System.out.println("Welcome\nEnter numbers for addition and subtraction");
    }
    
    public static void exit() {
        System.out.println("Thank you");
    }
}
