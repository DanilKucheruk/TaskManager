package servlet;

import java.io.IOException;
import java.util.List;

import dao.TaskDao;
import dto.CreateProjectDto;
import dto.CreateTaskDto;
import dto.UserDto;
import entity.ProjectParticipant;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.TaskService;

@WebServlet("/createtask")
public class CreateTaskServlet extends HttpServlet {
	private static TaskDao taskDao = TaskDao.getInstance();
	private static TaskService taskService = TaskService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("createTask.jsp").include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String deadline = req.getParameter("date");
		String projectId = (String) req.getSession().getAttribute("projectId");
		Long projectIdL = Long.parseLong(projectId);
		CreateTaskDto createTaskDto = new CreateTaskDto(title, deadline, projectIdL);
		try {
			Long taskId = taskService.crateTask(createTaskDto);
			resp.sendRedirect("/web/project?projectId=" + projectId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
