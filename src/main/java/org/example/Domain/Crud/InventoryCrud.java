package org.example.Domain.Crud;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.example.Domain.Entities.Inventory;
import org.example.Domain.ProductServiceInterface;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class InventoryCrud implements ProductServiceInterface {

    //Lista que va a almacenar el inventario
    List<Inventory> listinventory = new ArrayList<>();

    //Metodo constructor
    public InventoryCrud(List<Inventory> listinventory) {
        this.listinventory = listinventory;
    }

    public InventoryCrud() {}

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

    public void printInventory() {
        //Variable contador para asignar un id a cada producto del archivo
        int contador = 0;

        //La ruta del archivo inventory.csv
        File file = new File("C:\\Users\\PC\\IdeaProjects\\Semillero Banco de Bogotá\\MiTiendaDeBarrio-ProyectoIntegrador\\src\\main\\java\\org\\example\\resources\\inventory.csv");
        //Abre el archivo para leerlo
        try(Reader reader= new FileReader(file);
            //Esta linea recorre cada linea del archivo con el CSVParser por lo que no es necesario el Scanner
            CSVParser parseo = new CSVParser(reader, CSVFormat.DEFAULT)) {
            //La variable csvRecord almacena una linea del archivo cada vez que se itera el ciclo
            for (CSVRecord csvRecord : parseo) {

                //El contador empieza a sumar 1 cada vez que se itera el bucle
                contador++;
                //System.out.println(csvRecord);

                //Se asigna una posición a cada variable
                String nombre = csvRecord.get(0);
                String descripción = csvRecord.get(1);
                String categoria = csvRecord.get(2);
                String etiqueta  = csvRecord.get(3);
                String precio = csvRecord.get(4);
                String  URL = csvRecord.get(5);

                //Se imprime cada una de las variables que fueron asignadas anteriormente
                System.out.println("<------------------------------------->");
                System.out.println("Id Producto: "+contador);
                System.out.println("Nombre Producto: "+nombre);
                System.out.println("Descripción: "+descripción);
                System.out.println("Categoria: "+categoria);
                System.out.println("Etiqueta: "+etiqueta);
                System.out.println("Precio: "+precio);
                System.out.println("URL de la imagen: "+URL);
                System.out.println("<------------------------------------->");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}