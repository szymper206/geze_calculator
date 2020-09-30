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
Rejestracja admina<br>
<form:form method="post" modelAttribute="user" >
    <form:hidden path="id"/>
    <form:hidden path="email" value="s.jaroszynski@geze.com"/><br>
    Hasło: <form:password path="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                          title="Musi zawierać conajmniej jedną cyfrę, jedną dużą i małą literę oraz conajmniej 8 znaków"/><br>
    <form:errors path="password" cssClass="error"/><br>
    <input type="submit" value="Zarejestruj">
</form:form>
</body>
</html>