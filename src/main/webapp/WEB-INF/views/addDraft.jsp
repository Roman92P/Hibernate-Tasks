<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 18.10.2020
  Time: 08:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add Draft</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/draft/add" method="post" modelAttribute="draft">
    <p hidden><form:input path="id"/></p>
    <label for="title">Title</label>
    <form:input path="title" id="title"/>
    <form:errors path="title"/>
    <label for="content">Content</label>
    <form:input path="content" id="content"/>
    <form:errors path="content"/>
    <input type="submit">
</form:form>
</body>
</html>
