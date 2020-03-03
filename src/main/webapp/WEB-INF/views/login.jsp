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
    <title>Login</title>
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
      <h2>Zaloguj się</h2>

      <form method="post">
        <div class="form-group">
          <input type="text" name="username" placeholder="Email"/>
        </div>
        <div class="form-group">
          <input type="password" name="password" placeholder="Hasło"/>
        </div>
        <div class="form-group form-group--buttons">
          <button class="btn" type="submit">Zaloguj się</button>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      </form>

    </section>
    </div>
  </header>

    <%@include file="footer.jsp" %>

    <script src="<c:url value="/resources/js/app.js"/>"></script>
  </body>
</html>
