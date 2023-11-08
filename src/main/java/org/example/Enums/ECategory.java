package org.example.Enums;

public enum ECategory {

    //Categorias Unicas
    AseoHogar("Aseo Hogar"),
    Bebidas("Bebidas"),
    CarnesFriasyCongelados("Carnes frias y congelados"),
    Cigarrillos("Cigarrillos"),
    CuidadoBebe("Cuidado bebé"),
    CuidadoPersonal("Cuidado personal"),
    CuidadoRopa("Cuidado ropa"),
    Despensa("Despensa"),
    Drogueria("Drogueria"),
    DulcesyPostres("Dulces y postres"),
    Electrodomesticos("Electrodomesticos"),
    Helados("Helados"),
    HogaryDecoración("Hogar y decoración"),
    IluminacionyElectricos("Iluminación y electricos"),
    LacteosHuevosyRefrigerados("Lacteos, huevos y refrigerados"),
    LimpiezaCocina("Limpieza Cocina"),
    Mascotas("Mascotas"),
    PanaderiayPasteleria("Panaderia y pasteleria"),
    Pasabocas("Pasabocas"),
    ProductosCongelados("Productos congelados"),
    VinosyLicores("Vinos y licores");

    private String value;

    //Metodo constructor
    ECategory(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
