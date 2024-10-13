package com.aula04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// Definindo o servlet no caminho /ProdutoCreate
@WebServlet("/ProdutoCreate")
public class ProdutoCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Construtor padrão
    public ProdutoCreate() {
        super();
    }

    // Método GET (opcional, pode ser usado para carregar um formulário)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    // Método POST para processar a criação do produto
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém os parâmetros do produto enviados pelo formulário
        String nomeProduto = request.getParameter("nome");
        double precoProduto = Double.parseDouble(request.getParameter("preco"));

        // Cria uma nova instância de Produto
        Produto novoProduto = new Produto(nomeProduto, precoProduto);

        // Recupera a lista de produtos do servlet ProdutoRead
        ArrayList<Produto> listaProdutos = ProdutoRead.getListaProdutos();

        // Adiciona o novo produto à lista
        listaProdutos.add(novoProduto);

        // Redireciona para a página de listagem após a criação
        response.sendRedirect("listarProdutos.jsp");
    }
}
