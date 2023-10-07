package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import dao.ProjectDao;
import dao.TaskDao;
import entity.Project;
import entity.Task;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/project")
public class ShowProjectServlet extends HttpServlet {
	private static ProjectDao projectDao = ProjectDao.getInstance();
	private static TaskDao taskDao = TaskDao.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String projectId = req.getParameter("projectId");
		Optional<Project> project = projectDao.findById(Long.parseLong(projectId));
		String projectName = project.map(Project::getName).orElse("");
		String projectDesc = project.map(Project::getDescription).orElse("");
		LocalDate deadline = project.map(Project::getDeadline).orElse(LocalDate.now());

		List<Task> tasks = taskDao.findTaskByProjectId(Long.parseLong(projectId));
		req.setAttribute("tasks", tasks);
		req.setAttribute("deadline", deadline);
		req.setAttribute("projectName", projectName);
		req.setAttribute("projectDesc", projectDesc);
		req.getSession().setAttribute("projectId", projectId);
		
		req.getRequestDispatcher("project.jsp").include(req, resp);
	}
}
