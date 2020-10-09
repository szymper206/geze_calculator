<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Assortment Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
    <script src="../../../script/assortmentForm.js" type="text/javascript"></script>

</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<script src="../../../script/assortmentForm.js"></script>

<div class="jumbotron text-center">
<H1>Dodawanie doboru</H1><br>
</div>

<div class="container">
<form:form method="post" modelAttribute="assortment" >
    <form:hidden path="id"/>

    <div class="form-group">
        <label for="length">Wysokość światła przejścia:</label>
        <form:input id="length" path="length" cssClass="form-control"/>
        <form:errors path="length" cssClass="error"/>
    </div>

    <div class="form-group">
        <label for="width">Szerokość światła przejścia:</label>
        <form:input id="width" path="width" cssClass="form-control"/>
        <form:errors path="width" cssClass="error"/>
    </div>

    <div class="form-check">
        <label class="form-check-label">
            <form:checkbox path="painted" cssClass="form-check-input" value=""/>Czy lakierowane?
        </label>
    </div>

    <div class="form-group">
        <label for="notes">Notatki:</label>
    <form:textarea path="description" cssClass="form-control" rows="5" id="notes"/>
    </div>

    <div class="form-group">
        <label for="sel">Typ towaru:</label>
        <form:select path="productType" cssClass="form-control" id="sel">
        <form:option value="0" label="---typ towaru---"/>
        <form:options items="${productTypes}" itemValue="id" itemLabel="name"/>
        </form:select><br>
        <form:errors path="productType" cssClass="error"/>
    </div>

    <button type="submit" class="btn btn-primary">Dodaj dobór</button>

</form:form>
</div>


</body>
</html>

