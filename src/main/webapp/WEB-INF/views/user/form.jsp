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
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
    <H1>Dodawanie użytkownika</H1><br>
</div>
<div class="container">
    <form:form method="post" modelAttribute="user" >
        <form:hidden path="id"/>

        <div class="form-group">
            <label for="firstName1">Imię:</label>
            <form:input path="firstName" id="firstName1" cssClass="form-control"/><br>
            <form:errors path="firstName" cssClass="error"/><br>
        </div>

        <div class="form-group">
            <label for="lastName1">Nazwisko:</label>
            <form:input path="lastName" id="lastName1" cssClass="form-control"/><br>
            <form:errors path="lastName" cssClass="error"/><br>
        </div>

        <div class="form-group">
            <label for="email1">Email:</label>
            <form:input path="email" id="email1" cssClass="form-control"/><br>
            <form:errors path="email" cssClass="error"/><br>
        </div>

        <div class="form-group">
            <label for="password1">Hasło:</label>
            <form:password id="email1" cssClass="form-control" path="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                                  title="Musi zawierać co najmniej jedną cyfrę, jedną dużą i małą literę oraz co najmniej 8 znaków"/><br>
            <form:errors path="password" cssClass="error"/><br>
        </div>

        <button type="submit" class="btn btn-primary">Dodaj użytkownika</button>
    </form:form>
</div>
</body>
</html>
