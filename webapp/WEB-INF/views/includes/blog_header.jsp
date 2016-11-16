      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div id="header">
				<h1><a href="${pageContext.request.contextPath }/${authUser.id }">${blogVo.blogTitle }</a></h1>
			<ul>
			<c:choose>
				<c:when test="${empty authUser }">
				<li><a href="${pageContext.request.contextPath }/user/loginform">로그인</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="${pageContext.request.contextPath }/user/logout">로그아웃</a></li>
				<c:if test="${authUser.id == userId }">
				<li><a href="${pageContext.request.contextPath }/${authUser.id }/admin/basic/modify">블로그 관리</a></li>
				</c:if>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>