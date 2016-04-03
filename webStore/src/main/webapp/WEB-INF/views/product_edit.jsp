<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
	<div id="center" class="column">
		<form:form id="editProductForm" method="POST" modelAttribute="product" action="${contextPath}/do_product_edit">
			<input type="hidden" name="productId" value="${product.id}"/>
				<table id="cartTable" border="1" style="width: 95%">
				  <tr>
				    <td> <spring:message code="product.name"></spring:message></td>
				     <td><input type="text" name = "name" value="${product.name}" style="width: 100%"></td>
				  </tr>
				  <tr>
				    <td> <spring:message code="product.picture"></spring:message></td>
					<td><img alt="" src="${images}/${product.pictureName}"></td>
				</tr>
				  <tr>
				  	  <td> <spring:message code="product.description"></spring:message></td>
				  	  <td><input type="text" name = "description" value="${product.description}" style="width: 100%"></td> 
				  <tr>
				  <tr>
				  	  <td> <spring:message code="product.type"></spring:message></td>
 			  	   	  <td><input type="text" id="product.type" name = "product.type" value="${product.type.name}" style="width: 100%"></td>
				  <tr>
				  <tr>
				  	<td> <spring:message code="product.quantity"></spring:message></td>
				  	<td><input type="text" name = "quantity" value="${product.quantity}" style="width: 100%"></td>
				  </tr>
				  <tr>
				  	<td> <spring:message code="product.price"></spring:message></td>
				  	<td><input type="text" name = "singlePrice" value="${product.singlePrice}" style="width: 100%"></td>
				  </tr>
				  <tr>
				  	<td> <spring:message code="product.currency"></spring:message></td>
				  	<td> <select id="product.currency" name="product.currency"><option value="lev">${product.currency.name }</option></select></td>
				  </tr>
				  <tr>
				    <td> <spring:message code="product.delete"></spring:message></td>
				    <td><input type="checkbox" name="delete" id="delete"></td>
				 </tr>
				 <tr>
				    <td> <spring:message code="product.active"></spring:message></td>
				    <td><input type="checkbox" name="active" id="active"></td>
				 </tr>
				</table>
				<input type="submit" value=" <spring:message code="product.update"></spring:message>">
				
				<br>
		</form:form>
	</div>
	<ct:left></ct:left>
	<ct:right></ct:right>
</ct:body>
<ct:footer></ct:footer>

