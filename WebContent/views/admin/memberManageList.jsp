<%@page import="kr.or.iei.admin.model.dao.AdminMemberDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자페이지 - 회원 정보 관리</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/adminNavigation.css">
<link rel="stylesheet" href="/assets/commons/adminCommon.css">
<link rel="stylesheet" href="/assets/css/adminBoard.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>

<body>


   <%
       //세션에서 멤버가져오기
      Member m = (Member)session.getAttribute("member");
   %>
   
   <%//페이징 처리 된 데이터 가져오기
      HashMap<String,Object> pageDataMap = (HashMap<String,Object>)request.getAttribute("pageDataMap");   
      ArrayList<Member> list = (ArrayList<Member>)pageDataMap.get("list");
      String pageNavi = (String)pageDataMap.get("pageNavi");
      int currentPage =(int)request.getAttribute("currentPage");//<-이줄만 남진구.작동 안할시 삭제하기

   %>

    <div id="wrap">
        
        <!-- navigation -->
      <%@ include file="/views/commons/header/navigationAdmin.jsp"%>
        
        <div id="header">
            <div class="admin-path">
                <p>회원 정보</p>
                <p>회원 정보 관리</p>
            </div>
           
   
            <div class="box-user">
                <a href="/"><%=m.getNick()%></a>
                <a href="/member/logout.do">로그아웃</a>
            </div>
        </div>
        
        <div id="content">
            <div class="container">
                <div class="container_top">
                    <div class="count-all">
                        <p>전체 <span>7777</span> 건</p>
                    </div>
                    
                    <div class="box-search">
                  <form action="/admin/adminMemberSearch.do" method="post">
                     <div class="select-search">
                        <select name="type">
                           <option value="id">아이디</option>
                           <option value="email">이메일</option>
                        </select>
                        <i class="fas fa-chevron-down icon-arrow"></i>
                     </div>
                     <div class="input-search"><!-- 여기를 시작점으로 삼는다. 아이디 이메일  닉네임을 사용해서 회원을 찾아오는 것으로 한다.-->
                        <i class="fas fa-search icon-search"></i>
                        <input type="text" name="keyword" placeholder="검색어를 검색하세요">
                     </div>
                     <input type="submit" class="btn-rec" value="검색">
                  </form>
               </div>
                </div>
      
                <div class="table_wrap">
                    <table>
                        <thead>
                            <tr>
                                <th width="200">회원등급</th>
                                <th width="200">아이디</th>
                                <th width="200">닉네임</th>
                                <th width="300">이메일</th>
                                <th width="200">가입일</th>
                                <th width="150">탈퇴 / 복원</th>
                            </tr>
                        </thead>
                        
                        <tbody>
                          <%for(Member mem : list) {%>
                            <tr>
                                <td><%=mem.getAuthority_Id() %></td>
                                <td><%=mem.getUserId() %></td>
                                <td><%=mem.getNick() %></td>
                                <td><%=mem.getEmail() %></td>
                                <td><%=mem.getEnrollDate() %></td>
                                <td>
                                <%if(!mem.getAuthority_Id().equals("root")) { //관리자일 경우 탈퇴버튼 제거%>
                                   <%if(mem.getEnd_YN()=='N') {%>
                                    <button type="button" class="del_btn" onclick="deleteMember('<%=mem.getUserId()%>')">탈퇴</button>
                                        <!-- <a href="/admin/memberEndYNChange.do?userId=<%=mem.getUserId()%>&endYN=<%=mem.getEnd_YN()%>">
                                        </a> -->
                                   <%}else {%>
                                    <button type="button" class="re_btn" onclick="reMember('<%=mem.getUserId()%>')">복원</button>
                                      <!-- <a href="/admin/memberEndYNChange.do?userId=<%=mem.getUserId()%>&endYN=<%=mem.getEnd_YN()%>">
                                      </a> -->
                                   <%} %>
                                <%} %>
                                </td>
                            </tr>
                        <%} %>
                        </tbody> 
                        
                    </table>
            
                    <div id="page_wrap">
                        <ul class="page_ul">
                      <%=pageNavi%>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
        
        <footer id="footer">
            <p>2021 ⓒ JUP DAY</p>
        </footer>
    </div>

    <script>

    // 회원탈퇴
    function deleteMember(userId) {
      
        var confirm = window.confirm(userId + " 회원을 탈퇴처리하시겠습니까?");
    
        if(confirm) {
            location.href = "/admin/memberEndYNChange.do?userId="+userId+"&endYN=Y";
        } else {
            
        return false;

        }

   }


   // 회원 복원
   function reMember(userId) {
        var confirm = window.confirm(userId + " 회원을 복원하시겠습니까?");
        
        if (confirm) {
            location.href = "/admin/memberEndYNChange.do?userId="+userId+"&endYN=N";
        } else {
    
            return false;
    
        }
    }

//    $('.del_btn').click(function(){
      
//       var data = $(this).html();
      
//       if(data=='Y')
//       {
//          window.confirm(<%=m.getUserId() %> + " 회원을 탈퇴처리하시겠습니까?");
         
//       }
//       return false;
//    });
   
   
//    $('.re_btn').click(function(){
      
//       var data = $(this).html();
      
//       if(data=='Y')
//       {
//          window.confirm(<%=m.getUserId() %> + " 회원을 복원하시겠습니끼?");   
//       }
//       return false;
//    });
    </script>
</body>
</html>