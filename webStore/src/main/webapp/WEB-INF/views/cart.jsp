<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
	<form:form>
		<div id="center" class="column">
				<%-- <c:forEach var="o" varStatus="status" items="${order}"> --%>
					<table border="1" id="cart_table" width="400px">
					  <tr>
					    <th>Product</th>
					    <th>Description</th> 
					    <th>Quantity</th>
					    <th>Price</th>
					  </tr>
					  <tr>
					    <td>Eve</td>
					    <td>Jackson</td> 
					    <td>94</td>
					    <td>94</td>
					  </tr>
					</table>
				<%-- </c:forEach> --%>
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