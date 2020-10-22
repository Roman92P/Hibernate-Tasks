<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 07.10.2020
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Category Form zd 3</title>
</head>
<body>
<table border class="table">
    <thead>
    <th>id</th>
    <th>description</th>
    <th>name</th>
    <th>Article</th>
    <th>Action 1</th>
    <th>Action 2</th>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.id}</td>
            <td>${category.description}</td>
            <td>${category.name}</td>
            <td><c:forEach items="${category.articles}" var="article">
                <p>${article.title}
            </c:forEach></td>
            <td><a href="cat/delete/${category.id}">Usuń</a></td>
            <td><a href="/cat/edit/${category.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2>
    <a href="/cat/add">Add category</a>
</h2>
<br>
<a href="/">Home</a>
</body>
</html>
