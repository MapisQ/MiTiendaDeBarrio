package org.example.Services;

import org.example.Domain.Entities.BougthProduct;
import org.example.Domain.Entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SalesService {

    ProductService productService = new ProductService();

    List<BougthProduct> dataSales = new ArrayList<>();
    List<Integer> Prices = new ArrayList<>();

    //Metodo constructor
    public SalesService(List<BougthProduct> dataSales, List<Integer> prices) {
        this.dataSales = dataSales;
        Prices = prices;
    }

    public SalesService() {}

    //Metodos Getter y setter
    public List<BougthProduct> getDataSales() {
        return dataSales;
    }
    public void setDataSales(List<BougthProduct> dataSales) {
        this.dataSales = dataSales;
    }

    public List<Integer> getPrices() {
        return Prices;
    }
    public void setPrices(List<Integer> prices) {
        Prices = prices;
    }

    int cantiCompra = 0;
    String nombreCompra = "";
    int conversiontotalCompra = 0;
    int totalFinal = 0;

    public void SalesTotal(){

        Scanner compra = new Scanner(System.in);
        System.out.println("Por favor ingrese el nombre del producto a comprar");
        nombreCompra = compra.nextLine();
        String finalNombreCompra = nombreCompra;
        System.out.println(productService.getListProductsInventory());
        Optional<Product> productOptional = productService.findProductByIdOrName(finalNombreCompra);
        System.out.println(productOptional);

//        <Optional > containsProduct =productService.getListProductsInventory().stream().filter(product->String.valueOf(product.getName()).equals(finalNombreCompra));




        if (productOptional.isPresent()) {
            System.out.println("El producto SI se encuentra en inventario");
            Product productInList= productService.getListProductsInventory().stream().filter(x->x.getName().toLowerCase().equals(finalNombreCompra)).findFirst().orElse(null);

            System.out.println("Por favor ingrese la cantidad de " + nombreCompra + " que compra el cliente");
            cantiCompra = compra.nextInt();
            compra.nextLine();

            double IVA = 0.19;
            double totalIva = productInList.getPrice() * IVA;
            double total = totalIva + productInList.getPrice();
            double totalCompra = total * cantiCompra;
            conversiontotalCompra = (int) totalCompra;

            BougthProduct productbougth = new BougthProduct(nombreCompra, conversiontotalCompra, cantiCompra, totalFinal);
            dataSales.add(productbougth);
            getPrices().add(conversiontotalCompra);

            totalFinal = getPrices().stream().mapToInt(Integer::intValue).sum();
            BougthProduct bougthProduct = new BougthProduct();
            int quantityProductInList = productInList.getQuantity();

            int inventaryFinal= quantityProductInList-cantiCompra;
            productInList.setQuantity(inventaryFinal);
        } else {
            System.out.println("El producto no se encuentra en el inventario");
        }
    }

    public void printSale(ProductService productService) {

        System.out.println("*----------------------------------------------*");
        System.out.println("        PRODUCTOS COMPRADOS  ");
        getDataSales().stream().forEach(x-> System.out.println(x));
        System.out.println("\n");
        System.out.println("Total de la compra: " + totalFinal);
        System.out.println("*----------------------------------------------*");
    }

}


