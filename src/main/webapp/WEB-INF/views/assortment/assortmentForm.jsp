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
<body>
<script src="../../../script/assortmentForm.js"></script>
<form:form method="post" modelAttribute="assortment" >
    <form:hidden path="id"/>
    Wysokość światła przejścia: <form:input path="length"/><br>
    <form:errors path="length" cssClass="error"/><br>
    Szerokość światła przejścia: <form:input path="width"/><br>
    <form:errors path="width" cssClass="error"/><br>
    Czy lakierowane?: <form:checkbox path="painted"/><br>
    Notatki: <form:textarea path="description"/><br>

    <div id="productGroup">
    <form:select path="productGroup" >
    <form:option value="0" label="wybierz grupę towarową"/>
        <form:options items="${productGroups}" itemValue="id" itemLabel="name"/>
    </form:select><br>
    <form:errors path="productGroup" cssClass="error"/><br>
    </div>

    <div id="productType">
    <form:select path="productType">
    <form:option value="0" label="wybierz typ towaru"/>
    <form:options items="${productTypes}" itemValue="id" itemLabel="name"/>
    </form:select><br>
    <form:errors path="productType" cssClass="error"/><br>
    </div>

    <input type="submit" value="Dodaj dobór">
</form:form>


</body>
</html>

