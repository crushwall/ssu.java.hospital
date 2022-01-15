<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/view/css/style.css"%>
    </style>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <title>Clients</title>
</head>
<body>
<nav>
    <a class="button">Add</a>
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
                <td><p><fmt:formatDate value="${client.birthday}" pattern="E dd.M.y"/> </p></td>
                <td>${client.phoneNumber}</td>
                <td>${client.email}</td>
                <td>
                    <form action="clients" method="get">
                        <input type="submit" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="clients" method="post">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</article>
</body>
</html>