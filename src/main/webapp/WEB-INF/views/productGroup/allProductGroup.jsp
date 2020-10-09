<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Product Groups</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
    <h1>Lista Grup Towarowych</h1>
</div>
<div class="container">
<a href="/productGroup/add"><input type="submit" value="Dodaj grupę towarową"></a><br>
<table border="1" class="table table-striped table-boarder">
    <tr class="thead-dark">
        <td>Id</td>
        <td>Nazwa</td>
        <td>Akcja</td>
    </tr>
    <c:forEach items="${productGroups}" var="productGroup">
        <tr>
            <td>${productGroup.id}</td>
            <td>${productGroup.name}</td>
            <td>
                <a href="/productGroup/edit/${productGroup.id}">Edycja</a>&nbsp;<a href="/productGroup/delete/${productGroup.id}">Usuwanie</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/"><input type="submit" value="Powrót do strony głównej"></a>
</div>
</body>
</html>
