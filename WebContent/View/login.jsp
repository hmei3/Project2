<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Shopping | Login</title>
</head>
<body>
	<div class="container">
		<p style="text-align: center; color: red;">${loginErrorMsg}</p>
		<c:remove var="loginErrorMsg" scope="session"/>
		<div class="row vertical-offset-100">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"><spring:message code="login.title"></spring:message> </h3>
					</div>
					<div class="panel-body">
					<div id="msgArea">
					<%
					if(session.getAttribute("loginErrorMsg") != null){
					%>
					<p style="color: red; text-align: center;"><%= (String)session.getAttribute("loginErrorMsg")%></p>
					<%
					}
					%>
					</div>
					<spring:message code="login.email" var="loginEmail"></spring:message>
					<spring:message code="login.password" var="loginPassword"></spring:message>
						<form:form accept-charset="UTF-8" 
								   role="form" 
								   action="./logging-in" 
								   modelAttribute="user"
								   method="post"
								   id="loginForm">
							<fieldset>
								<div class="form-group">
									<form:input id="email" class="form-control" placeholder="${loginEmail}" path="email"
										type="text" />
									<form:errors path="email" cssClass="error"/>
								</div>
								<div class="form-group">
									<form:input id="password" class="form-control" placeholder="${loginPassword}"
										path="password" type="password" />
									<form:errors path="password" cssClass="error"/>
								</div>
								<br>
								<spring:message code="login.button" var="loginButton"></spring:message>
								<input id="login" class="btn btn-lg btn-success btn-block" type="submit"
									value="${loginButton}">
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="../js/loginValidation.js"></script>
</body>
</html>