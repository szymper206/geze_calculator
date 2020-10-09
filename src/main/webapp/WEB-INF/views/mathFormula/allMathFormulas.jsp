<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>All Math Formulas</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
    <h1>Lista Wzorów</h1>
</div>
<div class="container">
<a href="/mathFormula/add"><input type="submit" value="Dodaj wzór"></a><br>
<table border="1" class="table table-striped table-boarder">
    <tr class="thead-dark">
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
</div>
</body>
</html>