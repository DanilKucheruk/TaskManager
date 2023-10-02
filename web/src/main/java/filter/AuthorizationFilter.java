package filter;

import java.io.IOException;
import java.util.Set;

import dto.UserDto;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//@WebFilter("/*")
public class AuthorizationFilter implements Filter{
	private static final Set<String> PUBLIC_PATH = Set.of("/web/login","/web/registration");
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		  String uri = ((HttpServletRequest) servletRequest).getRequestURI();
		  if(isPublicPath(uri) || isUserLoggedIn(servletRequest)) {
			  filterChain.doFilter(servletRequest, servletResponse);
		  }else {
			  ((HttpServletResponse) servletResponse).sendRedirect("/web/login");
			  }
	}	
	private boolean isUserLoggedIn(ServletRequest servletRequest) {
		UserDto user = (UserDto)( (HttpServletRequest) servletRequest ).getSession().getAttribute("user"); 
		return user!=null;
	}
	private boolean isPublicPath(String uri) {
		return PUBLIC_PATH.stream().anyMatch(path -> uri.startsWith(path));
	}
}
