<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.aula04.Produto" %>
<%
    // Simulação de obtenção da lista de produtos
    List<Produto> produtos = // Lógica para buscar a lista de produtos (ainda a ser implementada)
%>
<html>
<head>
    <title>Listar Produtos</title>
</head>
<body>
    <h1>Lista de Produtos</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Preço</th>
            <th>Ações</th>
        </tr>
        <%
            if (produtos != null) {
                for (Produto produto : produtos) {
        %>
        <tr>
            <td><%= produto.getId() %></td>
            <td><%= produto.getNome() %></td>
            <td><%= produto.getPreco() %></td>
            <td>
                <a href="editarProduto.jsp?id=<%= produto.getId() %>">Editar</a>
                <a href="ProdutoDelete?id=<%= produto.getId() %>">Excluir</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="4">Nenhum produto encontrado.</td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
    <a href="cadastrarProduto.jsp">Cadastrar Novo Produto</a>
    <br>
    <a href="index.jsp">Voltar para a página inicial</a>
</body>
</html>
