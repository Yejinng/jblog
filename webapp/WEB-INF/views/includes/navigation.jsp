<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div id="navigation">
	<ul>
		<c:choose>
			<c:when test="${param.menu == 'main' }">
				<li class="selected"><a href="${pageContext.request.contextPath }">MAIN</a></li>
				<li><a href="${pageContext.request.contextPath }/guestbook">GUESTBOOK</a></li>
				<li><a href="${pageContext.request.contextPath }/guestbook/ajax">GUESTBOOK AJAX</a></li>
				<li><a href="${pageContext.request.contextPath }/gallery">GALLERY</a></li>
				<li><a href="${pageContext.request.contextPath }/board">BOARD</a></li>
			</c:when>
			<c:when test="${param.menu == 'guestbook' }">
				<li><a href="${pageContext.request.contextPath }">MAIN</a></li>
				<li class="selected"><a href="${pageContext.request.contextPath }/guestbook">GUESTBOOK</a></li>
				<li><a href="${pageContext.request.contextPath }/guestbook/ajax">GUESTBOOK AJAX</a></li>
				<li><a href="${pageContext.request.contextPath }/gallery">GALLERY</a></li>
				<li><a href="${pageContext.request.contextPath }/board">BOARD</a></li>
			</c:when>
			<c:when test="${param.menu == 'guestbook-ajax' }">
				<li><a href="${pageContext.request.contextPath }">MAIN</a></li>
				<li><a href="${pageContext.request.contextPath }/guestbook">GUESTBOOK</a></li>
				<li class="selected"><a href="${pageContext.request.contextPath }/guestbook/ajax">GUESTBOOK AJAX</a></li>
				<li><a href="${pageContext.request.contextPath }/gallery">GALLERY</a></li>
				<li><a href="${pageContext.request.contextPath }/board">BOARD</a></li>
			</c:when>
			<c:when test="${param.menu == 'gallery' }">
				<li><a href="${pageContext.request.contextPath }">MAIN</a></li>
				<li><a href="${pageContext.request.contextPath }/guestbook">GUESTBOOK</a></li>
				<li><a href="${pageContext.request.contextPath }/guestbook/ajax">GUESTBOOK AJAX</a></li>
				<li class="selected"><a href="${pageContext.request.contextPath }/gallery">GALLERY</a></li>
				<li><a href="${pageContext.request.contextPath }/board">BOARD</a></li>
			</c:when>
			<c:when test="${param.menu == 'board' }">
				<li><a href="${pageContext.request.contextPath }">MAIN</a></li>
				<li><a href="${pageContext.request.contextPath }/guestbook">GUESTBOOK</a></li>
				<li><a href="${pageContext.request.contextPath }/guestbook/ajax">GUESTBOOK AJAX</a></li>
				<li><a href="${pageContext.request.contextPath }/gallery">GALLERY</a></li>
				<li class="selected"><a href="${pageContext.request.contextPath }/board">BOARD</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath }">MAIN</a></li>
				<li><a href="${pageContext.request.contextPath }/guestbook">GUESTBOOK</a></li>
				<li><a href="${pageContext.request.contextPath }/guestbook/ajax">GUESTBOOK AJAX</a></li>
				<li><a href="${pageContext.request.contextPath }/gallery">GALLERY</a></li>
				<li><a href="${pageContext.request.contextPath }/board">BOARD</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>