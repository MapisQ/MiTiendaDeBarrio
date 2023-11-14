package org.example.domain.crud;

import org.example.SuperKeyBoard;
import org.example.domain.entities.Product;
import org.example.domain.ProductServiceInterface;
import org.example.enums.ECategory;
import org.example.menus.UpdateProductMenu;
import org.example.services.MenuService;
import org.example.services.ProductService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProductCrud implements ProductServiceInterface {

    private ProductService productService;
    private MenuService menuService;

    public ProductCrud(ProductService productService, MenuService menuService) {
        this.productService = productService;
        this.menuService=menuService;

    }

    @Override
    public void addProduct() {
        System.out.println("Por favor diligencie los siguientes datos para poder agregar el producto en el inventario \n");
        System.out.println("Por favor ingrese el nombre del producto");
        String name= SuperKeyBoard.readText();
        String date ="";
        Date finalDate = null;
        try {
            System.out.println("Por favor ingrese la fecha de vencimiento del producto");
            date= SuperKeyBoard.readText();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            finalDate = formato.parse(date);
        } catch (ParseException e) {
            System.out.println("Ingrese un valor válido para la fecha");
            date=SuperKeyBoard.readText();
        }
        System.out.println("Por favor ingrese la marca del producto");
        String brand= SuperKeyBoard.readText();
        ECategory category = productService.selectCategoryProduct();
        SuperKeyBoard.readText();
        System.out.println("Por favor ingrese la descripción del producto");
        String description= SuperKeyBoard.readText();
        System.out.println("Por favor ingrese el precio del producto");
        int price= SuperKeyBoard.readNumber();
        System.out.println("Por favor ingrese la url de la imagen del producto");
        String url= SuperKeyBoard.readText();
        System.out.println("Por favor ingrese la cantidad de producto almacenada en el inventario");
        int quantity= SuperKeyBoard.readNumber();

        Product product = new Product(name,finalDate,brand, category.getValue(), description,price,url,quantity);
        productService.addProductAtList(product);
    }

    @Override
    public void modifyProduct() {
        //Scanner updateProduct = new Scanner(System.in);

        System.out.println("Por favor seleccione una opción: ");
        System.out.println(UpdateProductMenu.SELECT_UPDATE_PRODUCT);
        int option = SuperKeyBoard.readNumber();
        if (option==6){
            menuService.selectOptionMenuI();
        }else if (!productService.getListProductsInventory().isEmpty()){
            System.out.println("Por favor ingrese el Id del producto que desea actualizar");
            int idProduct = SuperKeyBoard.readNumber();
            Product productoEncontrado= productService.getListProductsInventory().stream().filter(x->x.getIdProduct()==(idProduct)).findFirst().orElse(null);
            if (productoEncontrado != null){
                try {
                    if (option < 1 || option > 6) {
                        System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
                        menuService.selectOptionMenuUP();

                    } else if (option>=1 || option<=5) {
                        switch (option) {
                            case 1:
                                productoEncontrado.setName(productService.updateNameProduct());
                                break;
                            case 2:
                                productoEncontrado.setBrand(productService.updateBrandProduct());
                                break;
                            case 3:
                                productoEncontrado.setDescription(productService.updateDescriptionProduct());
                                break;
                            case 4:
                                productoEncontrado.setPrice(productService.updatePriceProduct());
                                break;
                            case 5:
                                productoEncontrado.setUrl(productService.updateURLProduct());
                                break;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("| La opción que seleccionó no es valida. Por favor intente nuevamente |\n");
                    menuService.selectOptionMenuUP();
                }
            }else { System.out.println("No es posible encontrar el producto con el id: "+idProduct); }
            modifyProduct();
        }else {
            System.out.println("El producto no se encuentra en el inventario");
            menuService.selectOptionMenuI();
        }
    }

    @Override
    public void removeProduct() {
        System.out.println("Por favor ingrese el Id del producto que desea eliminar");
        int idProduc = SuperKeyBoard.readNumber();

        int finalIdProduc = idProduc;
        productService.getListProductsInventory().removeIf(x-> finalIdProduc ==(x.getIdProduct()));
        System.out.println("¡El producto ha sido eliminado exitosamente!");
    }

    @Override
    public void searchProduct() {

        System.out.println("Por favor ingrese el Id del producto que desea consultar en inventario");
        int searchId = SuperKeyBoard.readNumber();
        Optional<Product> idOpcional = productService.findProductById(searchId);
        if (idOpcional.isPresent()){
            System.out.println(idOpcional.get());
        }else {
            System.out.println("El Id ingresado no se encuentra registrado");
        }
    }

    public void printInventory(){
        productService.printProduct();
    }
}
