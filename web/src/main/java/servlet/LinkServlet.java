package servlet;

import java.io.IOException;
import java.util.UUID;

import dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/link")
public class LinkServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object projectId = req.getParameter("project_id");
		String link = "http://localhost:8080/web/addToProject?project_id=" + projectId;
		req.setAttribute("link", link);
		req.getRequestDispatcher("linkforAddUser.jsp").include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
