package com.aula04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Definindo o servlet no caminho /ProdutoUpdate
@WebServlet("/ProdutoUpdate")
public class ProdutoUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Construtor padrão
    public ProdutoUpdate() {
        super();
    }

    // Método GET (opcional, pode ser usado para exibir um formulário de edição)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aqui você pode carregar o produto a ser editado e exibir um formulário se necessário
        int id = Integer.parseInt(request.getParameter("id"));
        Produto produto = ProdutoController.getProdutoById(id); // Recupera o produto pela ID

        request.setAttribute("produto", produto); // Adiciona o produto à requisição
        request.getRequestDispatcher("editarProduto.jsp").forward(request, response); // Encaminha para uma JSP de edição
    }

    // Método POST para atualizar o produto
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); // Obtém o ID do produto
        String novoNome = request.getParameter("nome"); // Obtém o novo nome
        double novoPreco = Double.parseDouble(request.getParameter("preco")); // Obtém o novo preço

        // Atualiza o produto
        ProdutoController.atualizarProduto(id, novoNome, novoPreco); // Chama o método para atualizar o produto

        // Redireciona para a lista de produtos após a atualização
        response.sendRedirect("ProdutoRead");
    }
}
