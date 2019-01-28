package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.MrPizzaMenu;

public class MrPizzaMenuDao {
	
	private static MrPizzaMenuDao pizzainstance;
	
	// 객체를 대신 만들어주는 메소드
	public static MrPizzaMenuDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(pizzainstance == null) {
			pizzainstance = new MrPizzaMenuDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return pizzainstance;
	}
	
	Connection conn;
	// 미스터피자 메뉴 등록 메서드
	// 미스터피자 식당 눌러서 신규 버튼 누르면 나오는 화면에서
	public void mrpizzaMenuInsert(MrPizzaMenu mpm) throws Exception {
		
		conn = DBConnector.getConnection();
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into mrpizza_menu(mrpizza_seq, mrpizza_id, mrpizza_rep, mrpizza_name, mrpizza_price) "
				+"values(?, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, mpm.getMrpizza_seq());
		pstmt.setInt(2, mpm.getMrpizza_id());
		pstmt.setInt(3, mpm.getMrpizza_rep());
		pstmt.setString(4, mpm.getMrpizza_name());
		pstmt.setInt(5, mpm.getMrpizza_price());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(mpm+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 맥도날드 메뉴 삭제 메서드(메뉴 번호로 삭제)
	public void mrpizzaMenuDelete(int mrpizza_seq) throws Exception {
			
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from mrpizza_menu where mrpizza_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, mrpizza_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(mrpizza_seq+"번째 메뉴가 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// 맥도날드 메뉴 수정 테이블(mac_seq 메뉴 번호로 검사)
	public void mrpizzaMenuUpdate(MrPizzaMenu mpm) throws Exception {
		
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update mrpizza_menu set mrpizza_id=? , mrpizza_rep=?, "
				+"mrpizza_name=?, mrpizza_price=? where mrpizza_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, mpm.getMrpizza_id());
		pstmt.setInt(2, mpm.getMrpizza_rep());
		pstmt.setString(3, mpm.getMrpizza_name());
		pstmt.setInt(4, mpm.getMrpizza_price());
		pstmt.setInt(5, mpm.getMrpizza_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(mpm.getMrpizza_seq()+"번째 메뉴를 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
}
