<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
	<div id="center" class="column">
		<form:form method="POST" modelAttribute="order" action="${contextPath}/processOrDelete">
				<table border="1" class="table table-striped" >
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
					    <td><a href="${contextPath}/removeProduct/${o.product.id}"><spring:message code="orderdetails.product.delete"/></a></td>
					    <td><input type="hidden" name="productId${status}" value="${o.product.id}" /></td>
					    <%-- <td> <input type="checkbox" name="${o.deleted}" id="deleted" value="${order.orderDetails[status]}"> </td> --%>
					  </tr>
				</c:forEach>
				</table>
				<br>
						<div class="item">
						<p class="line"> Shopping cart </p>
						<p class="line"><span>Login:</span> <input type="text"></p>
						<p class="line"><span>Password:</span> <input type="text"></p>
						<p class="line center"><a href="#" class="reg">Registration</a> | <a href="#" class="reg">Forgot password?</a></p>
						<p class="line center pad20"><a href="#"><img src="${images}/enter.gif" alt="" width="69" height="25"></a></p>
						
					</div>
			<input type="submit" value='<spring:message code="orderdetails.product.delete"></spring:message>' name="deleteRow">
			<input type="submit" value='<spring:message code="orderdetails.cart.process"></spring:message>' name="process">	
			
		</form:form>
		<%-- 	<input type="submit" value='<spring:message code="orderdetails.product.delete"></spring:message>' name="processOrDelete" onclick="location= '${contextPath}/processOrDelete' ">
		<input type="submit" value='<spring:message code="orderdetails.cart.process"></spring:message>' name="processOrDelete" onclick="location= '${contextPath}/processOrDelete' "> --%>	
	</div>
	
				
		
	<ct:left></ct:left>
	<ct:right></ct:right>
</ct:body>
<ct:footer></ct:footer>