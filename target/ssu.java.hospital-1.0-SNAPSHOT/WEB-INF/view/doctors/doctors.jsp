<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/view/css/style.css"%>
    </style>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <title>Doctors</title>
</head>
<body>
<nav>
    <form action="${pageContext.request.contextPath}/" method="get">
        <input type="submit" value="Home">
    </form>
    <form action="doctor-editing/new" method="get">
        <input type="submit" value="Add">
    </form>
</nav>

<article>
    <table>
        <tr>
            <th>ID</th>
            <th>Specialization</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Sex</th>
            <th>Birthday</th>
            <th>Phone number</th>
            <th>Email</th>
        </tr>

        <c:forEach items="${doctors}" var="doctor" varStatus="tagStatus">
            <tr>
                <td>${doctor.id}</td>
                <td>${doctor.specialization}</td>
                <td>${doctor.firstName}</td>
                <td>${doctor.lastName}</td>
                <td>${doctor.getSex().toString()}</td>
                <td><p><fmt:formatDate value="${doctor.birthday}" pattern="yyyy-MM-dd"/></p></td>
                <td>${doctor.phoneNumber}</td>
                <td>${doctor.email}</td>
                <td>
                    <a href="doctor-editing/edit?id=${doctor.id}">Edit</a>
                </td>
                <td>
                    <a href="doctors/delete?id=${doctor.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</article>
</body>
</html>
