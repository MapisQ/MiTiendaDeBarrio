package org.example;

import org.example.Services.MenuService;

public class App {
    public static void main(String[] args ) {

        System.out.println("*--------------------*");
        System.out.println(" Proyecto Integrador ");
        System.out.println("*--------------------*");

        MenuService menuService = new MenuService();
        menuService.selectOptionMenuP();
    }
}
