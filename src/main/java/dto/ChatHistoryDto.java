package dto;

import java.security.Timestamp;

public class ChatHistoryDto {
	int messageID;
	int chatRoomNumber;
	String id;
	String message;
	Timestamp timestamp;
	
	
	public ChatHistoryDto(int messageID, int chatRoomNumber, String id, String message, Timestamp timestamp) {
		super();
		this.messageID = messageID;
		this.chatRoomNumber = chatRoomNumber;
		this.id = id;
		this.message = message;
		this.timestamp = timestamp;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public int getChatRoomNumber() {
		return chatRoomNumber;
	}
	public void setChatRoomNumber(int chatRoomNumber) {
		this.chatRoomNumber = chatRoomNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
