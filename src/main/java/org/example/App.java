package org.example;

import org.example.domain.crud.InventoryCrud;
import org.example.domain.entities.Product;
import org.example.services.InventoryService;
import org.example.services.MenuService;
import org.example.services.ProductService;

public class App {
    public static void main(String[] args ) {

        System.out.println("*--------------------*");
        System.out.println(" Proyecto Integrador ");
        System.out.println("*--------------------*");

        MenuService menuService = new MenuService();
        menuService.selectOptionMenuP();
    }
}
