<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Product Types</title>
</head>
<body>
<h1>Lista Typów Towarów</h1>
<a href="/productType/add">Dodaj Typ Towaru</a><br>
<table border="1">
    <tr>
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
</body>
</html>
