package com.example.shoppingcart.dto;

import com.example.shoppingcart.model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteDTO implements IDTO<Cliente> {

    // Simulando um banco de dados em memória
    private static List<Cliente> clientes = new ArrayList<>();

    @Override
    public void save(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public void update(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(cliente.getId())) {
                clientes.set(i, cliente);
                break;
            }
        }
    }

    @Override
    public List<Cliente> list() {
        return clientes;
    }
}