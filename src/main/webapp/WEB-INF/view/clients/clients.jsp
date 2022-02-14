<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/view/css/style.css"%>
    </style>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <title>Clients</title>
</head>
<body>
<nav>
    <form action="${pageContext.request.contextPath}/" method="get">
        <input type="submit" value="Home">
    </form>
    <form action="client-editing/new" method="get">
        <input type="submit" value="Add">
    </form>
</nav>

<article>
    <table>
        <tr>
            <th>ID</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Sex</th>
            <th>Birthday</th>
            <th>Phone number</th>
            <th>Email</th>
        </tr>

        <c:forEach items="${clients}" var="client" varStatus="tagStatus">
            <tr>
                <td>${client.id}</td>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.getSex().toString()}</td>
                <td><p><fmt:formatDate value="${client.birthday}" pattern="yyyy-MM-dd"/></p></td>
                <td>${client.phoneNumber}</td>
                <td>${client.email}</td>
                <td>
                    <a href="client-editing/edit?id=${client.id}">Edit</a>
                        <%--                    <form action="client-editing/edit?id=${client.id}" method="get">--%>
                        <%--                        <input type="submit" value="Edit">--%>
                        <%--                    </form>--%>
                </td>
                <td>
                    <a href="clients/delete?id=${client.id}">Delete</a>
                        <%--                    <form action="clients/delete?id=${client.id}" method="post">--%>
                        <%--                        <input type="submit" value="Delete" />--%>
                        <%--                    </form>--%>
                </td>
            </tr>
        </c:forEach>
    </table>
</article>
</body>
</html>