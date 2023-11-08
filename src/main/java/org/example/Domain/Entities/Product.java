package org.example.Domain.Entities;

import java.util.Date;

public class Product {
    //Atributos
    private int idProduct;
    private String name;
    private String date ;
    private String brand;
    private int quantity;
    private String category;
    private String description;
    private int price;
    private String url;
    private static int contadorId = 0;
    //Lista que va almacenar los productos

    //Metodos constructores
    public Product(String name, String date, String brand, String category, String description, int price,String url,int quantity) {
        this.idProduct = ++contadorId;
        this.name = name;
        this.date = date;
        this.brand = brand;
        this.quantity= quantity;
        this.category = category;
        this.description = description;
        this.price = price;
        this.url = url;

    }
    public Product() {}

    //Metodos Getter y Setter
    public int getIdProduct() {
        return idProduct;
    }
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }


    //Metodo toString

    @Override
    public String toString() {
        return "\nId: "+idProduct+"\nNombre: "+name+"\nFecha de vencimiento: "+date
                +"\nMarca: "+brand+"\nCantidad: "+quantity+"\nCategoria: "+category+
                "\nDescripción: "+description+"\nPrecio: "+price+"\nUrl Imagen: "+url;
    }
}

