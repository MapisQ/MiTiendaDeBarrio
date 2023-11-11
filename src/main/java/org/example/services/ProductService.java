package org.example.services;


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

//    public void setListProductsInventory(List<Product> listProductsInventory) {
//        this.listProductsInventory = listProductsInventory;
//    }

    ProductService productService;

    Scanner updateProduct = new Scanner(System.in);

    public ProductService(ProductService productService) {
        this.productService = productService;
    }

    //Metodos de la clase ProductService
    public void addProductAtList(Product product){
        if (!listProductsInventory.contains(product)){
            listProductsInventory.add(product);
            System.out.println("¡Producto agregado al inventario!");
        }else {
            System.out.println("El producto ya se encuentra en el inventario :(");
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

    public void printProduct() {listProductsInventory.stream().forEach(product -> System.out.println(product)); }

    public ECategory selectCategoryProduct(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor seleccione una de las categorias que se muestran a continuación: ");
        for (int i=0;i<ECategory.values().length;i++){
            System.out.println("|-------------------------------------|");
            System.out.println("  "+(i+1)+". "+ECategory.values()[i].getValue());
        }
        System.out.println("|-------------------------------------|");
        try {
            int option = scanner.nextInt();
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
        String updateName = updateProduct.next();

        return updateName;
    }
    public String updateBrandProduct(){
        System.out.println("Por favor ingrese la marca que desea actualizar");
        String updateBrand = updateProduct.next();

        return updateBrand;
    }
    public String updateDescriptionProduct(){
        updateProduct.nextLine();
        System.out.println("Por favor ingrese la descripción que desea actualizar");
        String updateDescrip = updateProduct.nextLine();

        return updateDescrip;
    }
    public int updatePriceProduct(){
        int updatePrice;
        try {
            System.out.println("Por favor ingrese el precio que desea actualizar:");
            updatePrice = Integer.parseInt(updateProduct.next());
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            System.out.println("Ingrese un valor numérico válido para el precio.");
            updatePrice = Integer.parseInt(updateProduct.next());
        }

        return updatePrice;
    }
    public String updateURLProduct(){
        System.out.println("Por favor ingrese la URL que desea actualizar");
        String updateUrl = updateProduct.next();

        return updateUrl;
    }


    //Metodo toString
    @Override
    public String toString() {
        return "ProductService{" +
                "listProductsInventory=" + listProductsInventory +
                '}';
    }
}
