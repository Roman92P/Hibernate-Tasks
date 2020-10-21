<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 18.10.2020
  Time: 08:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Drfats</title>
</head>
<body>
<table border>
    <thead>
    <th>id</th>
    <th>title</th>
    <th>content</th>
    </thead>
    <tbody>
    <c:forEach items="${drafts}" var="draft">
        <tr>
            <td>${draft.id}</td>
            <td>${draft.title}</td>
            <td>${draft.content}</td>
            <td><a href="draft/delete/${draft.id}">Usuń</a></td>
            <td><a href="/draft/edit/${draft.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<h2>
    <a href="/draft/add">Add category</a>
</h2>
<br>
<a href="/">Home</a>
</body>
</html>
