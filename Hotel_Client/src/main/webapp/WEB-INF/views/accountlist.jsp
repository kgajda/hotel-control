<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insertDefinition name="adminTemplate">
    <tiles:putAttribute name="body">
        <table>
            <tr>
                <td>Login</td>
                <td>Email</td>
            </tr>
            <c:forEach items="${accountlist}" var="account">
                <tr>
                    <td><c:out value="${account.login}"/> </td>
                    <td><c:out value="${account.email}"/> </td>
                </tr>
            </c:forEach>
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>