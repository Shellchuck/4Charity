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
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <%@include file="header_menu.jsp" %>

    <section class="login-page">
      <h2>Załóż konto</h2>
      <form:form method="post" modelAttribute="user">
        <div class="form-group">
          <form:input path="name" placeholder="Imię" />
        </div>
        <div class="form-group">
          <form:input path="surname" placeholder="Nazwisko" />
        </div>
        <div class="form-group">
          <form:input type="email" path="email" placeholder="Email" />
        </div>
        <div class="form-group">
          <form:password path="password" placeholder="Hasło" />
        </div>
        <%--<div class="form-group">
          <form:input type="password" path="password2" placeholder="Powtórz hasło" />
        </div>--%>

        <div class="form-group form-group--buttons">
          <a href="/login.html" class="btn btn--without-border">Zaloguj się</a>
          <button class="btn" type="submit">Załóż konto</button>
        </div>
      </form:form>
    </section>

    <%@include file="footer.jsp" %>

    <script src="<c:url value="/resources/js/app.js"/>"></script>
  </body>
</html>
