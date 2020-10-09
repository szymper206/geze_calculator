<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Assortment Products By Assortment</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
    <h1>Lista Produktów dla doboru nr ${assortment.id}</h1>
</div>
<div class="container">
<table border="1" class="table table-striped table-boarder">
    <tr class="thead-dark">
        <td>Id</td>
        <td>Nazwa</td>
        <td>ID</td>
        <td>Ilość</td>
    </tr>
    <c:forEach items="${assortmentProducts}" var="assortmentProduct">
        <tr>
            <td>${assortmentProduct.id}</td>
            <td>${assortmentProduct.name}</td>
            <td>${assortmentProduct.idNumber}</td>
            <td>${assortmentProduct.quantity}</td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/assortmentProduct/download"><input type="submit" value="Pobierz pdf"></a><br>
<a href="/"><input type="submit" value="Powrót do strony głównej"></a>
</div>
</body>
</html>
