package dto;

public class ChatRoomDto {
	int chatRoomNumber;
	String roomName;
	
	public ChatRoomDto() {}
	public ChatRoomDto(int chatRoomNumber, String roomName) {
		super();
		this.chatRoomNumber = chatRoomNumber;
		this.roomName = roomName;
	}
	public int getChatRoomNumber() {
		return chatRoomNumber;
	}
	public void setChatRoomNumber(int chatRoomNumber) {
		this.chatRoomNumber = chatRoomNumber;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	
}