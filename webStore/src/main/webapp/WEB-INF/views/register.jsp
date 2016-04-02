<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
	<div id="center" class="column">
		<div class="content">
				<img src="/webstore/resources/images/top_bg.gif" alt="" width="100%" height="12">
				<form:form method="POST" action="${contextPath}/doRegister"  modelAttribute="customer">
					<table>
						<tr>
							<td><p class="line">Name:</p></td>
							<td><input type="text" id="name" name="name" value="${customer.name}"></td>
						</tr>
						<tr>
							<td><p class="line">Birth Date:</p></td>
							<td><input type="date" id="birthDate" name ="birthDate" value="${customer.birthDate}" style="width: 173px"></td>
						</tr>
						<tr>
							<td><p class="line">Address:</p></td>
							<td><input type="text" id="address" name="address" value="${customer.address}"></td>
						</tr>
						<tr>
							<td><p class="line">Username:</p></td>
							<td><input type="text" id="username" name = "user.username" value="${customer.user.username}"></td>
						</tr>
						<tr>
							<td><p class="line">Password:</p></td>
							<td><input type="password" id="password" name = "user.password" value="${customer.user.password}"></td>
						</tr>
						<tr>
							<td><p class="line">Repeat Password:</p></td>
							<td><input type="password" id="retypePassword"  name="retypePassword" value="${customer.user.retypePassword}"></td>
						</tr>
						
					</table>
					<input type="submit" id="btn1" name="submit" value="Register" class="button">
					<img src="/webstore/resources/images/bot_bg.gif" alt="" width="100%" height="10"><br>
				</form:form>
				
				    
				<!-- <input type="submit" class="button"> -->
				
		</div>
	</div>
	<ct:left></ct:left>
	<ct:right></ct:right>
</ct:body>
<ct:footer></ct:footer>