<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>

<tiles:insertDefinition name="adminTemplate">
    <tiles:putAttribute name="body">
        <springform:form method="POST" modelAttribute="roomModel">
            <table>
                <tr>
                    <td>Number:</td>
                    <td><springform:input path="number" id="number" size="20" /></td>
                </tr>
                <tr>
                    <td>Bed:</td>
                    <td><springform:input path="bed" id="bed" size="20" /></td>
                </tr>
                <tr>
                    <td><input class="button" type="submit" value="Add"/></td>
                </tr>
            </table>
        </springform:form>         

    </tiles:putAttribute>
</tiles:insertDefinition>