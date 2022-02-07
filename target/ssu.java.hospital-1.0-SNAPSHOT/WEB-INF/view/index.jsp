<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style><%@include file="/WEB-INF/view/css/style.css"%></style>
    <title>Hospital</title>
    <link rel="shortcut icon" href="#">
</head>
<body>
<header>Hospital</header>
<nav>
    <form action="clients" method="get">
        <input type="submit" value="Clients">
    </form>
    <form action="cards" method="get">
        <input type="submit" value="Cards">

    </form>
    <form action="doctors" method="get">
        <input type="submit" value="Doctors">
    </form>
    <form action="appointments" method="get">
        <input type="submit" value="Appointments">
    </form>
</nav>
</body>
</html>