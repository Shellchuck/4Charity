<%--
  Created by IntelliJ IDEA.
  User: marek
  Date: 29.02.2020
  Time: 09:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
  <header class="header--main-page">
    <nav class="container container--70">
      <ul class="nav--actions">
        <li><a href="<c:url value="/login" />" class="btn btn--small btn--without-border">Zaloguj</a></li>
        <li><a href="<c:url value="/register" />" class="btn btn--small btn--highlighted">Załóż konto</a></li>
      </ul>
      <%@include file="header_menu.jsp" %>
    </nav>
    <div class="slogan container container--90">
    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form method="post" modelAttribute="user">
        <div class="form-group">
          <form:input path="name" placeholder="Imię" />
          <p class="errors"><form:errors path="name"/></p>
        </div>
        <div class="form-group">
          <form:input path="surname" placeholder="Nazwisko" />
          <p class="errors"><form:errors path="surname"/></p>
        </div>
        <div class="form-group">
          <form:input type="email" path="email" placeholder="Email" />
          <p class="errors"><form:errors path="email"/></p>
        </div>
        <div class="form-group">
          <form:password path="password" placeholder="Hasło" />
          <p class="errors"><form:errors path="password"/></p>
        </div>
        <%--<div class="form-group">
          <form:input type="password" path="password2" placeholder="Powtórz hasło" />
        </div>--%>

        <div class="form-group form-group--buttons">
          <a href="<c:url value="/login" />" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
        </div>
      </form:form>
    </section>
    </div>
  </header>

    <%@include file="footer.jsp" %>

    <script src="<c:url value="/resources/js/app.js"/>"></script>
  </body>
</html>
