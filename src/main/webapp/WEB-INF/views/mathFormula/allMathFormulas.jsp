<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Math Formulas</title>
</head>
<body>
<h1>Lista Wzorów</h1>
<a href="/mathFormula/add">Dodaj Wzór</a><br>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Wzór</td>
        <td>Akcja</td>
    </tr>
    <c:forEach items="${mathFormulas}" var="mathFormula">
        <tr>
            <td>${mathFormula.id}</td>
            <td>${mathFormula.name}</td>
            <td>
                <a href="/mathFormula/edit/${mathFormula.id}">Edycja</a>&nbsp;<a href="/mathFormula/delete/${mathFormula.id}">Usuwanie</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="/"><input type="submit" value="Powrót do strony głównej"></a>
</body>
</html>