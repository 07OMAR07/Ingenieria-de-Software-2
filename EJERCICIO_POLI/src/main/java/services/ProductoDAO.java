package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Producto;
import model.ProductoElectronico;
import model.ProductoAlimento;

public class ProductoDAO {
    private Connection conexion;

    public ProductoDAO(Connection conexion) {
        this.conexion = conexion;
    }

    public void create(Producto producto) {
        try {
            String sql = "INSERT INTO producto (id, descripcion, precio, tipo) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, producto.getId());
            stmt.setString(2, producto.getDescripcion());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setString(4, producto.getTipo());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Producto> obtenerTodos() {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                Producto producto = null;
                if (tipo.equals("Electronico")) {
                    producto = new ProductoElectronico(rs.getInt("id"), rs.getString("descripcion"), rs.getDouble("precio"), 110);
                } else if (tipo.equals("Alimento")) {
                    producto = new ProductoAlimento(rs.getInt("id"), rs.getString("descripcion"), rs.getDouble("precio"), 100);
                }
                productos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }

    public List<Producto> buscarPorRangoDePrecio(double min, double max) {
        List<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto WHERE precio BETWEEN ? AND ?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setDouble(1, min);
            stmt.setDouble(2, max);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                Producto producto = null;
                if (tipo.equals("Electronico")) {
                    producto = new ProductoElectronico(rs.getInt("id"), rs.getString("descripcion"), rs.getDouble("precio"), 110);
                } else if (tipo.equals("Alimento")) {
                    producto = new ProductoAlimento(rs.getInt("id"), rs.getString("descripcion"), rs.getDouble("precio"), 100);
                }
                productos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }
}