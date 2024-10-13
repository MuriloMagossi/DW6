<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Produto</title>
</head>
<body>
    <h1>Adicionar Novo Produto</h1>
    <form action="ProdutoCreate" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
        <br>
        <label for="preco">Preço:</label>
        <input type="number" id="preco" name="preco" step="0.01" required>
        <br>
        <input type="submit" value="Adicionar Produto">
    </form>
    <br>
    <a href="listarProdutos.jsp">Voltar para a lista de produtos</a>
    <br>
    <a href="index.jsp">Voltar para a página inicial</a>
</body>
</html>
