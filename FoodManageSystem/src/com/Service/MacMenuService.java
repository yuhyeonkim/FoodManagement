package com.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import com.Dao.DBConnector;
import com.Dao.MacMenuDao;

public class MacMenuService {

	private static MacMenuService macservice;
	Connection conn;
	
	public static MacMenuService getInstance() {
		// 메소드가 처음 호출될 때 -> 새롭게 만든 객체를 반환
		if(macservice == null) {
			macservice = new MacMenuService();
		}
		// 그 다음부터 -> 만들어진 객체의 주소를 반환
		return macservice;
	}
	
	private MacMenuService() {	
		try {
			conn = DBConnector.getConnection();
			System.out.println("Connection 객체 연결 성공!");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 맥도날드 메뉴 이름 검사 메서드(중복, 길이제한10글자, 특수문자)
		public int macNameExamine(String mac_name) {
			
			String sql = "select mac_name from mac_menu where mac_name =? ";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String name = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, mac_name);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					name = rs.getString("mac_name");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// return 0 : 검사 성공
			// return 1 : 메뉴 이름 중복
			// return 2 : 1~10글자이내의 한글, 영어, 숫자가 아님
			
			if(name == null) {
				System.out.println(mac_name+"은 중복됩니다");
				return 1;
			}
			else if(!Pattern.matches("^[a-zA-Zㄱ-힣0-9]{1,10}+$", name)) {
				System.out.println(mac_name+"을 10글자 이내의 문자와 숫자로 입력해주세요");
				return 2;
			}
			else{
				return 0;
			}
		}
		// 맥도날드 대표 메뉴인지 검사 메서드(0, 1)
		public int macRepExamine(boolean mac_rep) {
			// return 0 : 검사 성공
			// return 1 : 대표 메뉴 체크
			if( mac_rep ) {
				System.out.println("대표 메뉴가 체크되었습니다");
				return 1;
			}
			else{
				System.out.println("대표 메뉴가 체크되지 않았습니다");
				return 0;
			}
		}
		
		// 맥도날드 메뉴 가격 0~100만원 이하 검사 메서드
		public int macPriceExamine(int mac_price) {
			
			String sql = "select mac_price from mac_menu where mac_price =? ";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String price = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, mac_price);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					price = Integer.toString(rs.getInt("mac_price")); 
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// return 0 : 검사 성공
			// return 1 : 메뉴 가격 0~100만원 이하가 아닐때
			if( !Pattern.matches("^[0-9]{1,7}+$", price) ) {
				System.out.println("메뉴 가격이 100만원을 초과합니다");
				return 1;
			}
			else{
				return 0;
			}
		}
		
		// 음식점 삭제 번호 검사 메서드
		public int macSeqExamine(int mac_seq) {
			
			String sql = "select mac_seq from mac_menu where mac_seq =? ";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int seq = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, mac_seq);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					seq = rs.getInt("mac_seq"); 
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			// return 0 : 검사 성공
			// return 1 : 삭제할 메뉴 번호가 존재하지 않을 때
			if( seq == 0 ) {
				System.out.println("삭제할 메뉴 번호가 존재하지 않습니다");
				return 1;
			}
			else{
				return 0;
			}
		}
}
