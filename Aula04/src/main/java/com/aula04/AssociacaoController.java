package com.aula04;

import java.util.ArrayList;
import java.util.List;

public class AssociacaoController {
    private static List<Associacao> compras = new ArrayList<>();

    public static void associarProdutoAoCliente(Cliente cliente, Produto produto) {
        compras.add(new Associacao(cliente, produto));
    }

    public static List<Produto> listarProdutosPorCliente(Cliente cliente) {
        List<Produto> produtosDoCliente = new ArrayList<>();
        for (Associacao compra : compras) {
            if (compra.getCliente().getId() == cliente.getId()) {
                produtosDoCliente.add(compra.getProduto());
            }
        }
        return produtosDoCliente;
    }

    public static void removerProdutoDoCliente(Cliente cliente, Produto produto) {
        compras.removeIf(compra -> compra.getCliente().getId() == cliente.getId() && compra.getProduto().getId() == produto.getId());
    }

    public static List<Associacao> getTodasCompras() {
        return new ArrayList<>(compras);
    }
}
