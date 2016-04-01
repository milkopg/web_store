<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
	<div id="center" class="column">
		<form:form id="cartForm" method="POST" modelAttribute="order" action="${contextPath}/processOrDelete">
			<input type="hidden" name="productId" />
			<input type="hidden" name="rowIndex" />
				<table id="cartTable" border="1" class="table table-striped" >
				  <tr>
				    <th> <spring:message code="orderdetails.product.name"></spring:message></th>
				    <th> <spring:message code="orderdetails.product.description"></spring:message></th> 
				    <th> <spring:message code="orderdetails.product.quantity"></spring:message></th>
				    <th> <spring:message code="orderdetails.product.price"></spring:message></th>
				    <th> <spring:message code="orderdetails.product.delete"></spring:message></th>
				 </tr>
					
				<c:forEach var="o" varStatus="status" items="${order.orderDetails}">
					  <tr>
					    <td>${fn:substring(o.product.name, 0,25)}</td>
					    <td>${fn:substring(o.product.description, 0,50)}</td> 
					    <td>${o.quantity}</td>
					    <td>${o.product.singlePrice}</td>
					    <%-- <td><a href="${contextPath}/removeProduct/${o.product.id}" onclick="submitter(this)"><spring:message code="orderdetails.product.delete"/></a></td> --%>
					     <td onclick="submitter(this)"><input type="submit" value="<spring:message code="orderdetails.product.delete"/>" class="btn-link"></td>
					    <%-- <td> <input type="checkbox" name="${o.deleted}" id="deleted" value="${order.orderDetails[status]}"> </td> --%>
					  </tr>
				</c:forEach>
				</table>
				<br>
						
			<input type="button" value='<spring:message code="orderdetails.product.continue"></spring:message>' name="continue" onclick="location='${contextPath}/home'">
			<input type="button" value='<spring:message code="orderdetails.cart.process"></spring:message>' name="process" onclick="location='${contextPath}/login'">	
			
		</form:form>
	</div>
	<ct:left></ct:left>
	<ct:right></ct:right>
</ct:body>
<ct:footer></ct:footer>

