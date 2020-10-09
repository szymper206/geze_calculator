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
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
    <H1>Dodawanie wzoru</H1>
</div>
<div class="container">
<form:form method="post" modelAttribute="mathFormula" >
    <form:hidden path="id"/>

    <div class="form-group">
        <label for="mathFormula">Wzór:</label>
        <form:input path="name" id="mathFormula" cssClass="form-control"/><br>
        <form:errors path="name" cssClass="error"/><br>
    </div>

    <button type="submit" class="btn btn-primary">Dodaj wzór</button>
</form:form>
</div>
</body>
</html>