<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
<!--        <div class="body">
            <spring:form method="POST" modelAttribute="login">
                <table>
                    <tr>
                        <td>Login</td>
                        <td><spring:input path="login" size="20" id="login"/></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><spring:password path="pass" size="20" id="pass" showPassword="true"  /></td>
                    </tr>
                </table>
            </spring:form>
        </div>-->
    </tiles:putAttribute>
</tiles:insertDefinition>