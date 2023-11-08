package org.example.Domain.Entities;

import java.util.ArrayList;
import java.util.List;

public class Sales {

    //Atributos
    private  int quantityBougthProduct;


    //Metodos Constructores
    public Sales(int quantityBougthProduct) {
        this.quantityBougthProduct = quantityBougthProduct;
    }
    public Sales() {}

    //Metodos Getter y Setter

    public int getQuantityBougthProduct() {
        return quantityBougthProduct;
    }
    public void setQuantityBougthProduct(int quantityBougthProduct) {
        this.quantityBougthProduct = quantityBougthProduct;
    }


}