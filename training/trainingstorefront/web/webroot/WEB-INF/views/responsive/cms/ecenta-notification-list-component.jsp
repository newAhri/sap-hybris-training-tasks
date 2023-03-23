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

<div class="ecentaNotificationListComponent" id="component">
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
            <button class="btn btn-success" data-id="${notification.id}"></button>
        </tr>
    </c:forEach>
</div>
<script>
    $(document).on('click', 'button[data-id]', function (e) {
        var notification_id = $(this).attr('data-id');
        var data = 'id=' + encodeURIComponent(notification_id);
        $.ajax({
            url : '/view/EcentaNotificationListComponentController/getRefreshedList',
            data : data,
            type : "GET",

            success : function(response){
                $('#component').val(response);
            }
        })
    });
</script>



