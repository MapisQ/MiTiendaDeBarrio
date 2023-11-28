package org.example;

import org.example.connectionDB.DataBaseConnection;
import org.example.services.MenuService;

public class App {
    public static void main(String[] args ) {

        DataBaseConnection dbConnection = new DataBaseConnection();
        dbConnection.insertData();

        System.out.println("*--------------------*");
        System.out.println(" Proyecto Integrador ");
        System.out.println("*--------------------*");


        MenuService menuService = new MenuService();
        menuService.selectOptionMenuP();
    }
}
