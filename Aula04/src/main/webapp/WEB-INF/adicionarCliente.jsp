<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Cliente</title>
</head>
<body>
    <h1>Adicionar Novo Cliente</h1>
    <form action="ClienteCreate" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <br>
        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone">
        <br>
        <input type="submit" value="Adicionar Cliente">
    </form>
    <br>
    <a href="listarClientes.jsp">Voltar para a lista de Clientes</a>
</body>
</html>
