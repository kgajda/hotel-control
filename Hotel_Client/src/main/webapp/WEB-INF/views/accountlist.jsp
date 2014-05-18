<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="adminTemplate">
    <tiles:putAttribute name="body">
        <h1>User List</h1>
        <table>
            <tr>
                <td>ID</td>
                <td>Login</td>
                <td>Email</td>
                <td>Type</td>
                <td>Status</td>
            </tr>
            <c:forEach items="${accountlist}" var="account">
                <tr>
                    <td><c:out value="${account.id}"/> </td>
                    <td>
                        <spring:url value="account/${account.login}" var="aboutUrl" htmlEscape="true"/>
                        <a class="button" href="${aboutUrl}"><c:out value="${account.login}"/> </a>
                    </td>
                    <td><c:out value="${account.email}"/> </td>
                    <td><c:out value="${account.role_account}"/> </td>
                    <td><c:out value="${account.status}"/> </td>
                </tr>
            </c:forEach>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>