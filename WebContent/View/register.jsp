<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Shopping | Register</title>
</head>
<body>
	<spring:message code="register.title" var="registerTitle"></spring:message>
	<spring:message code="register.name" var="registerName"></spring:message>
	<spring:message code="register.email" var="registerEmail"></spring:message>
	<spring:message code="register.password" var="registerPassword"></spring:message>
	<spring:message code="register.button" var="registerButton"></spring:message>
	
	<div class="container">
		<div class="row vertical-offset-100">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">${registerTitle }</h3>
					</div>
					<div class="panel-body">
					<div id="msgArea">
					<%
					if(session.getAttribute("registerErrorMsg") != null){
					%>
					<p style="color: red; text-align: center;"><%= (String)session.getAttribute("registerErrorMsg")%></p>
					<%
					}
					%>
					</div>
						<form:form accept-charset="UTF-8" 
								   role="form" 
								   action="./registering" 
								   modelAttribute="user"
								   method="post"
								   id="registerForm">
							<fieldset>
								
								<div class="form-group">
									<form:input class="form-control" 
												placeholder="${registerName }" 
												path="name"
												type="text" 
												id="name"/>
									<form:errors path="name" cssClass="error"/>
								</div>
								
								<div class="form-group">
									<form:input class="form-control" 
												placeholder="${registerEmail }" 
												path="email"
												type="text" 
												id="email"/>
									<form:errors path="email" cssClass="error"/>
								</div>
								
								<div class="form-group">
									<form:input class="form-control" 
												placeholder="${registerPassword }"
												path="password" 
												type="password" 
												id="password"/>
									<form:errors path="password" cssClass="error"/>
								</div>
								
								<input class="btn btn-lg btn-success btn-block" type="submit"
									value="${registerButton }" id="register">
							</fieldset>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="../js/registerValidation.js"></script>
</body>
</html>