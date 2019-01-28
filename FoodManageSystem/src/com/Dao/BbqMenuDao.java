package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.bean.BbqMenu;
import com.bean.DduckMenu;

public class BbqMenuDao {
	
	private static BbqMenuDao bbqinstance;
	Connection conn;
	
	
	// 객체를 대신 만들어주는 메소드
	public static BbqMenuDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(bbqinstance == null) {
			bbqinstance = new BbqMenuDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return bbqinstance;
	}
		
	private BbqMenuDao() {	
		try {
			conn = DBConnector.getConnection();
			System.out.println("Connection 객체 연결 성공!");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void bbqMenuInsert(BbqMenu bm) throws Exception {
		
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into bbq_menu(bbq_seq, bbq_id, bbq_rep, bbq_name, bbq_price) "
				+"values(?, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, bm.getBbq_seq());
		pstmt.setInt(2, bm.getBbq_id());
		pstmt.setInt(3, bm.getBbq_rep());
		pstmt.setString(4, bm.getBbq_name());
		pstmt.setInt(5, bm.getBbq_price());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(bm+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// BBQ 메뉴 삭제 메서드(메뉴 번호로 삭제)
	public void bbqMenuDelete(int bbq_seq) throws Exception {
			
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from bbq_menu where bbq_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bbq_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(bbq_seq+"번째 메뉴가 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// BBQ 메뉴 수정 테이블(dduck_seq 메뉴 번호로 검사)
	public void bbqMenuUpdate(BbqMenu bm) throws Exception {
		
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update bbq_menu set bbq_id=? , bbq_rep=?, "
				+"bbq_name=?, bbq_price=? where bbq_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, bm.getBbq_id());
		pstmt.setInt(2, bm.getBbq_rep());
		pstmt.setString(3, bm.getBbq_name());
		pstmt.setInt(4, bm.getBbq_price());
		pstmt.setInt(5, bm.getBbq_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(bm.getBbq_seq()+"번째 메뉴를 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
}
