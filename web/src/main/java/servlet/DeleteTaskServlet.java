package servlet;

import java.io.IOException;

import dao.TaskDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletetask")
public class DeleteTaskServlet extends HttpServlet {
	private static TaskDao taskDao = TaskDao.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long taskId = Long.parseLong(req.getParameter("taskId"));
		Long projectId = Long.parseLong(req.getParameter("projectId"));
		taskDao.deleteById(taskId);
		resp.sendRedirect("/web/project?projectId=" + projectId);
	}
}
