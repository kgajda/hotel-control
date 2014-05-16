<%-- 
    Document   : list
    Created on : Apr 19, 2014, 1:16:54 PM
    Author     : karol
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List</title>
    </head>
    <body>
        <span>###################ACCOUNT#############################</span>
        <table>
            <c:forEach items="${accountlist}" var="account">
                <tr>
                    <span>###################ACCOUNT#############################</span>
                    <td>${account.login}</td>
                    <td>${account.userInfo.name}</td>
                </tr>
            </c:forEach>
  
        </table>
    </body>
</html>
