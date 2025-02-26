<%@page import="kr.or.iei.notice.model.vo.BoxFAQ"%>
<%@page import="kr.or.iei.notice.model.vo.QuestionFAQ"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 자주 묻는 질문</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/noticeFAQ.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>
<body>

<%


HashMap<String,Object> pageDataMap = (HashMap<String,Object>)request.getAttribute("pageDataMap");

ArrayList<BoxFAQ> list = (ArrayList<BoxFAQ>)pageDataMap.get("list");//꺼내준다.
String pageNavi = (String)pageDataMap.get("pageNavi");//꺼내준다
int currentPage =(int)request.getAttribute("currentPage");
%>

	<div id="wrap">
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
			
		<div id="content">
			<div class="box-title">
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">자주 묻는 질문</p>
			</div>
			
			<div class="faq-all-box">
		   <%for(BoxFAQ boxFAQ : list){%>		
		        <div class="faq-box">
		       		<div class="question-box">
			          	<i class="fas fa-chevron-down"></i> 
			            <p><%=boxFAQ.getBoxAnswerFAQTitle() %></p>
					</div>
		            <div class="answer-box">
			          	<p><%=boxFAQ.getBoxFAQContent() %></p>
		            </div>
				</div>
		        <% }%> 
			  
      
   			</div>
		</div>   
							
		
      	<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
	
</body>
</html>