package servlet;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import service.UserService;
import dto.CreateUserDto;

@WebServlet("/registration")
public class RegistrationUserServlet extends HttpServlet {

	private final UserService userService = UserService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("roles", List.of("ADMIN", "USER"));
		request.getRequestDispatcher("registration.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("name");
		String lastName = request.getParameter("last-name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		String departmentCode = request.getParameter("department-code");

		CreateUserDto userEnt = new CreateUserDto(email, firstName, lastName, password, role, departmentCode);

		try {
			userService.createUser(userEnt);
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
