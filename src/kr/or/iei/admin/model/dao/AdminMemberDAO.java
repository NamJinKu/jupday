package kr.or.iei.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;
import kr.or.iei.notice.model.vo.NoticeCampaign;

public class AdminMemberDAO {
	
/*	public ArrayList<Member> SelectAllMemberList(String authorityId, Connection conn)
	{
	public ArrayList<Member> selectAllMemberList(Connection conn, int currentPage, int recordCountPerPage) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		int start = currentPage*recordCountPerPage-(recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		
		String query = "SELECT ROWNUM, MEMBER.* " + 
						"FROM MEMBER " + 
						"WHERE ROWNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) 
			{
				//Member m은 MemberDAO와 겹쳐서 memp으로 대체
				Member memp = new Member();
				
				memp.setAuthority_Id(rset.getString("authority_Id")); //1
				memp.setUserId(rset.getString("userId")); //2
				memp.setUserPwd(rset.getString("userPwd")); //3
				memp.setNick(rset.getString("nick")); //4
				memp.setEmail(rset.getString("email")); //5
				memp.setP_Image(rset.getString("p_Image")); //6
				memp.setEnrollDate(rset.getDate("enrollDate")); //7
				memp.setEnd_YN(rset.getString("end_yn").charAt(0)); //8
				list.add(memp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}

	public String getPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {
		
		//전체 회원수
		int recordTotalCount = totalCount(conn);
		
		//전체 페이지수
		int pageTotalCount = 0;
		
		if((recordTotalCount % recordCountPerPage)>0) 
		{
			pageTotalCount = (recordTotalCount / recordCountPerPage)+1;
		}else 
		{
			pageTotalCount = (recordTotalCount / recordCountPerPage);
		}
		
		int startNavi = (((currentPage-1)/naviCountPerPage)*naviCountPerPage)+1;
		int endNavi = startNavi+(naviCountPerPage-1);
		
		//endNavi가 총 page수보다 클 경우 총 page수로 셋팅
		if(endNavi > pageTotalCount) 
		{
			endNavi = pageTotalCount;
		}
				
		//pageNavi 모양 만들기
		StringBuilder sb = new StringBuilder();
		
		if(startNavi!=1) {
			sb.append("<li><a href='/admin/MemberManageList.do?currentPage="+(startNavi-1)+"'><i class='fas fa-chevron-left'></i></a></li>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			
			if(i==currentPage) {
				sb.append("<li><a href='/admin/MemberManageList.do?currentPage="+i+"' class='page_active'>"+i+"</a></li>");
			}else {
				sb.append("<li><a href='/admin/MemberManageList.do?currentPage="+i+"'>"+i+"</a></li>");
			}
		}

		if(endNavi!=pageTotalCount) {
			sb.append("<li><a href='/admin/MemberManageList.do?currentPage="+(endNavi+1)+"'><i class='fas fa-chevron-right'></i></a></li>");
		}
		
		return sb.toString();
				
	}
	
	public int totalCount(Connection conn)
	{
		String query = "SELECT * FROM MEMBER"; 
		return query;
	}


		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query = "SELECT COUNT(*) as count FROM MEMBER";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
*/
	
	
	public int updateMemberEndYN(String userId, char endYN, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET end_YN=? WHERE userId=? AND authority_id!='root'";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, String.valueOf(endYN));
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<Member> selectAllMemberPageList(Connection conn, int currentPage, int recordCountPerPage) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		String query = "select * from "
				+ " (select row_number() "
				+ " over (order by USERID ASC) AS NUM, "
				+ " MEMBER.* FROM MEMBER ) "
				+ " WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) 
			{
				//Member m은 MemberDAO와 겹쳐서 mem으로 대체
				Member mem = new Member();
				mem.setAuthority_Id(rset.getString("authority_Id")); //1
				mem.setUserId(rset.getString("userId")); //2
				mem.setUserPwd(rset.getString("userPwd")); //3
				mem.setNick(rset.getString("nick")); //4
				mem.setEmail(rset.getString("email")); //5
				mem.setP_Image(rset.getString("p_Image")); //6
				mem.setEnrollDate(rset.getDate("enrollDate")); //7
				mem.setEnd_YN(rset.getString("end_yn").charAt(0)); //8
				list.add(mem);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}

	public String getPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {
		
		//전체 회원수
		int recordTotalCount = totalCount(conn);
		
		//전체 페이지수
		int pageTotalCount = 0;
		
		if((recordTotalCount % recordCountPerPage)>0)
		{
			pageTotalCount = (recordTotalCount / recordCountPerPage) + 1;
		}else
		{
			pageTotalCount = (recordTotalCount / recordCountPerPage);
		}
		
		int startNavi = (((currentPage-1) / naviCountPerPage) * naviCountPerPage) +1;
		int endNavi = startNavi + (naviCountPerPage-1);
		
		//endNavi가 총 page수보다 클 경우 총 page수로 셋팅
		if(endNavi > pageTotalCount)
		{
			endNavi = pageTotalCount;
		}
				
		//pageNavi 모양 만들기
		StringBuilder sb = new StringBuilder();
		
		if(startNavi!=1) {
			sb.append("<li><a href='/admin/MemberManageList.do?currentPage="+(startNavi-1)+"'><i class='fas fa-chevron-left'></i></a></li>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			
			if(i==currentPage) {
				sb.append("<li><a href='/admin/MemberManageList.do?currentPage="+i+"' class='page_active'>"+i+"</a></li>");
			}else {
				sb.append("<li><a href='/admin/MemberManageList.do?currentPage="+i+"'>"+i+"</a></li>");
			}
		}

		if(endNavi!=pageTotalCount) {
			sb.append("<li><a href='/admin/MemberManageList.do?currentPage="+(endNavi+1)+"'><i class='fas fa-chevron-right'></i></a></li>");
		}
		
		return sb.toString();
				
	}
	
	public int totalCount(Connection conn)
	{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query = "SELECT COUNT(*) as count FROM MEMBER";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return count;
	}
	
	
	
	
	//검색 실패 시 이 메소드를 삭제(남진구)
	public ArrayList<Member> selectSearchAdminMemberList(Connection conn, int currentPage, int recordCountPerPage,
			String keyword, String type) {
	  
		
			PreparedStatement pstmt = null;
			ResultSet rset=null;
			ArrayList<Member> list = new ArrayList<Member>();
			
			
			int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
			int end = currentPage*recordCountPerPage;
			
			String query="";
			
			switch(type)
			{
			case "email" :
				query=  "select *" + 
						"		from (select row_number() over(order by USERID ASC)as num, MEMBER.* " + 
						"		from MEMBER " + 
						"		where email like ? ) " + 
						"		where num between ? and ?"; 

				break;
				
			case "id" :
				query=  "select *" + 
						"		from (select row_number() over(order by USERID ASC)as num, MEMBER.* " + 
						"		from MEMBER " + 
						"		where userId like ? ) " + 
						"		where num between ? and ?"; 
				break;
			}
			
			
			try {
				pstmt = conn.prepareStatement(query);
				
				if(type.equals("email"))
				{
					pstmt.setString(1, "%"+keyword+"%");
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					
				}else {
					pstmt.setString(1, "%"+keyword+"%");
					pstmt.setInt(2, start);
					pstmt.setInt(3, end);
					
				}

				
				rset = pstmt.executeQuery();//실행
				
				while(rset.next()) {
					
					Member mem = new Member();
					
					mem.setAuthority_Id(rset.getString("authority_Id")); //1
					mem.setUserId(rset.getString("userId")); //2
					mem.setUserPwd(rset.getString("userPwd")); //3
					mem.setNick(rset.getString("nick")); //4
					mem.setEmail(rset.getString("email")); //5
					mem.setP_Image(rset.getString("p_Image")); //6
					mem.setEnrollDate(rset.getDate("enrollDate")); //7
					mem.setEnd_YN(rset.getString("end_yn").charAt(0)); //8
				
					list.add(mem);
				
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return list;
	}

	public String getSearchAdminMemberPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage,
			int currentPage, String keyword, String type) {
		    
		   int recordTotalCount = adminMemberCount2(conn,keyword,type);
		
	       int pageTotalCount = 0; //전체 페이지 개수

			
			if((recordTotalCount % recordCountPerPage)>0) {
				pageTotalCount = (recordTotalCount / recordCountPerPage)+1;
			}else {
				pageTotalCount = (recordTotalCount / recordCountPerPage);
			}
			
			
			int startNavi = (((currentPage-1)/naviCountPerPage)*naviCountPerPage)+1;
			int endNavi = startNavi+(naviCountPerPage-1);
			
			
			//만약 공식으로 구한 endNavi가 총페이지 수 보다 크다면 총 페이지 수로 세팅하여라
			if(endNavi > pageTotalCount) {
				endNavi = pageTotalCount;
			}
			
			//&recordTotalCount="+recordTotalCount+
				
			//pageNavi 모양 만들기
			StringBuilder sb = new StringBuilder();

			if(startNavi!=1) {
				sb.append("<li><a href='/admin/adminMemberSearch.do?currentPage="+(startNavi-1)+"&keyword="+keyword+"&type="+type+"'><i class='fas fa-chevron-left'></i></a></li>");
			}

			for(int i=startNavi; i<=endNavi; i++) {
				
				if(i==currentPage) {
					sb.append("<li><a href='/admin/adminMemberSearch.do?currentPage="+i+"&keyword="+keyword+"&type="+type+"' class='page_active'>"+i+"</a></li>");
				}else {
					sb.append("<li><a href='/admin/adminMemberSearch.do?currentPage="+i+"&keyword="+keyword+"&type="+type+"'>"+i+"</a></li>");
				}
			}

			if(endNavi!=pageTotalCount) {
				sb.append("<li><a href='/admin/adminMemberSearch.do?currentPage="+(endNavi+1)+"&keyword="+keyword+"&type="+type+"'><i class='fas fa-chevron-right'></i></a></li>");
			}

			
			return sb.toString();
	}

	private int adminMemberCount2(Connection conn, String keyword, String type) {

		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query ="";
		
		switch(type)
		{
		case "email" :
			   query ="SELECT COUNT(*) as count FROM MEMBER WHERE email LIKE ? ";			   		
			   break;
			   
		case "id" :
			   query="SELECT COUNT(*) as count FROM MEMBER WHERE userId LIKE ? ";
			   break;
			   	
		}
		
		
		try {
			pstmt = conn.prepareStatement(query);
			
			if(type.equals("email"))
			{
				pstmt.setString(1, "%"+keyword+"%");
				
			}else
			{
				pstmt.setString(1, "%"+keyword+"%");

			}

			rset = pstmt.executeQuery();
			
			if(rset.next()) {//count라는 이름의 칼럼을 꺼낸것
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return count;
	}
}


