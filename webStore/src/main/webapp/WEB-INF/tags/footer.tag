<%@ attribute name="version"%>
<%@ attribute name="project_name"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <spring:url value="/resources/css/style.css" var="stylesCSS" />

<%@include file="../views/taglibs.jsp"%>
<div>
	Project Name: <label>${project_name}</label>
</div>
<div>
	Version: <label>${version}</label>
</div>
