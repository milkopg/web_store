<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
	<div id="center" class="column">
		<div class="content">
				<img src="/webstore/resources/images/top_bg.gif" alt="" width="100%" height="12">
				<form:form id="userForm" method="POST" action="${contextPath}/doRegister"  modelAttribute="customer">
					<input type="hidden" id="id" name="id" value="${customer.id}">
					<c:choose>
						<c:when test="${customer.id > 0}">
							<input type="hidden" id="userId" name="user.id" value="${customer.user.id}">
						</c:when>
					</c:choose>
					
					<table>
						<tr>
							<td><p class="line">Name:</p></td>
							<td><input type="text" id="name" name="name" value="${customer.name}"></td>
							<td><font color="red"><form:errors path="name"></form:errors></font><br/></td>
						</tr>
						<tr>
							<td><p class="line">Birth Date:</p></td>
							<td><input type="date" id="birthDate" name ="birthDate" value="<fmt:formatDate pattern="yyyy-mm-dd" value="${account.birthDate}" />" style="width: 173px"></td>
							<td><font color="red"><form:errors path="birthDate"></form:errors></font><br/></td>
						</tr>
						<tr>
							<td><p class="line">Address:</p></td>
							<td><input type="text" id="address" name="address" value="${customer.address}"></td>
							<td><font color="red"><form:errors path="address"></form:errors></font><br/></td>
						</tr>
						<tr>
							<td><p class="line">Username:</p></td>
							<td><input type="text" id="username" name = "user.username" value="${customer.user.username}"></td>
							<td><font color="red"><form:errors path="user.username"></form:errors></font><br/></td>
						</tr>
						<tr>
							<td><p class="line">Password:</p></td>
							<td><input type="password" id="password" name = "user.password" value="${customer.user.password}"></td>
							<td><font color="red"><form:errors path="user.password"></form:errors></font><br/></td>
						</tr>
						<c:if test="${customer.id==0}">
							<tr>
								<td><p class="line">Repeat Password:</p></td>
								<td><input type="password" id="retypePassword"  name="retypePassword" value="${customer.user.retypePassword}"></td>
								<td><font color="red"><form:errors path="user.password"></form:errors></font><br/></td>
							</tr>
						</c:if>
						
						
					</table>
				<c:choose>
					<c:when test="${customer.id == 0}">
						<input type="submit" class="name" value='<spring:message code="account.register"></spring:message>'>
					</c:when>
					<c:otherwise>
						<input type="submit" class="name"  value='<spring:message code="account.edit"></spring:message>'>
					</c:otherwise>
				</c:choose>
					<img src="/webstore/resources/images/bot_bg.gif" alt="" width="100%" height="10"><br>
				</form:form>
				
				    
				<!-- <input type="submit" class="button"> -->
				
		</div>
	</div>
	<ct:left></ct:left>
	<ct:right></ct:right>
</ct:body>
<ct:footer></ct:footer>