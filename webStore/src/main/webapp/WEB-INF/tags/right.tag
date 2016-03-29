<%@include file="../views/taglibs.jsp"%>
<div id="right" class="column">
	  	<a href="#"><img src="${images}/banner2.jpg" alt="" width="237" height="216"></a><br>
		<div class="rightblock">
			<img src="${images}/title4.gif" alt="" width="223" height="29"><br>
			<div id="login_user" class="blocks">
				<img src="${images}/top_bg.gif" alt="" width="218" height="12">
				<form:form action="${contextPath}/login" method="POST" modelAttribute="user">
					<p class="line"><span>Login:</span> <input type="text"></p>
					<p class="line"><span>Password:</span> <input type="text"></p>
					<p class="line center"><a href="#" class="reg">Registration</a> | <a href="#" class="reg">Forgot password?</a></p>
					<p class="line center pad20"><a href="#"><img src="${images}/enter.gif" alt="" width="69" height="25"></a></p>
				</form:form>
				
				<img src="${images}/bot_bg.gif" alt="" width="218" height="10"><br>
			</div>
			<div id="register_user" class="blocks">
				<img src="${images}/top_bg.gif" alt="" width="218" height="12">
				<form:form action="${contextPath}/registerUser" method="POST" modelAttribute="customer">
					<p class="line"><span>Name:</span> <input type="text" name="customer.name"></p>
					<p class="line"><span>Birth Date:</span> <input type="date" name="customer.birthDate"></p>
					<p class="line"><span>Address:</span> <input type="text" name="customer.address"></p>
					<p class="line"><span>Username:</span> <input type="text" name="customer.user.username"></p>
					<p class="line"><span>Password:</span> <input type="password" name="customer.user.password"></p>
					<p class="line"><span>Password:</span> <input type="password" name="customer.user.retypePassword"></p>
					<!-- <p class="line center"><a href="#" class="reg">Registration</a> | <a href="#" class="reg">Forgot password?</a></p> -->
					<%-- <p class="line center pad20"><a href="#"><img src="${images}/enter.gif" alt="" width="69" height="25"></a></p> --%>
					
					<input type="submit" value="Register" class="button">
					<img src="${images}/bot_bg.gif" alt="" width="218" height="10"><br>
				</form:form>
				
				    
				<!-- <input type="submit" class="button"> -->
				<%-- <img src="${images}/enter.gif" alt="" width="218" height="10"><br> --%>
			</div>
			<div class="blocks">
				<img src="${images}/top_bg.gif" alt="" width="218" height="12">
				<div id="news">
					<img src="${images}/title5.gif" alt="" width="201" height="28">
					<span class="date">23 november</span>
					<p>Dolor sit amet, consetetur sadipscing elitr, seddiam nonumy eirmod tempor. invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.</p>
					<a href="#" class="more">read more</a>
				</div>
				<img src="${images}/bot_bg.gif" alt="" width="218" height="10"><br>
			</div>
		</div>
	  </div>