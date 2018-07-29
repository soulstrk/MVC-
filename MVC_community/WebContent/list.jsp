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
<title>부트스트랩 및 커뮤연습</title>
<link rel="stylesheet" href="css/css.css?ver=3"/>

</head>
<body>
	<header>
		<div class="container">
			<div class="row" id="top1">
				<div class="col-md-4" id="top-left"></div>
				<div class="col-md-4 text-center" id="top-middle">
					<h2 class="text-primary"style="font-weight: bold; font-family: oblique; text-shadow: 3px 2px red; font-size: 40px; letter-spacing: 3px;">
						Login<br>and<br> Community
					</h2>
				</div>
				<div class="col-md-4" id="top-right"></div>
			</div>
		</div>
	</header>
	<div class="content">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="container col-md-3" id="login1">
				<div id="login" class="col-md-6">
					<form action="#" method="get">
						아이디 <br><input type="text" name="id" id="id"><br>
						<br> 비밀번호<input type="password" name="pwd" id="pwd">
						<input type="submit" value="로그인" id="join" class="btn btn-info">
					</form>
					<a href="#" class="btn btn-info" role="button" id="bjoin">회원가입</a>
				</div>
			</div>
			
			<div class="container" id="writeView">
				<form action="write.do" method="get">
					<div class="form-group">
						이름<br>
						<input type="text" name="name" id="name" size="5"><br>
						제목<br>
						<input type="text" class="form-control" name="title" id="title"><br>
						내용<br>
						<textarea rows="10" class="form-control" id="content" name="content"></textarea>
						<input type="submit" value="작성완료">
						<button onclick="closePopup()">닫기</button>
					</div>				
				</form>
			</div>
			
			<%! ArrayList<bDto> list = new ArrayList<>(); bDto dto; %>
			<% list = (ArrayList<bDto>)request.getAttribute("list"); %>
			<div class="container col-md-7" id="table1">
				<table class="table table-striped">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				<% for(int i = 0; i<list.size(); i++) { %>
					<tr>
						<td><%= list.get(i).getbId() %></td>
						<td><a href="content_view.do?bId=<%= list.get(i).getbId()%>"><%= list.get(i).getbTitle() %></a></td>
						<td><%= list.get(i).getbName() %></td>
						<td><%= list.get(i).getbDate() %></td>
						<td><%= list.get(i).getbHit() %></td>
					</tr>
				<% } %>
				</table>
				<button onclick="showPopup()">글쓰기</button>
				<div class="text-center">
					<ul class="pagination">
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
					</ul>
				</div>

			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4" id="LtimeBox">
				<span id="span1">현 재 시 간</span>
				<div id="nowTime"></div>
			</div>
			<div class="col-md-4" id="MtimeBox"></div>
			<div class="col-md-4" id="RtimeBox">
				<img src="img/dog2.jpg" alt="sang2" class="pic1" id="kakao2">
				<img src="img/kakao2.jpg" alt="후라이" class="rounded-circle"
					id="hurai">
			</div>
		</div>
	</div>

</body>
</html>