<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/view/css/style.css"%>
        <%@include file="/WEB-INF/view/css/edit-style.css"%>
    </style>
    <title>Editing</title>
</head>
<body>
<main>
    <form action="save" method="Post">
        <input type="hidden" name="id" value="${card.id}">
        <label>Client ID:
            <input type="text" name="first-name" value="${card.clientId}">
        </label>
        <br/>
        <c:forEach items="${appointments}" var="appointment">
            <label>Record #${appointment.id}
                <input type="checkbox" name="appointment" value="${appointment.id}"
                        <c:if test="${card.records.contains(appointment)}">checked</c:if>/>
            </label>
            <br>
        </c:forEach>
        <input type="submit" value="Save"/>
        <br/>
    </form>
</main>
</body>
</html>
