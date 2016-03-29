<%@include file="master.jsp"%>

	<ct:header></ct:header>
	<ct:body>
	<!-- <div id="container"> -->
		<form:form method="POST" action="${contextPath}/cart" modelAttribute="products">
			<div id="center" class="column">
				<div class="stuff">
					<c:forEach var="product" varStatus="status" items="${products}">
						<div class="item">
								<img src="${images}/${product.pictureName }" class="image_small">
								<a href="product_details?id=${product.id}" class="name">${fn:substring(product.name, 0,16)}</a>
								 <span>${product.singlePrice } ${product.currency.name} </span>
								 <input type="number" min="1" max="10" maxlength="2" value="1" name="${product.quantity }">
								 <input type="submit" value="Add to Cart"  onclick="location= '${contextPath}/addToChart'">
								 <input type="hidden" name="productId" value="${product.id}">
								<%-- <a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a> --%>
							</div>
					</c:forEach>
					<img src="${images}/title6.gif" alt="" width="537" height="23" class="pad25">
					<div class="item">
						<img src="${images}/pic1.jpg" class="image_small">
						<a href="index2.html" class="name">Name Product</a>
						<span>$250</span>
						<input type="number" min="1" max="10" maxlength="2" value="1" name="${product.quantity }">
						<input type="submit" value="Add to Cart"  onclick="location= '${contextPath}/cart'">
						<input type="hidden" name="productId" value="${product.id}">
					</div>
					 <div class="item">
						<img src="${images}/pic2.jpg" class="image_small">
						<a href="index2.html" class="name">Name Product</a>
						<span>$850</span>
						<input type="number" min="1" max="10" maxlength="2" value="1" name="${product.quantity }">
						<input type="submit" value="Add to Cart"  onclick="location= '${contextPath}/addToChart'">
						<input type="hidden" name="productId" value="${product.id}">
					</div>
					<%-- 
					<div class="item">
						<img src="${images}/pic3.jpg" class="image_small">
						<a href="index2.html" class="name">Name Product</a>
						<span>$400</span>
						<a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a>
					</div>
					<div class="item">
						<img src="${images}/pic4.jpg" class="image_small">
						<a href="index2.html" class="name">Name Product</a>
						<span>$350</span>
						<a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a>
					</div>
					<div class="item">
						<img src="${images}/pic5.jpg" class="image_small">
						<a href="index2.html" class="name">Name Product</a>
						<span>$250</span>
						<a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a>
					</div>
					<div class="item">
						<img src="${images}/pic6.jpg" class="image_small">
						<a href="index2.html" class="name">Name Product</a>
						<span>$2250</span>
						<a href="#"><img src="${images}/zoom.gif" alt="" width="53" height="19"></a><a href="#"><img src="${images}/cart.gif" alt="" width="71" height="19"></a>
					</div> --%>
					</div>
				</div>
			</form:form>
			<ct:left></ct:left>
			<ct:right></ct:right>
	<!-- </div> -->
	</ct:body>
	<ct:footer></ct:footer>