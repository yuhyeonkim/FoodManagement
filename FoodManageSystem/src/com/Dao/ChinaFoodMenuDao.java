package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.ChinaFoodMenu;
import com.bean.MrPizzaMenu;

public class ChinaFoodMenuDao {
	
	private static ChinaFoodMenuDao chinainstance;
	Connection conn;
	
	// 객체를 대신 만들어주는 메소드
	public static ChinaFoodMenuDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(chinainstance == null) {
			chinainstance = new ChinaFoodMenuDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return chinainstance;
	}
	
	
	private ChinaFoodMenuDao() {	
		try {
			conn = DBConnector.getConnection();
			System.out.println("Connection 객체 연결 성공!");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 진짜루 메뉴 등록 메서드
	// 진짜루 식당 눌러서 신규 버튼 누르면 나오는 화면에서
	public void chinafoodMenuInsert(ChinaFoodMenu cfm) throws Exception {
		
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into chinafood_menu(chinafood_seq, chinafood_id, chinafood_rep, chinafood_name, chinafood_price) "
				+"values(?, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, cfm.getChinafood_seq());
		pstmt.setInt(2, cfm.getChinafood_id());
		pstmt.setInt(3, cfm.getChinafood_rep());
		pstmt.setString(4, cfm.getChinafood_name());
		pstmt.setInt(5, cfm.getChinafood_price());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(cfm+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 진짜루 메뉴 삭제 메서드(메뉴 번호로 삭제)
	public void chinafoodMenuDelete(int chinafood_seq) throws Exception {
			
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from chinafood_menu where chinafood_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, chinafood_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(chinafood_seq+"번째 메뉴가 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// 진짜루 메뉴 수정 테이블(mac_seq 메뉴 번호로 검사)
	public void chinafoodMenuUpdate(ChinaFoodMenu cfm) throws Exception {
		
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update chinafood_menu set chinafood_id=? , chinafood_rep=?, "
				+"chinafood_name=?, chinafood_price=? where chinafood_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, cfm.getChinafood_id());
		pstmt.setInt(2, cfm.getChinafood_rep());
		pstmt.setString(3, cfm.getChinafood_name());
		pstmt.setInt(4, cfm.getChinafood_price());
		pstmt.setInt(5, cfm.getChinafood_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(cfm.getChinafood_seq()+"번째 메뉴를 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
}
