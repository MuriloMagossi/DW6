package com.aula04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// Definindo o servlet no caminho /ClienteCreate
@WebServlet("/ClienteCreate")
public class ClienteCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Armazenamento de clientes em memória (durante a execução)
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    // Construtor padrão
    public ClienteCreate() {
        super();
    }

    // Método GET (opcional, pode ser removido ou ajustado)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("/adicionarCliente.jsp").forward(request, response);    }

    // Método POST para processar o envio do formulário
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtendo o nome do cliente a partir do formulário
        String nomeCliente = request.getParameter("nome");

        // Gerando um ID único para o cliente
        int idCliente = listaClientes.size() + 1;

        // Criando um novo objeto Cliente
        Cliente novoCliente = new Cliente(idCliente, nomeCliente);

        // Adicionando o cliente à lista
        listaClientes.add(novoCliente);

        // Redirecionando para uma página de sucesso ou a lista de clientes
        response.sendRedirect("listarClientes.jsp");
    }

    // Método para retornar a lista de clientes (pode ser usado em outro servlet para listar clientes)
    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
}
