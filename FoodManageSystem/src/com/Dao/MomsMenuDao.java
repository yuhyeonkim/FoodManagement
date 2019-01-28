package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.MomsMenu;
import com.bean.MrPizzaMenu;

public class MomsMenuDao {
	
	private static MomsMenuDao momsinstance;
	Connection conn;
	
	// 객체를 대신 만들어주는 메소드
	public static MomsMenuDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(momsinstance == null) {
			momsinstance = new MomsMenuDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return momsinstance;
	}
	
	private MomsMenuDao() {	
		try {
			conn = DBConnector.getConnection();
			System.out.println("Connection 객체 연결 성공!");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 맘스터치 메뉴 등록 메서드
	// 맘스터치 식당 눌러서 신규 버튼 누르면 나오는 화면에서
	public void momsMenuInsert(MomsMenu moms) throws Exception {
		
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into moms_menu(moms_seq, moms_id, moms_rep, moms_name, moms_price) "
				+"values(?, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, moms.getMoms_seq());
		pstmt.setInt(2, moms.getMoms_id());
		pstmt.setInt(3, moms.getMoms_rep());
		pstmt.setString(4, moms.getMoms_name());
		pstmt.setInt(5, moms.getMoms_price());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(moms+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 맘스터치 메뉴 삭제 메서드(메뉴 번호로 삭제)
	public void momsMenuDelete(int moms_seq) throws Exception {
			
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from moms_menu where moms_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, moms_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(moms_seq+"번째 메뉴가 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// 맘스터치 메뉴 수정 테이블(moms_seq 메뉴 번호로 검사)
	public void momsMenuUpdate(MomsMenu moms) throws Exception {
		
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update moms_menu set moms_id=? , moms_rep=?, "
				+"moms_name=?, moms_price=? where moms_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, moms.getMoms_id());
		pstmt.setInt(2, moms.getMoms_rep());
		pstmt.setString(3, moms.getMoms_name());
		pstmt.setInt(4, moms.getMoms_price());
		pstmt.setInt(5, moms.getMoms_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(moms.getMoms_seq()+"번째 메뉴를 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
}
