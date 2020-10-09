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
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
    <H1>Dodawanie grupy towarowej</H1>
</div>
<div class="container">
    <form:form method="post" modelAttribute="productGroup" >
        <form:hidden path="id"/>

        <div class="form-group">
            <label for="productGroup">Nazwa grupy towarowej:</label>
            <form:input path="name" id="productGroup" cssClass="form-control"/><br>
            <form:errors path="name" cssClass="error"/><br>
        </div>

        <input type="submit" value="Dodaj Grupę Towaru">
    </form:form>
</div>
</body>
</html>
