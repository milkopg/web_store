<%@include file="master.jsp"%>
<%@include file="taglibs.jsp"%>

	<ct:header></ct:header>
	<ct:body>
	<!-- <div id="container"> -->
		<form:form method="POST" action="${contextPath}/home" modelAttribute="products">
			<div id="center" class="column">
				<div class="stuff">
					<c:forEach var="product" varStatus="status" items="${products}">
						<div class="item">
								<img src="${images}/${product.pictureName }" alt="" width="124" height="90">
								<a href="product_details?id=${product.id}" class="name">${fn:substring(product.name, 0,16)}</a>
								 <span>${product.singlePrice } ${product.currency.name} </span>
								 <input type="number" min="1" max="10" maxlength="2" value="1" name="${product.quantity }">
								 <input type="submit" value="Add to Cart"  onclick="location= '${contextPath}/addToChart'">
								 <input type="hidden" name="productId" value="${product.id}">
								<%-- <a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a> --%>
							</div>
					</c:forEach>
					</div>
				</div>
			</form:form>
			<ct:left></ct:left>
			<ct:right></ct:right>
	<!-- </div> -->
	</ct:body>
	<ct:footer></ct:footer>