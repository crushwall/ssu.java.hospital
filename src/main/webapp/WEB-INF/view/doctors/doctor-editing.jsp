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
    <form action="${pageContext.request.contextPath}/doctors" method="get">
        <input type="submit" value="Back">
    </form>
</nav>
<main>
    <form action="save" method="Post">
        <input type="hidden" name="id" value="${doctor.id}">
        <label>First Name:
            <input type="text" name="first-name" value="${doctor.firstName}">
        </label>
        <br/>
        <label>Last Name:
            <input type="text" name="last-name" value="${doctor.lastName}"/>
        </label>
        <br/>
        <label>Birthday:
            <fmt:formatDate var="fmtBirthday" value="${doctor.birthday}" pattern="yyyy-MM-dd"/>
            <input type="date" name="birthday" value="${fmtBirthday}"/>
        </label>
        <br/>
        <label>Male
            <input type="radio" name="sex" value="Male"
                   <c:if test="${doctor.sex eq 'Male'}">checked</c:if>/>
        </label>
        <label>Female
            <input type="radio" name="sex" value="Female"
                   <c:if test="${doctor.sex eq 'Female'}">checked</c:if>/>
        </label>
        <br/>
        <label>Phone:
            <input type="tel" name="phone" value="${doctor.phoneNumber}">
        </label>
        <br/>
        <label>Email:
            <input type="email" name="email" value="${doctor.email}">
        </label>
        <br/>
        <label>Username:
            <input type="text" name="username" value="${doctor.username}">
        </label>
        <br/>
        <label>Password:
            <input type="password" name="password" value="${doctor.password}">
        </label>
        <br/>
        <label>Employment date:
            <fmt:formatDate var="fmtEmployment" value="${doctor.employmentDate}" pattern="yyyy-MM-dd"/>
            <input type="date" name="employment-date" value="${fmtEmployment}"/>
        </label>
        <br/>
        <label>Education:
            <input type="text" name="education" value="${doctor.education}">
        </label>
        <br/>
        <label>Specialization:
            <select name="specialization">
                <option name="specialization" value="THERAPIST" <c:if test="${doctor.specialization eq 'THERAPIST'}">selected</c:if>>
                    THERAPIST
                </option>
                <option name="specialization" value="ONCOLOGIST" <c:if test="${doctor.specialization eq 'ONCOLOGIST'}">selected</c:if>>
                    ONCOLOGIST
                </option>
                <option name="specialization" value="DENTIST" <c:if test="${doctor.specialization eq 'DENTIST'}">selected</c:if>>
                    DENTIST
                </option>
                <option name="specialization" value="PSYCHOLOGIST" <c:if test="${doctor.specialization eq 'PSYCHOLOGIST'}">selected</c:if>>
                    PSYCHOLOGIST
                </option>
                <option name="specialization" value="PSYCHOTHERAPIST" <c:if test="${doctor.specialization eq 'PSYCHOTHERAPIST'}">selected</c:if>>
                    PSYCHOTHERAPIST
                </option>
                <option name="specialization" value="UROLOGIST" <c:if test="${doctor.specialization eq 'UROLOGIST'}">selected</c:if>>
                    UROLOGIST
                </option>
                <option name="specialization" value="SPEECH_THERAPIST" <c:if test="${doctor.specialization eq 'SPEECH_THERAPIST'}">selected</c:if>>
                    SPEECH THERAPIST
                </option>
            </select>
        </label>
        <br/>
        <label>Start working time:
            <fmt:formatDate var="fmtStartWorking" value="${doctor.startWorkingTime}" pattern="HH:mm"/>
            <input type="time" name="start-working-time" value="${fmtStartWorking}"/>
        </label>
        <br/>
        <label>End working time:
            <fmt:formatDate var="fmtEndWorking" value="${doctor.endWorkingTime}" pattern="HH:mm"/>
            <input type="time" name="end-working-time" value="${fmtEndWorking}"/>
        </label>
        <br/>
        <input type="submit" value="Save"/>
    </form>
</main>
</body>
</html>
