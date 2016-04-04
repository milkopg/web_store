<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
	<div id="center" class="column">
		<form:form id="accountsForm" method="GET" modelAttribute="accounts">
				<table id="cartTable" border="1" class="table table-striped" >
				  <tr>
				    <th> <spring:message code="account.name"></spring:message></th>
				    <th> <spring:message code="account.birthdate"></spring:message></th> 
				    <th> <spring:message code="account.address"></spring:message></th>
				    <th> <spring:message code="account.username"></spring:message></th>
				    <th> <spring:message code="account.password"></spring:message></th>
				    <th> <spring:message code="account.edit"></spring:message></th>
				    <th> <spring:message code="account.delete"></spring:message></th>
				 </tr>
				 <c:forEach var="account" varStatus="status" items="${accounts}">
				  <tr>
				    <td>${account.name}</td>
				    <td> <fmt:formatDate pattern="YYYY-MM-DD" value="${account.birthDate}" /></td> 
				    <td>${account.address}</td>
				    <td>${account.user.username}</td>
				    <td>${account.user.password}</td>
				    <td><a href="account_edit?id=${account.id}" class="name"><spring:message code="account.link_edit"></spring:message> </a></td>
				    <td><a href="acount_delete?id=${account.id}" class="name"><spring:message code="account.link_delete"></spring:message> </a></td>
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

