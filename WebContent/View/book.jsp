<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Shopping | Book</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<a href="#" class="thumbnail" style="margin-top: 70px;"> 
					<img src="<c:url value="${product.image}"/>" 
						 alt="${product.name }"
						 style="width: 100%; padding: 5px;">
				</a>
				<c:choose>
					<c:when test="${product.amount == 0 }">
						<p style="color: red; text-align:center;"><spring:message code="product.outOfStorage"></spring:message></p>
					</c:when>
					<c:otherwise>
						<p style="text-align:center;"><spring:message code="product.storage"></spring:message>: ${product.amount}</p>
					</c:otherwise>
				</c:choose>
			</div>
			
			<div class="col-md-9">
				<h3>${product.name }</h3>
				

				<p>by 
				<c:forEach items="${product.authors}" var="author" varStatus="loopStatus">
				${author.name}<c:if test="${!loopStatus.last}">, </c:if>
				</c:forEach></p>

				<hr>
				<h4><spring:message code="product.desc"></spring:message>:</h4>
				<p>${product.description }</p>
				<hr>
				<div>
					<p style="float: left"><spring:message code="product.price"></spring:message>:
					<fmt:setLocale value = "en_US"/>
					<fmt:formatNumber value = "${product.price}" type = "currency" currencySymbol="$"/></p>
					<form method="post" action="/Project2/user/cart/${product.id}">
						<div class="form-group" style="float: right;">
							<label style="padding-right: 10px;"><spring:message code="product.quantity"></spring:message> </label>
							<select name="amount">
								<c:choose>
									<c:when test="${product.amount >=5}">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
										<option value="5">5</option>
									</c:when>
									<c:otherwise>
										<c:forEach var="i" begin="1" end="${product.amount }">
											<option value="${i }">${i }</option>
										</c:forEach>
									</c:otherwise>
								</c:choose>
							</select>
						</div>
						<br>
						<br>
						
						<button style="float: right; padding: 10px 20px;" 
								class="btn btn-primary"
								type="submit"
								${product.amount == 0 ? 'disabled' : '' }><spring:message code="product.addToCart"></spring:message></button>
					</form>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>