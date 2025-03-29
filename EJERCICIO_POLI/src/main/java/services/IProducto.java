package services;

import java.sql.SQLException;
import java.util.List;

import model.Producto;

public interface IProducto {
    List<Producto> buscarPorRangoDePrecio(double min, double max) throws SQLException;
}