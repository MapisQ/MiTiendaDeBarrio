package org.example.domain.entities;

public class Product {
    //Atributos
    private int idProduct;
    private String name;
    private int quantity;
    private String category;
    private String description;
    private int price;
    private String label;
    private String url;
    private static int contadorId = 0;
    //Lista que va almacenar los productos

    //Metodos constructores
    public Product(int idProduct,String name, String description, String category, int quantity, int price, String label, String url) {
        this.idProduct =idProduct;
        this.name = name;
        this.quantity= quantity;
        this.category = category;
        this.description = description;
        this.price = price;
        this.label=label;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String etiqueta) {
        this.label = etiqueta;
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
        return "\nId: "+idProduct+"\nNombre: "+name+"\nCantidad: "+quantity+"\nCategoria: "+category+
        "\nDescripción: "+description+"\nPrecio: "+price+"\nEtiqueta: "+label+"\nUrl Imagen: "+url;

        //return String.format("%-5s|%-60s |%-5s| %-20s | %-30s | %-20s | %-10s | %50s", getIdProduct(), getName(),getQuantity(), getCategory(), getDescription(), getPrice(),getEtiqueta(),getUrl());
    }
}

