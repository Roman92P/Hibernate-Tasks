<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 07.10.2020
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Zadanie 4 Authors</title>
</head>
<body>
<table border>
    <thead>
    <th>id</th>
    <th>firstName</th>
    <th>lastName</th>
    <th>Action 1</th>
    <th>Action 2</th>
    </thead>
    <tbody>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href="/author/delete/${author.id}">Usuń</a></td>
            <td><a href="/author/edit/${author.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2>
    <a href="/author/add">Add author</a>
</h2>
<br>
<a href="/">Home</a>
</body>
</html>
