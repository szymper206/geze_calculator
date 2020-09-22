<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="user">
    <form:hidden path="id"/>
    Email: <form:input path="email"/><br>
    <form:errors path="email" cssClass="error"/><br>
    Hasło: <form:password path="password"/><br>
    <form:errors path="password" cssClass="error"/><br>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
