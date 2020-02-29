<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 19.02.2020
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Page Header Nav</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>

</head>
<body>
<header class="common-header">
<nav class="container container--70">
    <ul class="nav--actions">
        <li><a href="" class="btn btn--small btn--without-border">Zaloguj</a></li>
        <li><a href="#" class="btn btn--small btn--highlighted">Załóż konto</a></li>
    </ul>
    <ul>
        <li><a href="/" class="btn btn--without-border active">Start</a></li>
        <li><a href="#steps" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="#about-us" class="btn btn--without-border">O nas</a></li>
        <li><a href="#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <li><a href="<c:url value="/donation/add" />" class="btn btn--without-border">Przekaż dary</a></li>
        <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>
</header>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
