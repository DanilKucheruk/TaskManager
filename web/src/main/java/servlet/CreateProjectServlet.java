
package servlet;

import java.io.IOException;
import java.util.List;

import dao.ProjectDao;
import dao.UserDao;
import dto.CreateProjectDto;
import dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProjectService;

@WebServlet("/createproject")
public class CreateProjectServlet extends HttpServlet {
	private static UserDao userDao = UserDao.getInstance();
	private static ProjectService projectService = ProjectService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDto userDto = (UserDto) req.getSession().getAttribute("user");
		String depCode = userDto.getDepartmentCode();
		List<String> usersFullNames = userDao.getUserNames(depCode);
		req.setAttribute("usersFullNamesList", usersFullNames);
		req.getRequestDispatcher("createProject.jsp").include(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String adminName= req.getParameter("responsible");
		Long adminId = userDao.getIdByFullName(adminName);
		String deadline = req.getParameter("date");
		CreateProjectDto createProjectDto = new CreateProjectDto(name,description,adminId,deadline);
		
		try{
			projectService.crateProject(createProjectDto);
			resp.sendRedirect("/web/projects");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
