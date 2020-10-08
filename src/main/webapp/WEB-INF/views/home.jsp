<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>GEZE Calculator</h1>
<br>
<p>Aplikacja służąca do doboru elementów produktu na podstawie wprowadzonych danych</p>
<br>

<sec:authorize access="isAnonymous()">
<a href="/login"><input type="submit" value="Logowanie"></a><br>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <form action="<c:url value="/logout"/>" method="post">
        <input type="submit" value="Wyloguj">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
    <a href="/user/register"><input type="submit" value="Rejestracja użytkownika"></a>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
    <a href="/user/all"><input type="submit" value="Wszyscy użytkownicy"></a>
</sec:authorize><br>

<sec:authorize access="hasAnyRole('ADMIN', 'USER')">
    <a href="/assortment/add"><input type="submit" value="Dodaj dobór"></a>
</sec:authorize>

<sec:authorize access="hasAnyRole('ADMIN', 'USER')">
    <a href="/assortment/all"><input type="submit" value="Wszystkie dobory"></a>
</sec:authorize><br>

<sec:authorize access="hasRole('ADMIN')">
    <a href="/product/add"><input type="submit" value="Dodaj produkt"></a>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
    <a href="/product/all"><input type="submit" value="Wszystkie produkty"></a>
</sec:authorize><br>

<sec:authorize access="hasRole('ADMIN')">
    <a href="/productGroup/add"><input type="submit" value="Dodaj grupę produktową"></a>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
    <a href="/productGroup/all"><input type="submit" value="Wszystkie grupy produktowe"></a>
</sec:authorize><br>

<sec:authorize access="hasRole('ADMIN')">
    <a href="/productType/add"><input type="submit" value="Dodaj typ produktu"></a>
</sec:authorize>

<sec:authorize access="hasRole('ADMIN')">
    <a href="/productType/all"><input type="submit" value="Wszystkie typy produktów"></a>
</sec:authorize>


</body>
</html>
