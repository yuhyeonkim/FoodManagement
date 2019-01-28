package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.bean.DduckMenu;
import com.bean.Restaurant;
import com.bean.User;

public class UserDao {
	
	private static UserDao userinstance;
	Connection conn;
	
	// 객체를 대신 만들어주는 메소드
	public static UserDao getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(userinstance == null) {
			userinstance = new UserDao();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return userinstance;
	}
	
	private UserDao() {	
		try {
			conn = DBConnector.getConnection();
			System.out.println("Connection 객체 연결 성공!");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 사용자 등록 메서드
	public void userInsert(User u) throws Exception {
		
		// 메뉴를 insert하기 위해 필요
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql ="insert into user_table(user_seq, user_sex, user_name,"
				+ " user_id, user_pw, user_phone, user_loc, user_manage) "
				+"values(?, ?, ?, ?, ?, ?, ?, ?) ";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, u.getUser_seq());
		pstmt.setInt(2, u.getUser_sex());
		pstmt.setString(3, u.getUser_name());
		pstmt.setString(4, u.getUser_id());
		pstmt.setString(5, u.getUser_pw());
		pstmt.setString(6, u.getUser_phone());
		pstmt.setString(7, u.getUser_loc());
		pstmt.setInt(8, u.getUser_manage());
		
		pstmt.executeUpdate();
		// 확인차 출력
		System.out.println(u+"가 등록되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 사용자 삭제 메서드(사용자 번호로 삭제)
	public void userDelete(int user_seq) throws Exception {
			
		PreparedStatement pstmt = null;
		String sql = null;
			
		sql = "delete from user_table where user_seq = ? ";
				
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user_seq);
				
		pstmt.executeUpdate();
				
		System.out.println(user_seq+"번째 사용자가 삭제되었습니다");
				
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// 사용자 수정 테이블(user_seq 메뉴 번호로 검사)
	public void userUpdate(User u) throws Exception {
		
		PreparedStatement pstmt = null;
		String sql = null;
		
		sql = "update user_table set user_sex=? , user_name=?, "
				+"user_id=?, user_pw=?, user_phone=?, user_loc=?, user_manage=? where user_seq=? ";
			
		pstmt = conn.prepareStatement(sql);
			
		pstmt.setInt(1, u.getUser_sex());
		pstmt.setString(2, u.getUser_name());
		pstmt.setString(3, u.getUser_id());
		pstmt.setString(4, u.getUser_pw());
		pstmt.setString(5, u.getUser_phone());
		pstmt.setString(6, u.getUser_loc());
		pstmt.setInt(7, u.getUser_manage());
		pstmt.setInt(8, u.getUser_seq());
		
		pstmt.executeUpdate();
		
		System.out.println(u.getUser_seq()+"번째 사용자를 수정하였습니다");
			
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	
	// 사용자 조회 메서드(user_id 로 검색)
	public void userSelect(String user_id) throws Exception{
		
		PreparedStatement pstmt=null;
		String sql = null;
		
		sql = "select * from user_table where user_id=?";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, user_id);
		
		pstmt.executeQuery();
		
		System.out.println("해당 "+user_id+"가 조회되었습니다");
		
		if(pstmt.isClosed() || pstmt ==null) {
			pstmt.close();
		}
		conn.close();
	}
	// 사용자 주소에 따른 음식점 조회
	public void userLocRest(String user_loc) throws Exception{
		
		Statement stmt=null;
		String sql = null;
		
		sql = "select * from restaurant r where r.rest_loc= "
				+"(select distinct u.user_loc from user_table u)";
		
		stmt = conn.createStatement();
		
		stmt.executeQuery(sql);
		
		System.out.println(user_loc+"5km 내 음식점이 조회되었습니다");
		
		if(stmt.isClosed() || stmt ==null) {
			stmt.close();
		}
		conn.close();
	}	
		
}
