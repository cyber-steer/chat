package dto;

public class JoinDto {
	String friendName;
	int roomNumber;
	String friendID;
	String roomName;
	
	public JoinDto() {}
	public JoinDto(String friendName, int roomNumber, String friendID, String roomName) {
		super();
		this.friendName = friendName;
		this.roomNumber = roomNumber;
		this.friendID = friendID;
		this.roomName = roomName;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getFriendID() {
		return friendID;
	}
	public void setFriendID(String friendID) {
		this.friendID = friendID;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	
}
