package kr.or.iei.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.review.model.dao.ReviewDAO;
import kr.or.iei.review.model.vo.Review;


public class ReviewServiceImpl implements ReviewService{
	
	private ReviewDAO rDAO = new ReviewDAO();
	



	@Override
	public HashMap<String, Object> selectAllPostList(int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 8;
		
		ArrayList<Review> list = rDAO.selectAllpostList(conn,currentPage,recordCountPerPage);
		
		int naviCountPerPage = 8;
		
		String pageNavi = rDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list",list);
		hm.put("pageNavi", pageNavi);
		
		JDBCTemplate.close(conn);
		
		return hm;
	}
	
	@Override
	public HashMap<String, Object> selectMemberAllPostList(int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 9;
		
		ArrayList<Review> list = rDAO.selectAllpostList(conn,currentPage,recordCountPerPage);
		
		int naviCountPerPage = 8;
		
		String pageNavi = rDAO.getPageNavi2(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list",list);
		hm.put("pageNavi", pageNavi);
		
		JDBCTemplate.close(conn);
		
		return hm;
	}
	
	

	@Override
	public Review selectOnePost(int postNum) {
		Connection conn = JDBCTemplate.getConnection();
		
		Review review = rDAO.selectOneContent(conn, postNum);
		JDBCTemplate.close(conn);
		return review;

	}
	
	
}
