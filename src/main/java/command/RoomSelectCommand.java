package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoomSelectCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = (String) request.getSession().getAttribute("id");
		String friendID = request.getParameter("friendID");
		int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
		
		if(friendID == null) {
			
		}
		else {
			
		}
	}

}
