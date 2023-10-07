package servlet;

import java.io.IOException;

import dao.ProjectParticipantDao;
import dto.UserDto;
import entity.ProjectParticipant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addToProject")
public class ProjectParticipantServlet extends HttpServlet {
	private ProjectParticipantDao projectParticipantDao = ProjectParticipantDao.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String projectId = req.getParameter("project_id").toString();
		UserDto userDto = (UserDto) req.getSession().getAttribute("user");
		Long userId = userDto.getId();
		ProjectParticipant pjParticipant = new ProjectParticipant(userId, Long.parseLong(projectId));
		try {
			projectParticipantDao.save(pjParticipant);
			resp.sendRedirect("/web/projects");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
