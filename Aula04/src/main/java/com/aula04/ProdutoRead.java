package com.aula04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// Definindo o servlet no caminho /ProdutoRead
@WebServlet("/ProdutoRead")
public class ProdutoRead extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Construtor padrão
    public ProdutoRead() {
        super();
    }

    // Método GET para listar produtos
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera a lista de produtos do servlet ou de uma classe de controle
        ArrayList<Produto> listaProdutos = ProdutoController.getListaProdutos(); // Supondo que exista uma classe ProdutoController que gerencia os produtos.

        // Adiciona a lista de produtos como atributo na requisição
        request.setAttribute("listaProdutos", listaProdutos);

        // Encaminha a requisição para a página JSP que irá exibir os produtos
        request.getRequestDispatcher("listarProdutos.jsp").forward(request, response);
    }

    // Método POST (opcional, pode ser redirecionado para o GET)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
