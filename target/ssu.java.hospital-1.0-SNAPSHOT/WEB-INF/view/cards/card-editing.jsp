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
<nav>
    <form action="${pageContext.request.contextPath}/cards" method="get">
        <input type="submit" value="Back">
    </form>
</nav>
<main>
    <form action="save" method="Post">
        <input type="hidden" name="id" value="${card.id}">
        <label>Client ID:
            <input type="text" name="first-name" value="${card.client.id}">
        </label>
        <br/>
        <c:forEach items="${records}" var="record">
            <label>Record #${record.id}
                <input type="checkbox" name="appointment" value="${record.id}"
                        <c:if test="${card.records.contains(record)}">checked="checked"</c:if> />
            </label>
            <br>
        </c:forEach>
        <input type="submit" value="Save"/>
        <br/>
    </form>
</main>
</body>
</html>
