<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Products</title>
</head>
<body>
<h1>Lista Produktów</h1>
<a href="/product/add">Dodaj Towar</a><br>
<table border="1">
    <tr>
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
</body>
</html>
