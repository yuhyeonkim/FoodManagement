package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.DduckMenu;
import com.bean.GopMenu;

public class GopMenuDao {
	
	private static GopMenuDao gopinstance;
	
	// 객체를 대신 만들어주는 메소드
	public static GopMenuDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(gopinstance == null) {
			gopinstance = new GopMenuDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return gopinstance;
	}
	
	Connection conn;
	
	public void gopMenuInsert(GopMenu gm) throws Exception {
		
		conn = DBConnector.getConnection();
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into gop_menu(gop_seq, gop_id, gop_rep, gop_name, gop_price) "
				+"values(?, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, gm.getGop_seq());
		pstmt.setInt(2, gm.getGop_id());
		pstmt.setInt(3, gm.getGop_seq());
		pstmt.setString(4, gm.getGop_name());
		pstmt.setInt(5, gm.getGop_price());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(gm+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 대한곱창 메뉴 삭제 메서드(메뉴 번호로 삭제)
	public void gopMenuDelete(int gop_seq) throws Exception {
			
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from gop_menu where gop_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, gop_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(gop_seq+"번째 메뉴가 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// 대한곱창 메뉴 수정 테이블(gop_seq 메뉴 번호로 검사)
	public void gopMenuUpdate(GopMenu gm) throws Exception {
		
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update gop_menu set gop_id=? , gop_rep=?, "
				+"gop_name=?, gop_price=? where gop_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, gm.getGop_id());
		pstmt.setInt(2, gm.getGop_rep());
		pstmt.setString(3, gm.getGop_name());
		pstmt.setInt(4, gm.getGop_price());
		pstmt.setInt(5, gm.getGop_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(gm.getGop_seq()+"번째 메뉴를 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
}
