<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Confirm Delete Product</title>
</head>
<body>
<p>Czy na pewno chcesz usunąć ${product.name}</p>
<a href="/product/all"><input type="submit" value="Anuluj"></a>

<form:form method="post" modelAttribute="product">
    <form:hidden path="id"/>
    <form:hidden path="name"/>
    <input type="submit" value="Usuń">
</form:form>

</body>
</html>
