<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/view/css/style.css"%>
    </style>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <title>Appointments</title>
</head>
<body>
<nav>
    <form action="appointment-editing/new" method="get">
        <input type="submit" value="Add">
    </form>

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
                    <td>${appointment.doctorId}</td>
                    <td>${appointment.clientId}</td>
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
</nav>
</body>
</html>
