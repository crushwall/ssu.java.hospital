<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="/templates/view/css/style.css"%>
    </style>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <title>Cards</title>
</head>
<body>
<nav>
    <form action="${pageContext.request.contextPath}/" method="get">
        <input type="submit" value="Home">
    </form>
    <form action="card-editing/new" method="get">
        <input type="submit" value="Add">
    </form>
</nav>

<article>
    <table>
        <tr>
            <th>ID</th>
            <th>Client ID</th>
            <th>Appointments</th>
        </tr>

        <c:forEach items="${cards}" var="card" varStatus="tagStatus">
            <tr>
                <td>${card.id}</td>
                <td>${card.client.id}</td>
                <td>
                    <ol>
                        <c:forEach items="${card.records}" var="record" varStatus="status">
                            <li><a href="appointment-editing/edit?id=${record.id}">Record ${record.id}</a></li>
                        </c:forEach>
                    </ol>
                </td>
                <td>
                    <a href="card-editing/edit?id=${card.id}">Edit</a>
                </td>
                <td>
                    <a href="cards/delete?id=${card.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</article>
</body>
</html>