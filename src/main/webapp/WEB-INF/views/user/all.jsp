<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Users</title>
</head>
<body>
<h1>Lista użytkowników</h1>
<a href="/user/add">Dodaj użytkownika</a><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>email</td>
        <td>Akcja</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>
                <a href="/user/edit/${user.id}">Edycja</a>&nbsp;<a href="/user/confirm/${user.id}">Kasowanie</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
