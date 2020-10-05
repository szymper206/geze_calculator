<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Confirm Delete Product Group</title>
</head>
<body>
<p>Czy na pewno chcesz usunąć ${productType.name}</p>
<a href="/productType/all"><input type="submit" value="Anuluj"></a>

<form:form method="post" modelAttribute="productType">
    <form:hidden path="id"/>
    <form:hidden path="name"/>
    <input type="submit" value="Usuń">
</form:form>

</body>
</html>
