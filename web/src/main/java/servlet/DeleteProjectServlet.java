package servlet;

import java.io.IOException;

import dao.ProjectDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteproject")
public class DeleteProjectServlet extends HttpServlet {
	private static ProjectDao projectDao = ProjectDao.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long projectId = Long.parseLong(req.getParameter("projectId"));
		projectDao.deleteById(projectId);
		resp.sendRedirect("/web/projects");
	}
}
