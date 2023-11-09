package org.example.Services;

import org.example.Domain.Entities.BougthProduct;
import org.example.Domain.Entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class SalesService {

    private List<BougthProduct> dataSales = new ArrayList<>();
    private List<Integer> prices = new ArrayList<>();

    int cantiCompra = 0;
    String nombreCompra = "";
    int conversiontotalCompra = 0;
    int totalFinal = 0;
    private ProductService productService;

    //Metodo constructor
   public SalesService(ProductService productService) {}


    //Metodos Getter y setter
    public List<BougthProduct> getDataSales() {
        return dataSales;
    }
    public void setDataSales(List<BougthProduct> dataSales) {
        this.dataSales = dataSales;
    }

    public List<Integer> getPrices() {
        return prices;
    }
    public void setPrices(List<Integer> prices) {
        prices = prices;
    }

    Scanner compra = new Scanner(System.in);
    public void SalesTotal(ProductService productService){

        System.out.println("Por favor ingrese el nombre del producto a comprar");
        nombreCompra = compra.nextLine();

        Optional<Product> productOptional = productService.findProductByName(nombreCompra);
        //System.out.println(productOptional);

        if (productOptional.isPresent()) {
            //System.out.println("El producto SI se encuentra en inventario");
            Product productInList= productOptional.stream().filter(x->x.getName().equals(nombreCompra)).findFirst().orElse(new Product());

            System.out.println("Por favor ingrese la cantidad de " + nombreCompra + " que compra el cliente");
            cantiCompra = compra.nextInt();
            compra.nextLine();

            double IVA = 0.19;
            double totalIva = productInList.getPrice() * IVA;
            double total = totalIva + productInList.getPrice();
            double totalCompra = total * cantiCompra;

            BougthProduct productbougth = new BougthProduct(nombreCompra, (int) total, cantiCompra);
            getDataSales().add(productbougth);
            //System.out.println(getDataSales());

            getPrices().add((int) totalCompra);
            //System.out.println(getPrices());

            totalFinal = getPrices().stream().mapToInt(Integer::intValue).sum();

            int quantityProductInList = productInList.getQuantity();

            int inventaryFinal= quantityProductInList-cantiCompra;
            //System.out.println(inventaryFinal);
            productInList.setQuantity(inventaryFinal);

            System.out.println(getDataSales());
            System.out.println(totalFinal);
        }
        else {
            System.out.println("El producto no se encuentra en el inventario");
        }
    }

    public void printSale() {

        System.out.println("*----------------------------------------------*");
        System.out.println("        PRODUCTOS COMPRADOS  ");
        System.out.println(getDataSales());
        System.out.println("\n");
        System.out.println("Total de la compra: " + totalFinal);
        System.out.println("*----------------------------------------------*");
    }

}


