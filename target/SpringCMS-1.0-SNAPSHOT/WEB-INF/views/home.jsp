<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 06.10.2020
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>App test homework</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <table border>
                <thead>
                <th>Tytuł</th>
                <th>Data dodania</th>
                <th>Kontent</th>
                </thead>
                <tbody>
                <c:forEach items="${articles}" var="article">
                    <tr>
                        <td>${article.title}</td>
                        <td>${article.created}</td>
                        <td>${article.content}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-3" style="background-color: fuchsia">
            <a href="/authors">Autorzy</a>
        </div>
        <div class="col-md-3" style="background-color: aqua">
            <a href="/cat">Categorie</a>
        </div>
        <div class="clo-md-3" style="background-color: darkgray">
            <a href="/articles">Articles</a>
        </div>
        <div class="clo-md-3" style="background-color: cornflowerblue">
            <a href="/draft">Drafts</a>
        </div>
    </div>
</div>
</body>
</html>
