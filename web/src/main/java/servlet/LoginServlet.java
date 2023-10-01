package servlet;

import java.io.IOException;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private final UserService userService = UserService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			userService.login(req.getParameter("email"), req.getParameter("password")).ifPresentOrElse(
					user -> {
						req.getSession().setAttribute("user",user);
						try {
							resp.sendRedirect("/main");
						}catch (IOException e) {
							e.printStackTrace();
						}
					},
					()->onLoginFileError(req,resp)
					);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onLoginFileError(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.sendRedirect("/web/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
