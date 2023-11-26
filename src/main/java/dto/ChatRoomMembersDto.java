package dto;

public class ChatRoomMembersDto {
	String id;
	int chatRommNumber;
	
	public ChatRoomMembersDto() {}
	public ChatRoomMembersDto(String id, int chatRommNumber) {
		this.id = id;
		this.chatRommNumber = chatRommNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getChatRommNumber() {
		return chatRommNumber;
	}
	public void setChatRommNumber(int chatRommNumber) {
		this.chatRommNumber = chatRommNumber;
	}
}
