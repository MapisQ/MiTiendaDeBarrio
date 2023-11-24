package org.example.domain.crud;

import org.example.domain.ProductServiceInterface;
import org.example.domain.entities.Product;
import org.example.services.InventoryService;
import org.example.services.ProductService;

public class InventoryCrud implements ProductServiceInterface {
    private ProductService productService;

    public InventoryCrud(ProductService productService) {
        this.productService=productService;
    }

    //Metodos implementados de la interface.
    @Override
    public void addProduct() {
        //En dado caso que se pasen los productos agregados de ProductCrud a un archivo plano
    }

    @Override
    public void modifyProduct() {
        //En dado caso que se pase la modificación de ProductCrud a un archivo plano
    }

    @Override
    public void removeProduct() {
        //En dado caso que se eliminen los productos directamente del archivo
    }

    @Override
    public void searchProduct() {
        //En caso de que se busquen los archivos directamente del archivo
    }
}