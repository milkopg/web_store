<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
	<div id="center" class="column">
		<form:form id="editProductForm" method="POST" modelAttribute="orders">
			<p><form:errors/></p>
			<spring:hasBindErrors name="orders">
	            <c:forEach items="${errors.globalErrors}" var="errorMessage">
	                <div id="errors" class="errors">
	                        <c:out value="${errorMessage.defaultMessage}" />
	                </div>
	            </c:forEach>
    		</spring:hasBindErrors>
    		
    		<c:if test="${not empty msg}">
			    <div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" 
	                                aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			    </div>
			</c:if>
    		
			<input type="hidden" name="orderId" />
			<input type="hidden" name="rowIndex" />
				<table id="orderTable" border="1" class="table table-striped" >
				  <tr>
				    <th> <spring:message code="order.id"></spring:message></th>
				    <th> <spring:message code="order.customer.name"></spring:message></th> 
				    <th> <spring:message code="order.ordertype.name"></spring:message></th>
				    <th> <spring:message code="order.totalPrice"></spring:message></th>
				    <th> <spring:message code="order.totalQuantity"></spring:message></th>
				    <th> <spring:message code="order.purchaseDate"></spring:message></th>
				    <th> <spring:message code="order.comment"></spring:message></th>
				    <th> <spring:message code="order.refund"></spring:message></th>
				 </tr>
				 <c:forEach var="order" varStatus="status" items="${orders}">
				  <tr>
				    <td>${order.id}</td> 
				    <td>${order.customer.name}</td> 
				    <td>${order.orderType.name}</td>
				    <td>${order.totalPrice}</td>
				    <td>${order.totalQuantity}</td>
				    <td>${order.purchaseDate}</td>
				    <td>${order.comment}</td>
				    <td><a href="order_refund?id=${order.id}" class="name"><spring:message code="order.refund"></spring:message> </a></td>
			     	<%-- <td onclick="submitter(this)"><input type="submit" name="edit" value="<spring:message code="product.edit"/>" class="btn-link"></td>
			     	<td onclick="submitter(this)"><input type="submit" name="delete" value="<spring:message code="product.delete"/>" class="btn-link"></td> --%>
				  </tr>
				  </c:forEach>
				</table>
				
				<br>
		</form:form>
	</div>
	<ct:left></ct:left>
	<ct:right></ct:right>
</ct:body>
<ct:footer></ct:footer>

