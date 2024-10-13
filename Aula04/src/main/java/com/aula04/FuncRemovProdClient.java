package com.aula04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class FuncRemovProdClient
 */
@WebServlet("/FuncRemovProdClient")
public class FuncRemovProdClient extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public FuncRemovProdClient() {
        // Construtor padrão
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Para este exemplo, redirecionaremos o GET para a página que lista as compras ou um formulário para remover produtos.
        response.sendRedirect("listarCompras.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtemos os parâmetros do cliente e do produto a serem removidos.
        int clienteId = Integer.parseInt(request.getParameter("clienteId"));
        int produtoId = Integer.parseInt(request.getParameter("produtoId"));

        // Aqui, você precisará buscar o cliente correspondente (supondo que você tenha um método para isso).
        Cliente cliente = ClienteController.buscarClientePorId(clienteId); // Método hipotético

        // E o produto correspondente.
        Produto produto = ProdutoController.buscarProdutoPorId(produtoId); // Método hipotético

        // Agora, removemos a associação do cliente ao produto.
        AssociacaoController.removerProdutoDoCliente(cliente, produto);

        // Após a remoção, redirecionamos o usuário para uma página de confirmação ou para a lista de compras atualizada.
        response.sendRedirect("listarCompras.jsp");
    }
}
