<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 07.10.2020
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Add Authors</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/author/add" method="post" modelAttribute="author">
    <p hidden><form:input path="id"/></p>
    <label for="firstName">Imię</label>
    <form:input path="firstName" id="firstName"/>
    <form:errors path="firstName"/>
    <label for="lastName">Nazwisko</label>
    <form:input path="lastName" id="lastName"/>
    <form:errors path="lastName"/>
    <input type="submit">
</form:form>
</body>
</html>
