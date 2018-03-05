<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.hmei.hibernate.entity.*"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->

<link rel="stylesheet"
	href="https://bootswatch.com/3/yeti/bootstrap.min.css">

<!-- JQuery-3.3.1 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<style>
.error {
	color: red;
}

;
.cart-badge {
	background-color: red;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/Project2/index" style="margin-right:80px">Online Shopping</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-2">
			<form:form class="navbar-form navbar-left form-inline" 
				  role="search" action="/Project2/search" method="GET" modelAttribute="searchForm">
				<div class="form-group">
					<form:select class="form-control" path="category" style="height: 35px;">
						<form:option value="Product"><spring:message code="nav.product"></spring:message> </form:option>
						<form:option value="Computer"><spring:message code="nav.computer"></spring:message></form:option>
						<form:option value="Book"><spring:message code="nav.book"></spring:message></form:option>
						<form:option value="Toy"><spring:message code="nav.toy"></spring:message></form:option>
						<form:option value="Grocery"><spring:message code="nav.grocery"></spring:message></form:option>
					</form:select>
				</div>
				<div class="form-group">
					<form:input type="text" class="form-control" size="50"
						style="height: 35px;" aria-label="..." path="keyword" />
				</div>
				<button type="submit" class="btn btn-default"
					style="height: 35px; padding: 0px 30px;">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
				</button>
			</form:form>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false"><spring:message code="nav.lang"></spring:message>
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="?language=en">EN</a></li>
						<li><a href="?language=zh">ZH</a></li>
					</ul>
				</li>
				<%
					if (session == null || session.getAttribute("customer") == null
					|| ((Customer) session.getAttribute("customer")).getEmail() == null) {
				%>
				<li><a href="/Project2/user/login"> <span
						class="glyphicon glyphicon-user" aria-hidden="true"></span> <spring:message code="nav.login"></spring:message>
				</a></li>
				<li><a href="/Project2/user/register"> <span
						class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						<spring:message code="nav.register"></spring:message>
				</a></li>
				<%
					} else {
						Customer customer = (Customer) session.getAttribute("customer");
						int cartSize = 0;
						if (customer.getCart() != null) {
							for(int i : customer.getCart().getItemList().values()){
								cartSize += i;
							}
							
						}
				%>

				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">${customer.getEmail()}
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/Project2/user/cart"><spring:message code="cart.cart"></spring:message> <span class="badge"
								style="background-color: red;" id="cartSize"><%=cartSize%></span></a></li>
						<li class="divider"></li>
						<li><a href="/Project2/user/logout"><spring:message code="dropdown.logout"></spring:message></a></li>
					</ul></li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
	</nav>
	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
		integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
		crossorigin="anonymous">
		
	</script>
</body>
</html>