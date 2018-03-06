<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" errorPage="errorPage.jsp"%>
<%@ include file="header.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Shopping | Cart</title>
</head>
<body>
	<div class="container">
		<h1>
			<spring:message code="cart.cart"></spring:message>
		</h1>
		<hr>
		<div class="cart-body">
		<c:choose>
			<c:when test="${fn:length(customer.cart.itemList) gt 0}">
			<c:set var="total" value="${0}"></c:set>
			<c:forEach items="${customer.cart.itemList }" var="item">
				<div>
					<h4>${item.key.name }</h4>
					<a
						href="/Project2/product/details/${item.key.category }/${item.key.id}">
						<img src="<c:url value="${item.key.image}"/>"
						alt="${item.key.name }" style="width: 150px;">
					</a>
					<p>
						<spring:message code="product.storage"></spring:message>
						: ${item.key.amount }
					</p>
					<p>
						<spring:message code="product.quantity"></spring:message>
						<c:choose>
							<c:when test="${item.key.amount == 0 }">
								<input type="number" class="item-amount" value="${item.value}"
									maxlength="2" max="${item.key.amount }" min="0" disabled>
							</c:when>
							<c:otherwise>
								<input type="number" class="item-amount" value="${item.value}"
									maxlength="2" max="${item.key.amount }" min="1">
							</c:otherwise>
						</c:choose>
					</p>
					<a class="update_item" href="/Project2/user/cart/${item.key.id}"><spring:message
							code="cart.update"></spring:message></a>
					<c:set var="price" value="${item.key.price*item.value}"></c:set>
					<p class="items-price-area">
						<spring:message code="product.price"></spring:message>
						: <span class="items-price"> <fmt:setLocale value="en_US" />
							<fmt:formatNumber value="${price}" type="currency"
								currencySymbol="$" />
						</span>
					</p>

					<c:set var="total" value="${total + price}" />
					<a class="rm_item" href="/Project2/user/cart/${item.key.id}"><spring:message
							code="cart.remove"></spring:message></a>
					<hr>
				</div>
			</c:forEach>
			<c:if test="${fn:length(customer.cart.itemList) gt 0}">
				<div style="text-align: right" id="checkoutArea">
					<p>
						<spring:message code="cart.total"></spring:message>
						: <span id="total-price"> <fmt:setLocale value="en_US" /> <fmt:formatNumber
								value="${total}" type="currency" currencySymbol="$" />
						</span>
					</p>
					<a id="checkout" href="/Project2/user/cart" class="btn btn-warning"><spring:message
							code="cart.checkOut"></spring:message></a>
				</div>
			</c:if>
			</c:when>
			<c:otherwise>
				<p style="color: #b2bec3; position: absolute; left: 50%; top: 50%;"><spring:message code="cart.isEmpty"></spring:message></p>
			</c:otherwise>
		</c:choose>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/js/cartAlert.js"></script>
</body>
</html>