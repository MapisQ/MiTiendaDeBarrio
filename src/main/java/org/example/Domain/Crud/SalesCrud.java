package org.example.Domain.Crud;

import org.example.Domain.ProductServiceInterface;
import org.example.Services.SalesService;
import java.util.Scanner;

public class SalesCrud implements ProductServiceInterface {
    SalesService salesService = new SalesService();


    @Override
    public void addProduct() {
        Scanner selec = new Scanner(System.in);

        System.out.println("¿Desea ingresar un producto a la venta?");
        System.out.println("| 1. Si              |");
        System.out.println("| 2. No              |");

        //Este es el del do while que indica que mientras opcion1 sea diferente a 2 va a seguir ejerciendo el do while
        int opcion1 = selec.nextInt();

        do {
            switch (opcion1) {
                case 1: salesService.SalesTotal();
                    System.out.println("¿Desea ingresar un producto a la venta?");
                    System.out.println("| 1. Si              |");
                    System.out.println("| 2. No              |");
                    opcion1 = selec.nextInt();
                    break;
                case 2:
                    System.out.println("Salió del menú");
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


}
