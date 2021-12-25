<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/css/memberSearchId.css">
</head>



<body>
	<div class="bg-color">
		<div class="box-white">
			<div class="tab-search">
				<a href="/views/member/memberSearchId.jsp">아이디 찾기</a>
				<a href="/views/member/memberSearchPwd.jsp">비밀번호 찾기</a>
			</div>
			<form action="/member/memberSearchId.do" method="get">
				<input type="email" id="email" class="input-style" name="email" placeholder="이메일 입력"><br>
				<span id="emailCheck" class="check-msg"></span><br>
				<input type="submit" id="searchId" onclick="submitSearchId();" class="btn-searchId" value="아이디 찾기">
			</form>
			<a href="/">메인으로 가기</a>
		</div>
	</div>
	

	
	<!-- jQuery 라이브러리 -->
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	
	<script>
			//이메일이 일치하면 아이디 값을 알려준다.

			$("#searchId").click(function() {
				var email = $("#email").val();
			    var getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);

			    if(!getMail.test($("#email").val())){
					$("#emailCheck").html("올바른 이메일 형식이 아닙니다.").css("color","red");
			        return false;
			      }
			    
			});
			
			
	</script>
	
	<!-- footer -->
	<%@ include file="/views/commons/footer/footer.jsp"%>
</body>
</html>