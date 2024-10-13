package com.aula04;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private static List<Produto> produtos = new ArrayList<>();

    public static void createProduto(Produto produto) {
        produtos.add(produto);
    }

    public static Produto getProdutoById(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null; // Produto não encontrado
    }

    public static void updateProduto(Produto updatedProduto) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getId() == updatedProduto.getId()) {
                produtos.set(i, updatedProduto);
                return;
            }
        }
    }

    public static void deleteProduto(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public static List<Produto> getAllProdutos() {
        return new ArrayList<>(produtos);
    }
}
