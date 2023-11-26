package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.FriendsDto;

public class FriendsDao  extends ChatdbDao{

	public void insert(FriendsDto dto) {
		String sql = "INSERT INTO friends (id, friendID) VALUES(?, ?);";
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		){
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getfriendID());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<FriendsDto> select(String id){
		ArrayList<FriendsDto> dtos = new ArrayList<FriendsDto>();
		String sql = "select * from friends where id='"+id+"';";
		try (
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		){
			while(rs.next()) {
				FriendsDto dto = new FriendsDto();
				dto.setId(id);
				dto.setfriendID(rs.getString("friendID"));
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}
	public boolean check(String id, String friendID) {
		String sql = "select * from friends where id='"+id+"' and friendID='"+friendID+"';";

		try (
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		){
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
