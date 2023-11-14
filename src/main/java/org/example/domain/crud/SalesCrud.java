package org.example.domain.crud;

import org.example.SuperKeyBoard;
import org.example.domain.ProductServiceInterface;
import org.example.services.MenuService;
import org.example.services.ProductService;
import org.example.services.SalesService;

public class SalesCrud implements ProductServiceInterface {

    private ProductService productService;
    private  MenuService menuService;

    public SalesCrud(ProductService productService, MenuService menuService) {

        this.productService=productService;
        this.menuService=menuService;
    }
    private SalesService salesService = new SalesService(productService);


    @Override
    public void addProduct() {

        System.out.println("¿Desea ingresar un producto a la venta?");
        System.out.println("| 1. Si              |");
        System.out.println("| 2. No              |");

        //Este es el del do while que indica que mientras opcion1 sea diferente a 2 va a seguir ejerciendo el do while
        int opcion1 = SuperKeyBoard.readNumber();

        do {
            switch (opcion1) {
                case 1: salesService.SalesTotal(productService);
                    System.out.println("¿Desea ingresar un producto a la venta?");
                    System.out.println("| 1. Si              |");
                    System.out.println("| 2. No              |");
                    opcion1 = SuperKeyBoard.readNumber();
                    break;
                case 2:menuService.selectOptionMenuS();
                    //System.out.println("Salió del menú");
                    break;
                default:
                    System.out.println("La opción seleccionada no es valida");
                    break;
            }

        }while (opcion1 != 2) ;
    }
    @Override
    public void modifyProduct() {}

    @Override
    public void removeProduct() {}

    @Override
    public void searchProduct() {}

    public void printSale(){
        salesService.printSale(productService);
    }


}
