package org.example.Domain.Entities;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Product product;

    //Metodo Constructor
    public Inventory() {}

    //Metodos Getter y Setter
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}

