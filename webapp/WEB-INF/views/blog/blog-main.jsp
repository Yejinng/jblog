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
			<div id="content">
				<div class="blog-content">
				<c:choose>
					<c:when test="${empty postVo }">
					<h4>${postList[0].postTitle}</h4>
					<p>
					${postList[0].postContent }
					</p>
					</c:when>
					<c:otherwise>
					<h4>${postVo.postTitle}</h4>
					<p>
					${postVo.postContent }
					</p>
					</c:otherwise>
				</c:choose>	
				</div>
				<ul class="blog-list">
				<c:set var="count" value="${fn:length(categoryList)}"/>
				<c:choose>
					<c:when test="${empty postVo }">
					<c:forEach items="${postList }" var="vo" varStatus="status" >
						<c:if test="${(status.index != 0) }">
						<li><a href="${pageContext.request.contextPath}/${userId }/${vo.postNo }">${vo.postTitle }
						</a> <span>2015/05/02</span>	</li>
						</c:if>
					</c:forEach>
					</c:when>
					<c:otherwise>
					<c:forEach items="${postList }" var="vo" varStatus="status" >
						<li><a 
						<c:if test="${vo.postNo != postVo.postNo }">
						href="${pageContext.request.contextPath}/${userId }/${vo.postNo }"
						</c:if>
						>${vo.postTitle }
						<c:if test="${vo.postNo == postVo.postNo }">
						<img src="${pageContext.request.contextPath}/assets/images/eyes.png" width="30px"/>
						</c:if>
						</a> <span>2015/05/02</span>	</li>
					</c:forEach>
					</c:otherwise>
				</c:choose>
				</ul>
			</div>
		</div>

		<div id="extra">
			<div class="blog-logo">
				<img  src="${pageContext.request.contextPath}/assets/logo/${blogVo.blogLogo }">
			</div>
		</div>

		<div id="navigation">
			<h2>카테고리</h2>
			<c:set var="count" value="${fn:length(categoryList)}"/>
			<ul>
			<c:forEach items="${categoryList }" var="vo" varStatus="status" >
				<li><a href="${pageContext.request.contextPath}/${userId }/category/${vo.categoryNo }">${vo.categoryName }(${vo.postNumber })</a></li>
      		</c:forEach>
			</ul>
		</div>
		<c:import url="/WEB-INF/views/includes/blog_footer.jsp"></c:import>
	</div>
</body>
</html>