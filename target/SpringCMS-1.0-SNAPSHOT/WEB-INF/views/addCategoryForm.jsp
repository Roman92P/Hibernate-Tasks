<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 07.10.2020
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Category Form</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/cat/add" method="post" modelAttribute="category">
    <p hidden><form:input path="id"/></p>
    <label for="description">Opis</label>
    <form:input path="description" id="description"/>
    <form:errors path="description"/>
    <label for="name">Name</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>
    <input type="submit">
</form:form>
</body>
</html>
