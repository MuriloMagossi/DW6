package com.aula04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ProdutoUpdate")
public class ProdutoUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ArrayList<Produto> produtos = new ArrayList<>();

    // Construtor
    public ProdutoUpdate() {
        // Exemplo de inicialização de produtos
        produtos.add(new Produto(1, "Produto 1", 10.0));
        produtos.add(new Produto(2, "Produto 2", 20.0));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém os dados do formulário
        String idParam = request.getParameter("id");
        String nome = request.getParameter("nome");
        String precoParam = request.getParameter("preco");

        // Verifica se os parâmetros são válidos
        if (idParam != null && nome != null && precoParam != null) {
            int id = Integer.parseInt(idParam);
            double preco = Double.parseDouble(precoParam);

            // Lógica para atualizar o produto
            Produto produto = null;
            for (Produto p : produtos) {
                if (p.getId() == id) {
                    p.setNome(nome);
                    p.setPreco(preco);
                    produto = p;
                    break;
                }
            }

            // Redireciona para a página de listagem de produtos após a atualização
            if (produto != null) {
                response.sendRedirect("listarProdutos.jsp");
            } else {
                // Se não encontrado, redireciona para uma página de erro
                response.sendRedirect("erro.jsp");
            }
        } else {
            // Redireciona para uma página de erro se os parâmetros não estiverem presentes
            response.sendRedirect("erro.jsp");
        }
    }
}
