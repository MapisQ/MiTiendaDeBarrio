package org.example.domain.entities;

public class BougthProduct {

    //Atributos
    private String bougthNameProduct;
    private int totalConver;
    private int quantityProductBougth;

    //Metodos Constructores
    public BougthProduct(String bougthNameProduct, int totalConver, int quantityProductBougth ) {
        this.bougthNameProduct = bougthNameProduct;
        this.totalConver = totalConver;
        this.quantityProductBougth = quantityProductBougth;
    }
    public BougthProduct() {}

    //Metodos Getter y Setter
    public String getBougthNameProduct() {
        return bougthNameProduct;
    }
    public void setBougthNameProduct(String bougthNameProduct) {
        this.bougthNameProduct = bougthNameProduct;
    }

    public int getTotalConver() {
        return totalConver;
    }
    public void setTotalConver(int totalConver) {
        this.totalConver = totalConver;
    }

    public int getQuantityProductBougth() {
        return quantityProductBougth;
    }
    public void setQuantityProductBougth(int quantityProductBougth) {
        this.quantityProductBougth = quantityProductBougth;
    }

    //Metodo toString
    @Override
    public String toString() {
        return getBougthNameProduct()+"................."+getTotalConver()+"  *  "+getQuantityProductBougth()+"\n";
    }
}
