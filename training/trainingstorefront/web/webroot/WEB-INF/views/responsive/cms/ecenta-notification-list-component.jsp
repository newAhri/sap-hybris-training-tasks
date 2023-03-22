<%--
  Created by IntelliJ IDEA.
  User: vladi
  Date: 22.03.2023
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="ecentaNotificationListComponent">
    <c:forEach items="${ecentaNotificationDataList}" var="notification">
        <tr>
            <td>
                <c:if test="${notification.priority == 'HIGH'}">
                    <span class="glyphicon glyphicon-exclamation-sign" id="red_e"/>
                </c:if>
                <c:if test="${notification.priority == 'MEDIUM'}">
                    <span class="glyphicon glyphicon-exclamation-sign" id="yellow_e"/>
                </c:if>
                <c:if test="${notification.priority == 'LOW'}">
                    <span class="glyphicon glyphicon-exclamation-sign" id="green_e"/>
                </c:if>
            </td>
            <td><c:out value="${notification.date}"/></td>
            <td><c:out value="${notification.message}"/></td>
        </tr>
    </c:forEach>

</div>

