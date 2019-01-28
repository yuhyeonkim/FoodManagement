package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.DduckMenu;
import com.bean.MrPizzaMenu;

public class DduckMenuDao {
	
	private static DduckMenuDao dduckinstance;
	
	// 객체를 대신 만들어주는 메소드
	public static DduckMenuDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(dduckinstance == null) {
			dduckinstance = new DduckMenuDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return dduckinstance;
	}
	
	Connection conn;
	// 불닭발 엽기 떡볶이 메뉴 등록 메서드
	// 불닭발 엽기 떡볶이 식당 눌러서 신규 버튼 누르면 나오는 화면에서
	public void dduckMenuInsert(DduckMenu dm) throws Exception {
		
		conn = DBConnector.getConnection();
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into dduck_menu(dduck_seq, dduck_id, dduck_rep, dduck_name, dduck_price) "
				+"values(?, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, dm.getDduck_seq());
		pstmt.setInt(2, dm.getDduck_id());
		pstmt.setInt(3, dm.getDduck_seq());
		pstmt.setString(4, dm.getDduck_name());
		pstmt.setInt(5, dm.getDduck_price());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(dm+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 떡볶이 메뉴 삭제 메서드(메뉴 번호로 삭제)
	public void dduckMenuDelete(int dduck_seq) throws Exception {
			
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from dduck_menu where dduck_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dduck_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(dduck_seq+"번째 메뉴가 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// 떡볶이 메뉴 수정 테이블(dduck_seq 메뉴 번호로 검사)
	public void dduckMenuUpdate(DduckMenu dm) throws Exception {
		
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update dduck_menu set dduck_id=? , dduck_rep=?, "
				+"dduck_name=?, dduck_price=? where dduck_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, dm.getDduck_id());
		pstmt.setInt(2, dm.getDduck_rep());
		pstmt.setString(3, dm.getDduck_name());
		pstmt.setInt(4, dm.getDduck_price());
		pstmt.setInt(5, dm.getDduck_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(dm.getDduck_seq()+"번째 메뉴를 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
}
