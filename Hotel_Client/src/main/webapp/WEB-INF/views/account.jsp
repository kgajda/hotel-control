<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<tiles:insertDefinition name="adminTemplate">
    <tiles:putAttribute name="body">
        <spring:form  method="POST" modelAttribute="accountModel">
            <table>
                <tr>
                    <td>ID:  </td>
                    <td><c:out value="${accountModel.id}"/> </td>
                </tr>
                <tr>
                    <td>Login:  </td>
                    <td><c:out value="${accountModel.login}"/> </td>
                </tr>

                <tr>
                    <td>Email:  </td>
                    <td><c:out value="${accountModel.email}"/> </td>
                </tr>
                <tr>
                    <td>Name:  </td>
                    <td><c:out value="${accountModel.userInfo.name}"/> </td>
                </tr>
                <tr>
                    <td>Surname:  </td>
                    <td><c:out value="${accountModel.userInfo.sourName}"/> </td>
                </tr>
                <tr>
                    <td>Phone:  </td>
                    <td><c:out value="${accountModel.userInfo.phone}"/> </td>
                </tr>
                <tr>
                    <td>Status:  </td>
                    <td><spring:select path="status" items="${status}"/></td>
                </tr>
                <tr>
                    <td>Role: </td>
                    <td><spring:select path="role_account" items="${role}"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save"/></td>
                </tr>

            </table>
        </spring:form>
    </tiles:putAttribute>
</tiles:insertDefinition>