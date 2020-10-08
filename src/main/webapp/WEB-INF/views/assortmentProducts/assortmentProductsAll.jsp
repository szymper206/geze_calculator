<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Assortment Products By Assortment</title>
</head>
<body>
<h1>Lista Produktów dla doboru nr ${assortment.id}</h1>
<table border="1">
    <tr>
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
</body>
</html>
