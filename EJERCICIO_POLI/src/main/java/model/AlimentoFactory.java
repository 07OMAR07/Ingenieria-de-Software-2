package model;

public class AlimentoFactory {
    public static ProductoAlimento crearProducto(int id, String descripcion, double precio, int calorias) {
        return new ProductoAlimento(id, descripcion, precio, calorias);
    }
}