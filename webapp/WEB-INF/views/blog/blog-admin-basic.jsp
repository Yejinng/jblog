<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JBlog</title>
<Link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/blog_header.jsp"></c:import>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li class="selected"><a href="${pageContext.request.contextPath }/${authUser.id }/admin/basic/modify">기본설정</a></li>
					<li><a href="${pageContext.request.contextPath }/${authUser.id }/admin/category">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath }/${authUser.id }/admin/write">글작성</a></li>
				</ul>
				<form id="admin_basic" method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/admin/basic">
				<input type="hidden" name="logo" value="${blogVo.blogLogo }"/>
	 		      	<table class="admin-config">
			      		<tr>
			      			<td class="t">블로그 제목</td>
			      			<td><input type="text" size="40" name="title" value="${blogVo.blogTitle }"></td>
			      		</tr>
			      		<tr>
			      			<td class="t">로고이미지</td>
			      			<c:choose>
			      				<c:when test="${blogVo.blogLogo == 'default' }">
					      			<td><img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg"></td>      			
			      				</c:when>
			      				<c:otherwise>
			      					<td><img src="${pageContext.request.contextPath}/assets/logo/${blogVo.blogLogo }"></td>      			
			      				</c:otherwise>
			      			</c:choose>
			      		</tr>      		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td><input type="file" name="logo-file"></td>      			
			      		</tr>           		
			      		<tr>
			      			<td class="t">&nbsp;</td>
			      			<td class="s"><input type="submit" value="설정 변경">&nbsp;&nbsp;      			
			      			<%-- <button onclick="window.location='${pageContext.request.contextPath}/${authUser.id }';" >메인으로</button>   --%>			
			      			</td>
			      		</tr>   
			      	</table>
				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/blog_footer.jsp"></c:import>
	</div>
</body>
</html>