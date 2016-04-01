<%@include file="master.jsp"%>
<ct:header></ct:header>
<ct:body>
		<div id="center" class="column">
		  	<div id="content">
		  	<h2 id="header2"> Shopping cart details</h2>
		  	<form:form method="POST" action="${contextPath}/performLogin" modelAttribute="user">
		  		<table>
		  			<tr>
		  				<td><p class="line">Login:</td>
		  				<td><p class="line"><span><input type="text"></span> </p></td>
		  			</tr>
		  			<tr>
		  				<td><p class="line"><span>Password:</span></td>
		  				<td><p class="line"><span><input type="text"></span> </p></td>
		  			</tr>
		  			<tr>
		  				<td><p><a href="#"><img src="${images}/enter.gif" alt="" width="69" height="25"></a></p></td>
		  			</tr>
		  			<tr>
		  				<td><a href="${contextPath }/register" class="reg">Registration</a></td>
		  				<td><a href="#" class="reg">Forgot password?</a></td>
		  			</tr>
		  		</table>
		  	</form:form>
		  		<%-- </table>
		  			<tr>
		  				<td><p class="line"><span>Password:</span></td>
		  				<td><p class="line"><span><input type="text"></span> </p></td>
		  			</tr>
		  			
		  			<tr>
		  				<td><p><a href="#"><img src="${images}/enter.gif" alt="" width="69" height="25"></a></p></td>
		  			</tr>
		  			<tr>
		  				<td><p class="line center"><a href="${contextPath }/register" class="reg">Registration</a></p></td>
		  				<td><p><a href="#" class="reg">Forgot password?</a></p></td>
		  			</tr>
		  		</table> --%>
				<!-- <p class="line"> Shopping cart </p>
				<div><p class="line"><span>Login:</span> <input type="text"></p></div>
				<div><p class="line"><span>Password:</span> <input type="text"></p></div> -->
			
				<%-- <p class="line center"><a href="${contextPath }/register" class="reg">Registration</a> | <a href="#" class="reg">Forgot password?</a></p>
				<a href="#"><img src="${images}/enter.gif" alt="" width="69" height="25"></a>
				<p class="line center pad20"><a href="#"><img src="${images}/enter.gif" alt="" width="69" height="25"></a></p> --%>
			</div>
			
		</div>
	<ct:left></ct:left>
	<ct:right></ct:right>
</ct:body>
<ct:footer></ct:footer>