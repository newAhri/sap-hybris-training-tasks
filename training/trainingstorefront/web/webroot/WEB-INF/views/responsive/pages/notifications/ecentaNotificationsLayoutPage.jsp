<%--
  Created by IntelliJ IDEA.
  User: vladi
  Date: 12.05.2023
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags" %>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/responsive/common" %>

<template:page pageTitle="${pageTitle}">
    <div id="globalMessages">
        <common:globalMessages/>
    </div>

    <cms:pageSlot position="ecentaNotificationsParagraph" var="feature" element="div" class="ecentaNotificationsParagraph">
        <cms:component component="${feature}" />
    </cms:pageSlot>

</template:page>