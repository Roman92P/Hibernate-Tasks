<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 23.10.2020
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>CategoryArticles</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <table border class="table table-hover">
                <thead>
                <th>Title</th>
                <th>Author</th>
                </thead>
                <tbody>
                <c:forEach items="${categoryArticles}" var="article">
                    <tr>
                        <td>${article.title}</td>
                        <td>${article.author.firstName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <div class="col-4">
                    <a href="/" class="button-btn">Other home</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>