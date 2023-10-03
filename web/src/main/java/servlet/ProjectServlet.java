package servlet;

import java.io.IOException;
import java.util.List;

import dao.UserDao;
import dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/projects")
public class ProjectServlet extends HttpServlet {
	private static UserDao userDao = UserDao.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		UserDto userDto = (UserDto) session.getAttribute("user");
		String depCode = userDto.getDepartmentCode();
		List<String> value = userDao.getUserNames(depCode);
		req.setAttribute("userList", value);
		req.getRequestDispatcher("createProject.jsp").include(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
