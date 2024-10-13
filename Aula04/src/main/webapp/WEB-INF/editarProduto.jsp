<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.aula04.Produto" %>
<%@ page import="java.util.List" %>
<%
    // Simulação de obter o ID do produto a ser editado
    String idParam = request.getParameter("id");
    Produto produto = null;

    // Lógica para buscar o produto pelo ID (ainda a ser implementada)
    // Exemplo: produto = ProdutoService.getProdutoById(Integer.parseInt(idParam));
%>
<html>
<head>
    <title>Editar Produto</title>
</head>
<body>
    <h1>Editar Produto</h1>
    <%
        if (produto != null) {
    %>
    <form action="ProdutoUpdate" method="post">
        <input type="hidden" name="id" value="<%= produto.getId() %>">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="<%= produto.getNome() %>" required>
        <br>
        <label for="preco">Preço:</label>
        <input type="text" id="preco" name="preco" value="<%= produto.getPreco() %>" required>
        <br>
        <input type="submit" value="Salvar">
    </form>
    <%
        } else {
    %>
    <p>Produto não encontrado.</p>
    <%
        }
    %>
    <br>
    <a href="listarProdutos.jsp">Voltar para a lista de produtos</a>
</body>
</html>
