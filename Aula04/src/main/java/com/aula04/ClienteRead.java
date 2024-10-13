package com.aula04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// Definindo o servlet no caminho /ClienteRead
@WebServlet("/ClienteRead")
public class ClienteRead extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Construtor padrão
    public ClienteRead() {
        super();
    }

    // Método GET para listar os clientes
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera a lista de clientes do servlet ClienteCreate
        ArrayList<Cliente> listaClientes = ClienteCreate.getListaClientes();

        // Armazena a lista de clientes na requisição para ser acessada na JSP
        request.setAttribute("listaClientes", listaClientes);

        // Despacha a requisição para a página listarClientes.jsp
        request.getRequestDispatcher("listarClientes.jsp").forward(request, response);
    }

    // Chamando o método GET também no POST (caso necessário)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
