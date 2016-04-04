<h1>${title}</h1>

<%@include file="../views/taglibs.jsp"%>

<div id="header">
		<a href="${contextPath}/home" class="float"><img src="${images}/logo.jpg" alt="" width="171" height="73"></a>																																																		
	  <div class="topblock1">
			Currency:<br><select><option>Bulgarian Lev</option></select>
		</div>
	    <div class="topblock2">
			Lanquage:<br>
		    <a href="#"><img src="${images}/flag1.gif" alt="" width="19" height="11"></a>																																		
		    <a href="#"><img src="${images}/flag2.gif" alt="" width="19" height="11"></a>
		    <a href="#"><img src="${images}/flag3.gif" alt="" width="19" height="11"></a>
		    <a href="#"><img src="${images}/flag4.gif" alt="" width="19" height="11"></a>
		    <a href="#"><img src="${images}/flag5.gif" alt="" width="19" height="11"></a>
		    <a href="#"><img src="${images}/flag6.gif" alt="" width="19" height="11"></a>
		</div>
		<div class="topblock2">
			<img src="${images}/shopping.gif" alt="" width="24" height="24" class="shopping">																																																																									
		 	<a href="${contextPath}/cart"><spring:message code="cart.name"></spring:message></a> <p><strong> <a href="${contextPath}/cart">${fn:length(sessionScope.order.orderDetails)} items</a></strong></p>
		</div>
		<ul id="menu">
			<li><img src="${images}/li.gif" alt="" width="19" height="29"></li>
			<li><a href="${contextPath}/home"><img src="${images}/but1_a.gif" alt="" width="90" height="29"></a></li>
			<li><a href="index2.html"><img src="${images}/but2.gif" alt="" width="129" height="29"></a></li>
			<li><a href="index2.html"><img src="${images}/but3.gif" alt="" width="127" height="29"></a></li>
			<li><a href="index2.html"><img src="${images}/but4.gif" alt="" width="113" height="29"></a></li>
			<li><a href="${contextPath }/cart"><img src="${images}/but5.gif" alt="" width="132" height="29"></a></li>
			<li><a href="index2.html"><img src="${images}/but6.gif" alt="" width="105" height="29"></a></li>
			<li><a href="index2.html"><img src="${images}/but7.gif" alt="" width="82" height="29"></a></li>
			<li><a href="index2.html"><img src="${images}/but8.gif" alt="" width="112" height="29"></a></li>
			<li><a href="index2.html"><img src="${images}/but9.gif" alt="" width="71" height="29"></a></li>
		</ul>
	</div>