package org.example.Domain.Crud;

import org.example.Domain.Entities.Product;
import org.example.Domain.ProductServiceInterface;
import org.example.Enums.ECategory;
import org.example.Services.ProductService;

import java.util.*;

public class ProductCrud implements ProductServiceInterface {
    public ProductCrud() {}

    ProductService productService = new ProductService();

    public ProductCrud(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void addProduct() {
        System.out.println("Por favor diligencie los siguientes datos para poder agregar el producto en el inventario \n");
        Scanner data = new Scanner(System.in);
        System.out.println("Por favor ingrese el nombre del producto");
        String name= data.nextLine();
        System.out.println("Por favor ingrese la fecha de vencimiento del producto");
        String date= data.nextLine();
        System.out.println("Por favor ingrese la marca del producto");
        String brand= data.nextLine();
        ECategory category = productService.selectCategoryProduct();
        System.out.println("Por favor ingrese la descripción del producto");
        String description= data.nextLine();
        int price =0;
        try {
            System.out.println("Por favor ingrese el precio del producto");
            price= data.nextInt();
        }catch (InputMismatchException e){
            data.nextLine();
            //e.printStackTrace();
            System.out.println("Ingrese un valor numérico válido para el precio");
            data.nextInt();
        }
        data.nextLine();
        System.out.println("Por favor ingrese la url de la imagen del producto");
        String url= data.nextLine();
        int quantity =0;
        try {
            System.out.println("Por favor ingrese la cantidad de producto almacenada en el inventario");
            quantity= data.nextInt();

        }catch (InputMismatchException ex){
            data.nextLine();
            //ex.printStackTrace();
            System.out.println("Ingrese un valor numérico válido para la cantidad.");
            quantity= data.nextInt();
        }
        Product product = new Product(name,date,brand, category.getValue(), description,price,url,quantity);
        productService.addProductAtList(product);
        //System.out.println(product);
        //productService.printProduct();
    }

    @Override
    public void modifyProduct() {

        Scanner updateProduct = new Scanner(System.in);
        System.out.println("Por favor ingrese el Id del producto que desea actualizar");
        int idProduct = updateProduct.nextInt();
        updateProduct.nextLine();

        if (!productService.getListProductsInventory().isEmpty()){
            Product productoEncontrado= productService.getListProductsInventory().stream().filter(x->x.getIdProduct()==(idProduct)).findFirst().orElse(null);
            if (productoEncontrado != null){
                System.out.println("Por favor ingrese el nombre que desea actualizar");
                String updateName=updateProduct.nextLine();
                System.out.println("Por favor ingrese la descripción que desea actualizar");
                String updateDescrip=updateProduct.nextLine();
                int updatePrice;
                try {
                    System.out.println("Por favor ingrese el precio que desea actualizar:");
                    updatePrice = Integer.parseInt(updateProduct.nextLine());
                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                    System.out.println("Ingrese un valor numérico válido para el precio.");
                    updatePrice = Integer.parseInt(updateProduct.nextLine());
                }
                productoEncontrado.setName(updateName);
                //productoEncontrado.setCategory(updateCate);
                productoEncontrado.setDescription(updateDescrip);
                productoEncontrado.setPrice(updatePrice);
            }else { System.out.println("No es posible encontrar el producto con el id: "+idProduct); }
        }
        else {
            System.out.println("Producto no se encuentra en el inventario");
        }
    }

    @Override
    public void removeProduct() {
        Scanner substractProduct = new Scanner(System.in);
        int idProduc;
        try{
            System.out.println("Por favor ingrese el Id del producto que desea eliminar");
            idProduc = substractProduct.nextInt();
        }catch (Exception e){
            //e.printStackTrace();
            System.out.println("Ingrese un valor numérico válido para el Id.");
            idProduc = substractProduct.nextInt();
        }
        int finalIdProduc = idProduc;
        productService.getListProductsInventory().removeIf(x-> finalIdProduc ==(x.getIdProduct()));
        System.out.println("¡El producto ha sido eliminado exitosamente!");


    }


    @Override
    public void searchProduct() {

        Scanner search = new Scanner(System.in);
        int searchId;
        try {
            System.out.println("Por favor ingrese el Id del producto que desea consultar en inventario");
            searchId = search.nextInt();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Ingrese un valor numérico válido para el Id.");
            searchId = search.nextInt();
        }
        Optional<Product> idOpcional = productService.lookForProduct(searchId);
        if (idOpcional.isPresent()){
            System.out.println(idOpcional.get());
        }else {
            System.out.println("El Id ingresado no se encuentra registrado");
        }
    }


}
