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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Add article form</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
        <form:form action="${pageContext.request.contextPath}/articles/add" method="post" modelAttribute="article"
                   class="border">
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
            <label for="draft">Draft</label>
            <br>
            <form:checkbox path="draft" label="draftcheck" value="1"/>
            <br>
            <form:errors path="draft"/>
            <input type="submit">
        </form:form>
        </div>
    </div>
</div>
</body>
</html>
