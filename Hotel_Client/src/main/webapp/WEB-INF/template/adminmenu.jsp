<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="adminmenu">
    <ol>
        <ul>
            <li >
            <spring:url value="/admin/account" var="homeUrl" htmlEscape="true"/>
            <a class="button" href="${homeUrl}">Users</a>
        </li>
        <li >
            <spring:url value="/admin/hotel" var="adminUri" htmlEscape="true"/>
            <a class="button" href="${adminUri}">Hotels</a>
        </li>
        <li class="button">
            <spring:url value="/admin/reservation" var="aboutUrl" htmlEscape="true"/>
            <a class="button" href="${aboutUrl}">Reservation</a>
        </li>
        </ul>
    </ol>
</div>