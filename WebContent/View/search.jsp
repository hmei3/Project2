<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online Shopping | Search</title>
</head>
<body>
	<div class="container">

		<div class="row">
			<c:forEach items="${result }" var="item">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="/Project2/product/details/${item.category}/${item.id}"
							style="display: block"> 
							<img src="<c:url value="${item.image}"/>" 
								 alt="${item.name }"
								 style="width: 100%; padding: 5px;">
						</a>
							<div class="caption" style="text-align: center;">
								<h4 style="margin-top: 0px">${item.name }</h4>
								<p style="margin-bottom: 0;">
								<fmt:setLocale value = "en_US"/>
								<fmt:formatNumber value = "${item.price}" type = "currency" currencySymbol="$"/>
								</p>
							</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<c:choose>
			
			<c:when  test="${pages== 1}">
			</c:when>
			
			<c:otherwise>
				<div class="text-center" style="position: absolute; bottom: 0; left: 0; right: 0;">
					<ul class="pagination">
						<li ${curPage == 1? 'class="disabled"' : ''}><a href="/Project2/search/page/1">&laquo;</a></li>
						<c:forEach var="i" begin="1" end="${pages}">
						<li ${curPage == i? 'class="active"' : ''}><a href="/Project2/search/page/${i }">${i}</a></li>
						</c:forEach>
						<li ${curPage == pages? 'class="disabled"' : ''}><a href="/Project2/search/page/${pages}">&raquo;</a></li>
					</ul>
				</div>
			</c:otherwise>
		
		</c:choose>
	</div>
</body>
</html>