package com.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.bean.MacMenu;

public class MacMenuDao {

	private static MacMenuDao macinstance;
	Connection conn = null;
	
	// 객체를 대신 만들어주는 메소드
	public static MacMenuDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(macinstance == null) {
			macinstance = new MacMenuDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return macinstance;
	}
	
	private MacMenuDao() {	
		try {
			conn = DBConnector.getConnection();
			System.out.println("Connection 객체 연결 성공!");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 맥도날드 메뉴 등록 메서드
	// 진짜루 눌러서 신규 버튼 누르면 나오는 화면에서
	public void macMenuInsert(MacMenu mm) throws Exception {
		
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into mac_menu(mac_seq, mac_id, mac_rep, mac_name, mac_price) "
				+"values(?, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, mm.getMac_seq());
		pstmt.setInt(2, mm.getMac_id());
		pstmt.setInt(3, mm.getMac_rep());
		pstmt.setString(4, mm.getMac_name());
		pstmt.setInt(5, mm.getMac_price());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(mm+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 맥도날드 메뉴 삭제 메서드(메뉴 번호로 삭제)
	public void macMenuDelete(int mac_seq) throws Exception {
			
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from mac_menu where mac_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mac_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(mac_seq+"번째 메뉴가 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// 맥도날드 메뉴 수정 테이블(mac_seq 메뉴 번호로 검사)
	public void macMenuUpdate(MacMenu mm) throws Exception {
		
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update mac_menu set mac_id=? , mac_rep=?, "
				+"mac_name=?, mac_price=? where mac_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, mm.getMac_id());
		pstmt.setInt(2, mm.getMac_rep());
		pstmt.setString(3, mm.getMac_name());
		pstmt.setInt(4, mm.getMac_price());
		pstmt.setInt(5, mm.getMac_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(mm.getMac_seq()+"번째 메뉴를 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
}
