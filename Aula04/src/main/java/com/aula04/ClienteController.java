package com.aula04;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private static List<Cliente> clientes = new ArrayList<>();

    public static void createCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static Cliente getClienteById(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; // Cliente não encontrado
    }

    public static void updateCliente(Cliente updatedCliente) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getId() == updatedCliente.getId()) {
                clientes.set(i, updatedCliente);
                return;
            }
        }
    }

    public static void deleteCliente(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }

    public static List<Cliente> getAllClientes() {
        return new ArrayList<>(clientes);
    }
}
