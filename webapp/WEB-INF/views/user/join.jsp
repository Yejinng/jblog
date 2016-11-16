<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
$(function(){
	$("#join-form").submit(function(){
		// 1. 이름이 비어있는지 체크
		if($("#name").val() == "") {
			$("#dialog p").text("이름을 입력해주세요!");
			$("#dialog").dialog();
			$("#name").focus();
			return false;
		}
		// 2.이메일 
		if($("#id").val() == "") {
			$("#dialog p").text("아이디를 입력해주세요!");
			$("#dialog").dialog();
			$("#id").focus();
			return false;
		}
		// 2-2 이메일 중복 체크유무
		if($("#img_checkid").is(":visible") == false ) {
			$("#dialog p").text("이메일 중복체크를 해주세요!");
			$("#dialog").dialog();
			return false;
		}
		if($("input[type='password']").val() == "") {
			$("#dialog p").text("비밀번호를 입력해주세요!");
			$("#dialog").dialog();
			$("input[type='password']").focus();
			return false;
		}
		if($("#agree-prov").is(":checked") == false ) {
			$("#dialog p").text("약관동의를 해주세요!");
			$("#dialog").dialog();
			return false;
		}
		return true;
	});
	$("#id").change(function(){
		$("#img_checkid").hide();
		$("#btn_checkid").show();
	});
	$("#btn_checkid").click(function(){
		console.log("123");
		var id = $("#id").val();
		if( id == "") {
			return;
		}
		$.ajax({
			url:"${pageContext.request.contextPath }/user/api/checkid?id=" + id,
			type:"get",
			dataType:"json",
			data:"",
			success: function(response){
				console.log(response);
				if( response.result == "fail"){
					console.log(response.message);
					return;
				}
				//success
				if( response.data == "exist") {
					alert("이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요");
					$("#id").val("").focus();
					return;
				}
				//존재하지 않는 이메일
				$("#img_checkid").show();
				$("#btn_checkid").hide();
			},
			error: function(jqXHR, status, e) {
				console.error(status + ":" + e);
			}
		});
	});
});
</script>
</head>
<body>
	<div class="center-content">
		<h1 class="logo">JBlog</h1>
		
		<form class="join-form" id="join-form" method="post" action="${pageContext.request.contextPath }/user/join">
			<label class="block-label" for="name">이름</label>
			<input id="name"name="name" type="text" value="">
			
			<label class="block-label" for="id">아이디</label>
			<input id="id" name="id" type="text"> 
			<input id="btn_checkid" type="button" value="id 중복체크">
			<img id="img_checkid" style="display: none;" src="${pageContext.request.contextPath}/assets/images/check.png">

			<label class="block-label">패스워드</label>
			<input name="password" type="password" value="">
			
			<fieldset>
				<legend>약관동의</legend>
				<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
				<label class="l-float">서비스 약관에 동의합니다.</label>
			</fieldset>

			<input type="submit" value="가입하기">

		</form>
	</div>
	<div id="dialog" title="" style="display:none">
	  <p></p>
	</div>
</body>
</html>
