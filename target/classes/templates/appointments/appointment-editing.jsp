<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="/templates/view/css/style.css"%>
        <%@include file="/templates/view/css/edit-style.css"%>
    </style>
    <title>Editing</title>
</head>
<body>
<nav>
    <form action="${pageContext.request.contextPath}/appointments" method="get">
        <input type="submit" value="Back">
    </form>
</nav>
<main>
    <form action="save" method="Post">
        <input type="hidden" name="id" value="${appointment.id}">
        <label>Doctor ID:
            <input type="text" name="doctor-id" value="${appointment.doctor.id}">
        </label>
        <br/>
        <label>Client ID:
            <input type="text" name="client-id" value="${card.client.id}"/>
        </label>
        <br/>
        <label>Date:
            <fmt:parseDate value="${appointment.date}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDate"/>
            <fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd HH:mm" var="fmtDate"/>
            <input type="datetime-local" name="date" value="${fmtDate}"/>
        </label>
        <br/>
        <label>Appointment status:
            <select name="appointment-status">
                <option name="appointment-status" value="ACTIVE" <c:if test="${appointment.appointmentStatus eq 'ACTIVE'}">selected</c:if>>
                    ACTIVE
                </option>
                <option name="appointment-status" value="PROCESSING" <c:if test="${appointment.appointmentStatus eq 'PROCESSING'}">selected</c:if>>
                    PROCESSING
                </option>
                <option name="appointment-status" value="DONE" <c:if test="${appointment.appointmentStatus eq 'DONE'}">selected</c:if>>
                    DONE
                </option>
                <option name="appointment-status" value="CANCELED" <c:if test="${appointment.appointmentStatus eq 'CANCELED'}">selected</c:if>>
                    CANCELED
                </option>
                <option name="appointment-status" value="NOT SHOWN" <c:if test="${appointment.appointmentStatus eq 'NOT_SHOWN'}">selected</c:if>>
                    NOT SHOWN
                </option>
            </select>
        </label>
        <br/>
        <label>Client status:
            <select name="client-status">
                <option name="client-status" value="HEALTHY" <c:if test="${appointment.clientStatus eq 'HEALTHY'}">selected</c:if>>
                    HEALTHY
                </option>
                <option name="client-status" value="SICK" <c:if test="${appointment.clientStatus eq 'SICK'}">selected</c:if>>
                    SICK
                </option>
                <option name="client-status" value="UNKNOWN" <c:if test="${appointment.clientStatus eq 'UNKNOWN'}">selected</c:if>>
                    UNKNOWN
                </option>
            </select>
        </label>
        <br/>
        <input type="submit" value="Save"/>
    </form>
</main>
</body>
</html>
