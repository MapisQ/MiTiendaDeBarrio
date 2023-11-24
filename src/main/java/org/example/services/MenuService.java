package org.example.services;

import org.example.SuperKeyBoard;
import org.example.domain.crud.InventoryCrud;
import org.example.domain.crud.ProductCrud;
import org.example.domain.crud.SalesCrud;
import org.example.domain.entities.Product;
import org.example.menus.InventoryMenu;
import org.example.menus.PrincipalMenu;
import org.example.menus.SalesMenu;
import org.example.menus.UpdateProductMenu;
import java.util.InputMismatchException;

public class MenuService {
    public MenuService() {}

    Product product =new Product();

    ProductService productService = new ProductService();
    InventoryService inventoryService = new InventoryService(product,productService);

    InventoryCrud inventoryCrud = new InventoryCrud(productService);
    ProductCrud productCrud = new ProductCrud(productService,this,inventoryService);
    SalesCrud sales = new SalesCrud(productService,this);



    //Metodos para seleccionar alguna opción en los menus
    public PrincipalMenu selectOptionMenuP(){

        inventoryService.readCSV();

        System.out.println("Por favor seleccione una opción: ");
        System.out.println(PrincipalMenu.PRINCIPAL_MENU);
        int option = SuperKeyBoard.readNumber();
        try {
            if (option < 1 || option > 3) {
                System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
                selectOptionMenuP();
            } else if (option>=1 || option<=3) {
                switch (option) {
                    case 1: selectOptionMenuI();
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

    public PrincipalMenu selectOptionMenuI() {

        System.out.println("Por favor seleccione una opción: ");
        System.out.println(InventoryMenu.INVENTORY_MENU);
        int option =SuperKeyBoard.readNumber();

    try {
        if (option < 1 || option > 9) {
            System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
            selectOptionMenuI();
        } else if (option >= 1 || option <= 9) {
            switch (option) {
                case 1:productCrud.addProduct();
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
                    //productCrud.printAllInventory();
                    productCrud.printAllInventory();
                    //System.out.println("La lista de invetario es: ");
                    break;
                case 6:selectOptionMenuS();
                    //System.out.println("Esta en el menú de ventas");
                    break;
                case 7:
                    selectOptionMenuP();
                    //System.out.println("Esta en el menú principal");
                    break;
                case 8:
                    System.exit(0);
                    //System.out.println("Esta en el menú principal");
            }
        }
    }catch (InputMismatchException e) {
        System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
        selectOptionMenuI();
    }
    return selectOptionMenuI();
}

    public SalesMenu selectOptionMenuS(){

        System.out.println("Por favor seleccione una opción: ");
        System.out.println(SalesMenu.SALES_MENU);
        int option = SuperKeyBoard.readNumber();

        try {
        if (option < 1 || option > 5) {
            System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
            selectOptionMenuS();
        } else if (option>=1 || option<=5) {
            switch (option) {
                case 1: sales.addProduct();
                    //System.out.println("ha generado una venta");
                    break;
                case 2:sales.printSale();
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

    public UpdateProductMenu selectOptionMenuUP() {

        System.out.println("Por favor seleccione una opción valida: ");
        System.out.println(UpdateProductMenu.SELECT_UPDATE_PRODUCT);
        int option = SuperKeyBoard.readNumber();

        try {
            if (option < 1 || option > 7) {
                System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
                selectOptionMenuUP();

            } else if (option>=1 || option<=6) {
                productCrud.modifyProduct();
            } else if (option==7) {
                selectOptionMenuI();
            }
        } catch (InputMismatchException e) {
            System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
            selectOptionMenuUP();
        }
        return selectOptionMenuUP();
    }
}
