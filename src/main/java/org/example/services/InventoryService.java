package org.example.services;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.example.domain.entities.Product;

import java.io.IOException;
import java.util.List;

import java.io.FileReader;
import java.util.Scanner;

public class InventoryService {

    int idF = 0;
    private Product product;
    private ProductService productService;

    public InventoryService(Product product, ProductService productService) {
        this.product=product;
        this.productService=productService;
    }

    public int getIdF() {
        return idF;
    }
    public void setIdF(int idF) {
        this.idF = idF;
    }

    public void readCSV() {
        try {
            //3.leer el archivo CSV
            FileReader file = new FileReader("C:\\Users\\PC\\IdeaProjects\\Semillero Banco de Bogotá\\MiTiendaDeBarrio-ProyectoIntegrador\\src\\main\\java\\org\\example\\resources\\PAULA.csv");
            CSVParser readerCSV = new CSVParser(file, CSVFormat.DEFAULT);

            boolean firstLine = true;

            for (CSVRecord csvRecord : readerCSV) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                int id = Integer.parseInt(csvRecord.get(0));
                idF = Math.max(idF, id);

                //Product product = new Product();
                product.setName(csvRecord.get(1));
                product.setDescription(csvRecord.get(2));
                product.setCategory(csvRecord.get(3));
                String cantidad = csvRecord.get(4);
                product.setQuantity(Integer.parseInt(cantidad));
                product.setLabel(csvRecord.get(5));
                product.setPrice(Integer.parseInt(csvRecord.get(6)));
                product.setUrl(csvRecord.get(7));

                Product producto = new Product(id, product.getName(), product.getDescription(), product.getCategory(),
                        product.getQuantity(), product.getPrice(), product.getLabel(), product.getUrl());
                //productService.addProductAtList(producto);
                productService.getListProductsInventory().add(producto);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}