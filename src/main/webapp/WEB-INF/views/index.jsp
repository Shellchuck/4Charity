<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Main Page</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>

<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <sec:authorize access="!(isAuthenticated())">
                        <li><a href="<c:url value="/login" />" class="btn btn--small btn--without-border">Zaloguj</a></li>
                        <li><a href="<c:url value="/register" />" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </sec:authorize>

            <sec:authorize access="isAuthenticated()">
                <li><p>Witaj <sec:authentication property="name"/></p></li>
                <li><form action="<c:url value="/logout"/>" method="post">
                    <input type="submit" value="Wyloguj" class="btn btn--small btn--highlighted">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form></li>
            </sec:authorize>
        </ul>
        <%@include file="header_menu.jsp" %>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br/>
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>
        </div>
    </div>
</header>

<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em><c:out value="${allGifts}"/></em>

            <h3>Oddanych worków</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum
                tempora!</p>
        </div>

        <div class="stats--item">
            <em><c:out value="${donationsNumber}"/></em>
            <h3>Przekazanych darów</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas
                quam.</p>
        </div>

    </div>
</section>

<section id="steps" class="steps">
    <h2>Wystarczą 4 proste kroki</h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3>Wybierz rzeczy</h3>
            <p>ubrania, zabawki, sprzęt i inne</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3>Spakuj je</h3>
            <p>skorzystaj z worków na śmieci</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3>Zdecyduj komu chcesz pomóc</h3>
            <p>wybierz zaufane miejsce</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3>Zamów kuriera</h3>
            <p>kurier przyjedzie w dogodnym terminie</p>
        </div>
    </div>
    <sec:authorize access="!(isAuthenticated())">
        <a href="<c:url value="/register" />" class="btn btn--large">Załóż konto</a>
    </sec:authorize>
</section>

<section id="about-us" class="about-us">
    <div class="about-us--text">
        <h2>O nas</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero
            optio esse quisquam illo omnis.</p>
        <img src="<c:url value="/resources/images/signature.svg"/>" class="about-us--text-signature" alt="Signature"/>
    </div>
    <div class="about-us--image"><img src="<c:url value="/resources/images/about-us.jpg"/>" alt="People in circle"/>
    </div>
</section>

<section id="help" class="help">
    <h2>Komu pomagamy?</h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują.</p>

        <ul class="help--slides-items">
            <c:forEach var="institution" items="${institutions}" varStatus="position">
                <c:choose>
                    <c:when test="${position.index % 2 == 0}">
                        <li>
                        <div class="col">
                            <div class="title"><c:out value="Fundacja \"${institution.name}\""/></div>
                            <div class="subtitle"><c:out value="Cel i misja: ${institution.description}"/></div>
                        </div>
                        <c:if test="${position.last}">
                            </li><li>
                        </c:if>
                    </c:when>
                    <c:otherwise>
                        <div class="col">
                            <div class="title"><c:out value="Fundacja \"${institution.name}\""/></div>
                            <div class="subtitle"><c:out value="Cel i misja: ${institution.description}"/></div>
                        </div>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </ul>
    </div>

</section>

<%@include file="footer.jsp" %>

<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>
