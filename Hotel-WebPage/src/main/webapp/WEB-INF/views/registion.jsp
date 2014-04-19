<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <spring:form method="POST" modelAttribute="registerModel">
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
                    <td><spring:password path="password1" id="password1" size="20" /></td>
                </tr>
                <tr>
                    <td class="error">
                        <spring:errors cssClass="error" path="password1"/>
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><spring:password path="password2" id="password2" size="20" /></td>
                </tr>
                <tr>
                    <td class="error">
                        <spring:errors cssClass="error" path="password2"/>
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><spring:input path="name" id="name" size="20" /></td>
                </tr>
                <tr>
                    <td class="error">
                        <spring:errors cssClass="error" path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>Sourname</td>
                    <td><spring:input path="sourname" id="sourname" size="20" /></td>
                </tr>
                <tr>
                    <td class="error">
                        <spring:errors cssClass="error" path="sourname"/>
                    </td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><spring:input path="addres" id="addres" size="20" /></td>
                </tr>
                <tr>
                    <td class="error">
                        <spring:errors cssClass="error" path="addres"/>
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><spring:input path="mail" id="mail" size="20" /></td>
                </tr>
                <tr>
                    <td class="error">
                        <spring:errors cssClass="error" path="mail"/>
                    </td>
                </tr>
                <tr>
                    <td>Telefon</td>
                    <td><spring:input path="phone" id="phone" size="20" /></td>
                </tr>
                <tr>
                    <td class="error">
                        <spring:errors cssClass="error" path="phone"/>
                    </td>
                </tr>
            </table>
            <input class="button" type="submit" value="Registr"/>
        </spring:form>
    </tiles:putAttribute>
</tiles:insertDefinition>