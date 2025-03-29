package controller;

import java.sql.Connection;
import java.util.List;

import model.IPrototype;
import model.Producto;
import services.ProductoDAO;

public class ProductoController {
    private ProductoDAO productoDAO;

    public ProductoController(Connection conexion) {
        this.productoDAO = new ProductoDAO(conexion);
    }

    public void agregarProducto(Producto producto) {
        productoDAO.create(producto);
    }

    public List<Producto> obtenerProductos() {
        return productoDAO.obtenerTodos();
    }

    public Producto clonarProducto(Producto producto) {
        if (producto instanceof IPrototype) {
            return ((IPrototype) producto).clonar();
        } else {
            throw new IllegalArgumentException("El producto no soporta clonación");
        }
    }

    public List<Producto> buscarPorRangoDePrecio(double min, double max) {
        return productoDAO.buscarPorRangoDePrecio(min, max);
    }
}
