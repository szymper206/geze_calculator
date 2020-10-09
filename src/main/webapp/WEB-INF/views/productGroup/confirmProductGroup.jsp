<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Confirm Delete Product Group</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
    <h1>Potwierdź usunięcie</h1>
</div>
<p>Czy na pewno chcesz usunąć ${productGroup.name}</p>
<a href="/productGroup/all"><input type="submit" value="Anuluj"></a>

<form:form method="post" modelAttribute="productGroup">
    <form:hidden path="id"/>
    <form:hidden path="name"/>
    <input type="submit" value="Usuń">
</form:form>

</body>
</html>
