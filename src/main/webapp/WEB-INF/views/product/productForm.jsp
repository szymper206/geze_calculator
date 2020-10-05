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
<body>
<form:form method="post" modelAttribute="product" >
    <form:hidden path="id"/>
    Nazwa Towaru: <form:input path="name"/><br>
    <form:errors path="name" cssClass="error"/><br>
    Numer ID: <form:input path="idNumber"/><br>
    <form:errors path="idNumber" cssClass="error"/><br>
    Domyślna ilość: <form:input path="defQuantity"/><br>
    <form:errors path="defQuantity" cssClass="error"/><br>
    Typ towaru: <form:select path="productType">
    <form:option value="0" label="wybierz typ towaru"/>
    <form:options items="${productTypes}" itemValue="id" itemLabel="name"/>
    </form:select><br>
    <form:errors path="productType" cssClass="error"/><br>
    Wzór: <form:select path="mathFormula">
    <form:option value="0" label="wybierz wzór dla towaru"/>
    <form:options items="${mathFormulas}" itemValue="id" itemLabel="name"/>
    </form:select><br>
    <form:errors path="mathFormula" cssClass="error"/><br>
    <input type="submit" value="Dodaj Towar">
</form:form>
</body>
</html>
