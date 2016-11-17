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
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
var render = function( vo, where) {
		var num = parseInt($("tbody tr td").first().text())+1;
		var htmls = 
			"<tr><td id='category_no'>" + num + "</td>" +
			"<td>" + vo.categoryName  + "</td>" +
			"<td> 0 </td>" +
			"<td>" + vo.categoryDescription + "</td>" +
			"<td id='btn_delete'><a href=''><img src='${pageContext.request.contextPath}/assets/images/delete.jpg'></a></td>" +
			"</tr>";
			$("#list_category").prepend(htmls);
}

$(function(){
	/* $(".errorMsg").hide();
	var $no = null; */
	//삭제버튼
	$("#btn_delete").click(function(event){
		event.preventDefault();
		$no = $(this).parent().attr("id");
		dialog.dialog("open");
	});
	
	var deleteCategory = function(){
		no = $no.replace("btn_delete","");
		$.ajax({
			url: "${pageContext.request.contextPath }/blog/api/delete",
			type: "post",
			dataType: "json",
			data: "no=" + no,
			success: function(response) {
				if(response.result != "success"){
					console.error(response.message);
					$(".errorMsg").show();
					isEnd = true;
					return;
				}
				console.log(response.data);
				$(response.data).remove();
				dialog.dialog( "close" );
			},
			error: function(jqXHR, status, e) {
				console.log(status + ":" + e);
			}
		});
	}
		dialog = $( "#dialog-form" ).dialog({
		    autoOpen: false,
		    height: 400,
		    width: 350,
		    modal: true,
		    buttons: {
		  	  
		      "삭제하기": deleteCategory,
		      Cancel: function() {
		        dialog.dialog( "close" );
		      }
		    },
		    close: function() {
			       	  form[ 0 ].reset();
		        $(".errorMsg").hide();
		    }
		  });

	  form = dialog.find( "form" ).on( "submit", function( event ) {
		      event.preventDefault();
	    deleteCategory();
	  }); 
  
		$("#admin-cat-add").submit( function(event) {
			event.preventDefault();
			//ajax insert
			var name = $("#name").val();
			var desc = $("#desc").val();
			var no = $("#no").val();
			if( name == "") {
				alert("카테고리명을 입력해주세요");
				return;
			}
	
		$.ajax({
			url: "${pageContext.request.contextPath }/blog/api/insert",
			type: "post",
			dataType: "json",
			data: "categoryName=" + name + "&categoryDescription=" + desc + "&userNo=" + no ,
			success: function(response) {		// response.result = "success" or "fail"
												// response.data = [{},{},{}....]
				if(response.result != "success"){
					console.error(response.message);
					isEnd = true;
					return;
				}
				console.log(response.data);
				render( response.data);
			},
			error: function(jqXHR, status, e) {
				console.log(status + ":" + e);
			}
		});
	});
	//1번째 리스트 가져오기
});
</script>

</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/blog_header.jsp"></c:import>
		<div id="wrapper">
			<div id="content" class="full-screen">
				<ul class="admin-menu">
					<li><a href="${pageContext.request.contextPath }/${authUser.id }/admin/basic/modify">기본설정</a></li>
					<li class="selected"><a href="${pageContext.request.contextPath }/${authUser.id }/admin/category">카테고리</a></li>
					<li><a href="${pageContext.request.contextPath }/${authUser.id }/admin/write">글작성</a></li>
				</ul>
		      		<table class="admin-cat">
		      		<thead>
		      		<tr>
		      			<th>번호</th>
		      			<th>카테고리명</th>
		      			<th>포스트 수</th>
		      			<th>설명</th>
		      			<th>삭제</th>      			
		      		</tr>
		      		</thead>
		      		<tbody id="list_category">
		      		<c:set var="count" value="${fn:length(list)}"/>
				<c:forEach items="${list }" var="vo" varStatus="status" >
		      		<tr id="category-${vo.categoryNo }">
		      			<td>${count - status.index }</td>
		      			<td>${vo.categoryName }</td>
		      			<td>${vo.postNumber }</td>
		      			<td>${vo.categoryDescription }</td>
		      			<td>삭제</td>      			
		      		</tr>
		      		</c:forEach>
		      		</tbody>	      		
					</table>
	      		<h4 class="n-c">새로운 카테고리 추가</h4>
	      		<form id="admin-cat-add" method="post" action="${pageContext.request.contextPath }/blog/api/insert">
				<input id="no" type="hidden" name="no" value="${blogVo.userNo }"/>
		      	<table id="admin-cat-add">
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input id="name" type="text" name="name"></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input id="desc" type="text" name="desc"></td>
		      		</tr>
		      		<tr>
		      			<td class="s">&nbsp;</td>
		      			<td><input type="submit" value="카테고리 추가"></td>
		      		</tr>      		      		
		      	</table> 
		      	</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/blog_footer.jsp"></c:import>
	</div>
</body>
</html>