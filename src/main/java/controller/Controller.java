package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;
import command.FirendInsertCommand;
import command.FriendSelectCommand;
import command.RoomInsertCommand;
import command.RoomSelectCommand;
import command.UserInsertCommand;
import command.UserSelectCommand;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = null;
		response.setContentType("text/html; charset=UTF-8");
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".do"));
		Command command;

		switch(com.trim()) {
			case "index":
				viewPage="WEB-INF/view/index.jsp";
				break;
			case "home":
				command = new FriendSelectCommand();
				command.execute(request, response);
				command = new RoomSelectCommand();
				command.execute(request, response);
				viewPage="WEB-INF/view/home.jsp";
				break;
			case "login":
				viewPage="WEB-INF/view/login.jsp";
				break;
			case "signup":
				viewPage="WEB-INF/view/signup.jsp";
				break;
			case "userInsert":
				command = new UserInsertCommand();
				command.execute(request, response);
				viewPage="WEB-INF/view/login.jsp";
				break;
			case "userSelect":
				command = new UserSelectCommand();
				command.execute(request, response); 
				// 로그인 성공 체크
				if(request.getSession().getAttribute("name") != null) {
					viewPage="home.do";
				}
				else {
					viewPage="WEB-INF/view/login.jsp";
				}
				break;
			case "logout":
				request.getSession().invalidate();
				viewPage="WEB-INF/view/index.jsp";
				break;
			case "friendInsert":
				command = new FirendInsertCommand();
				command.execute(request, response);
				viewPage = "home.do";
				break;
			case "roomCreate":
				viewPage = "WEB-INF/view/roomCreate.jsp";
				break;
			case "roomInsert":
				command = new RoomInsertCommand();
				command.execute(request, response);
				viewPage = "home.do";
				break;
				
		}
		RequestDispatcher rd = request.getRequestDispatcher(viewPage);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
