<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Product Types</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
    <h1>Lista Typów Towarów</h1>
</div>
<div class="container">
<a href="/productType/add"><input type="submit" value="Dodaj typ towaru"></a><br>
<table border="1" class="table table-striped table-boarder">
    <tr class="thead-dark">
        <td>Id</td>
        <td>Nazwa</td>
        <td>Grupa towarowa</td>
        <td>Akcja</td>
    </tr>
    <c:forEach items="${productTypes}" var="productType">
        <tr>
            <td>${productType.id}</td>
            <td>${productType.name}</td>
            <td>${productType.productGroup.name}</td>
            <td>
                <a href="/productType/edit/${productType.id}">Edycja</a>&nbsp;<a href="/productType/delete/${productType.id}">Usuwanie</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/"><input type="submit" value="Powrót do strony głównej"></a>
</div>
</body>
</html>
