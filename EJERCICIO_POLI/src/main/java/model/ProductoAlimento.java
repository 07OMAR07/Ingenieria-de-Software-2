package model;

public class ProductoAlimento extends Producto implements IPrototype {
    private int calorias;

    public ProductoAlimento(int id, String descripcion, double precio, int calorias) {
        super(id, descripcion, precio, "Alimento");
        this.calorias = calorias;
    }

    public int getCalorias() {
        return calorias;
    }

    @Override
    public Producto clonar() {
        return new ProductoAlimento(id, descripcion, precio, calorias);
    }
}
