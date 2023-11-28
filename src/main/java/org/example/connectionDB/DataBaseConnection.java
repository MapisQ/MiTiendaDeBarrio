package org.example.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBaseConnection {

    final String DRIVER_JDBC = "org.postgresql.Driver";
    final String URL_DB = "jdbc:postgresql://localhost:5432/project_store";

    // Credenciales de la base de datos
    final String USER = "admin_store";
    final String PASSWORD = "abc123!";

    public void insertData() {
        try {
            // Cargar el controlador JDBC
            Class.forName(DRIVER_JDBC);

            // Establecer la conexión
            try (Connection connection = DriverManager.getConnection(URL_DB, USER, PASSWORD)) {

                // Consulta SQL de inserción
                PreparedStatement preparedSt = connection.prepareStatement("INSERT INTO Product (id_product, name_product, unit_price, stock_quantity, category) VALUES (1, 'Leche', 1.20, 50, 'Lácteos');\n" +
                        "INSERT INTO Product (id_product, name_product, unit_price, stock_quantity, category) VALUES (2, 'Pan', 0.50, 100, 'Panadería');");
                preparedSt.executeUpdate();
                preparedSt.close();
            }
        } catch (Exception exception) {
            //exception.printStackTrace();
            exception.getMessage();
        }
    }
}