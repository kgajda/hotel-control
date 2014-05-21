<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="adminTemplate">
    <tiles:putAttribute name="body">
        <h1>Hotel List</h1>
        <table>
            <tr>
                <td>ID</td>
                <td>Place</td>
                <td>Name</td>
                <td>Stars</td>
            </tr>
            <c:forEach items="${hotelModelList}" var="hotelModel">
                <tr>
                    <td><c:out value="${hotelModel.id}"/> </td>
                    <td>
                        <spring:url value="hotel/${hotelModel.name}" var="aboutUrl" htmlEscape="true"/>
                        <a class="button" href="${aboutUrl}"><c:out value="${hotelModel.name}"/> </a>
                    </td>
                    <td><c:out value="${hotelModel.city}"/> </td>
                    <td><c:out value="${hotelModel.stars}"/> </td>
                </tr>
            </c:forEach>
                <tr>
                    <td><spring:url value="hotel/new" var="aboutUrl" htmlEscape="true"/>
                        <a class="button" href="${aboutUrl}"><c:out value="Registr new hotel"/> </a></td>
                </tr>    
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>