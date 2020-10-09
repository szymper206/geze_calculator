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
    <H1>Dodawanie typu towaru</H1>
</div>
<div class="container">
    <form:form method="post" modelAttribute="productType" >
        <form:hidden path="id"/>

        <div class="form-group"></div>
            <label for="productType">Nazwa typu towaru:</label>
            <form:input path="name" id="productType" cssClass="form-control"/><br>
            <form:errors path="name" cssClass="error"/><br>
        <div class="form-group"></div>

        <div class="form-group">
            <label for="sel">Grupa towarowa:</label>
            <form:select path="productGroup" cssClass="form-control" id="sel">
            <form:option value="0" label="---grupa towarowa---"/>
            <form:options items="${productGroups}" itemValue="id" itemLabel="name"/>
            </form:select><br>
            <form:errors path="productGroup" cssClass="error"/><br>
        </div>

        <button type="submit" class="btn btn-primary">Dodaj typ towaru</button>
</form:form>
</div>
</body>
</html>
