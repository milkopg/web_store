<%@include file="../views/taglibs.jsp"%>
<div id="left" class="column">
	  	<div class="block">
		<img src="${images}/title1.gif" alt="" width="168" height="42"><br>
			<ul id="navigation">
				<form:form method="GET" modelAttribute="products">
					<c:forEach var="type" varStatus="status" items="${types }">
						<c:choose>
							<c:when test="${status.index % 2 == 0 }">
								<li class="color"><a href="${contextPath}/performProductSearch?productTypeId=${type.id}">${type.name}</a></li>	
							</c:when>
							<c:otherwise>
								<li><a href="${contextPath}/performProductSearch/productTypeId=${type.id}">${type.name}</a></li>	
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</form:form>
			</ul>
		</div>
		<a href="#"><img src="${images}/banner1.jpg" alt="" width="172" height="200"></a>
	  </div>
