package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.ChiclegMenu;
import com.bean.DduckMenu;

public class ChiclegMenuDao {
	
	private static ChiclegMenuDao chicinstance;
	Connection conn;
	
	// 객체를 대신 만들어주는 메소드
	public static ChiclegMenuDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(chicinstance == null) {
			chicinstance = new ChiclegMenuDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return chicinstance;
	}
		
	private ChiclegMenuDao() {	
		try {
			conn = DBConnector.getConnection();
			System.out.println("Connection 객체 연결 성공!");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void chiclegMenuInsert(ChiclegMenu cm) throws Exception {
		
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into chicleg_menu(chicleg_seq, chicleg_id, chicleg_rep, chicleg_name, chicleg_price) "
				+"values(?, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, cm.getChicleg_seq());
		pstmt.setInt(2, cm.getChicleg_id());
		pstmt.setInt(3, cm.getChicleg_seq());
		pstmt.setString(4, cm.getChicleg_name());
		pstmt.setInt(5, cm.getChicleg_price());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(cm+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 땡초 불닭발 메뉴 삭제 메서드(메뉴 번호로 삭제)
	public void chiclegMenuDelete(int chicleg_seq) throws Exception {
			
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from chicleg_menu where chicleg_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, chicleg_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(chicleg_seq+"번째 메뉴가 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// 땡초 불닭발 메뉴 수정 테이블(chicleg_seq 메뉴 번호로 검사)
	public void chiclegMenuUpdate(ChiclegMenu cm) throws Exception {
		
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update chicleg_menu set chicleg_id=? , chicleg_rep=?, "
				+"chicleg_name=?, chicleg_price=? where chicleg_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, cm.getChicleg_id());
		pstmt.setInt(2, cm.getChicleg_rep());
		pstmt.setString(3, cm.getChicleg_name());
		pstmt.setInt(4, cm.getChicleg_price());
		pstmt.setInt(5, cm.getChicleg_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(cm.getChicleg_seq()+"번째 메뉴를 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
}
