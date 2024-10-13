<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Clientes</title>
</head>
<body>
    <h1>Lista de Clientes</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Ações</th>
        </tr>
        <!-- Aqui você pode iterar sobre a lista de clientes e exibir as informações -->
        <tr>
            <td>1</td>
            <td>Cliente Exemplo</td>
            <td>
                <a href="ClienteUpdate?id=1">Editar</a>
                <a href="ClienteDelete?id=1">Excluir</a>
            </td>
        </tr>
        <!-- Repita o bloco acima para cada cliente -->
    </table>
    <a href="adicionarCliente.jsp">Adicionar Novo Cliente</a>
</body>
</html>
