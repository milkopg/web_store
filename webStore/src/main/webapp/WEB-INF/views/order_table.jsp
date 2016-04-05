<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
	<div id="center" class="column">
		<form:form id="editProductForm" method="POST" modelAttribute="orders">
			<input type="hidden" name="orderId" />
			<input type="hidden" name="rowIndex" />
				<table id="orderTable" border="1" class="table table-striped" >
				  <tr>
				    <th> <spring:message code="product.name"></spring:message></th>
				    <th> <spring:message code="product.description"></spring:message></th> 
				    <th> <spring:message code="product.quantity"></spring:message></th>
				    <th> <spring:message code="product.price"></spring:message></th>
				    <th> <spring:message code="product.edit"></spring:message></th>
				    <th> <spring:message code="product.delete"></spring:message></th>
				 </tr>
				 <c:forEach var="product" varStatus="status" items="${products}">
				  <tr>
				    <%-- <td> <input type="text" name="name" value="${product.name }"></td>
				    <td> <input type="text" name="description" value="${product.description}"></td> 
				    <td> <input type="text" name="quantity" value="${product.quantity}"></td>
				    <td> <input type="text" name="singlePrice" value="${product.singlePrice}"> </td> --%>
				    <td>${fn:substring(product.name, 0,25)}</td>
				    <td>${fn:substring(product.description, 0,50)}</td> 
				    <td>${product.quantity}</td>
				    <td>${product.singlePrice}</td>
				    <td><a href="product_edit?id=${product.id}" class="name"><spring:message code="product.edit"></spring:message> </a></td>
				    <td><a href="product_delete?id=${product.id}" class="name"><spring:message code="product.delete"></spring:message> </a></td>
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

