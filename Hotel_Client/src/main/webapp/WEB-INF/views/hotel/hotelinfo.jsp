<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tiles:insertDefinition name="adminTemplate">
    <tiles:putAttribute name="body">
        <h1>Hotel <c:out value="${hotelModel.name}"/></h1>
        <table>
            <tr>
                <td>City:</td><td><c:out value="${hotelModel.city}"/></td>
                <td>Stars:</td><td><c:out value="${hotelModel.stars}"/></td>
            </tr>
            <tr>
                <td>ID</td>
                <td>Number</td>
                <td>Bed</td>
                <td>Standard</td>
            </tr>
            <c:forEach items="${hotelModel.room}" var="room">
                <tr>
                    <td><c:out value="${room.id}"/> </td>
                    <td><c:out value="${room.number}"/> </td>
                    <td><c:out value="${room.bed}"/> </td>
                </tr>
            </c:forEach>  
                 <tr>
                    <td><spring:url value="/admin/hotel/${hotelModel.id}/room" var="aboutUrl" htmlEscape="true"/>
                        <a class="button" href="${aboutUrl}"><c:out value="Add new Room"/> </a></td>
                </tr>    
        </table>
    </tiles:putAttribute>
</tiles:insertDefinition>