package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ChatRoomMembersDao;


public class RoomInsertCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("roomName");
		String friend = request.getParameter("friend");
		String[] friends = request.getParameterValues("friends");
		
		if(friend == null) {
			
		}
		else {
			ChatRoomMembersDao dao = new ChatRoomMembersDao();
			for(String id : friends) {
			}
		}
		
	}
}
