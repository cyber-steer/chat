package dto;

public class FriendsDto {
	String id;
	String friendID;
	
	public FriendsDto() {}
	public FriendsDto(String id, String friendID) {
		super();
		this.id = id;
		this.friendID = friendID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getfriendID() {
		return friendID;
	}
	public void setfriendID(String friendID) {
		this.friendID = friendID;
	}
	
	
}
