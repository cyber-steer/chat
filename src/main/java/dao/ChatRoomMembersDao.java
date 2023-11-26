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
	public ArrayList<Integer> select(String id) {
		ArrayList<Integer> dtos = new ArrayList<Integer>();
		String query = "select * from chatRoomMembers where id='"+id+"';";
		try (
				Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
		){
			while(rs.next()) {
				dtos.add(rs.getInt("chatRoomNumber"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
	}
}
