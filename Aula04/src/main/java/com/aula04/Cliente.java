package com.aula04;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nome;
    private ArrayList<Produto> produtos; // Lista de produtos associados ao cliente (compras)

    // Construtor padrão
    public Cliente() {
        produtos = new ArrayList<>();
    }

    // Construtor com parâmetros
    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    // Métodos para adicionar e remover produtos (compras)
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", produtos=" + produtos + "]";
    }
}
