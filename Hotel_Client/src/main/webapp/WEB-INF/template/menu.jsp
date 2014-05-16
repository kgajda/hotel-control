<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="menu">
    <ul>
        <li >
            <spring:url value="/home" var="homeUrl" htmlEscape="true"/>
            <a class="button" href="${homeUrl}">Home</a>
        </li>
        <li >
            <spring:url value="/admin" var="adminUri" htmlEscape="true"/>
            <a class="button" href="${adminUri}">Administrator</a>
        </li>
        <li class="button">
            <spring:url value="/login" var="aboutUrl" htmlEscape="true"/>
            <a class="button" href="${aboutUrl}">Logowanie</a>
        </li>
        <li class="button">
            <spring:url value="/registration" var="aboutUrl" htmlEscape="true"/>
            <a class="button" href="${aboutUrl}">Rejestracja</a>
        </li>
    </ul>
</div>