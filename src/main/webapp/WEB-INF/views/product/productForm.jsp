<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="jumbotron text-center">
    <H1>Dodawanie produktu</H1>
</div>
<div class="container">
    <form:form method="post" modelAttribute="product" >
        <form:hidden path="id"/>

        <div class="form-group">
            <label for="name1">Nazwa Towaru:</label>
            <form:input path="name" id="name1" cssClass="form-control"/>
            <form:errors path="name" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="idNumber1">Numer ID:</label>
            <form:input path="idNumber" id="idNumber1" cssClass="form-control"/>
            <form:errors path="idNumber" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="defQuantity1">Domyślna ilość:</label>
            <form:input path="defQuantity" id="defQuantity1" cssClass="form-control"/><br>
            <form:errors path="defQuantity" cssClass="error"/><br>
        </div>

        <div class="form-group">
            <label for="sel">Typ towaru:</label>
            <form:select path="productType" cssClass="form-control" id="sel">
                <form:option value="0" label="---typ towaru---"/>
                <form:options items="${productTypes}" itemValue="id" itemLabel="name"/>
            </form:select><br>
            <form:errors path="productType" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="sel1">Wzór:</label>
            <form:select path="mathFormula" cssClass="form-control" id="sel1">
            <form:option value="0" label="wybierz wzór dla towaru"/>
            <form:options items="${mathFormulas}" itemValue="id" itemLabel="name"/>
            </form:select><br>
            <form:errors path="mathFormula" cssClass="error"/>
        </div>

        <button type="submit" class="btn btn-primary">Dodaj towar</button>
    </form:form>
</div>
</body>
</html>
