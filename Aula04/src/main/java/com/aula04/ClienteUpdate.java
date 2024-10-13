package com.aula04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

// Definindo o servlet no caminho /ClienteUpdate
@WebServlet("/ClienteUpdate")
public class ClienteUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Construtor padrão
    public ClienteUpdate() {
        super();
    }

    // Método GET (opcional, pode ser usado para carregar dados do cliente em um formulário)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redireciona para o método POST
        doPost(request, response);
    }

    // Método POST para processar a atualização do cliente
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o ID do cliente da requisição (enviado via formulário)
        int idCliente = Integer.parseInt(request.getParameter("id"));

        // Obtém o novo nome do cliente enviado pelo formulário
        String novoNome = request.getParameter("nome");

        // Recupera a lista de clientes do servlet ClienteCreate
        ArrayList<Cliente> listaClientes = ClienteCreate.getListaClientes();

        // Encontra o cliente correspondente ao ID e atualiza o nome
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == idCliente) {
                cliente.setNome(novoNome);
                break;
            }
        }

        // Redireciona para a página de listagem após a atualização
        response.sendRedirect("listarClientes.jsp");
    }
}
