package org.example.Services;


import org.example.Domain.Entities.Product;
import org.example.Enums.ECategory;

import java.util.*;

public class ProductService {
    private final List<Product> listProductsInventory = new ArrayList<>();

    public ProductService() {}

    //Metodos getter y setter
    public List<Product> getListProductsInventory() {
        return listProductsInventory;
    }

//    public void setListProductsInventory(List<Product> listProductsInventory) {
//        this.listProductsInventory = listProductsInventory;
//    }

    //Metodos de la clase ProductService
    public void addProductAtList(Product product){
        if (!listProductsInventory.contains(product)){
            listProductsInventory.add(product);
            System.out.println("¡Producto agregado al inventario!");
        }else {
            System.out.println("El producto ya se encuentra en el inventario :(");
        }
    }

    public Optional<Product> lookForProduct(int id){
        return listProductsInventory.stream().filter(product -> product.getIdProduct()==id).findAny();
    }

    public Optional<Product> findProductByName(String name) {
        return listProductsInventory.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findAny();
    }

    public void printProduct() {listProductsInventory.stream().forEach(product -> System.out.println(product)); }

    public ECategory selectCategoryProduct(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor seleccione una de las categorias que se muestran a continuación: ");
        for (int i=0;i<ECategory.values().length;i++){
            System.out.println((i+1)+". "+ECategory.values()[i].getValue());
        }
        int option = scanner.nextInt();
        if (option>=1 && option<=ECategory.values().length){
            return ECategory.values()[option-1];
        }else {
            return selectCategoryProduct();
        }
    }

    //Metodo toString
    @Override
    public String toString() {
        return "ProductService{" +
                "listProductsInventory=" + listProductsInventory +
                '}';
    }
}
