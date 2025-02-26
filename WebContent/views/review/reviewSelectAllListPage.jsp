<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@page import="kr.or.iei.review.model.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 리뷰 목록</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/reviewSelectAllListPage.css">
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
<script src="/assets/js/swiper.js"></script>
</head>

<body>
	<div id="wrap">
	
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
			
		<div id="content">
			<div class=box-title>
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">줍데이리뷰</p>
			</div>
		
			<div class="box-review-best">
				<p class="tit">베스트 리뷰</p>
				<!-- Swiper -->
			    <div class="swiper mySwiper">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">첫 플로깅 후기입니다:)</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰1.jpeg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">아이와 함께 줍데이 했어요</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰2.png">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">플로깅 꿀팁 공유합니다!</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰3.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">동해바다 플로깅 진행했습니다</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰4.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">연신내줍데이 크루 오프만남 진행했어요!</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰5.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">계곡에서도 줍데이하기^^~</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰6.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">한강 플로깅 한달 일지</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰7.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">한강에서 줍데이하며 10kg 감량</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰8.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">플로깅 명소 추천합니다!</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰9.jpg">
							</a>
						</div>
					</div>
					<div class="swiper-button-next"></div>
					<div class="swiper-button-prev"></div>
			    </div>
			</div>
			
			<%
				HashMap<String,Object> pageDataMap = (HashMap<String,Object>)request.getAttribute("pageDataMap");
				
				ArrayList<Review> list = (ArrayList<Review>)pageDataMap.get("list");
				String pageNavi = (String)pageDataMap.get("pageNavi");
				int currentPage = (int)request.getAttribute("currentPage");
				String keyword = (String)request.getAttribute("keyword"); //getParameter로도 넘기기 가능
				
			%>
			
			<div class="box-write-search">
				<button class="btn-rec">
					<a href="/views/review/reviewWriteForm.jsp">글쓰기</a>
				</button>
				
				<div class="box-search">
					<form action="/review/reviewPostSearch.do" method="get">
						<div class="select-search">
							<select name="type">
								<option>검색필터</option>
								<option value="subject">제목</option>
								<option value="writer">작성자</option>
								<option value="all">제목+작성자</option>
							</select>
							<i class="fas fa-chevron-down icon-arrow"></i>
						</div>
						<div class="input-search">
							<i class="fas fa-search icon-search"></i>
							<input type="text" name="keyword" placeholder="검색어을 검색하세요">
						</div>
						<input type="submit" class="btn-rec" value="검색">
					</form>
				</div>
			</div>
			
			
			
			<div class="box-review">
			
			<%for(Review review : list) { %>
			
				<div class="box-one-review">
					<div class="box-img">
						<a href="/review/reviewSelectContent.do?postNum=<%=review.getPostNum()%>&currentPage=<%=currentPage%>">
							<img alt="" src="">
						</a>
					</div>
					<div class="box-txt">
						<p><%=review.getPostTitle() %></p>
						<p class="review-writer"><%=review.getUserId() %></p>
						<div class="review-info">
							<i class="far fa-heart"></i><span><%=review.getHits() %></span>
							<i class="far fa-comment"></i><span>5</span>
						</div>
						<p class="review-date"><%=review.getRegDate() %></p>				
					</div>
				</div>

				<%} %>
				
				<div id="page_wrap">
                   <ul class="page_ul">
                     	<%=pageNavi %>         
                   </ul>
               	</div>
			</div>

			
		</div>
	
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
</body>
</html>