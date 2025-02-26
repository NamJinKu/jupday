package kr.or.iei.admin.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.admin.model.dao.AdminMemberDAO;
import kr.or.iei.admin.notice.model.dao.AdminNoticeDAO;
import kr.or.iei.admin.notice.model.vo.AdminNotice;
import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;

public class AdminNoticeServiceImpl implements AdminNoticeService {
	private AdminNoticeDAO adnDAO = new AdminNoticeDAO(); 

	@Override
	public HashMap<String, Object> selectAllNoticePageList(int currentPage) {
	Connection conn = JDBCTemplate.getConnection();
		
		//한 개의 page에서 몇 개의 목록으로 보여줄 것인지
		int recordCountPerPage = 10;
		
		ArrayList<AdminNotice> list = adnDAO.selectAllNoitcePageList(conn, currentPage, recordCountPerPage);
		
		//한 개의 pageNavi에서 보여질 Navi 개수
		int naviCountPerPage = 5;
		
		String pageNavi = adnDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list", list);
		hm.put("pageNavi", pageNavi);

		JDBCTemplate.close(conn);
		return hm;
	}

}
