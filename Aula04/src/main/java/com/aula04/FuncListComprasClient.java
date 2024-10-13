package com.aula04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class FuncListComprasClient
 */
@WebServlet("/FuncListComprasClient")
public class FuncListComprasClient extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Construtor padrão
    public FuncListComprasClient() {
        super();
    }

    // Método GET para listar as compras do cliente
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o ID do cliente da requisição
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        // Busca o cliente pelo ID e suas compras
        Cliente cliente = ClienteController.getClienteById(idCliente); // Presumindo que você tenha esse método
        List<Produto> produtosComprados = cliente.getProdutosComprados(); // Presumindo que você tenha essa lista no Cliente

        // Armazenando o cliente e seus produtos na requisição
        request.setAttribute("cliente", cliente);
        request.setAttribute("produtosComprados", produtosComprados);

        // Encaminha para a JSP que exibirá as compras
        request.getRequestDispatcher("listComprasClient.jsp").forward(request, response);
    }

    // Método POST (opcional)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
