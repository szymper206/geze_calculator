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
<body>
<form:form method="post" modelAttribute="productType" >
    <form:hidden path="id"/>
    Nazwa Typu Towaru: <form:input path="name"/><br>
    <form:errors path="name" cssClass="error"/><br>
    Grupa towarowa: <form:select path="productGroup">
    <form:option value="0" label="wybierz grupę towarową"/>
    <form:options items="${productGroups}" itemValue="id" itemLabel="name"/>
    </form:select><br>
    <form:errors path="productGroup" cssClass="error"/><br>
    <input type="submit" value="Dodaj Typ Towaru">
</form:form>
</body>
</html>
