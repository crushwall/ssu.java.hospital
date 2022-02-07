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
        <input type="hidden" name="id" value="${client.id}">
        <label>First Name:
            <input type="text" name="first-name" value="${client.firstName}">
        </label>
        <br/>
        <label>Last Name:
            <input type="text" name="last-name" value="${client.lastName}"/>
        </label>
        <br/>
        <label>Birthday:
            <fmt:formatDate var="fmtDate" value="${client.birthday}" pattern="yyyy-MM-dd"/>
            <input type="date" name="birthday" value="${fmtDate}"/>
        </label>
        <br/>
        <label>Male
            <input type="radio" name="sex" value="Male"
                   <c:if test="${client.sex eq 'Male'}">checked</c:if>/>
        </label>
        <label>Female
            <input type="radio" name="sex" value="Female"
                   <c:if test="${client.sex eq 'Female'}">checked</c:if>/>
        </label>
        <br/>
        <label>Phone:
            <input type="tel" name="phone" value="${client.phoneNumber}">
        </label>
        <br/>
        <label>Email:
            <input type="email" name="email" value="${client.email}">
        </label>
        <br/>
        <label>Username:
            <input type="text" name="username" value="${client.username}">
        </label>
        <br/>
        <label>Password:
            <input type="password" name="password" value="${client.password}">
        </label>
        <br/>
        <input type="submit" value="Save"/>
    </form>
</main>
</body>
</html>
