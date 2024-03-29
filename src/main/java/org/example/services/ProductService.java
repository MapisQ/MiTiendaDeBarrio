package org.example.services;


import org.example.SuperKeyBoard;
import org.example.domain.entities.Product;
import org.example.enums.ECategory;

import java.util.*;

public class ProductService {
    private final List<Product> listProductsInventory = new ArrayList<>();

    public ProductService() {}

    //Metodos getter y setter
    public List<Product> getListProductsInventory() {
        return listProductsInventory;
    }

    //Metodos de la clase ProductService
    public void addProductAtList(Product product){
        if (!listProductsInventory.contains(product)){
            listProductsInventory.add(product);
            //System.out.println(listProductsInventory);
            System.out.println("¡Producto agregado al inventario!");
        }else {
            System.out.println("El producto ya se encuentra en el inventario");
        }
    }

    public Optional<Product> findProductById(int id){
        return listProductsInventory.stream().filter(product -> product.getIdProduct()==id).findAny();
    }

    public Optional<Product> findProductByName(String name) {
        return listProductsInventory.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findAny();
    }

    public ECategory selectCategoryProduct(){

        System.out.println("Por favor seleccione una de las categorias que se muestran a continuación: ");
        for (int i=0;i<ECategory.values().length;i++){
            System.out.println("|-------------------------------------|");
            System.out.println("  "+(i+1)+". "+ECategory.values()[i].getValue());
        }
        System.out.println("|-------------------------------------|");
        try {
            int option = SuperKeyBoard.readNumber();
            if (option>=1 && option<=ECategory.values().length){
                return ECategory.values()[option-1];
            }else {
                return selectCategoryProduct();
            }

        }catch (InputMismatchException ex){
            System.out.println("Ingresa un valor valido para la categoria \n");
            return selectCategoryProduct();
        }
    }

    public String updateNameProduct(){
        System.out.println("Por favor ingrese el nombre que desea actualizar");
        String updateName = SuperKeyBoard.readText();

        return updateName;
    }

    public String updateDescriptionProduct(){
        SuperKeyBoard.readText();
        System.out.println("Por favor ingrese la descripción que desea actualizar");
        String updateDescrip = SuperKeyBoard.readText();

        return updateDescrip;
    }
    public int updatePriceProduct(){

        System.out.println("Por favor ingrese el precio que desea actualizar:");
        int updatePrice = SuperKeyBoard.readNumber();

        return updatePrice;
    }
    public int updateQuantityProduct(Product product) {

        System.out.println("Por favor ingrese la cantidad de productos que desea actualizar:");
        int updateQuantity = SuperKeyBoard.readNumber();
        int finalQuantity;
        if (updateQuantity <= 0) {
            System.out.println("por favor ingrese un valor valido para la cantidad en stock");
            return updateQuantityProduct(product);
        } else {
            finalQuantity = updateQuantity + product.getQuantity();
        }
        return finalQuantity;
    }
    public String updateURLProduct(){
        System.out.println("Por favor ingrese la URL que desea actualizar");
        String updateUrl = SuperKeyBoard.readText();

        return updateUrl;
    }
    public void printAllInventory(){
        System.out.println(listProductsInventory);
    }

    //Metodo toString
    @Override
    public String toString() {
        return "ProductService{" +
                "listProductsInventory=" + listProductsInventory +
                '}';
    }
}
