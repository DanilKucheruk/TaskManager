package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.ProjectDao;
import dto.UserDto;
import entity.Project;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/projects")
public class ProjectServlet extends HttpServlet {
	private static ProjectDao projectDao = ProjectDao.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDto userDto = (UserDto) req.getSession().getAttribute("user");
		Long userId = userDto.getId();
		List<Project> projects = projectDao.findAllProjectsByIdParticipantsId(userId);
		List<String> projectsNames = new ArrayList<>();
 		for(Project pj : projects) {
			projectsNames.add(pj.getName());
		}
		req.setAttribute("projectsNames", projectsNames);
		req.getRequestDispatcher("projects.jsp").include(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
