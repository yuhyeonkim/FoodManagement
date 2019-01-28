package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.DduckMenu;
import com.bean.Restaurant;

public class RestaurantDao {
	
	private static RestaurantDao restinstance;
	
	// 객체를 대신 만들어주는 메소드
	public static RestaurantDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(restinstance == null) {
			restinstance = new RestaurantDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return restinstance;
	}
	
	Connection conn;
	// 음식점 등록 메서드
	public void restInsert(Restaurant r) throws Exception {
		
		conn = DBConnector.getConnection();
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into restaurant(rest_seq, rest_name, rest_loc, rest_rate) "
				+"values(?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, r.getRest_seq());
		pstmt.setString(2, r.getRest_name());
		pstmt.setString(3, r.getRest_loc());
		pstmt.setInt(4, r.getRest_rate());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(r+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 음식점 삭제 메서드(음식점 번호seq로 삭제)
	public void restDelete(int rest_seq) throws Exception {
			
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from restaurant where rest_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, rest_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(rest_seq+"번째 음식점이 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 음식점 수정 테이블(rest_seq 번호로 검사)
	public void restUpdate(Restaurant r) throws Exception {
		
		conn = DBConnector.getConnection();
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update restaurant set rest_name=? , rest_loc=?, "
				+"rest_rate=? where rest_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setString(1, r.getRest_name());
		pstmt.setString(2, r.getRest_loc());
		pstmt.setInt(3, r.getRest_rate());
		pstmt.setInt(4, r.getRest_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(r.getRest_seq()+"번째 음식점을 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
}
