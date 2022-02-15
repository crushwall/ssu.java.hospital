<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="/templates/view/css/style.css"%>
    </style>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <title>Appointments</title>
</head>
<body>
<nav>
    <form action="${pageContext.request.contextPath}/" method="get">
        <input type="submit" value="Home">
    </form>
    <form action="appointment-editing/new" method="get">
        <input type="submit" value="Add">
    </form>
</nav>

<article>
    <table>
        <tr>
            <th>ID</th>
            <th>Doctor ID</th>
            <th>Client ID</th>
            <th>Date</th>
            <th>Status</th>
            <th>Client status</th>
        </tr>

        <c:forEach items="${appointments}" var="appointment" varStatus="tagStatus">
            <tr>
                <td>${appointment.id}</td>
                <td>${appointment.doctor.id}</td>
                <td>${appointment.patientCard.client.id}</td>
                <td>
                    <fmt:parseDate value="${appointment.date}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDate"/>
                    <p><fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd HH:mm"/></p>
                </td>
                <td>${appointment.appointmentStatus}</td>
                <td>${appointment.clientStatus}</td>
                <td>
                    <a href="appointment-editing/edit?id=${appointment.id}">Edit</a>
                </td>
                <td>
                    <a href="appointments/delete?id=${appointment.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</article>
</body>
</html>
