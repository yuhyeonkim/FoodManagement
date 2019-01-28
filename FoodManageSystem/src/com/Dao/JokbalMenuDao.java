package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.DduckMenu;
import com.bean.JokbalMenu;

public class JokbalMenuDao {

	private static JokbalMenuDao jokbalinstance;
	
	// 객체를 대신 만들어주는 메소드
	public static JokbalMenuDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(jokbalinstance == null) {
			jokbalinstance = new JokbalMenuDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return jokbalinstance;
	}
	
	Connection conn;
	// 장충동 왕족발 메뉴 등록 메서드
	// 장충동 왕족발 식당 눌러서 신규 버튼 누르면 나오는 화면에서
	public void jokbalMenuInsert(JokbalMenu jm) throws Exception {
		
		conn = DBConnector.getConnection();
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into jokbal_menu(jokbal_seq, jokbal_id, jokbal_rep, jokbal_name, jokbal_price) "
				+"values(?, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, jm.getJokbal_seq());
		pstmt.setInt(2, jm.getJokbal_id());
		pstmt.setInt(3, jm.getJokbal_seq());
		pstmt.setString(4, jm.getJokbal_name());
		pstmt.setInt(5, jm.getJokbal_price());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(jm+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 왕족발 메뉴 삭제 메서드(메뉴 번호로 삭제)
	public void	jokbalMenuDelete(int jokbal_seq) throws Exception {
			
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from jokbal_menu where jokbal_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, jokbal_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(jokbal_seq+"번째 메뉴가 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// 왕족발 메뉴 수정 테이블(dduck_seq 메뉴 번호로 검사)
	public void jokbalMenuUpdate(JokbalMenu jm) throws Exception {
		
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update jokbal_menu set jokbal_id=? , jokbal_rep=?, "
				+"jokbal_name=?, jokbal_price=? where jokbal_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, jm.getJokbal_id());
		pstmt.setInt(2, jm.getJokbal_rep());
		pstmt.setString(3, jm.getJokbal_name());
		pstmt.setInt(4, jm.getJokbal_price());
		pstmt.setInt(5, jm.getJokbal_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(jm.getJokbal_seq()+"번째 메뉴를 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
}
