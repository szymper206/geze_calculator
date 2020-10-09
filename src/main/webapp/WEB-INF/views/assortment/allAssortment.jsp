<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Assortments</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
<h1>Lista Doborów</h1>
</div>

<div class="container">
<a href="/assortment/add"><input type="submit" value="Dodaj dobór"></a><br>
<table border="1" class="table table-striped table-boarder">
    <tr class="thead-dark">
        <td>Id/Numer Zamówienia</td>
        <td>Wysokość światła przejścia</td>
        <td>Szerokość światła przejścia</td>
        <td>Czy lakierowane?</td>
        <td>Opis</td>
        <td>Grupa produktowa</td>
        <td>Typ towaru</td>
        <td>Lista produktów</td>
        <td>Akcja</td>
    </tr>
    <c:forEach items="${assortments}" var="assortment">
        <tr>
            <td>${assortment.id}</td>
            <td>${assortment.length}</td>
            <td>${assortment.width}</td>
            <td>${assortment.painted}</td>
            <td>${assortment.description}</td>
            <td>${assortment.productGroup.name}</td>
            <td>${assortment.productType.name}</td>
            <td>
                <a href="/assortmentProduct/all/${assortment.id}">Lista produktów</a>
            </td>
            <td>
                <a href="/assortment/edit/${assortment.id}">Edycja</a>&nbsp;<a href="/assortment/delete/${assortment.id}">Usuwanie</a>
            </td>

        </tr>
    </c:forEach>
</table>
<br>
<a href="/"><input type="submit" value="Powrót do strony głównej"></a>
</div>
</body>
</html>
