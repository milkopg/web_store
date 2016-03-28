<%-- <%@ taglib prefix="ct" uri="http://softuni.bg/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <spring:url value="/resources/css/style.css" var="stylesCSS" />
 <spring:url value="/resources/${images}/" var="images" />
 

<c:set var="contextPath" value="${pageContext.request.contextPath}" /> --%>
<%@include file="master.jsp"%>
<%@include file="taglibs.jsp"%>
<html>

<head>
	<link href="${stylesCSS}" rel="stylesheet" />
	<link href="${images}" rel="stylesheet" />
	<title>Web Banking Page</title>
	
</head>
<body>
<h1>
	Online store -> Products
	<ct:header></ct:header>
</h1>

<%-- <form:form method="POST" action="${contextPath}/home" modelAttribute="product">
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
--%>
	
	<div id="container">
		
		<div id="center" class="column">
			<div class="stuff">
						<div class="item">
							<img src="${images}/pic1.jpg" alt="" width="124" height="90">
							<a href="index2.html" class="name">Name Product</a>
							<span>$250</span>
							<a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a>
						</div>
						<div class="item">
							<img src="${images}/pic2.jpg" alt="" width="124" height="111">
							<a href="index2.html" class="name">Name Product</a>
							<span>$850</span>
							<a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a>
						</div>
						<div class="item">
							<img src="${images}/pic3.jpg" alt="" width="124" height="89">
							<a href="index2.html" class="name">Name Product</a>
							<span>$400</span>
							<a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a>
						</div>
						<div class="item">
							<img src="${images}/pic4.jpg" alt="" width="124" height="89">
							<a href="index2.html" class="name">Name Product</a>
							<span>$350</span>
							<a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a>
						</div>
						<div class="item">
							<img src="${images}/pic5.jpg" alt="" width="124" height="97">
							<a href="index2.html" class="name">Name Product</a>
							<span>$250</span>
							<a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a>
						</div>
						<div class="item">
							<img src="${images}/pic6.jpg" alt="" width="124" height="111">
							<a href="index2.html" class="name">Name Product</a>
							<span>$2250</span>
							<a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a>
						</div>
				</div>
			</div>
			<ct:left></ct:left>
			<ct:right></ct:right>
	</div>
<ct:footer></ct:footer>