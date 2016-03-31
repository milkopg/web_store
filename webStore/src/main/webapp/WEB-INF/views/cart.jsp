<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
	<form:form method="POST" modelAttribute="order">
		<div id="center" class="column">
				<c:forEach var="o" varStatus="status" items="${order.orderDetails}">
					<table border="1" class="table table-striped" >
					  <tr>
					    <th> <spring:message code="orderdetails.product.name"></spring:message></th>
					    <th> <spring:message code="orderdetails.product.description"></spring:message></th> 
					    <th> <spring:message code="orderdetails.product.quantity"></spring:message></th>
					    <th> <spring:message code="orderdetails.product.price"></spring:message></th>
					  </tr>
					  <tr>
					    <td>${o.product.name} </td>
					    <td>${o.product.description}</td> 
					    <td>${o.product.quantity}</td>
					    <td>${o.product.singlePrice}</td>
					  </tr>
					</table>
				</c:forEach>
					<div class="item">
						<p class="line"> Shopping cart </p>
						<p class="line"><span>Login:</span> <input type="text"></p>
						<p class="line"><span>Password:</span> <input type="text"></p>
						<p class="line center"><a href="#" class="reg">Registration</a> | <a href="#" class="reg">Forgot password?</a></p>
						<p class="line center pad20"><a href="#"><img src="${images}/enter.gif" alt="" width="69" height="25"></a></p>
					</div>
		</div>
	</form:form>	
	<ct:left></ct:left>
	<ct:right></ct:right>
</ct:body>
<ct:footer></ct:footer>