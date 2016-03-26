<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <spring:url value="/resources/styles.css" var="stylesCSS" />


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
	<link href="${stylesCSS}" rel="stylesheet" />
	<title>Web Banking Page</title>
	
</head>
<body>
<h1>
	Online store -> Products
</h1>

<form:form method="POST" action="${contextPath}/home" modelAttribute="product">
	<table>
		<tr>
			<td>
				 <c:forEach  var="error" varStatus="errorStatus" items="${account.errors}">
					<p><c:out value="${error}"></c:out></p>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>Name</td>
			<td><c:out value="${product.name}"></c:out></td>
		</tr>
		<tr>
			<td>Product Type</td>
			<td><c:out value="${product.type.name}"></c:out></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><c:out value="${product.singlePrice}"></c:out></td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td><c:out value="${product.quantity}"></c:out></td>
		</tr>
	</table>
	<!-- <input type="submit" id = "btn1" name="Submit" value="Submit"> -->
	
</form:form>
	<input type="submit" onclick="location= '${contextPath}/operation'" value="Operation">
	<input type="button" onclick="location= '${contextPath}/logout'" value="Logout">
	
