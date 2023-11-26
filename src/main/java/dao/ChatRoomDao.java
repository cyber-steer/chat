package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dto.ChatRoomDto;

public class ChatRoomDao  extends ChatdbDao{

	public void insert(String name) {
		String sql = "INSERT INTO chatRooms (roomName) VALUES('"+name+"');";
		try (
			Connection con = getConnection();
			Statement stmt = con.createStatement();
		){
			stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<ChatRoomDto> select(){
		String sql = "SELECT * FROM chatRooms;";
		ArrayList<ChatRoomDto> dtos = new ArrayList<ChatRoomDto>();
		try (
			Connection con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
		){
			while(rs.next()) {
				ChatRoomDto dto = new ChatRoomDto();
				dto.setChatRoomNumber(rs.getInt("chatRoomNumber"));
				dto.setRoomName(rs.getString("roomName"));
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtos;
		
	}
}
