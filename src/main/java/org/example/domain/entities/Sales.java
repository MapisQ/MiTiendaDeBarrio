package org.example.domain.entities;

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