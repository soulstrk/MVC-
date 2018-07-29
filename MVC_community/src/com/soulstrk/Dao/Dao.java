package com.soulstrk.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.soulstrk.Dto.bDto;

public class Dao {
	private Connection conn = null;
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	
	public Dao() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, "scott", "soul4310");
			System.out.println("연결 성공");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("에러여기1");
		}
	}
	
	public ArrayList<bDto> getListAll(){ //모든 글목록 가져오기
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from mvc_board";
		ArrayList<bDto> list = new ArrayList<>();
		bDto dto = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bId = rs.getInt("bid");
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Date bDate = rs.getDate("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new bDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				list.add(dto);
			}
			
			return list;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("getList 에러");
			return null;
		} finally {
			try {
				if(rs != null) {
					rs.close();
					ps.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	
	public int writeContent(String name,String title,String content){
		PreparedStatement ps = null;
		String sql = "insert into mvc_board values(mvc_board_seq.nextval,?,?,?,sysdate,0,mvc_board_seq.currval,0,0)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, title);
			ps.setString(3, content);
			int w = ps.executeUpdate();
			return w;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("writeContent 에러");
			return -1;
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	
	public bDto getContent(String bId){ //모든 글목록 가져오기
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from mvc_board where bId = ?";
		bDto dto = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(bId));
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String bName = rs.getString("bName");
				String bTitle = rs.getString("bTitle");
				String bContent = rs.getString("bContent");
				Date bDate = rs.getDate("bDate");
				int bHit = rs.getInt("bHit");
				int bGroup = rs.getInt("bGroup");
				int bStep = rs.getInt("bStep");
				int bIndent = rs.getInt("bIndent");
				
				dto = new bDto(Integer.parseInt(bId), bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
			
			return dto;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("getContent 에러");
			return null;
		} finally {
			try {
				if(rs != null) {
					rs.close();
					ps.close();
				}
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
