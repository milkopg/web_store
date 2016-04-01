<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
	<div id="center" class="column">
		<div class="content">
				<img src="/webstore/resources/images/top_bg.gif" alt="" width="100%" height="12">
				<form:form id="customerForm" action="${contextPath}/performRegister" method="POST">
					<table>
						<tr>
							<td><p class="line">Name:</p></td>
							<td><input type="text" name="customer.name"></td>
						</tr>
						<tr>
							<td><p class="line">Birth Date:</p></td>
							<td><input type="date" name="customer.birthDate" style="width: 173px"></td>
						</tr>
						<tr>
							<td><p class="line">Address:</p></td>
							<td><input type="text" name="customer.address"></td>
						</tr>
						<tr>
							<td><p class="line">Username:</p></td>
							<td><input type="text" name="customer.user.username"></td>
						</tr>
						<tr>
							<td><p class="line">Password:</p></td>
							<td><input type="password" name="customer.user.password"></td>
						</tr>
						<tr>
							<td><p class="line">Repeat Password:</p></td>
							<td><input type="password" name="customer.user.retypePassword"></td>
						</tr>
						
					</table>
					<!-- <p class="line"><span>Name:</span> <input type="text" name="customer.name"></p>
					<p class="line"><span>Birth Date:</span> <input type="date" name="customer.birthDate"></p>
					<p class="line"><span>Address:</span> <input type="text" name="customer.address"></p>
					<p class="line"><span>Username:</span> <input type="text" name="customer.user.username"></p>
					<p class="line"><span>Password:</span> <input type="password" name="customer.user.password"></p>
					<p class="line"><span>Password:</span> <input type="password" name="customer.user.retypePassword"></p> -->
					<!-- <p class="line center"><a href="#" class="reg">Registration</a> | <a href="#" class="reg">Forgot password?</a></p> -->
					
					
					<input type="submit" value="Register" class="button">
					<img src="/webstore/resources/images/bot_bg.gif" alt="" width="100%" height="10"><br>
				</form:form>
				
				    
				<!-- <input type="submit" class="button"> -->
				
		</div>
	</div>
	<ct:left></ct:left>
	<ct:right></ct:right>
</ct:body>
<ct:footer></ct:footer>