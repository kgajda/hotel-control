<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <spring:form method="POST" modelAttribute="hotelModel">
            <h1>Registration New Hotel</h1>
            <table>
                <tr>
                    <td>City</td>
                    <td><spring:input path="city" id="city" size="20" /></td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><spring:input path="name" id="name" size="20" /></td>
                </tr>
                <tr>
                    <td>Stars</td>
                    <td><spring:input path="stars" id="stars" size="20" /></td>
                </tr>
            </table>
            <input class="button" type="submit" value="Add"/>
        </spring:form>
    </tiles:putAttribute>
</tiles:insertDefinition>