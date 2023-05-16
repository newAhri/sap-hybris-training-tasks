<%--
  Created by IntelliJ IDEA.
  User: vladi
  Date: 22.03.2023
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<csrf disabled="true"/>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        console.log("check");
        const csrftoken = jQuery("[name=csrfmiddlewaretoken]").val();
        let name = [[${maxAmountToShow}]];
        console.log("modelAttributeValue: ", name)
    </script>
    <script>
        function csrfSafeMethod(method) {
            // these HTTP methods do not require CSRF protection
            console.log("check");
            return (/^(GET|HEAD|OPTIONS|TRACE)$/.test(method));
        }

        $.ajaxSetup({
            beforeSend: function (xhr, settings) {
                if (!csrfSafeMethod(settings.type) && !this.crossDomain) {
                    console.log("token");
                    xhr.setRequestHeader("X-CSRFToken", csrftoken);
                }
            }
        });
        function myFunction(objButton) {
            var id = objButton.value
            var data = {
                "id": id
            }
            $.ajax({
                url: "/getRefreshedList",
                data: JSON.stringify(id),
                type: "POST",
                csrftoken: csrftoken,

                success: function () {
                    $('#component').val();
                }
            })
        }
    </script>
    <script>

    </script>


</head>

<%--<spring:htmlEscape defaultHtmlEscape="true"/>--%>
<%--<b>${fn:length(ecentaNotificationDataList)}</b>--%>
<div class="ecentaNotificationListComponent" id="component">
    <table>
        <tr>
            <th>Priority</th>
            <th>Date</th>
            <th>Message</th>
            <th>Read</th>
        </tr>
        <c:forEach items="${ecentaNotificationDataList}" var="notification" end="${maxAmountToShow}">
            <tr>
                <td>

                    <c:if test="${notification.priority == 'HIGH'}">
                        <p style="font-weight:bold; font-size: 25px; color:red">!</p>
                    </c:if>
                    <c:if test="${notification.priority == 'NORMAL'}">
                        <p style="font-weight:bold; font-size: 25px; color:orange">!</p>
                    </c:if>
                    <c:if test="${notification.priority == 'LOW'}">
                        <p style="font-weight:bold; font-size: 25px; color:limegreen">!</p>
                    </c:if>

                </td>
                <td><c:out value="${notification.date}"/></td>
                <td><c:out value="${notification.message}"/></td>
                <td>
                        <%-- <button class="btn btn-success" onclick="myFunction(notification.id)"></button>--%>
                    <button class="btn-small" value="${notification.id}" onclick='myFunction(this)'></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>





