package com.aula04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// Definindo o servlet no caminho /ClienteDelete
@WebServlet("/ClienteDelete")
public class ClienteDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Construtor padrão
    public ClienteDelete() {
        super();
    }

    // Método GET (opcional, pode ser usado para confirmar a remoção)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirecionando para o método POST (caso queira testar via GET)
        doPost(request, response);
    }

    // Método POST para processar a remoção do cliente
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtendo o ID do cliente da requisição (enviado via formulário ou query string)
        int idCliente = Integer.parseInt(request.getParameter("id"));

        // Buscando a lista de clientes do servlet ClienteCreate
        ArrayList<Cliente> listaClientes = ClienteCreate.getListaClientes();

        // Removendo o cliente da lista, comparando pelo ID
        listaClientes.removeIf(cliente -> cliente.getId() == idCliente);

        // Redirecionando para a página de listagem após a remoção
        response.sendRedirect("listarClientes.jsp");
    }
}
