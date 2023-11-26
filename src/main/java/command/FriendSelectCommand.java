package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FriendsDao;
import dao.UserDao;
import dto.FriendsDto;
import dto.UserDto;

public class FriendSelectCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = (String) request.getSession().getAttribute("id");
		ArrayList<FriendsDto> friendsDtos = new FriendsDao().select(id);
		UserDao dao = new UserDao();
		ArrayList<UserDto> dtos = new ArrayList<UserDto>();
		
		for(FriendsDto friendsDto: friendsDtos) {
			String friendID = friendsDto.getfriendID();
			String name = dao.selectName(friendID);
			UserDto dto = new UserDto();
			dto.setId(friendID);
			dto.setName(name);
			dtos.add(dto);
			System.out.println(friendID);
		}
		
		request.setAttribute("friendsDtos", dtos);
	}
		
}
