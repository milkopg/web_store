<%@ taglib prefix="ct" uri="http://softuni.bg/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <spring:url value="/resources/css/style.css" var="stylesCSS" />
 <spring:url value="/resources/images/" var="images" />
 <c:set var="contextPath" value="${pageContext.request.contextPath}" />
 