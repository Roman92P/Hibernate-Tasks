<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 07.10.2020
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add article form</title>
</head>
<body>
<%--@elvariable id="article" type="pl.coderslab.app.model.Article"--%>
<form:form action="${pageContext.request.contextPath}/articles/add" method="post" modelAttribute="article">
    <p hidden><form:input path="id"/></p>
    <label for="content">Content</label>
    <br>
    <form:input path="content" id="content"/>
    <br>
    <form:errors path="content" cssClass="error"/>
    <br>
    <label for="title">Title</label>
    <br>
    <form:input path="title" id="title"/>
    <br>
    <form:errors path="title" cssClass="error"/>
    <br>
    <form:select path="author">
        <form:option value="0" label="Choose"/>
        <form:options itemValue="id" itemLabel="firstName" items="${authors}"/>
    </form:select>
    <br>
    <form:errors path="author" cssClass="error"/>
    <br>
    <label for="categoryList">Choose category </label>
    <br>
    <form:select path="categoryList">
        <form:option value="0" label="Please select one or more"/>
        <form:options items="${categories}" itemValue="id" itemLabel="name"/>
    </form:select>
    <br>
    <form:errors path="categoryList"/>
    <br>
    <br>

<%--    <label for="categories">Category</label>--%>
<%--    <br>--%>
<%--    <form:select  id="categories"--%>
<%--                  path="categoryList">--%>
<%--        <form:option value="0" label="--Please Select--"/>--%>
<%--        <form:options items="${categories}" itemLabel="name" itemValue="id"/>--%>
<%--    </form:select>--%>
<%--    <form:errors path="categoryList"/>--%>
<%--    <br>--%>


    <input type="submit">
</form:form>
</body>
</html>
