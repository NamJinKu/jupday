package kr.or.iei.admin.notice.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.admin.notice.model.vo.AdminCampaign;
//import kr.or.iei.admin.notice.model.vo.AdminCampaign;
//import kr.or.iei.admin.notice.model.vo.AdminFAQ;
import kr.or.iei.admin.notice.model.vo.AdminNotice;
import kr.or.iei.common.JDBCTemplate;

public class AdminNoticeDAO {

	public ArrayList<AdminNotice> selectAllNoitcePageList(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AdminNotice> list = new ArrayList<AdminNotice>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;		
		
		String query = " SELECT N_NO, N_TITLE, N_CONTENT, N_REGDATE, N_DEL_YN FROM NOTICE " + 
						" WHERE N_NO BETWEEN ? AND ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) 
			{
				AdminNotice an = new AdminNotice();
				an.setN_No(rset.getInt("n_No"));
				an.setN_Title(rset.getString("n_Title"));
				an.setN_Content(rset.getString("n_Content"));
				an.setN_regDate(rset.getDate("n_regDate"));
				an.setN_Del_YN(rset.getString("n_Del_YN").charAt(0));
				list.add(an);
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
		
		//전체 공지수
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
			sb.append("<li><a href='/admin/noticeManageList.do?currentPage="+(startNavi-1)+"'><i class='fas fa-chevron-left'></i></a></li>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			
			if(i==currentPage) {
				sb.append("<li><a href='/admin/noticeManageList.do?currentPage="+i+"' class='page_active'>"+i+"</a></li>");
			}else {
				sb.append("<li><a href='/admin/noticeManageList.do?currentPage="+i+"'>"+i+"</a></li>");
			}
		}

		if(endNavi!=pageTotalCount) {
			sb.append("<li><a href='/admin/noticeManageList.do?currentPage="+(endNavi+1)+"'><i class='fas fa-chevron-right'></i></a></li>");
		}
		
		return sb.toString();
				
	}
	
	public int totalCount(Connection conn)
	{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query = "SELECT COUNT(*) as count FROM NOTICE";
		
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

	
}