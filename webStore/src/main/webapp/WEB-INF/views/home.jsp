<%@include file="master.jsp"%>

	<ct:header></ct:header>
	<ct:body>
	<div id="center" class="column">
				<div class="stuff">
				
				<form:form method="GET" action="${contextPath }/performProductSearch">
					<label> <spring:message code="product.searchBy"></spring:message> </label><br/>
					<input type="radio" name="criteriaGroup" value="name" checked="checked"> <spring:message code="product.criteria.name"></spring:message>
					<input type="radio" name="criteriaGroup" value="type.name"><spring:message code="product.criteria.type"></spring:message>
					<input type="radio" name="criteriaGroup" value="quantity"><spring:message code="product.criteria.quantity"></spring:message>
					<input type="radio" name="criteriaGroup" value="price"><spring:message code="product.criteria.price"></spring:message>
					<select name="operation">
						<option value="=">=</option>
						<option value=">">></option>
						<option value="<"><</option>
					</select><input type="text" name="criteriaValue">
					
					<input type="submit" value="<spring:message code="product.searchButton"></spring:message>">
				</form:form>
				
				<form:form id="cartForm" method="POST" action="${contextPath}/cart"  modelAttribute="products">
					 	<input type="hidden" name="productId" />
					 
					<c:forEach var="product" varStatus="status" items="${products}">
					 	<div class="item">
								<img src="${images}/${product.pictureName }" class="image_small">
								<a href="product_details?id=${product.id}" class="name">${fn:substring(product.name, 0,16)}</a>
								 <span>${product.singlePrice } ${product.currency.name} </span>
							 	<input type="button" id="${product.id }" value="Add to Cart" name="addToCart" onclick="submitter(this)">
								  
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
					</div>
					 <div class="item">
						<img src="${images}/pic2.jpg" class="image_small">
						<a href="index2.html" class="name">Name Product</a>
						<span>$850</span>
						<input type="number" min="1" max="10" maxlength="2" value="1" name="${product.quantity }">
						<input type="submit" value="Add to Cart"  onclick="location= '${contextPath}/addToChart/productId=${product.id}'">
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
					
				</form:form>
			</div>
			</div>
			<ct:left></ct:left>
			<ct:right></ct:right>
	<!-- </div> -->
	</ct:body>
	<ct:footer></ct:footer>