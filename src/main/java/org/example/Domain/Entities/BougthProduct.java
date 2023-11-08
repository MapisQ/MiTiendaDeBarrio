package org.example.Domain.Entities;

public class BougthProduct {

    //Atributos
    private String bougthNameProduct;
    private int totalConver;
    private int quantityProductBougth;
    private int totalSales;

    //Metodos Constructores
    public BougthProduct(String bougthNameProduct, int totalConver, int quantityProductBougth, int totalSales) {
        this.bougthNameProduct = bougthNameProduct;
        this.totalConver = totalConver;
        this.quantityProductBougth = quantityProductBougth;
        this.totalSales = totalSales;
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

    public int getTotalSales() {
        return totalSales;
    }
    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    //Metodo toString
    @Override
    public String toString() {
        return getBougthNameProduct()+"................."+getTotalConver()+"  *  "+getQuantityProductBougth()+"\n";
    }
}
