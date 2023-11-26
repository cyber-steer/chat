package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.ChatRoomMembersDto;

public class ChatRoomMembersDao  extends ChatdbDao{
	public void insert(ChatRoomMembersDto dto) {
		String sql = "INSERT INTO chatRoomMembers (id, chatRoomNumber) VALUES(?, ?);";
		try (
			Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
		){
			pstmt.setString(1, dto.getId());
			pstmt.setInt(2, dto.getChatRommNumber());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int select(String id, String friendID) {
		ArrayList<Integer> dtos = new ArrayList<Integer>();
		String query = "SELECT a.chatRoomNumber"
				+ "FROM chatRoomMembers a"
				+ "JOIN chatRoomMembers b ON a.chatRoomNumber = b.chatRoomNumber"
				+ "WHERE a.id = '"+id+"' AND b.id = '"+friendID+"'"
				+ "GROUP BY a.chatRoomNumber\r\n"
				+ "HAVING COUNT(DISTINCT a.id) = 1 AND COUNT(DISTINCT b.id) = 1;";
		try (
				Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
		){
			if(rs.next()) return rs.getInt("number.chatRoomNumber");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
