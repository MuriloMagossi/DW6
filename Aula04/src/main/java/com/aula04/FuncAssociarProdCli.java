package com.aula04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Definindo o servlet no caminho /FuncAssociarProdCli
@WebServlet("/FuncAssociarProdCli")
public class FuncAssociarProdCli extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Construtor padrão
    public FuncAssociarProdCli() {
        super();
    }

    // Método GET (opcional, pode ser usado para exibir um formulário de associação)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aqui você pode carregar clientes e produtos para exibir em um formulário
        request.setAttribute("clientes", ClienteController.getAllClientes());
        request.setAttribute("produtos", ProdutoController.getAllProdutos());
        request.getRequestDispatcher("associarProdutoCliente.jsp").forward(request, response); // Encaminha para a JSP
    }

    // Método POST para associar produtos a um cliente
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente")); // Obtém o ID do cliente
        String[] idsProdutos = request.getParameterValues("idProduto"); // Obtém os IDs dos produtos (array)

        // Associa os produtos ao cliente
        ClienteController.associarProdutos(idCliente, idsProdutos); // Chama o método para associar produtos

        // Redireciona para a lista de clientes ou uma página de confirmação
        response.sendRedirect("ClienteRead");
    }
}
