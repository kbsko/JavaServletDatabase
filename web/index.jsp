<%@ page import="java.util.ArrayList" %>
<%@ page import="students.web.Person" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>




<html>

  <head>
    <title></title>
  </head>
  <body>
    <table border="1" align="center">
        <caption>My First Table</caption>
        <tr><th>Names</th>
            <th>Ages</th></tr>
        <c:forEach var="nameOption" items="${requestScope.nameList}">
            <%--    <c:set var="ageTotal" value="${nameOption.G}" />
                <c:set var="nameTotal" value="${nameOption.name}" /> --%>
                <tr><td><c:out value="${nameOption}"/></td>
                    <td><c:out value="${1990}"/></td></tr>
            </c:forEach>
        </table>

      </body>
    </html>