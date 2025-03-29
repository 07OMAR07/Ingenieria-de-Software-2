package controller;

import java.sql.SQLException;
import java.util.List;

import model.Cliente;
import services.ClienteDAO;

public class ClienteController {
    private ClienteDAO clienteDAO;

    // Constructor sin parámetros
    public ClienteController() {
        try {
            this.clienteDAO = new ClienteDAO();  // Asegúrate de que ClienteDAO esté correctamente instanciado
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarCliente(String id, String nombre) throws SQLException {
        Cliente cliente = new Cliente(id, nombre);
        clienteDAO.create(cliente);
    }

    public List<Cliente> listarClientes() throws SQLException {
        return clienteDAO.read();
    }

    public Cliente buscarCliente(String id) throws SQLException {
        return clienteDAO.read(id);
    }

    public void actualizarCliente(String id, String nuevoNombre) throws SQLException {
        Cliente cliente = new Cliente(id, nuevoNombre);
        clienteDAO.update(id, cliente);
    }

    public void eliminarCliente(String id) throws SQLException {
        clienteDAO.delete(id);
    }
}
