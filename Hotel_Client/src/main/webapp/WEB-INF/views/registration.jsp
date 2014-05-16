<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <spring:form method="POST" modelAttribute="accountModel">
            <table>
                <tr>
                    <td>Login</td>
                    <td><spring:input path="login" id="login" size="20" /></td>
                </tr>
                <tr>
                    <td class="error">
                        <spring:errors cssClass="error" path="login" />
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><spring:password path="password" id="password" size="20" /></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><spring:input path="email" id="email" size="20" /></td>
                </tr>
                <tr>
                    <td class="error">
                        <spring:errors cssClass="error" path="email"/>
                    </td>
                </tr>
            </table>
            <input class="button" type="submit" value="Registr"/>
        </spring:form>
    </tiles:putAttribute>
</tiles:insertDefinition>