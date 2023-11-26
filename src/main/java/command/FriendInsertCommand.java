package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FriendsDao;
import dao.UserDao;
import dto.FriendsDto;

public class FriendInsertCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = (String) request.getSession().getAttribute("id");
		String friendID = request.getParameter("friendID");
		
		if(!new UserDao().idCheack(friendID) ||
			new FriendsDao().check(id, friendID)) {
			request.setAttribute("check", false);
			System.out.println("error");
			return;
		}
		
		FriendsDto dto = new FriendsDto();
		dto.setId(id);
		dto.setfriendID(friendID);
		
		
		FriendsDao dao = new FriendsDao();
		dao.insert(dto);
	}
}
