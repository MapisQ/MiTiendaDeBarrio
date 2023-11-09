package org.example.Services;

import org.example.Domain.Crud.ProductCrud;
import org.example.Domain.Crud.SalesCrud;
import org.example.Menus.InventoryMenu;
import org.example.Menus.PrincipalMenu;
import org.example.Menus.SalesMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuService {

    ProductService productService = new ProductService();
    ProductCrud productCrud = new ProductCrud(productService);
    SalesService salesService = new SalesService(productService);
    SalesCrud sales = new SalesCrud(productService);


    //Metodos para seleccionar alguna opción en los menus
    public PrincipalMenu selectOptionMenuP(){
        
        Scanner menuP = new Scanner(System.in);

        System.out.println("Por favor seleccione una opción: ");
        System.out.println(PrincipalMenu.PRINCIPAL_MENU);
        int option = menuP.nextInt();
        try {
            if (option < 1 || option > 3) {
                System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
                selectOptionMenuP();
            } else if (option>=1 || option<=3) {
                switch (option) {
                    case 1:selectOptionMenuI();
                        //System.out.println("Menu inventario");
                        break;
                    case 2:selectOptionMenuS();
                        //System.out.println("Menu Ventas");
                        break;
                    case 3:System.exit(0);
                        //System.out.println("Saliendo...");
                        break;
                }
                
            }
        } catch (InputMismatchException e) {
            System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
            selectOptionMenuP();
        }
        return selectOptionMenuP();
    }

    public InventoryMenu selectOptionMenuI() {
        Scanner menuI = new Scanner(System.in);


        System.out.println("Por favor seleccione una opción: ");
        System.out.println(InventoryMenu.INVENTORY_MENU);
        int option = menuI.nextInt();

    try {
        if (option < 1 || option > 7) {
            System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
            selectOptionMenuI();
        } else if (option >= 1 || option <= 7) {
            switch (option) {
                case 1:
                    productCrud.addProduct();
                    //System.out.println("Has registrado un producto");
                    break;
                case 2:
                    productCrud.removeProduct();
                    //System.out.println("Has eliminado un producto");
                    break;
                case 3:
                    productCrud.searchProduct();
                    //System.out.println("Ha consultado un producto");
                    break;
                case 4:
                    productCrud.modifyProduct();
                    //System.out.println("Ha modificado un producto");
                    break;
                case 5:
                    productService.printProduct();
                    //System.out.println("La lista de invetario es: ");
                    break;
                case 6:
                    selectOptionMenuS();
                    //System.out.println("Esta en el menú de ventas");
                    break;
                case 7:
                    selectOptionMenuP();
                    //System.out.println("Esta en el menú principal");
                    break;
            }
        }


    }catch (InputMismatchException e) {
            System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
            selectOptionMenuI();
        }
        return selectOptionMenuI();
    }

    public SalesMenu selectOptionMenuS(){

        Scanner menuS = new Scanner(System.in);

        System.out.println("Por favor seleccione una opción: ");
        System.out.println(SalesMenu.SALES_MENU);
        int option = menuS.nextInt();

        try {
        if (option < 1 || option > 5) {
            System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
            selectOptionMenuS();
        } else if (option>=1 || option<=5) {
            switch (option) {
                case 1: sales.addProduct();
                    //System.out.println("ha generado una venta");
                    break;
                case 2:salesService.printSale();
                    //System.out.println("Ha impreso una factura");
                    break;
                case 3:selectOptionMenuI();
                    //System.out.println("Esta en el menú de inventario");
                    break;
                case 4:selectOptionMenuP();
                    //System.out.println("Esta en el menú principal");
                    break;
                case 5:
                    System.exit(0);
                    //System.out.println("La lista de invetario es: ");
                    break;
            }
        }
    }catch (InputMismatchException e) {
            System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
            selectOptionMenuS();
        }
        return selectOptionMenuS();
    }
}
