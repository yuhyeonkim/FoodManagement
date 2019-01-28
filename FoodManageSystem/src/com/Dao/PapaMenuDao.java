package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.PapaMenu;

public class PapaMenuDao {

	private static PapaMenuDao papainstance;
	
	// 객체를 대신 만들어주는 메소드
	public static PapaMenuDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(papainstance == null) {
			papainstance = new PapaMenuDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return papainstance;
	}
	Connection conn;
	
	public void papaMenuInsert(PapaMenu pm) throws Exception {
		
		conn = DBConnector.getConnection();
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into papa_menu(papa_seq, papa_id, papa_rep, papa_name, papa_price) "
				+"values(?, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, pm.getPapa_seq());
		pstmt.setInt(2, pm.getPapa_id());
		pstmt.setInt(3, pm.getPapa_rep());
		pstmt.setString(4, pm.getPapa_name());
		pstmt.setInt(5, pm.getPapa_price());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(pm+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 파파존스 메뉴 삭제 메서드(메뉴 번호로 삭제)
	public void papaMenuDelete(int papa_seq) throws Exception {
			
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from papa_menu where papa_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, papa_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(papa_seq+"번째 메뉴가 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// 파파존스 메뉴 수정 테이블(papa_seq 메뉴 번호로 검사)
	public void dduckMenuUpdate(PapaMenu pm) throws Exception {
		
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update papa_menu set papa_id=? , papa_rep=?, "
				+"papa_name=?, papa_price=? where papa_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, pm.getPapa_id());
		pstmt.setInt(2, pm.getPapa_rep());
		pstmt.setString(3, pm.getPapa_name());
		pstmt.setInt(4, pm.getPapa_price());
		pstmt.setInt(5, pm.getPapa_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(pm.getPapa_seq()+"번째 메뉴를 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
}
