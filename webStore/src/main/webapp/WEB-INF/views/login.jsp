<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
		<div id="center" class="column">
		  	<div id="content">
		  	<h2 id="header2"> Shopping cart details</h2>
		  	<form:form method="POST" action="${contextPath}/doLogin" modelAttribute="customer">
		  		<table>
		  			<tr>
		  				<td><p class="line">Login:</td>
		  				<td><p class="line"><span><input type="text" id="username" name="username" value="${customer.user.username }"></span> </p></td>
		  			</tr>
		  			<tr>
		  				<td><p class="line"><span>Password:</span></td>
		  				<td><p class="line"><span><input type="password" id="password" name="password" value="${customer.user.password }"></span> </p></td>
		  			</tr>
		  			<tr>
		  				<td><input type="submit" id="btn1" name="submit" value="Login" class="button"></td>
		  			</tr>
		  			
		  			<tr>
		  				<td><a href="${contextPath }/register" class="reg">Registration</a></td>
		  				<td><a href="#" class="reg">Forgot password?</a></td>
		  			</tr>
		  		</table>
		  	</form:form>
			</div>
			
		</div>
	<ct:left></ct:left>
	<ct:right></ct:right>
</ct:body>
<ct:footer></ct:footer>