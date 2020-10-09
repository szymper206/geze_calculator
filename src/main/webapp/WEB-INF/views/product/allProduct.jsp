<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Products</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
    <h1>Lista Produktów</h1>
</div>
<div class="container">
<a href="/product/add"><input type="submit" value="Dodaj towar"></a><br>
<table border="1" class="table table-striped table-boarder">
    <tr class="thead-dark">
        <td>Id</td>
        <td>Nazwa</td>
        <td>Numer ID</td>
        <td>Ilość domyślna</td>
        <td>Typ towaru</td>
        <td>Wzór</td>
        <td>Akcja</td>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.idNumber}</td>
            <td>${product.defQuantity}</td>
            <td>${product.productType.name}</td>
            <td>${product.mathFormula.name}</td>
            <td>
                <a href="/product/edit/${product.id}">Edycja</a>&nbsp;<a href="/product/delete/${product.id}">Usuwanie</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/"><input type="submit" value="Powrót do strony głównej"></a>
</div>
</body>
</html>
