<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 07.10.2020
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Articles</title>
</head>
<body>
<table border>
    <thead>
    <th>id</th>
    <th>Content</th>
    <th>Created</th>
    <th>Title</th>
    <th>Updated</th>
    <th>Autor</th>
    <th>Action 1</th>
    <th>Action 2</th>
    </thead>
    <tbody>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.id}</td>
            <td>${article.content}</td>
            <td>${article.created}</td>
            <td>${article.title}</td>
            <td>${article.updated}</td>
            <td>${article.author.firstName}</td>
            <td><a href="/articles/delete/${article.id}">Usuń</a></td>
            <td><a href="/articles/edit/${article.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2>
    <a href="/articles/add">Add Article</a>
</h2>
<br>
<a href="/">Home</a>
</body>
</html>
