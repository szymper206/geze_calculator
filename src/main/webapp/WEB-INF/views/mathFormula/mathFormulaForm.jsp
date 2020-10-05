<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Math Formula Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="mathFormula" >
    <form:hidden path="id"/>
    Wzór: <form:input path="name"/><br>
    <form:errors path="name" cssClass="error"/><br>
    <input type="submit" value="Dodaj Wzór">
</form:form>
</body>
</html>