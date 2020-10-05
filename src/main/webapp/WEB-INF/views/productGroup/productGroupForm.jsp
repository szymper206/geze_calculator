<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Group Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="productGroup" >
    <form:hidden path="id"/>
    Nazwa Grupy Towarowej: <form:input path="name"/><br>
    <form:errors path="name" cssClass="error"/><br>
    <input type="submit" value="Dodaj Grupę Towaru">
</form:form>
</body>
</html>
