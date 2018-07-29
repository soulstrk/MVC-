<%@page import="com.soulstrk.Dao.Dao"%>
<%@page import="java.io.Writer"%>
<%@page import="com.soulstrk.Dto.bDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="script/js.js"></script>
<title>게시글</title>
<link rel="stylesheet" href="css/css.css?ver=1"/>
<%! bDto dto; %>
<% dto = (bDto)request.getAttribute("content"); %>
</head>
<body>
	<header>
	</header>
	<div class="content" id="abc">
		<div class="col-md-2">
		</div>
		<div class="col-md-8" id="contentBox">
		<h2>제목</h3>
		<%= dto.getbTitle() %><br><br><br>
		<h3>작성자</h4>
		<%= dto.getbName() %><br><br>
		<h2>내용</h2>
		<br>
		<%= dto.getbContent() %>
		</div>
		<div class="col-md-2">
		</div>
		<a href="start.jsp" id="back">뒤로가기</a>
	</div>
</body>
</html>